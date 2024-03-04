
package unics.oksysbar;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;

import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;

/**
 * Created by Lucio on 2020-11-15.
 * 系统UI交互：状态栏，虚拟导航栏
 */
public class SystemBar {

    static SysBarUI impl;

    static {
        int sdkInt = Build.VERSION.SDK_INT;
        if (sdkInt >= 23) {
            impl = new SysBarUi23();
        } else if (sdkInt >= 21) {
            impl = new SysBarUi21();
        } else if (sdkInt >= 19) {
            impl = new SysBarUi19();
        } else {
            impl = new SysBarUiDefault();
        }
    }

    /**
     * 设置自定义系统栏处理器
     */
    public static void setSystemBarHandler(SysBarUI handler) {
        impl = handler;
    }

    /**
     * 设置沉浸式状态栏模式（即状态栏会覆盖布局内容），并且状态栏背景透明
     */
    public static void setImmersiveStatusBar(@NonNull Activity activity) {
        impl.setImmersiveStatusBar(activity);
    }

    /**
     * 设置沉浸式状态栏模式（即状态栏会覆盖布局内容）
     *
     * @param color 状态栏背景色
     */
    public static void setImmersiveStatusBar(@NonNull Activity activity, @ColorInt int color) {
        impl.setImmersiveStatusBar(activity, color);
    }

    /**
     * 设置沉浸式状态栏模式（即状态栏会覆盖布局内容），并根据给定比率混合两种颜色，将得到的颜色应用到状态栏背景，如果比率为0，则使用[color1],如果比率为0.5,则均匀混合两种颜色，如果比率为1，则使用[color2]
     *
     * @param color1 状态栏背景色1
     * @param color2 状态栏背景色2
     * @param ratio  比率
     */
    public static void setImmersiveStatusBar(
            @NonNull Activity activity,
            @ColorInt int color1,
            @ColorInt int color2,
            @FloatRange(from = 0.0, to = 1.0) float ratio
    ) {
        impl.setImmersiveStatusBar(activity, color1, color2, ratio);
    }

    /**
     * 设置状态栏颜色：状态栏不会覆盖内容布局
     *
     * @param color 状态栏颜色值
     */
    public static void setStatusBarColor(@NonNull Activity activity, @ColorInt int color) {
        impl.setStatusBarColor(activity, color);
    }

    /**
     * 设置状态栏颜色：使用给定的比例在两种ARGB颜色之间进行混合；
     * 如果比率为0，则使用[color1],如果比率为0.5,则均匀混合两种颜色，如果比率为1，则使用[color2]
     *
     * @param color1 颜色1
     * @param color2 颜色2
     * @param ratio  比率，0-1
     */
    public static void setStatusBarColor(@NonNull Activity activity,
                                         @ColorInt int color1,
                                         @ColorInt int color2,
                                         @FloatRange(from = 0.0, to = 1.0) float ratio
    ) {
        impl.setStatusBarColor(activity, color1, color2, ratio);
    }

    /**
     * 设置沉浸式导航栏（即导航栏会覆盖内容布局），并且导航栏背景透明
     */
    public static void setImmersiveNavigationBar(@NonNull Activity activity) {
        impl.setImmersiveNavigationBar(activity);
    }

    /**
     * 设置沉浸式导航栏（即导航栏会覆盖内容布局）
     *
     * @param color 导航栏背景色
     */
    public static void setImmersiveNavigationBar(@NonNull Activity activity, @ColorInt int color) {
        impl.setImmersiveNavigationBar(activity, color);
    }


    /**
     * 设置沉浸式导航栏（即导航栏会覆盖内容布局），并根据给定比率混合两种颜色，将得到的颜色应用到状态栏背景，如果比率为0，则使用[color1],如果比率为0.5,则均匀混合两种颜色，如果比率为1，则使用[color2]
     *
     * @param color1 导航栏背景色1
     * @param color2 导航栏背景色2
     * @param ratio  比率
     */
    public static void setImmersiveNavigationBar(@NonNull Activity activity,
                                                 @ColorInt int color1,
                                                 @ColorInt int color2,
                                                 @FloatRange(from = 0.0, to = 1.0) float ratio
    ) {
        impl.setImmersiveNavigationBar(activity, color1, color2, ratio);
    }

    /**
     * 设置导航栏颜色
     *
     * @param color 状态栏颜色值
     */
    public static void setNavigationBarColor(@NonNull Activity activity, @ColorInt int color) {
        impl.setNavigationBarColor(activity, color);
    }


    /**
     * 设置Navigation Bar颜色
     * see [applyStatusBarColor]
     */
    public static void setNavigationBarColor(@NonNull Activity activity,
                                             @ColorInt int color1,
                                             @ColorInt int color2,
                                             @FloatRange(from = 0.0, to = 1.0) float ratio
    ) {
        impl.setNavigationBarColor(activity, color1, color2, ratio);
    }

    /**
     * 设置沉浸式系统栏（即状态栏和导航栏会覆盖布局内容），并且状态栏和导航栏背景透明
     */
    public static void setImmersiveSystemBar(@NonNull Activity activity) {
        impl.setImmersiveSystemBar(activity);
    }

    /**
     * 设置沉浸式系统栏（即状态栏和导航栏会覆盖布局内容）
     *
     * @param color 系统栏的背景色
     */
    public static void setImmersiveSystemBar(@NonNull Activity activity, @ColorInt int color) {
        impl.setImmersiveSystemBar(activity, color);
    }


    /**
     * 设置沉浸式系统栏（即状态栏和导航栏会覆盖布局内容），并根据给定比率混合两种颜色，将得到的颜色应用到状态栏和导航栏背景，如果比率为0，则使用[color1],如果比率为0.5,则均匀混合两种颜色，如果比率为1，则使用[color2]
     *
     * @param color1 第一个颜色
     * @param color2 第二个颜色
     * @param ratio  混合比率，如果比率为0，则使用[color1],如果比率为0.5,则均匀混合两种颜色，如果比率为1，则使用[color2]
     */
    public static void setImmersiveSystemBar(@NonNull Activity activity,
                                             @ColorInt int color1,
                                             @ColorInt int color2,
                                             @FloatRange(from = 0.0, to = 1.0) float ratio
    ) {
        impl.setSystemBarColor(activity, color1, color2, ratio);
    }

    /*
     * 设置System Bar的颜色：即同时设置Status Bar和Navigation Bar的背景颜色
     */
    public static void setSystemBarColor(@NonNull Activity activity, @ColorInt int color) {
        impl.setSystemBarColor(activity, color);
    }

    /**
     * 设置System Bar的颜色：即同时设置Status Bar和Navigation Bar的背景颜色
     */
    public static void setSystemBarColor(@NonNull Activity activity,
                                         @ColorInt int color1,
                                         @ColorInt int color2,
                                         @FloatRange(from = 0.0, to = 1.0) float ratio
    ) {
        impl.setSystemBarColor(activity, color1, color2, ratio);
    }

    /**
     * 设置状态栏为浅色模式：即状态栏背景为浅色、文字为深色（比如黑色）
     */
    public static void setStatusBarLightMode(@NonNull Activity activity) {
        impl.setStatusBarLightMode(activity);
    }

    /**
     * 设置状态栏为深色模式：即状态栏背景为深色、文字为浅色（比如白色）
     */
    public static void setStatusBarDarkMode(@NonNull Activity activity) {
        impl.setStatusBarDarkMode(activity);
    }

    /**
     * 混合颜色
     *
     * @param color1 第一个颜色
     * @param color2 第二个颜色
     * @param ratio  混合比率，如果比率为0，则使用[color1],如果比率为0.5,则均匀混合两种颜色，如果比率为1，则使用[color2]
     */
    static int blendColor(
            @ColorInt int color1,
            @ColorInt int color2,
            @FloatRange(from = 0.0, to = 1.0) float ratio
    ) {
        return blendARGB(color1, color2, ratio);
    }

    /**
     * 为了不添加core-ktx的依赖，因此复制了方法[androidx.core.graphics.ColorUtils.blendARGB]
     */
    @ColorInt
    public static int blendARGB(
            @ColorInt int color1, @ColorInt int color2,
            @FloatRange(from = 0.0, to = 1.0) float ratio
    ) {
        float inverseRatio = 1 - ratio;
        float a = Color.alpha(color1) * inverseRatio + Color.alpha(color2) * ratio;
        float r = Color.red(color1) * inverseRatio + Color.red(color2) * ratio;
        float g = Color.green(color1) * inverseRatio + Color.green(color2) * ratio;
        float b = Color.blue(color1) * inverseRatio + Color.blue(color2) * ratio;
        return Color.argb((int) a, (int) r, (int) g, (int) b);
    }
}
