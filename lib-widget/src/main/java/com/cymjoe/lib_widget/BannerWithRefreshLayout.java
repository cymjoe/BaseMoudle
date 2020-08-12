package com.cymjoe.lib_widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

public class BannerWithRefreshLayout extends SwipeRefreshLayout {
    private float mStartX = 0;
    private float mStartY = 0;
    private boolean isDrag;
    private int mTouchSlop;

    public BannerWithRefreshLayout(@NonNull Context context) {
        super(context);
    }

    public BannerWithRefreshLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mStartX = ev.getX();
                mStartY = ev.getY();
                isDrag = false;
                break;
            case MotionEvent.ACTION_MOVE:
                if (isDrag) {
                    return false;
                }
                float endY = ev.getY();
                float endX = ev.getX();
                float distanceX = Math.abs(endX - mStartX);
                float distanceY = Math.abs(endY - mStartY);
                if (distanceX > mTouchSlop && distanceX > distanceY) {
                    isDrag = true;
                    return false;
                }

                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                isDrag = false;
                break;

        }
        return super.onInterceptTouchEvent(ev);
    }
}
