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
                SystemBar.setStatusBarColor(this, Color.BLUE);
//                SystemBar.setStatusBarLightMode(this);
                break;
            case R.id.translucentBtn2:
                SystemBar.setStatusBarColor(this, Color.RED);
//                SystemBar.setStatusBarDarkMode(this);
                break;
            case R.id.transBtn:
                SystemBar.setImmersiveSystemBar(this);
                SystemBar.setStatusBarLightMode(this);
                break;
            case R.id.transBtn2:
                SystemBar.setStatusBarColor(this, Color.YELLOW);
                SystemBar.setStatusBarLightMode(this);
                break;
            case R.id.transBtn3:
                SystemBar.setStatusBarColor(this, Color.RED);
                SystemBar.setStatusBarDarkMode(this);
                break;
        }

    }
}
