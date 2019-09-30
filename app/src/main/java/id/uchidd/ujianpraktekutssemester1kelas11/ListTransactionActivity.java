package id.uchidd.ujianpraktekutssemester1kelas11;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

import id.uchidd.ujianpraktekutssemester1kelas11.model.DatabaseHelper;
import id.uchidd.ujianpraktekutssemester1kelas11.model.ListTransaction;
import id.uchidd.ujianpraktekutssemester1kelas11.utils.AdapterListTransaction;

public class ListTransactionActivity extends AppCompatActivity {

    private AdapterListTransaction AdapterListTransaction;
    private List<ListTransaction> ListTransaction = new ArrayList<>();
    private LinearLayout linearLayout;
    private RecyclerView rv_listtransaction;

    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_transaction);

        Toolbar toolbar = (Toolbar)findViewById(R.id)
    }
}
