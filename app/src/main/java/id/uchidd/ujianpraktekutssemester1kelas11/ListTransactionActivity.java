package id.uchidd.ujianpraktekutssemester1kelas11;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.uchidd.ujianpraktekutssemester1kelas11.model.DatabaseHelper;
import id.uchidd.ujianpraktekutssemester1kelas11.model.ListTransaction;
import id.uchidd.ujianpraktekutssemester1kelas11.utils.AdapterListTransaction;
import id.uchidd.ujianpraktekutssemester1kelas11.utils.RecycleTouchListener;

public class ListTransactionActivity extends AppCompatActivity {

    @BindView(R.id.ivBackCB)
    ImageView ivBackCB;
    @BindView(R.id.rvList)
    RecyclerView rvList;
    @BindView(R.id.linear_layout_main)
    LinearLayout linearLayoutMain;

    private AdapterListTransaction AdapterListTransaction;
    private List<ListTransaction> ListTransaction = new ArrayList<>();
    private LinearLayout linearLayout;
    private RecyclerView rv_listtransaction;

    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_transaction);
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
        String getTotal = getData.getString("TOTAL");

        linearLayout = (LinearLayout) findViewById(R.id.linear_layout_main);
        rv_listtransaction = (RecyclerView) findViewById(R.id.rvList);

        db = new DatabaseHelper(this);
        ListTransaction.addAll(db.getAllNotes());

        AdapterListTransaction = new AdapterListTransaction(this, ListTransaction);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        rv_listtransaction.setLayoutManager(layoutManager);

        rv_listtransaction.setAdapter(AdapterListTransaction);

        rv_listtransaction.addOnItemTouchListener(new RecycleTouchListener(this,
                rv_listtransaction, new RecycleTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {

            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
    }
}
