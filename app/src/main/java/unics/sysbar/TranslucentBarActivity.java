package unics.sysbar;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import unics.oksysbar.OkSysBar;


public class TranslucentBarActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        OkSysBar.setStatusBarColor(this, Color.BLUE);
    }

}
