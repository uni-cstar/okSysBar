package unics.sysbar;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import unics.oksysbar.OkSysBar;

public class LauncherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
    }

    public void onViewClick(View view) {
        switch (view.getId()) {
            case R.id.colorStatusBar:
                startActivity(ColorStatusBarActivity.newIntent(this));
                break;
            case R.id.immersiveStatusBar:
                startActivity(ColorStatusBarActivity.newIntent(this, true));
                break;
            case R.id.colorNavigationBar:
                startActivity(ColorNavigationBarActivity.newIntent(this));
                break;
            case R.id.immersiveNavigationBar:
                startActivity(ColorNavigationBarActivity.newIntent(this, true));
                break;
            case R.id.immersiveSysBar:
                startActivity(new Intent(this, ImmersiveBarActivity.class));
                break;

            case R.id.statusBarMode:
                startActivity(new Intent(this, StatusBarModeActivity.class));
                break;
        }

    }
}
