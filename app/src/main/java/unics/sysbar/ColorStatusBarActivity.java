package unics.sysbar;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import unics.oksysbar.OkSysBar;

public class ColorStatusBarActivity extends AppCompatActivity {

    public static final Intent newIntent(Context context) {
        return newIntent(context, false);
    }

    public static final Intent newIntent(Context context, boolean immersive) {
        Intent it = new Intent(context, ColorStatusBarActivity.class);
        it.putExtra("immersive", immersive);
        return it;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status_bar_color);
        boolean immersive = getIntent().getBooleanExtra("immersive", false);
        findViewById(R.id.red).setOnClickListener(v -> {
            setBar(Color.RED, immersive);
        });

        findViewById(R.id.yellow).setOnClickListener(v -> {
            setBar(Color.YELLOW, immersive);
        });

        findViewById(R.id.blue).setOnClickListener(v -> {
            setBar(Color.BLUE, immersive);
        });

        findViewById(R.id.alpha).setOnClickListener(v -> {
            if (immersive) {
                OkSysBar.setImmersiveStatusBar(this, Color.parseColor("#7FFF0000"), Color.parseColor("#7F00FF00"), 0.6f);
            } else {
                OkSysBar.setStatusBarColor(this, OkSysBar.blendARGB(Color.parseColor("#7FFF0000"), Color.parseColor("#7F00FF00"), 0.6f));
            }
        });
    }

    private void setBar(int color, boolean immersive) {
        if (immersive) {
            OkSysBar.setImmersiveStatusBar(this, color);
        } else {
            OkSysBar.setStatusBarColor(this, color);
        }
    }

}
