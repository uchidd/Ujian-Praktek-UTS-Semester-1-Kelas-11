package id.uchidd.ujianpraktekutssemester1kelas11;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SplashScreenActivity extends AppCompatActivity {

    @BindView(R.id.pgloading)
    ProgressBar pgloading;

    private int progressStatusDefault = 0;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        ButterKnife.bind(this);

        splashrun();
        hideNavigationBar();
    }

    private void splashrun() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (progressStatusDefault < 100) {
                    progressStatusDefault += 1;

                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            pgloading.setProgress(progressStatusDefault);

                            int hasil = progressStatusDefault;
                            if (hasil == 100) {
                                startActivity(new Intent(SplashScreenActivity.this, MainActivity.class));
                                finish();
                            }
                        }
                    });
                }
            }
        }).start();
    }

    public void hideNavigationBar() {

        this.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

    }
}
