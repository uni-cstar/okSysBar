package unics.sysbar;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import unics.oksysbar.SystemBar;


public class ImmersiveBarActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SystemBar.applyImmersiveNavigationBar(this);
    }

}
