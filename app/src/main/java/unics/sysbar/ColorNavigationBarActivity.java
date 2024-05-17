package unics.sysbar;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import unics.oksysbar.OkSysBar;

public class ColorNavigationBarActivity extends AppCompatActivity {

    public static final Intent newIntent(Context context) {
        return newIntent(context, false);
    }

    public static final Intent newIntent(Context context, boolean immersive) {
        Intent it = new Intent(context, ColorNavigationBarActivity.class);
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
                OkSysBar.setImmersiveNavigationBar(this, Color.parseColor("#7FFF0000"), Color.parseColor("#7F00FF00"), 0.6f);
            } else {
                OkSysBar.setNavigationBarColor(this, OkSysBar.blendARGB(Color.parseColor("#7FFF0000"), Color.parseColor("#7F00FF00"), 0.6f));
            }
        });
    }

    private void setBar(int color, boolean immersive) {
        if (immersive) {
            OkSysBar.setImmersiveNavigationBar(this, color);
        } else {
            OkSysBar.setNavigationBarColor(this, color);
        }
    }

}
