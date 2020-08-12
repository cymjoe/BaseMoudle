package com.cymjoe.module_work.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.MarginLayoutParams
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.cymjoe.lib_arouter.ARoutePath
import com.cymjoe.lib_base.launch
import com.cymjoe.lib_base.load
import com.cymjoe.lib_base.toast
import com.cymjoe.lib_model.response.BannerEntity
import com.cymjoe.module_work.adapter.ImagesAdapter.ImageHolder
import com.youth.banner.adapter.BannerAdapter
import com.youth.banner.util.BannerUtils

/**
 * 自定义布局，图片
 */
class ImagesAdapter(mDatas: List<BannerEntity?>?) :
    BannerAdapter<BannerEntity, ImageHolder>(mDatas) {
    //更新数据
    fun updateData(data: List<BannerEntity?>?) {
        //这里的代码自己发挥，比如如下的写法等等
        mDatas.clear()
        mDatas.addAll(data!!)
        notifyDataSetChanged()
    }

    //创建ViewHolder，可以用viewType这个字段来区分不同的ViewHolder
    override fun onCreateHolder(parent: ViewGroup, viewType: Int): ImageHolder {
        val imageView = ImageView(parent.context)
        //注意，必须设置为match_parent，这个是viewpager2强制要求的
        val params = MarginLayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        params.marginStart = BannerUtils.dp2px(20f).toInt()
        params.marginEnd = BannerUtils.dp2px(20f).toInt()
        imageView.layoutParams = params
        imageView.scaleType = ImageView.ScaleType.CENTER_CROP
        return ImageHolder(imageView)
    }

    @SuppressLint("CheckResult")
    override fun onBindView(
        holder: ImageHolder,
        data: BannerEntity,
        position: Int,
        size: Int
    ) {
        val context = holder.imageView.context
        //        Glide.with(context).load(data.getPicture()).into(holder.imageView);
        holder.imageView.load(data.cover.toString(), 10)
        holder.imageView.setOnClickListener {
            data.apply {
                when (jumpType) {
                    "URL" -> {
                        openBrowser(context, src)

                    }
                    "DOCTOR" -> {
                        launch(ARoutePath.UserActivity) {
                            withString("url", src)
                        }
                    }
                    "TEAM" -> {
                        launch(ARoutePath.UserActivity) {
                            withString("url", src)
                        }
                    }
                }
            }
        }


    }

    inner class ImageHolder(view: View) :
        RecyclerView.ViewHolder(view) {
        var imageView: ImageView = view as ImageView

    }

    companion object {
        fun openBrowser(context: Context, url: String?) {
            val intent = Intent()
            intent.action = Intent.ACTION_VIEW
            intent.data = Uri.parse(url)
            // 注意此处的判断intent.resolveActivity()可以返回显示该Intent的Activity对应的组件名
            // 官方解释 : Name of the component implementing an activity that can display the intent
            if (intent.resolveActivity(context.packageManager) != null) {
                context.startActivity(Intent.createChooser(intent, "请选择浏览器"))
            } else {
                toast("链接错误或无浏览器")
            }
        }
    }
}