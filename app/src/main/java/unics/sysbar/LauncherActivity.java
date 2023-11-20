package unics.sysbar;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import unics.oksysbar.SystemBar;

public class LauncherActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
    }

    public void onViewClick(View view){
        switch (view.getId()){
            case R.id.translucentBtn:
                SystemBar.applyStatusBarColor(this, Color.BLUE);
//                SystemBar.applyStatusBarLightMode(this);
                break;
            case R.id.translucentBtn2:
                SystemBar.applyStatusBarColor(this, Color.RED);
//                SystemBar.applyStatusBarDarkMode(this);
                break;
            case R.id.transBtn:
                SystemBar.applyImmersiveSystemBar(this);
                SystemBar.applyStatusBarLightMode(this);
                break;
            case R.id.transBtn2:
                SystemBar.applyStatusBarColor(this, Color.YELLOW);
                SystemBar.applyStatusBarLightMode(this);
                break;
            case R.id.transBtn3:
                SystemBar.applyStatusBarColor(this, Color.RED);
                SystemBar.applyStatusBarDarkMode(this);
                break;
        }

    }
}
