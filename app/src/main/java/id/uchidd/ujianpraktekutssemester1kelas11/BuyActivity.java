package id.uchidd.ujianpraktekutssemester1kelas11;

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

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BuyActivity extends AppCompatActivity {

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

        int ukuran = spinnerSizeOD.getSelectedItem().hashCode();
        int jumlah = spinnerQtyOD.getSelectedItem().hashCode();
        int harga = getPrice
        tvTotalOD.setText();

    }
}
