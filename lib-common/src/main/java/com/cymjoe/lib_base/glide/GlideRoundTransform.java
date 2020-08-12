package com.cymjoe.lib_base.glide;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

import androidx.annotation.NonNull;

import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;


import java.security.MessageDigest;

/**
 * Place：Chengdu,China
 * Project：KlilalaLifeService
 * Version：V1.0.0
 * CreatedBy:Wc 2019/11/30
 * Copyright©2019 Past Present Future. All Rights Reserved
 */
public class GlideRoundTransform extends CenterCrop {

    private static float radius = 10f;

    public GlideRoundTransform(Context context) {
        this(context, 10);
    }

    public GlideRoundTransform(Context context, int dp) {
        super();
        radius = dp;
    }

    @Override
    protected Bitmap transform(@NonNull BitmapPool pool, @NonNull Bitmap toTransform, int outWidth, int outHeight) {
        //glide4.0+
        Bitmap transform = super.transform(pool, toTransform, outWidth, outHeight);
        return roundCrop(pool, transform);
        //glide3.0
        //return roundCrop(pool, toTransform);
    }

    private static Bitmap roundCrop(BitmapPool pool, Bitmap source) {
        if (source == null) return null;

        Bitmap result = pool.get(source.getWidth(), source.getHeight(), Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(result);
        Paint paint = new Paint();
        paint.setShader(new BitmapShader(source, BitmapShader.TileMode.CLAMP, BitmapShader.TileMode.CLAMP));
        paint.setAntiAlias(true);
        RectF rectF = new RectF(0f, 0f, source.getWidth(), source.getHeight());
        canvas.drawRoundRect(rectF, radius, radius, paint);
        return result;
    }

    public String getId() {
        return getClass().getName() + Math.round(radius);
    }

    @Override
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {

    }

}
