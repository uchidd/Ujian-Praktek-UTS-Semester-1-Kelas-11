package id.uchidd.ujianpraktekutssemester1kelas11;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ChooseProductActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;

    public static final String preference = "preferenceBundle";

    public static final String safeBrand = "brandKey";

    String saveData, brand;

    @BindView(R.id.ivBackCB)
    ImageView ivBackCB;
    @BindView(R.id.rvList)
    RecyclerView rvList;

    private ArrayList<String> textName;
    private ArrayList<String> textColor;
    private ArrayList<String> textPrice;
    private ArrayList<Integer> imageList1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_product);
        ButterKnife.bind(this);

        sharedPreferences = getSharedPreferences(preference, Context.MODE_PRIVATE);

        ivBackCB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChooseProductActivity.this, ChooseBrandActivity.class));
                finishAffinity();
                finish();
            }
        });

        Bundle getData = getIntent().getExtras();
        brand = getData.getString("BRAND");

        autoSaveBrandinOnCreate();

        if (sharedPreferences.contains(safeBrand)){
            saveData = sharedPreferences.getString(safeBrand, "");
        }

        if (saveData.equals("ADIDAS")) {
            initItemViewA();
        } else if (saveData.equals("NIKE")) {
            initItemViewB();
        } else if (saveData.equals("New Balance")) {
            initItemViewC();
        }

        hideNavigationBar();
    }

    private void autoSaveBrandinOnCreate() {
        String getBrand = brand;

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(safeBrand, getBrand);

        editor.commit();

        //Toast.makeText(this, "get " + getBrand, Toast.LENGTH_SHORT).show();
    }

    private void initItemViewA() {

        final RecyclerView rvList = (RecyclerView) findViewById(R.id.rvList);
        rvList.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        rvList.setLayoutManager(layoutManager);

        textName = new ArrayList<>();
        textName.add("Adidas NMD Human Trail");
        textName.add("Adidas EQT Support 93/17");
        textName.add("Adidas Yung-1");
        textName.add("Adidas NMD R1");
        textName.add("Adidas Ultra Boost 1.0");

        textColor = new ArrayList<>();
        textColor.add("Sun Calm");
        textColor.add("White/Turbo Red");
        textColor.add("Dragon Ball Z Frieza");
        textColor.add("Clear Pink");
        textColor.add("Black Reflective");

        textPrice = new ArrayList<>();
        textPrice.add("IDR 3.800.000");
        textPrice.add("IDR 3.150.000");
        textPrice.add("IDR 2.850.000");
        textPrice.add("IDR 1.380.000");
        textPrice.add("IDR 7.850.000");

        imageList1 = new ArrayList<>();
        imageList1.add(R.drawable.adidas1);
        imageList1.add(R.drawable.adidas2);
        imageList1.add(R.drawable.adidas3);
        imageList1.add(R.drawable.adidas4);
        imageList1.add(R.drawable.adidas5);

        RecyclerView.Adapter adapter = new AdapterList(textName, textColor, textPrice, imageList1);
        rvList.setAdapter(adapter);

        rvList.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {

            GestureDetector gestureDetector = new GestureDetector(getApplicationContext(), new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }
            });

            @Override
            public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
                View child = rvList.findChildViewUnder(motionEvent.getX(), motionEvent.getY());
                if (child != null && gestureDetector.onTouchEvent(motionEvent)) {
                    int position = rvList.getChildAdapterPosition(child);

                    String brand, text1, text2, text3;
                    Integer image1;

                    brand = "ADIDAS";
                    text1 = textName.get(position);
                    text2 = textColor.get(position);
                    text3 = textPrice.get(position);
                    image1 = imageList1.get(position);

                    pushData(brand, text1, text2, text3, image1);

                }

                return false;
            }


            @Override
            public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean b) {

            }
        });
    }

    private void initItemViewB() {
        final RecyclerView rvList = (RecyclerView) findViewById(R.id.rvList);
        rvList.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        rvList.setLayoutManager(layoutManager);

        textName = new ArrayList<>();
        textName.add("Nike Air Presto Mid Acronym");
        textName.add("Nike LD Waffle Sacai");
        textName.add("Nike Air Yeezy 2");
        textName.add("Nike Air Max 1");
        textName.add("Nike Kyrie 5");

        textColor = new ArrayList<>();
        textColor.add("Racer Pink");
        textColor.add("Green Purple");
        textColor.add("Red October");
        textColor.add("Nike Day");
        textColor.add("Patrick Star");

        textPrice = new ArrayList<>();
        textPrice.add("IDR 4.250.000");
        textPrice.add("IDR 9.000.000");
        textPrice.add("IDR 35.000.000");
        textPrice.add("IDR 2.262.000");
        textPrice.add("IDR 2.600.000");

        imageList1 = new ArrayList<>();
        imageList1.add(R.drawable.nike1);
        imageList1.add(R.drawable.nike2);
        imageList1.add(R.drawable.nike3);
        imageList1.add(R.drawable.nike4);
        imageList1.add(R.drawable.nike5);

        RecyclerView.Adapter adapter = new AdapterList(textName, textColor, textPrice, imageList1);
        rvList.setAdapter(adapter);

        rvList.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {

            GestureDetector gestureDetector = new GestureDetector(getApplicationContext(), new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }
            });

            @Override
            public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
                View child = rvList.findChildViewUnder(motionEvent.getX(), motionEvent.getY());
                if (child != null && gestureDetector.onTouchEvent(motionEvent)) {
                    int position = rvList.getChildAdapterPosition(child);

                    String brand, text1, text2, text3, link;
                    Integer image1;

                    brand = "NIKE";
                    text1 = textName.get(position);
                    text2 = textColor.get(position);
                    text3 = textPrice.get(position);
                    image1 = imageList1.get(position);

                    pushData(brand, text1, text2, text3, image1);

                }

                return false;
            }


            @Override
            public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean b) {

            }
        });
    }

    private void initItemViewC() {
        final RecyclerView rvList = (RecyclerView) findViewById(R.id.rvList);
        rvList.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        rvList.setLayoutManager(layoutManager);

        textName = new ArrayList<>();
        textName.add("New Balance 997 OG");
        textName.add("New Balance 997S");
        textName.add("New Balance 990 V5 Engineered");
        textName.add("New Balance OMN1S Kawhi");
        textName.add("New Balance 997 2019");

        textColor = new ArrayList<>();
        textColor.add("Kith United Arrows and Sons");
        textColor.add("Kith United Arrows and Sons");
        textColor.add("Garments Grey");
        textColor.add("Leonard 2-Way");
        textColor.add("Grey Day");

        textPrice = new ArrayList<>();
        textPrice.add("IDR 6.400.000");
        textPrice.add("IDR 5.200.000");
        textPrice.add("IDR 5.300.000");
        textPrice.add("IDR 26.600.000");
        textPrice.add("IDR 7.000.000");

        imageList1 = new ArrayList<>();
        imageList1.add(R.drawable.nb1);
        imageList1.add(R.drawable.nb2);
        imageList1.add(R.drawable.nb3);
        imageList1.add(R.drawable.nb4);
        imageList1.add(R.drawable.nb5);

        RecyclerView.Adapter adapter = new AdapterList(textName, textColor, textPrice, imageList1);
        rvList.setAdapter(adapter);

        rvList.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {

            GestureDetector gestureDetector = new GestureDetector(getApplicationContext(), new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }
            });

            @Override
            public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
                View child = rvList.findChildViewUnder(motionEvent.getX(), motionEvent.getY());
                if (child != null && gestureDetector.onTouchEvent(motionEvent)) {
                    int position = rvList.getChildAdapterPosition(child);

                    String brand, text1, text2, text3;
                    Integer image1;

                    brand = "New Balance";
                    text1 = textName.get(position);
                    text2 = textColor.get(position);
                    text3 = textPrice.get(position);
                    image1 = imageList1.get(position);

                    pushData(brand, text1, text2, text3, image1);

                }

                return false;
            }


            @Override
            public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean b) {

            }
        });
    }

    private void pushData(String brand, String text1, String text3, String text4, Integer image1) {

        Bundle bundle = new Bundle();
        bundle.putString("BRAND", brand);
        bundle.putString("NAME", text1);
        bundle.putString("COLOR", text3);
        bundle.putString("PRICE", text4);
        bundle.putInt("IMAGE1", image1);

        Intent goToDetailProduk = new Intent(this, DetailsActivity.class);
        goToDetailProduk.putExtras(bundle);
        startActivity(goToDetailProduk);
        return;

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(ChooseProductActivity.this, ChooseBrandActivity.class));
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

        setContentView(R.layout.activity_buy);

    }
}
