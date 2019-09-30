package id.uchidd.ujianpraktekutssemester1kelas11;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import id.uchidd.ujianpraktekutssemester1kelas11.model.DatabaseHelper;
import id.uchidd.ujianpraktekutssemester1kelas11.model.ListTransaction;
import id.uchidd.ujianpraktekutssemester1kelas11.utils.AdapterListTransaction;
import id.uchidd.ujianpraktekutssemester1kelas11.utils.RecycleTouchListener;

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

        linearLayout = (LinearLayout)findViewById(R.id.linear_layout_main);
        rv_listtransaction = (RecyclerView)findViewById(R.id.rvList);

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
