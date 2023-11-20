package unics.oksysbar;

import android.annotation.TargetApi;
import android.app.Activity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.NonNull;

/**
 * Created by Lucio on 2020-11-15.
 * Android 5.1 以上 提供了设置System Bar颜色的方法，但是必须配合标志位使用才行；
 * 可以通过代码实现，也可以通过Style实现；
 * <p>
 * 核心原理：
 * Window添加WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS标志位，并移除WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS标志位
 * 这样设置之后，System Bar所在的区域会变成透明，并且会使用{@link Window#getStatusBarColor()} 和 {@link Window#getNavigationBarColor()}填充对应区域的颜色
 */
@TargetApi(21)
class SysBarUI21 extends SysBarUI19 {

    @Override
    public void setImmersiveStatusBar(@NonNull Activity activity, int color1, int color2, float ratio) {
        //更改状态栏颜色
        setStatusBarColor(activity, color1, color2, ratio);
        //使用沉浸式状态栏模式
        View decorView = activity.getWindow().getDecorView();
        int sysUiFlag = decorView.getSystemUiVisibility();
        int newSysUIFlag =
                sysUiFlag | View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;
        if (sysUiFlag != newSysUIFlag) {
            decorView.setSystemUiVisibility(newSysUIFlag);
        }
    }

    /**
     * 方式一：代码设置状态栏颜色
     * getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
     * getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
     * getWindow().setStatusBarColor(ContextCompat.getColor(this,android.R.color.holo_blue_dark));
     * <p>
     * 方式二:通过主题Style设置，添加以下属性（因为是android5.0新添加的属性，所以在添加到values-v21文件夹下的主题中）；
     * <item name="android:windowTranslucentStatus">false</item>
     * <item name="android:windowDrawsSystemBarBackgrounds">true</item>
     * <item name="android:statusBarColor">@android:color/holo_blue_dark</item>
     */
    @Override
    public void setStatusBarColor(@NonNull Activity activity, int color1, int color2, float ratio) {
        int blendColor = OkSysBar.blendColor(color1, color2, ratio);
        Window window = activity.getWindow();
        //添加关键标志位--状态栏和NavigationBar颜色设置的核心
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        //必须清除这个标志才能使设置的状态栏颜色生效
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        //设置状态栏颜色
        window.setStatusBarColor(blendColor);
    }

    /**
     * 设置NavigationBar的颜色；具体用法参见[android.view.Window.setNavigationBarColor]说明
     */
    @Override
    public void setNavigationBarColor(@NonNull Activity activity, int color1, int color2, float ratio) {
        int blendColor = OkSysBar.blendColor(color1, color2, ratio);
        //5.1以上透明状态栏设置的
        Window window = activity.getWindow();
        //添加关键标志位--状态栏和NavigationBar颜色设置的核心
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        //必须清除这个标志才能使设置的NavigationBarColor生效
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        window.setNavigationBarColor(blendColor);
    }

    @Override
    public void setImmersiveNavigationBar(@NonNull Activity activity, int color1, int color2, float ratio) {
        setNavigationBarColor(activity, color1, color2, ratio);
        View decorView = activity.getWindow().getDecorView();
        int sysUiFlag = decorView.getSystemUiVisibility();
        int newSysUIFlag = sysUiFlag | View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION;
        if (sysUiFlag != newSysUIFlag) {
            decorView.setSystemUiVisibility(newSysUIFlag);
        }
    }

    @Override
    public void setImmersiveSystemBar(@NonNull Activity activity, int color1, int color2, float ratio) {
        setImmersiveStatusBar(activity, color1, color2, ratio);
        setImmersiveNavigationBar(activity, color1, color2, ratio);
    }

    @Override
    public void setSystemBarColor(@NonNull Activity activity, int color1, int color2, float ratio) {
        int blendColor = OkSysBar.blendColor(color1, color2, ratio);
        Window window = activity.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        window.setStatusBarColor(blendColor);
        window.setNavigationBarColor(blendColor);
    }

}

