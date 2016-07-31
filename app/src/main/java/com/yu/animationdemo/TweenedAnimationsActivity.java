package com.yu.animationdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

/**
 * 补间动画 TweenedAnimations
 * Created by yu on 2016/7/12.
 *
 * 代码的方式使用 TweenedAnimations 的步骤：
 *  1.创建一个 AnimationSet 对象（Animation 子类）；
 *  2.增加需要创建相应的 Animation 对象；
 *  3.更加项目的需求，为 Animation 对象设置相应的数据；
 *  4.将 Animation 对象添加到 AnimationSet 对象当中；
 *  5.使用控件对象开始执行 AnimationSet。
 *
 * XML的方式使用 TweenedAnimations 的步骤：
 *  1. 在res文件夹下面新建一个名为 anim 的文件夹
 *  2. 在 anim 文件夹下新建 xml 文件，根标签设为 set （相当于 AnimationSet）
 *  3. 在 set 标签中添加子标签 (可为 rotate、scale、alpha、translate)
 *  4. 在代码中使用 AnimationUtils 加载 xml 文件，并生成 Animation 对象
 *  5. 使用控件对象开始执行 Animation
 *
 *  注：例子中的 Animation.RELATIVE_TO_SELF 相对自身 和 Animation.RELATIVE_TO_PARENT 相对父控件
 *  相对的概念是指 相对于控件自身的坐标原点或者相对于父控件的坐标原点来说的 默认都是左上角
 *  但如果父控件设置了 android:gravity="center" 那么父控件的坐标原点就变为父控件的中心了
 */
public class TweenedAnimationsActivity extends AppCompatActivity {

    private ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tweened_animations);
        imageView = (ImageView) findViewById(R.id.iv_chry);
    }

    /**
     * 代码的方式创建 移动动画
     * @param view v
     */
    public void startTranslateByCode(View view) {
        //1.创建一个 AnimationSet 对象(集合)，true 表示使用 AnimationSet 自带的插补器，false 表示使用自定义的插补器
        AnimationSet animationSet = new AnimationSet(true);
        /**
         * 2.创建 TranslateAnimation 对象
         * 8个参数，参数1、2确定X起点；参数3、4确定X终点；参数5、6确定Y起点；参数7、8确定Y终点
         *
         * 参数1：描述x轴起始坐标的类型  Animation.ABSOLUTE绝对坐标； Animation.RELATIVE_TO_SELF相对自身； Animation.RELATIVE_TO_PARENT.相对父控件
         * 参数2：x起始坐标：如果参数1是 Animation.ABSOLUTE，那么这里可以填绝对数值，0表示左边界；否则可以是一个相对于自身或父控件的百分比（1.0 表示 100%）
         * 参数3：描述x轴结束坐标的类型  Animation.ABSOLUTE绝对坐标； Animation.RELATIVE_TO_SELF相对自身； Animation.RELATIVE_TO_PARENT.相对父控件
         * 参数4：x结束坐标：如果参数3是 Animation.ABSOLUTE，那么这里可以填绝对数值，0表示左边界；否则可以是一个相对于自身或父控件的百分比（1.0 表示 100%）
         *
         * 参数5：描述y轴起始坐标的类型  Animation.ABSOLUTE绝对坐标； Animation.RELATIVE_TO_SELF相对自身； Animation.RELATIVE_TO_PARENT.相对父控件
         * 参数6：y起始坐标：如果参数5是 Animation.ABSOLUTE，那么这里可以填绝对数值，0表示左边界；否则可以是一个相对于自身或父控件的百分比（1.0 表示 100%）
         * 参数7：描述y轴终止坐标的类型  Animation.ABSOLUTE绝对坐标； Animation.RELATIVE_TO_SELF相对自身； Animation.RELATIVE_TO_PARENT.相对父控件
         * 参数8：y终止坐标：如果参数7是 Animation.ABSOLUTE，那么这里可以填绝对数值，0表示左边界；否则可以是一个相对于自身或父控件的百分比（1.0 表示 100%）
         *
         * 此处效果：以父控件左上角移动到右下角
         */
        TranslateAnimation translateAnimation = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT,0,Animation.RELATIVE_TO_PARENT,1,
                Animation.RELATIVE_TO_PARENT,0,Animation.RELATIVE_TO_PARENT,1);
        //3.为 translateAnimation 设置参数，如动画执行时间为2秒
        // 也可以使用 animationSet.setDuration(3000);这样集合内的所有动画都拥有这个效果
        translateAnimation.setDuration(3000);
        //4.把 translateAnimation 添加到 AnimationSet 中
        animationSet.addAnimation(translateAnimation);
        //5.给定控件开始执行 AnimationSet
        imageView.startAnimation(animationSet);
        //imageView.startAnimation(translateAnimation);
    }

    /**
     * 代码的方式创建 缩放动画
     * @param view v
     */
    public void startScaleByCode(View view) {
        //1.创建一个 AnimationSet 对象(集合)，true 表示使用 AnimationSet 自带的插补器，false 表示使用自定义的插补器
        AnimationSet animationSet = new AnimationSet(true);
        /**
         * 2.创建 ScaleAnimation 对象
         * 8个参数，参数1、2确定X轴（水平方向）缩放；参数3、4确定Y轴（竖直方向）的缩放；后四个参数确定缩放的中心位置(缩放过程中中心是不变的)
         *
         * 参数1：X轴的初始大小 1.0表示原始尺寸
         * 参数2：X轴缩放后的大小
         * 参数3：Y轴的初始大小
         * 参数4：Y轴缩放后的大小
         *
         * 参数5：描述x轴坐标的类型  Animation.ABSOLUTE绝对坐标； Animation.RELATIVE_TO_SELF相对自身； Animation.RELATIVE_TO_PARENT.相对父控件
         * 参数6：x轴坐标：如果参数5是 Animation.ABSOLUTE，那么这里可以填绝对数值，0表示左边界；否则可以是一个相对于自身或父控件的百分比（1.0 表示 100%）
         * 参数7：描述y轴坐标的类型  Animation.ABSOLUTE绝对坐标； Animation.RELATIVE_TO_SELF相对自身； Animation.RELATIVE_TO_PARENT.相对父控件
         * 参数8：y轴坐标：如果参数7是 Animation.ABSOLUTE，那么这里可以填绝对数值，0表示左边界；否则可以是一个相对于自身或父控件的百分比（1.0 表示 100%）
         *
         * 此处效果：以控件的左上角为坐标原点进行缩放，从原始尺寸放大到 原来的2倍
         */
        ScaleAnimation scaleAnimation = new ScaleAnimation(1,2,1,2,Animation.RELATIVE_TO_SELF,0.0f,Animation.RELATIVE_TO_SELF,0.0f);
        //3.为 scaleAnimation 设置动画参数，如缩放过程用时3s
        scaleAnimation.setDuration(3000);
        //4.把 scaleAnimation 添加到 animationSet 中
        animationSet.addAnimation(scaleAnimation);
        //5.让控件执行动画
        imageView.startAnimation(animationSet);
    }

    /**
     * 代码的方式创建 旋转动画
     * @param view v
     */
    public void startRotateByCode(View view) {
        //1.创建一个 AnimationSet 对象(集合)，true 表示使用 AnimationSet 自带的插补器，false 表示使用自定义的插补器
        AnimationSet animationSet = new AnimationSet(true);
        /**
         * 2.创建 RotateAnimation 对象
         * 6个参数，前两个参数确定旋转的角度,后四个参数确定旋转的圆心位置
         * 参数1：旋转起始角度
         * 参数2：旋转结束角度
         * 参数3：描述x轴坐标的类型  Animation.ABSOLUTE绝对坐标； Animation.RELATIVE_TO_SELF相对自身； Animation.RELATIVE_TO_PARENT.相对父控件
         * 参数4：x轴坐标：如果参数3是 Animation.ABSOLUTE，那么这里可以填绝对数值，0表示左边界；否则可以是一个相对于自身或父控件的百分比（1.0 表示 100%）
         * 参数5：描述y轴坐标的类型  Animation.ABSOLUTE绝对坐标； Animation.RELATIVE_TO_SELF相对自身； Animation.RELATIVE_TO_PARENT.相对父控件
         * 参数6：y轴坐标：如果参数5是 Animation.ABSOLUTE，那么这里可以填绝对数值，0表示左边界；否则可以是一个相对于自身或父控件的百分比（1.0 表示 100%）
         * 此处效果：以控件自身中心为圆心，旋转一圈
         */
        RotateAnimation rotateAnimation = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        //3.为 rotateAnimation 设置动画参数，如旋转过程用时3s
        rotateAnimation.setDuration(3000);
        //4.把 rotateAnimation 添加到 animationSet 中
        animationSet.addAnimation(rotateAnimation);
        //5.让控件执行动画
        imageView.startAnimation(animationSet);
    }

    /**
     * 代码的方式创建 淡入淡出动画
     * @param view v
     */
    public void startAlphaByCode(View view) {
        //1.创建一个 AnimationSet 对象(集合)，true 表示使用 AnimationSet 自带的插补器，false 表示使用自定义的插补器
        AnimationSet animationSet = new AnimationSet(true);
        /**
         * 2.创建 AlphaAnimation 对象
         * 参数1：起始透明度  1表示完全不透明，0表示完全透明
         * 参数2：截止透明度  1表示完全不透明，0表示完全透明
         * 此处效果：从完全不透明到完全透明渐变
         */
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        //3.为 AlphaAnimation 设置参数，如动画渐变的过程为3秒
        alphaAnimation.setDuration(3000);
        //4.把 AlphaAnimation 添加到 AnimationSet 中
        animationSet.addAnimation(alphaAnimation);
        //5.给定控件开始执行 AnimationSet
        imageView.startAnimation(animationSet);
    }


    /**
     * XML的方式创建 淡入淡出动画
     * @param view v
     */
    public void startAlphaByXML(View view) {
        // 1. 在res文件夹下面新建一个名为 anim 的文件夹
        // 2. 在 anim 文件夹下新建 xml 文件，根标签设为 set （相当于 AnimationSet）
        // 3. 在 set 标签中添加子标签 alpha
        // 4. 在代码中使用 AnimationUtils 加载 xml 文件，并生成 Animation 对象
        Animation alpha = AnimationUtils.loadAnimation(this, R.anim.alpha);
        // 5. 使用控件对象开始执行 Animation
        imageView.startAnimation(alpha);
    }

    /**
     * XML的方式创建 旋转动画
     * @param view v
     */
    public void startRotateByXML(View view) {
        // 1. 在res文件夹下面新建一个名为 anim 的文件夹
        // 2. 在 anim 文件夹下新建 xml 文件，根标签设为 set （相当于 AnimationSet）
        // 3. 在 set 标签中添加子标签 rotate
        // 4. 在代码中使用 AnimationUtils 加载 xml 文件，并生成 Animation 对象
        Animation rotate = AnimationUtils.loadAnimation(this, R.anim.rotate);
        // 5. 使用控件对象开始执行 Animation
        imageView.startAnimation(rotate);
    }

    /**
     * XML的方式创建 缩放动画
     * @param view v
     */
    public void startScaleByXML(View view) {
        // 1. 在res文件夹下面新建一个名为 anim 的文件夹
        // 2. 在 anim 文件夹下新建 xml 文件，根标签设为 set （相当于 AnimationSet）
        // 3. 在 set 标签中添加子标签 scale
        // 4. 在代码中使用 AnimationUtils 加载 xml 文件，并生成 Animation 对象
        Animation scale = AnimationUtils.loadAnimation(this, R.anim.scale);
        // 5. 使用控件对象开始执行 Animation
        imageView.startAnimation(scale);
    }

    /**
     * XML的方式创建 移动动画
     * @param view v
     */
    public void startTranslateByXML(View view) {
        // 1. 在res文件夹下面新建一个名为 anim 的文件夹
        // 2. 在 anim 文件夹下新建 xml 文件，根标签设为 set （相当于 AnimationSet）
        // 3. 在 set 标签中添加子标签 translate
        // 4. 在代码中使用 AnimationUtils 加载 xml 文件，并生成 Animation 对象
        Animation translate = AnimationUtils.loadAnimation(this, R.anim.translate);
        // 5. 使用控件对象开始执行 Animation
        imageView.startAnimation(translate);
    }

    /**
     * 代码的方式创建 动画集合
     * @param view v
     */
    public void startAnimationSetByCode(View view) {
        // 创建 AnimationSet 对象
        AnimationSet animationSet = new AnimationSet(true);
        //旋转动画 以自身中心为圆心顺时针旋转 2 圈
        RotateAnimation rotateAnimation = new RotateAnimation(0, 720,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        //移动动画 从父控件(坐标原点)左上角移动到右下角
        TranslateAnimation translateAnimation = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT,0,Animation.RELATIVE_TO_PARENT,1,
                Animation.RELATIVE_TO_PARENT,0,Animation.RELATIVE_TO_PARENT,1);
        //把动画添加到动画集合中
        animationSet.addAnimation(rotateAnimation);
        animationSet.addAnimation(translateAnimation);

        //设置通用属性
        animationSet.setDuration(2000); // 动画时长 2 秒
        animationSet.setStartOffset(500);// 延迟 500 毫秒再开始动画
        //开始执行动画
        imageView.startAnimation(animationSet);
    }

    /**
     * XML 的方式创建 动画集合
     * @param view v
     */
    public void startAnimationSetByXML(View view) {
        //使用 AnimationUtils 加载 xml 文件，并生成 Animation 对象
        Animation animation =  AnimationUtils.loadAnimation(this, R.anim.animations_set);
        //开始执行动画
        imageView.startAnimation(animation);
    }
}
