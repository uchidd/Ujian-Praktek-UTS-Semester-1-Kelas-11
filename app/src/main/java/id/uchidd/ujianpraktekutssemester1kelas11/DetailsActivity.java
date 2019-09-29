package id.uchidd.ujianpraktekutssemester1kelas11;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailsActivity extends AppCompatActivity {


    @BindView(R.id.ivBackCP)
    ImageView ivBackCP;
    @BindView(R.id.ivImage)
    ImageView ivImage;
    @BindView(R.id.tvDetails1)
    TextView tvDetails1;
    @BindView(R.id.tvDetails2)
    TextView tvDetails2;
    @BindView(R.id.tvDetails3)
    TextView tvDetails3;
    @BindView(R.id.tvDetails5)
    TextView tvDetails5;
    @BindView(R.id.tvDetails4)
    TextView tvDetails4;
    @BindView(R.id.cvAddToCart)
    CardView cvAddToCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ButterKnife.bind(this);

//        ivBackCP.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(DetailsActivity.this, ChooseProductActivity.class));
//                finishAffinity();
//                finish();
//            }
//        });

        Bundle getData = getIntent().getExtras();
        String getBrand = getData.getString("BRAND");
        String getName = getData.getString("NAME");
        String getColor = getData.getString("COLOR");
        String getPrice = getData.getString("PRICE");
        final Integer getDesc = getData.getInt("DESC");
        final Integer getImage = getData.getInt("IMAGE");

        Picasso.get().load(getImage).into(ivImage);
        tvDetails1.setText(getBrand);
        tvDetails2.setText(getName);
        tvDetails3.setText(getColor);
        tvDetails4.setText(getPrice);
        tvDetails5.setText(getDesc);

        pushData(getBrand, getName, getColor, getPrice, getImage);

        hideNavigationBar();
    }

    public void pushData(String brand, String text1, String text3, String text4, Integer image) {

        final Bundle bundle = new Bundle();
        bundle.putString("BRAND", brand);
        bundle.putString("NAME", text1);
        bundle.putString("COLOR", text3);
        bundle.putString("PRICE", text4);
        bundle.putInt("IMAGE", image);

        cvAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToDetailProduk = new Intent(DetailsActivity.this, BuyActivity.class);
                goToDetailProduk.putExtras(bundle);
                startActivity(goToDetailProduk);
                return;
            }
        });

    }

//    @Override
//    public void onBackPressed() {
//        super.onBackPressed();
//        startActivity(new Intent(DetailsActivity.this, ChooseProductActivity.class));
//        finishAffinity();
//        finish();
//    }

    public void hideNavigationBar() {

        this.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

    }
}
