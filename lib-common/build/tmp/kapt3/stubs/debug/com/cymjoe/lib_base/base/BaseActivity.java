package com.cymjoe.lib_base.base;

import java.lang.System;

/**
 * Created by cymjoe
 * on 2019/5/31 15:44
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u00032\u00020\u0004B\u000f\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0002J\b\u0010\u0018\u001a\u00020\u0016H\u0014J\u0010\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u001bH\u0007J\b\u0010\u001c\u001a\u00020\u001dH&J\n\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0006\u0010 \u001a\u00020\u0016J\b\u0010!\u001a\u00020\u0016H&J\b\u0010\"\u001a\u00020\u0016H&J\u000e\u0010#\u001a\u00020\u00162\u0006\u0010$\u001a\u00020\u0006J\u0012\u0010%\u001a\u00020\u00162\b\u0010&\u001a\u0004\u0018\u00010\'H\u0014J\b\u0010(\u001a\u00020\u0016H\u0014J\b\u0010)\u001a\u00020\u0016H\u0014J\b\u0010*\u001a\u00020\u0016H&R\u000e\u0010\b\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\nX\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u00028\u0000X\u0086.\u00a2\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u00a8\u0006+"}, d2 = {"Lcom/cymjoe/lib_base/base/BaseActivity;", "T", "Landroidx/databinding/ViewDataBinding;", "Landroidx/appcompat/app/AppCompatActivity;", "Lkotlinx/coroutines/CoroutineScope;", "useBinding", "", "(Z)V", "_useBinding", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "dialog", "Lcom/kaopiz/kprogresshud/KProgressHUD;", "mBinding", "getMBinding", "()Landroidx/databinding/ViewDataBinding;", "setMBinding", "(Landroidx/databinding/ViewDataBinding;)V", "Landroidx/databinding/ViewDataBinding;", "allScreen", "", "avoidLauncherAgain", "dismissLoadingDialog", "finishActivity", "event", "Lcom/cymjoe/lib_base/entity/FinishActivityEvent;", "getLayoutResId", "", "getResources", "Landroid/content/res/Resources;", "getViewModel", "initData", "initView", "loading", "load", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "showLoadingDialog", "startObserve", "lib-common_debug"})
public abstract class BaseActivity<T extends androidx.databinding.ViewDataBinding> extends androidx.appcompat.app.AppCompatActivity implements kotlinx.coroutines.CoroutineScope {
    private final boolean _useBinding = false;
    @org.jetbrains.annotations.NotNull()
    public T mBinding;
    private com.kaopiz.kprogresshud.KProgressHUD dialog;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.NotNull()
    public final T getMBinding() {
        return null;
    }
    
    public final void setMBinding(@org.jetbrains.annotations.NotNull()
    T p0) {
    }
    
    /**
     * 避免从桌面启动程序后，会重新实例化入口类的activity
     */
    private final void avoidLauncherAgain() {
    }
    
    protected void showLoadingDialog() {
    }
    
    protected void dismissLoadingDialog() {
    }
    
    /**
     * 全屏
     */
    public void allScreen() {
    }
    
    /**
     * 重写 getResource 方法，防止系统字体影响
     */
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.content.res.Resources getResources() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    public final void loading(boolean load) {
    }
    
    public abstract int getLayoutResId();
    
    public abstract void initView();
    
    public abstract void initData();
    
    public abstract void startObserve();
    
    @java.lang.Override()
    protected void onDestroy() {
    }
    
    @org.greenrobot.eventbus.Subscribe()
    public final void finishActivity(@org.jetbrains.annotations.NotNull()
    com.cymjoe.lib_base.entity.FinishActivityEvent event) {
    }
    
    public final void getViewModel() {
    }
    
    public BaseActivity(boolean useBinding) {
        super();
    }
    
    public BaseActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlin.coroutines.CoroutineContext getCoroutineContext() {
        return null;
    }
}