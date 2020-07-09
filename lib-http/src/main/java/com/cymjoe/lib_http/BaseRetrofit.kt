package com.cymjoe.lib_http


import android.content.Context
import android.os.Environment
import android.util.Log
import okhttp3.*
import retrofit2.Retrofit

import java.io.File
import java.io.IOException
import java.io.InputStream
import java.math.BigInteger
import java.security.KeyStore
import java.security.SecureRandom
import java.security.cert.CertificateException
import java.security.cert.CertificateFactory
import java.security.cert.X509Certificate
import java.security.interfaces.RSAPublicKey
import java.util.*
import java.util.concurrent.TimeUnit
import javax.net.ssl.*


/**
 * cymjoe
 * Created by LiRui on 2017/9/1.
 */

open class BaseRetrofit {
     lateinit var retrofit: Retrofit


    lateinit var map: Map<String, String>
    private lateinit var builder: OkHttpClient.Builder
    protected fun createOkHttpClient(map: Map<String, String>): OkHttpClient {
        builder = OkHttpClient.Builder()
        try {
            /**
             * 获取缓存
             */
            val baseInterceptor = Interceptor { chain ->
                val request: Request = chain.request()
                val newBuilder = request.newBuilder()
                newBuilder.cacheControl(
                    CacheControl.Builder().maxStale(50 * 50 * 10, TimeUnit.SECONDS).build()
                )
                chain.proceed(newBuilder.build())
            }
            val max = 10 * 1024 * 1024L;//设置缓存最大内存
            val file =
                File(Environment.getDownloadCacheDirectory(), "cache");//为缓存设置缓存//目录文件夹 和缓存文件夹名字
            val cache = Cache(file, max);//Cache是缓存对象
            this.map = map
            builder.cache(cache)
            builder.connectTimeout(5, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .addInterceptor(RequestInterceptor())
                .addInterceptor(baseInterceptor)
                .addNetworkInterceptor(LoggingInterceptor())

        } catch (e: Exception) {
            e.printStackTrace()
        }
        return builder.build()
    }

    fun onHttpCertficates(n: Int, context: Context?) {
        val certificates = intArrayOf(n)
        builder.socketFactory(getSSLSocketFactory(context, certificates))
    }

    fun <T> create(clazz: Class<T>): T {
        return retrofit!!.create(clazz)
    }

    /**
     * 请求固定参数类
     */
    protected inner class RequestInterceptor() : Interceptor {
        @Throws(IOException::class)
        override fun intercept(chain: Interceptor.Chain): Response {


            val builder = chain.request()
                .newBuilder()
            map.forEach {
                builder.addHeader(it.key, it.value)
            }
            builder.addHeader("Content-Type", "application/json; charset=UTF-8")

            return chain.proceed(builder.build())
        }
    }

    /**
     * 日志类
     */
    protected inner class LoggingInterceptor : Interceptor {
        @Throws(Exception::class)
        override fun intercept(chain: Interceptor.Chain): Response {
            //这个chain里面包含了request和response，所以你要什么都可以从这里拿
            val request = chain.request()
            val t1 = System.nanoTime()//请求发起的时间
            Log.d(TAG, String.format("发送请求 %s ", request.url()))
            val h = request.headers()
            for (s in h.names()) {
                Log.d(TAG, s + "->" + h[s])
            }

            val response = chain.proceed(request)
            try {


                val t2 = System.nanoTime()//收到响应的时间
                val responseBody = response.peekBody((1024 * 1024).toLong())
                Log.d(
                    TAG, String.format(
                        "接收响应: [%s] %n返回json:【%s】 %.1fms%n%s".toLowerCase(Locale.ROOT),
                        response.request().url(),
                        responseBody.string(),
                        (t2 - t1) / 1e6,

                        response.headers()
                    ) + "code:" + response.code()
                )
            } catch (e: Exception) {
                e.printStackTrace()
            }
            return response
        }
    }

    companion object {
        private const val TAG = "NetWork"

        //证书中的公钥
        val PUB_KEY =
            "3082010a0282010100d52ff5dd432b3a05113ec1a7065fa5a80308810e4e181cf14f7598c8d553cccb7d5111fdcdb55f6ee84fc92cd594adc1245a9c4cd41cbe407a919c5b4d4a37a012f8834df8cfe947c490464602fc05c18960374198336ba1c2e56d2e984bdfb8683610520e417a1a9a5053a10457355cf45878612f04bb134e3d670cf96c6e598fd0c693308fe3d084a0a91692bbd9722f05852f507d910b782db4ab13a92a7df814ee4304dccdad1b766bb671b6f8de578b7f27e76a2000d8d9e6b429d4fef8ffaa4e8037e167a2ce48752f1435f08923ed7e2dafef52ff30fef9ab66fdb556a82b257443ba30a93fda7a0af20418aa0b45403a2f829ea6e4b8ddbb9987f1bf0203010001"

        protected fun getSSLSocketFactory(
            context: Context?,
            certificates: IntArray
        ): SSLSocketFactory? {
            if (context == null) {
                throw NullPointerException("context == null")
            }

            //CertificateFactory用来证书生成
            val certificateFactory: CertificateFactory
            try {
                certificateFactory = CertificateFactory.getInstance("X.509")
                //Create a KeyStore containing our trusted CAs
                val keyStore = KeyStore.getInstance(KeyStore.getDefaultType())
                keyStore.load(null, null)
                for (i in certificates.indices) {
                    //读取本地证书
                    val `is`: InputStream =
                        context.resources.openRawResource(certificates[i])
                    keyStore.setCertificateEntry(
                        i.toString(),
                        certificateFactory.generateCertificate(`is`)
                    )
                    `is`.close()
                }
                //Create a TrustManager that trusts the CAs in our keyStore
                val trustManagerFactory =
                    TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm())
                trustManagerFactory.init(keyStore)

                //Create an SSLContext that uses our TrustManager
                val sslContext = SSLContext.getInstance("TLS")
                sslContext.init(null, trustManagerFactory.trustManagers, SecureRandom())
                return sslContext.socketFactory
            } catch (e: java.lang.Exception) {
            }
            return null
        }

        @Throws(java.lang.Exception::class)
        open fun getSSLSocketFactory(): SSLSocketFactory? {
            // Create a trust manager that does not validate certificate chains
            val trustAllCerts =
                arrayOf<TrustManager>(object : X509TrustManager {

                    @Throws(CertificateException::class)
                    override fun checkClientTrusted(
                        chain: Array<X509Certificate>,
                        authType: String
                    ) {
                    }

                    //客户端并为对ssl证书的有效性进行校验
                    @Throws(CertificateException::class)
                    override fun checkServerTrusted(
                        chain: Array<X509Certificate>,
                        authType: String
                    ) {
                        require(chain.isNotEmpty()) { "checkServerTrusted: X509Certificate is empty" }
                        if (!(authType.equals("RSA", ignoreCase = true))) {
                            throw CertificateException("checkServerTrusted: AuthType is not RSA")
                        }

                        // Perform customary SSL/TLS checks
                        try {
                            val tmf =
                                TrustManagerFactory.getInstance("X509")
                            tmf.init(null as KeyStore?)
                            for (trustManager in tmf.trustManagers) {
                                (trustManager as X509TrustManager).checkServerTrusted(
                                    chain,
                                    authType
                                )
                            }
                        } catch (e: java.lang.Exception) {
                            throw CertificateException(e)
                        }
                        // Hack ahead: BigInteger and toString(). We know a DER encoded Public Key begins
                        // with 0×30 (ASN.1 SEQUENCE and CONSTRUCTED), so there is no leading 0×00 to drop.
                        val pubkey: RSAPublicKey = chain[0].publicKey as RSAPublicKey
                        val encoded: String =
                            BigInteger(1 /* positive */, pubkey.getEncoded()).toString(16)
                        // Pin it!
                        val expected = PUB_KEY.equals(encoded, ignoreCase = true)
                        if (!expected) {
                            throw CertificateException(
                                "checkServerTrusted: Expected public key: "
                                        + PUB_KEY + ", got public key:" + encoded
                            )
                        }
                    }

                    override fun getAcceptedIssuers(): Array<X509Certificate?> {
                        return arrayOfNulls(0)
                    }
                })

            // Install the all-trusting trust manager
            val sslContext = SSLContext.getInstance("TLS")
            sslContext.init(
                null, trustAllCerts,
                SecureRandom()
            )
            // Create an ssl socket factory with our all-trusting manager
            return sslContext
                .socketFactory
        }
    }

}
