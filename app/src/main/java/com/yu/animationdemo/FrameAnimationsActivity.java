package com.yu.animationdemo;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

/**
 * 帧动画
 * Created by yu on 2016/7/12.
 */
public class FrameAnimationsActivity extends AppCompatActivity{

    private ImageView ivFrameXml;  //xml 方式使用的控件
    private ImageView ivFrameCode; //代码 方式使用的控件

    private AnimationDrawable animationDrawableXml; //xml 方式使用的帧动画对象
    private AnimationDrawable animationDrawableCode;//代码 方式使用的帧动画对象
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_animations);

        // xml 方式 初始化
        initFrameXml();
        //代码方式 初始化
        initFrameCode();
    }

    /**
     * 代码的方式 初始化帧动画对象
     */
    private void initFrameCode() {
        ivFrameCode = (ImageView) findViewById(R.id.iv_frame_code);
        // 创建 AnimationDrawable 实例
        animationDrawableCode = new AnimationDrawable();
        // 添加动画帧
        animationDrawableCode.addFrame(getResources().getDrawable(R.drawable.h1),100);
        animationDrawableCode.addFrame(getResources().getDrawable(R.drawable.h2),100);
        // false 重复    true 执行一次
        animationDrawableCode.setOneShot(false);
        // 把 AnimationDrawable 设置为 ImageView 的背景
        ivFrameCode.setBackgroundDrawable(animationDrawableCode);
    }

    /**
     * Xml的方式 初始化帧动画对象
     */
    private void initFrameXml() {
        ivFrameXml = (ImageView) findViewById(R.id.iv_frame_xml);
        if (ivFrameXml != null) {
            /*
            // 方式一
            // 为 ImageView 设置 资源文件 背景
            ivFrameXml.setBackgroundResource(R.drawable.frame);
            // 获取背景作为 AnimationDrawable 对象
            animationDrawableXml = (AnimationDrawable) ivFrameXml.getBackground();
            */

            // 方式二
            // 通过逐帧动画的资源文件获得 AnimationDrawable 实例
            animationDrawableXml = (AnimationDrawable) getResources().getDrawable(R.drawable.frame);
            // 把 AnimationDrawable 设置为 ImageView 的背景
            ivFrameXml.setBackgroundDrawable(animationDrawableXml);
        }
    }

    /**
     * xml 执行动画
     * @param view v
     */
    public void startFrame(View view) {
        if (!animationDrawableXml.isRunning()) {
            ivFrameXml.setVisibility(View.VISIBLE);
            ivFrameCode.setVisibility(View.GONE);
            animationDrawableCode.stop();
            //开始动画
            animationDrawableXml.start();
        }
    }

    /**
     * xml 停止动画
     * @param view v
     */
    public void stopFrame(View view) {
        animationDrawableXml.stop();
    }

    /**
     * 代码 执行动画
     * @param view v
     */
    public void startFrameByCode(View view) {
        if (!animationDrawableCode.isRunning()) {
            ivFrameXml.setVisibility(View.GONE);
            ivFrameCode.setVisibility(View.VISIBLE);
            animationDrawableXml.stop();
            //开始动画
            animationDrawableCode.start();
        }
    }

    /**
     * 代码 停止动画
     * @param view v
     */
    public void stopFrameByCode(View view) {
        animationDrawableCode.stop();
    }
}
