package id.uchidd.ujianpraktekutssemester1kelas11;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CheckoutActivity extends AppCompatActivity {

    @BindView(R.id.ivBackCP)
    ImageView ivBackCP;
    @BindView(R.id.tvDetail1)
    TextView tvDetail1;
    @BindView(R.id.tvDetail2)
    TextView tvDetail2;
    @BindView(R.id.tvDetail3)
    TextView tvDetail3;
    @BindView(R.id.tvDetail4)
    TextView tvDetail4;
    @BindView(R.id.tvDetail5)
    TextView tvDetail5;
    @BindView(R.id.tvDetail6)
    TextView tvDetail6;
    @BindView(R.id.tvDetail7)
    TextView tvDetail7;
    @BindView(R.id.tvCheckout1)
    TextView tvCheckout1;
    @BindView(R.id.tvCheckout2)
    TextView tvCheckout2;
    @BindView(R.id.tvCheckout3)
    TextView tvCheckout3;
    @BindView(R.id.tvCheckout4)
    TextView tvCheckout4;
    @BindView(R.id.tvCheckout5)
    TextView tvCheckout5;
    @BindView(R.id.tvCheckout6)
    TextView tvCheckout6;
    @BindView(R.id.tvCheckout7)
    TextView tvCheckout7;
    @BindView(R.id.cvSaveTransaction)
    CardView cvSaveTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);
        ButterKnife.bind(this);

        Bundle getData = getIntent().getExtras();
        String getBrand = getData.getString("BRAND");
        String getName = getData.getString("NAME");
        String getColor = getData.getString("COLOR");
        String getPrice = getData.getString("PRICE");
        int getUkuran = getData.getInt("UKURAN");
        int getJumlahBeli = getData.getInt("JUMLAHBELI");
        String getTotalHargaText = getData.getString("TOTALHARGATEXT");
        String getNama = getData.getString("NAMA");
        String getTelp = getData.getString("TELP");
        String getAlamat = getData.getString("ALAMAT");
        String getPengiriman = getData.getString("PENGIRIMAN");
        String getTax = getData.getString("TAX");
        String getPembayaran = getData.getString("PEMBAYARAN");

        String subtotalString = getTotalHargaText.replaceAll("[^0-9]", "");
        int subtotalInt = Integer.parseInt(subtotalString);
        String taxString = getTax.replaceAll("[^0-9]", "");
        int taxInt = Integer.parseInt(taxString);
        int totalInt = subtotalInt + taxInt;
        String totalString = "IDR " + totalInt;

        tvDetail1.setText(getBrand);
        tvDetail2.setText(getName);
        tvDetail3.setText(getColor);
        tvDetail4.setText(getPrice);
        tvDetail5.setText("" + getUkuran);
        tvDetail6.setText("" + getJumlahBeli);
        tvDetail7.setText(getTotalHargaText);

        tvCheckout1.setText(getNama);
        tvCheckout2.setText(getTelp);
        tvCheckout3.setText(getAlamat);
        tvCheckout4.setText(getPengiriman);
        tvCheckout5.setText(getTax);
        tvCheckout6.setText(getPembayaran);
        tvCheckout7.setText(totalString);

        pushData (getBrand, getName, getColor, getUkuran, getJumlahBeli, getTotalHargaText);
    }

    public void pushData(String brand, String text1, String text2, Integer text3, Integer text4, String price ) {

        final Bundle bundle = new Bundle();
        bundle.putString("BRAND", brand);
        bundle.putString("NAME", text1);
        bundle.putString("COLOR", text2);
        bundle.putInt("UKURAN", text3);
        bundle.putInt("JUMLAHBELI", text4);
        bundle.putString("TOTALHARGATEXT", text5);

        bundle.putString("NAMA", text6);
        bundle.putString("TELP", text7);
        bundle.putString("ALAMAT", text8);
        bundle.putString("PENGIRIMAN", text9);
        bundle.putString("TAX", text10);
        bundle.putString("PEMBAYARAN", text11);
        bundle.putString("TOTAL", text12);

        //Rizki Khaerul

        cvSaveTransaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToDetailProduk = new Intent(CheckoutActivity.this, ListTransactionActivity.class);
                goToDetailProduk.putExtras(bundle);
                startActivity(goToDetailProduk);
                return;
            }
        });

    }
}
