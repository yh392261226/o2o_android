package activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

import com.gjzg.R;

import utils.UserUtils;

public class LaunchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_launch);
        if (UserUtils.isFirstUse(LaunchActivity.this)) {
            startActivity(new Intent(LaunchActivity.this, GuideActivity.class));
        } else {
            startActivity(new Intent(LaunchActivity.this, WelcomeActivity.class));
        }
        finish();
    }
}