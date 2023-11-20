package unics.sysbar;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import unics.oksysbar.OkSysBar;

public class StatusBarModeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status_bar_mode);

        findViewById(R.id.darkMode).setOnClickListener(v -> OkSysBar.setStatusBarDarkMode(StatusBarModeActivity.this));

        findViewById(R.id.darkModeRed).setOnClickListener(v -> {
            OkSysBar.setStatusBarDarkMode(StatusBarModeActivity.this);
            OkSysBar.setStatusBarColor(StatusBarModeActivity.this, Color.RED, Color.BLUE, 0.5f);
        });

        findViewById(R.id.lightMode).setOnClickListener(v -> OkSysBar.setStatusBarLightMode(StatusBarModeActivity.this));

        findViewById(R.id.lightMode2).setOnClickListener(v -> {
            OkSysBar.setStatusBarDarkMode(StatusBarModeActivity.this);
            OkSysBar.setImmersiveStatusBar(StatusBarModeActivity.this);
        });

    }

}
