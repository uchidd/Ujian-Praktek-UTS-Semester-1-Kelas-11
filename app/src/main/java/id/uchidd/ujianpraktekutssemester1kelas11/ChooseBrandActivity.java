package id.uchidd.ujianpraktekutssemester1kelas11;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ChooseBrandActivity extends AppCompatActivity {

    @BindView(R.id.ivBackMain)
    ImageView ivBackMain;
    @BindView(R.id.vFirst)
    View vFirst;
    @BindView(R.id.vSecond)
    View vSecond;
    @BindView(R.id.vThird)
    View vThird;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_brand);
        ButterKnife.bind(this);

        ivBackMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChooseBrandActivity.this, MainActivity.class));
                finishAffinity();
                finish();
            }
        });

        vFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToCP = new Intent(ChooseBrandActivity.this, ChooseProductActivity.class);
                goToCP.putExtra("BRAND", "ADIDAS");
                startActivity(goToCP);
                finishAffinity();
                finish();
            }
        });

        vSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToCP = new Intent(ChooseBrandActivity.this, ChooseProductActivity.class);
                goToCP.putExtra("BRAND", "NIKE");
                startActivity(goToCP);
                finishAffinity();
                finish();
            }
        });

        vThird.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToCP = new Intent(ChooseBrandActivity.this, ChooseProductActivity.class);
                goToCP.putExtra("BRAND", "New Balance");
                startActivity(goToCP);
                finishAffinity();
                finish();
            }
        });

        hideNavigationBar();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this, MainActivity.class));
        finishAffinity();
        finish();
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
