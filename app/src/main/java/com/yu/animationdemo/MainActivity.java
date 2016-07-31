package com.yu.animationdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    /**
     * 补间动画
     * @param view v
     */
    public void startTweenedAnimations(View view) {
        startActivity(new Intent(this, TweenedAnimationsActivity.class));
    }

    /**
     * 帧动画
     * @param view v
     */
    public void startFrameAnimations(View view) {
        startActivity(new Intent(this, FrameAnimationsActivity.class));
    }

    /**
     * 属性动画
     * @param view v
     */
    public void startAttrAnimations(View view) {
        startActivity(new Intent(this, PropertyAnimatorActivity.class));
    }
}
