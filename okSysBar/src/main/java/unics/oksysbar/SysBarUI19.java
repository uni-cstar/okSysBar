package unics.oksysbar;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import androidx.annotation.NonNull;

/**
 * Created by Lucio on 2020-11-15.
 */
class SysBarUI19 implements SysBarUI {

    private static final int fakeStatusBarId = R.id.ucs_faker_status_bar_id;

    @Override
    public void setImmersiveStatusBar(@NonNull Activity activity, int color1, int color2, float ratio) {
        doImmersiveStatusBar(activity, color1, color2, ratio);
    }

    @Override
    public void setStatusBarColor(@NonNull Activity activity, int color1, int color2, float ratio) {
        doImmersiveStatusBar(activity, color1, color2, ratio);
        ViewGroup contentView = activity.findViewById(android.R.id.content);
        View userRoot = contentView.getChildAt(0);
        if (userRoot != null){
            userRoot.setFitsSystemWindows(true);
        }
    }

    @Override
    public void setImmersiveNavigationBar(@NonNull Activity activity, int color1, int color2, float ratio) {
        activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
    }

    @Override
    public void setNavigationBarColor(@NonNull Activity activity, int color1, int color2, float ratio) {
        //不支持，不过有人使用修改状态栏颜色的方式创建一个FakeNavigationBar来实现，经过考虑，我觉得这不是常态需求，如果真的需要实现这样的效果，在需要的时候单独针对性实现即可；
    }

    @Override
    public void setImmersiveSystemBar(@NonNull Activity activity, int color1, int color2, float ratio) {
        setImmersiveStatusBar(activity, color1, color2, ratio);
        setImmersiveNavigationBar(activity, color1, color2, ratio);
    }

    @Override
    public void setSystemBarColor(@NonNull Activity activity, int color1, int color2, float ratio) {
        setStatusBarColor(activity, color1, color2, ratio);
        setNavigationBarColor(activity, color1, color2, ratio);
    }

    /**
     * 查找或添加一个新的模拟的状态栏
     */
    private StatusBarFakerView findOrAddNewFakeStatusBar(Activity activity) {
        ViewGroup decorView = (ViewGroup) activity.getWindow().getDecorView();
        View statusBarView = decorView.findViewById(fakeStatusBarId);
        if (!(statusBarView instanceof StatusBarFakerView)) {
            statusBarView = new StatusBarFakerView(activity);
            statusBarView.setId(fakeStatusBarId);
            decorView.addView(statusBarView);
        }

        if (statusBarView.getVisibility() != View.VISIBLE) {
            statusBarView.setVisibility(View.VISIBLE);
        }
        return (StatusBarFakerView) statusBarView;
    }

    /**
     * 4.4只支持透明状态栏，即状态栏覆盖内容布局，为了达到改变状态栏背景色的效果，所以增加一个与状态栏等高的View渲染背景
     */
    private void doImmersiveStatusBar(Activity activity, int color1, int color2, float ratio) {
        //透明状态栏
        activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        //查找或添加模拟的状态栏View
        View statusBar = findOrAddNewFakeStatusBar(activity);
        //计算显示的颜色
        int blendColor = OkSysBar.blendColor(color1, color2, ratio);
        statusBar.setBackgroundColor(blendColor);
    }
}
