package id.uchidd.ujianpraktekutssemester1kelas11;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BuyActivity extends AppCompatActivity {

    int getJumlahBeli;
    String getTotalHargaText, getMethod, getTax;

    @BindView(R.id.ivProductOD)
    ImageView ivProductOD;
    @BindView(R.id.tvBrandOD)
    TextView tvBrandOD;
    @BindView(R.id.tvNameOD)
    TextView tvNameOD;
    @BindView(R.id.tvColorOD)
    TextView tvColorOD;
    @BindView(R.id.tvPriceOD)
    TextView tvPriceOD;
    @BindView(R.id.spinnerSizeOD)
    Spinner spinnerSizeOD;
    @BindView(R.id.spinnerQtyOD)
    Spinner spinnerQtyOD;
    @BindView(R.id.tvTotalOD)
    TextView tvTotalOD;
    @BindView(R.id.etRecipientOD)
    EditText etRecipientOD;
    @BindView(R.id.etPhoneOD)
    EditText etPhoneOD;
    @BindView(R.id.etAddressOD)
    EditText etAddressOD;
    @BindView(R.id.spinnerMethodShippingOD)
    Spinner spinnerMethodShippingOD;
    @BindView(R.id.tvTaxOD)
    TextView tvTaxOD;
    @BindView(R.id.spinnerMethodPaymentOD)
    Spinner spinnerMethodPaymentOD;
    @BindView(R.id.cvCheckoutOD)
    CardView cvCheckoutOD;

    private Integer[] ukuran = {
            37,
            38,
            39,
            40,
            41,
            42,
            43,
            44,
            45
    };

    private Integer[] jumlah = {
            1,
            2,
            3,
            4,
            5,
            6,
            7,
            8,
            9
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy);
        ButterKnife.bind(this);

        Bundle getData = getIntent().getExtras();
        final String getBrand = getData.getString("BRAND");
        final String getName = getData.getString("NAME");
        final String getColor = getData.getString("COLOR");
        final String getPrice = getData.getString("PRICE");
        final Integer getImage = getData.getInt("IMAGE");

        int notelp;

        Picasso.get().load(getImage).into(ivProductOD);
        tvBrandOD.setText(getBrand);
        tvNameOD.setText(getName);
        tvPriceOD.setText(getColor);
        tvPriceOD.setText(getPrice);

        ArrayAdapter<Integer> adapterUkuran = new ArrayAdapter<Integer>(BuyActivity.this, R.layout.spinner_checked, ukuran);
        adapterUkuran.setDropDownViewResource(R.layout.spinner_list);
        spinnerSizeOD.setAdapter(adapterUkuran);

        ArrayAdapter<Integer> adapterJumlah = new ArrayAdapter<Integer>(BuyActivity.this, R.layout.spinner_checked, jumlah);
        adapterJumlah.setDropDownViewResource(R.layout.spinner_list);
        spinnerQtyOD.setAdapter(adapterJumlah);

        final int ukuran = spinnerSizeOD.getSelectedItem().hashCode();

        spinnerQtyOD.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                int jumlahBeli = spinnerQtyOD.getSelectedItem().hashCode();
                String hargaString = getPrice.replaceAll("[^0-9]", "");
                int hargaInt = Integer.parseInt(hargaString);
                int totalHarga = hargaInt * jumlahBeli;
                String totalHargaText = "IDR " + totalHarga;

                tvTotalOD.setText(totalHargaText);

                getJumlahBeli = jumlahBeli;
                getTotalHargaText = totalHargaText;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter<CharSequence> adapterMethodPengiriman = ArrayAdapter.createFromResource(BuyActivity.this, R.array.metodePengiriman, R.layout.spinner_checked);
        adapterMethodPengiriman.setDropDownViewResource(R.layout.spinner_list);
        spinnerMethodShippingOD.setAdapter(adapterMethodPengiriman);


        spinnerMethodShippingOD.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (spinnerMethodShippingOD.getSelectedItem().toString().equals("Instant")){
                    String method1 = spinnerMethodShippingOD.getSelectedItem().toString();
                    String tax1 = "IDR 15000";
                    tvTaxOD.setText(tax1);

                    getMethod = method1;
                    getTax = tax1;
                } else if (spinnerMethodShippingOD.getSelectedItem().toString().equals("Same Day")) {
                    String method2 = spinnerMethodShippingOD.getSelectedItem().toString();
                    String tax2 = "IDR 10000";
                    tvTaxOD.setText(tax2);

                    getMethod = method2;
                    getTax = tax2;
                } else if (spinnerMethodShippingOD.getSelectedItem().toString().equals("Regular")) {
                    String method3 = spinnerMethodShippingOD.getSelectedItem().toString();
                    String tax3 = "IDR 5000";
                    tvTaxOD.setText(tax3);

                    getMethod = method3;
                    getTax = tax3;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter<CharSequence> adapterMethodPembayaran = ArrayAdapter.createFromResource(BuyActivity.this, R.array.metodePembayaran, R.layout.spinner_checked);
        adapterMethodPembayaran.setDropDownViewResource(R.layout.spinner_list);
        spinnerMethodPaymentOD.setAdapter(adapterMethodPembayaran);

        cvCheckoutOD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String nama = String.valueOf(etRecipientOD.getText());
                String no = String.valueOf(etPhoneOD.getText());
                final String telp = no;
                final String alamat = String.valueOf(etAddressOD.getText());
                String methodPay = spinnerMethodPaymentOD.getSelectedItem().toString();

                Toast.makeText(BuyActivity.this,
                        getBrand + " " +
                        getName + " " +
                        getColor + " " +
                        getPrice + " " +
                        ukuran + " " +
                        getJumlahBeli + " " +
                        getTotalHargaText + " " +
                        nama + " " +
                        telp + " " +
                        alamat + " " +
                        getMethod + " " +
                        getTax + " " +
                        methodPay + " " , Toast.LENGTH_SHORT).show();

                pushData(getBrand, getName, getColor, getPrice, ukuran, getJumlahBeli, getTotalHargaText, nama, telp, alamat, getMethod, getTax, methodPay);

            }
        });

    }

    private void pushData(String brand,
                          String name,
                          String color,
                          String price,
                          Integer ukuran,
                          Integer jumlahBeli,
                          String totalHargaText,
                          String nama,
                          String telp,
                          String alamat,
                          String pengiriman,
                          String tax,
                          String pembayaran) {

        Bundle bundle = new Bundle();
        bundle.putString("BRAND", brand);
        bundle.putString("NAME", name);
        bundle.putString("COLOR", color);
        bundle.putString("PRICE", price);
        bundle.putInt("UKURAN", ukuran);
        bundle.putInt("JUMLAHBELI", jumlahBeli);
        bundle.putString("TOTALHARGATEXT", totalHargaText);
        bundle.putString("NAMA", nama);
        bundle.putString("TELP", telp);
        bundle.putString("ALAMAT", alamat);
        bundle.putString("PENGIRIMAN", pengiriman);
        bundle.putString("TAX", tax);
        bundle.putString("PEMBAYARAN", pembayaran);

        Intent goToDetailProduk = new Intent(this, CheckoutActivity.class);
        goToDetailProduk.putExtras(bundle);
        startActivity(goToDetailProduk);
        return;

    }

//    public void hideNavigationBar() {
//
//        this.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
//                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
//                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
//                | View.SYSTEM_UI_FLAG_FULLSCREEN
//                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
//
//    }

}
