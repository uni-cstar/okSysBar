package unics.oksysbar;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * Created by Lucio on 2019/6/6.
 * 状态栏伪装（与状态栏等高的View，用于需要放在布局顶端占用状态栏高度的场景）
 */
public class StatusBarFakerView extends View {

    private static int availableStatusBarHeight = 0;

    public StatusBarFakerView(Context context) {
        super(context);
    }

    public StatusBarFakerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public StatusBarFakerView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        setMeasuredDimension(measureWidth(widthMeasureSpec), measureHeight(heightMeasureSpec));
    }

    private int measureWidth(int measureSpec) {
        return getMeasureSize(
                Math.max(getSuggestedMinimumWidth(), getResources().getDisplayMetrics().widthPixels),
                measureSpec,
                "measureWidth"
        );
    }

    private int measureHeight(int measureSpec) {
        return getMeasureSize(
                Math.max(getSuggestedMinimumHeight(), getAvailableStatusBarHeight(getContext())),
                measureSpec,
                "measureHeight"
        );
    }

    private int getMeasureSize(int size, int measureSpec, String tag) {
        int result;
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);
        if (specMode == MeasureSpec.EXACTLY) {
            result = specSize;
            if (OkSysBar.DEBUG) {
                Log.e("OkSysBar", tag + ": [EXACTLY] size=" + size);
            }
        } else if (specMode == View.MeasureSpec.AT_MOST) {
            result = Math.min(size, specSize);
            if (OkSysBar.DEBUG) {
                Log.e("OkSysBar", tag + ": [AT_MOST] size=" + size);
            }
        } else {
            result = size;
            if (OkSysBar.DEBUG) {
                Log.e("OkSysBar", tag + ": [UNSPECIFIED] size=" + size);
            }
        }
        return result;
    }

    /**
     * 获取状态栏高度;通过资源读取状态栏高度
     */
    public static int getStatusBarHeight(Context ctx) {
        Resources res = ctx.getResources();
        try {
            @SuppressLint("InternalInsetResource") int resourceId = res.getIdentifier("status_bar_height", "dimen", "android");
            if (resourceId > 0) {
                return res.getDimensionPixelSize(resourceId);
            }
        } catch (Resources.NotFoundException e) {
            if (OkSysBar.DEBUG) {
                Log.e("OkSysBar", "StatusBarFakerView:getStatusBarHeight error.", e);
            }
        }
        return 0;
    }

    public static int getAvailableStatusBarHeight(Context ctx) {
        if (availableStatusBarHeight == 0) {
            availableStatusBarHeight = getStatusBarHeight(ctx);
            if (availableStatusBarHeight == 0 && Build.VERSION.SDK_INT >= 19) {
                //如果获取系统状态栏高度失败，并且设备系统大于19，则默认25dp
                availableStatusBarHeight =
                        (int) (ctx.getResources().getDisplayMetrics().density * 25);
            }
        }
        return availableStatusBarHeight;
    }

}
