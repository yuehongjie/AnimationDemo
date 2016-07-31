package com.yu.animationdemo;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

/**
 * 属性动画
 *
 *  ofFloat(arg1, arg2，...)
 * 参数1：要操作的对象
 * 参数2：要操作的属性(只能操作一个属性)
 * 可变参数：开始和结束
 *
 * Created by yu on 2016/7/12.
 */
public class PropertyAnimatorActivity extends AppCompatActivity {

    private ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_animator);
        imageView = (ImageView) findViewById(R.id.image_view);
    }

    /**
     * 代码的方式 旋转动画
     * @param view v
     */
    public void startRotateByCode(View view) {

        //中心旋转
        //ObjectAnimator animator = ObjectAnimator.ofFloat(imageView,"rotation",0,360);
        //围绕 X 轴旋转
        //ObjectAnimator animator = ObjectAnimator.ofFloat(imageView,"rotationX",0,360,180);
        //围绕 Y 轴旋转
        ObjectAnimator animator = ObjectAnimator.ofFloat(imageView,"rotationY",0,360,180);
        animator.setDuration(2000);
        //下面两句设置重复模式 INFINITE (-1) 表示一直重复
        //animator.setRepeatMode(ValueAnimator.REVERSE);
        //animator.setRepeatCount(ValueAnimator.INFINITE);
        //开始动画
        animator.start();
    }

    /**
     * XML的方式 旋转动画
     * @param view v
     */
    public void startRotateByXML(View view) {
        //加载资源文件
        Animator animator = AnimatorInflater.loadAnimator(this, R.animator.rotate);
        //设置作用的对象
        animator.setTarget(imageView);
        //开始动画
        animator.start();
    }

    /**
     * 代码的方式 缩放动画
     * @param view v
     */
    public void startScaleByCode(View view) {
        // X 轴方向缩放 0.5 --> 2 --> 1
        ObjectAnimator animator = ObjectAnimator.ofFloat(imageView,"scaleX",0.5f,2,1);
        animator.setDuration(2000);
        animator.start();
    }

    /**
     * XML的方式 缩放动画
     * @param view v
     */
    public void startScaleByXML(View view) {
        Animator animator = AnimatorInflater.loadAnimator(this, R.animator.scale);
        animator.setTarget(imageView);
        animator.start();
    }

    /**
     * 代码方式 位移动画
     * @param view v
     */
    public void startTranslateByCode(View view) {
        //水平方向位移 从 0 -> 300 -> 100 -> 500 止
        ObjectAnimator animator = ObjectAnimator.ofFloat(imageView,"translationX",0,300,100,500);
        animator.setDuration(2000);
        //animator.setRepeatMode(ValueAnimator.REVERSE);
        animator.start();
    }

    /**
     * XML方式 位移动画
     * @param view v
     */
    public void startTranslateByXML(View view) {
        Animator animator = AnimatorInflater.loadAnimator(this, R.animator.translate);
        animator.setTarget(imageView);
        animator.start();
    }

    /**
     * 代码的方式 淡入淡出
     * @param view v
     */
    public void startAlphaByCode(View view) {
        //淡入淡出 从 0.2 的不透明度 -> 0.8 的不透明度 -> 0.5 的不透明度 -> 1 完全不透明
        ObjectAnimator animator = ObjectAnimator.ofFloat(imageView,"alpha",0.2f,0.8f,0.5f,1);
        animator.setDuration(3000);
        //animator.setRepeatMode(ValueAnimator.REVERSE);
        animator.start();
    }

    /**
     * XML的方式 淡入淡出
     * @param view v
     */
    public void startAlphaByXML(View view) {
        Animator animator = AnimatorInflater.loadAnimator(this, R.animator.alpha);
        animator.setTarget(imageView);
        animator.start();
    }

    /**
     * 代码方式 动画集合
     * @param view v
     */
    public void startAnimatorSetByCode(View view) {
        //创建 AnimatorSet 集合对象
        AnimatorSet set = new AnimatorSet();
        //创建 淡入淡出动画
        ObjectAnimator animatorAlpha = ObjectAnimator.ofFloat(imageView,"alpha",0.2f,1);
        //创建 平移动画
        ObjectAnimator animatorTranslationX = ObjectAnimator.ofFloat(imageView,"translationX",0,300,100,500);
        //设置顺序播放
        //set.playSequentially(animatorTranslationX,animatorAlpha);
        //设置一起播放
        set.playTogether(animatorAlpha, animatorTranslationX);
        //设置作用的对象
        set.setTarget(imageView);
        //设置动画时长
        set.setDuration(3000);
        //开始执行动画
        set.start();
    }

    /**
     * XML方式 动画集合
     * @param view v
     */
    public void startAnimatorSetByXML(View view) {
        Animator animator = AnimatorInflater.loadAnimator(this, R.animator.animator_set);
        animator.setTarget(imageView);
        animator.start();
    }
}
