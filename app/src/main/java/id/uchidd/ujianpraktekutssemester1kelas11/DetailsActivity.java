package id.uchidd.ujianpraktekutssemester1kelas11;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailsActivity extends AppCompatActivity {

    @BindView(R.id.ivBackCP)
    ImageView ivBackCP;
    @BindView(R.id.ivDetails)
    ImageView ivDetails;
    @BindView(R.id.tvDetails1)
    TextView tvDetails1;
    @BindView(R.id.tvDetails2)
    TextView tvDetails2;
    @BindView(R.id.tvDetails3)
    TextView tvDetails3;
    @BindView(R.id.tvDetails4)
    TextView tvDetails4;
    @BindView(R.id.cvAddToCart)
    CardView cvAddToCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ButterKnife.bind(this);

        hideNavigationBar();
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
