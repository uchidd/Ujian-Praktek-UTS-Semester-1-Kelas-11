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
    private ArrayList<Integer> textDesc;
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
        textName.add("NMD Hu Trail");
        textName.add("EQT Support 93/17");
        textName.add("Yung-1");
        textName.add("NMD R1");
        textName.add("Ultra Boost 1.0");

        textColor = new ArrayList<>();
        textColor.add("Sun Calm");
        textColor.add("White/Turbo Red");
        textColor.add("Dragon Ball Z Frieza");
        textColor.add("Clear Pink");
        textColor.add("Black Reflective");

        textPrice = new ArrayList<>();
        textPrice.add("IDR 3800000");
        textPrice.add("IDR 3150000");
        textPrice.add("IDR 2850000");
        textPrice.add("IDR 1380000");
        textPrice.add("IDR 7850000");

        textDesc = new ArrayList<>();
        textDesc.add(R.string.adidas1);
        textDesc.add(R.string.adidas2);
        textDesc.add(R.string.adidas3);
        textDesc.add(R.string.adidas4);
        textDesc.add(R.string.adidas5);

        imageList1 = new ArrayList<>();
        imageList1.add(R.drawable.adidas1);
        imageList1.add(R.drawable.adidas2);
        imageList1.add(R.drawable.adidas3);
        imageList1.add(R.drawable.adidas4);
        imageList1.add(R.drawable.adidas5);


        RecyclerView.Adapter adapter = new AdapterList(textName, textColor, textPrice, textDesc, imageList1);
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
                    Integer image1, text4;

                    brand = "ADIDAS";
                    text1 = textName.get(position);
                    text2 = textColor.get(position);
                    text3 = textPrice.get(position);
                    text4 = textDesc.get(position);
                    image1 = imageList1.get(position);

                    pushData(brand, text1, text2, text3, text4, image1);

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
        textName.add("Air Presto Mid Acronym");
        textName.add("LD Waffle Sacai");
        textName.add("Air Yeezy 2");
        textName.add("Air Max 1");
        textName.add("Kyrie 5");

        textColor = new ArrayList<>();
        textColor.add("Racer Pink");
        textColor.add("Green Purple");
        textColor.add("Red October");
        textColor.add("Nike Day");
        textColor.add("Patrick Star");

        textPrice = new ArrayList<>();
        textPrice.add("IDR 4250000");
        textPrice.add("IDR 9000000");
        textPrice.add("IDR 35000000");
        textPrice.add("IDR 2262000");
        textPrice.add("IDR 2600000");

        textDesc = new ArrayList<>();
        textDesc.add(R.string.nike1);
        textDesc.add(R.string.nike2);
        textDesc.add(R.string.nike3);
        textDesc.add(R.string.nike4);
        textDesc.add(R.string.nike5);

        imageList1 = new ArrayList<>();
        imageList1.add(R.drawable.nike1);
        imageList1.add(R.drawable.nike2);
        imageList1.add(R.drawable.nike3);
        imageList1.add(R.drawable.nike4);
        imageList1.add(R.drawable.nike5);

        RecyclerView.Adapter adapter = new AdapterList(textName, textColor, textPrice, textDesc, imageList1);
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
                    Integer image1, text4;

                    brand = "NIKE";
                    text1 = textName.get(position);
                    text2 = textColor.get(position);
                    text3 = textPrice.get(position);
                    text4 = textDesc.get(position);
                    image1 = imageList1.get(position);

                    pushData(brand, text1, text2, text3, text4, image1);

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
        textName.add("997 OG");
        textName.add("997S");
        textName.add("990 V5 Engineered");
        textName.add("OMN1S Kawhi");
        textName.add("997 2019");

        textColor = new ArrayList<>();
        textColor.add("Kith United Arrows and Sons");
        textColor.add("Kith United Arrows and Sons");
        textColor.add("Garments Grey");
        textColor.add("Leonard 2-Way");
        textColor.add("Grey Day");

        textPrice = new ArrayList<>();
        textPrice.add("IDR 6400000");
        textPrice.add("IDR 5200000");
        textPrice.add("IDR 5300000");
        textPrice.add("IDR 26600000");
        textPrice.add("IDR 7000000");

        textDesc = new ArrayList<>();
        textDesc.add(R.string.nb1);
        textDesc.add(R.string.nb2);
        textDesc.add(R.string.nb3);
        textDesc.add(R.string.nb4);
        textDesc.add(R.string.nb5);

        imageList1 = new ArrayList<>();
        imageList1.add(R.drawable.nb1);
        imageList1.add(R.drawable.nb2);
        imageList1.add(R.drawable.nb3);
        imageList1.add(R.drawable.nb4);
        imageList1.add(R.drawable.nb5);

        RecyclerView.Adapter adapter = new AdapterList(textName, textColor, textPrice, textDesc, imageList1);
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
                    Integer image1, text4;

                    brand = "New Balance";
                    text1 = textName.get(position);
                    text2 = textColor.get(position);
                    text3 = textPrice.get(position);
                    text4 = textDesc.get(position);
                    image1 = imageList1.get(position);

                    pushData(brand, text1, text2, text3, text4, image1);

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

    private void pushData(String brand, String text1, String text3, String text4, Integer text5, Integer image) {

        Bundle bundle = new Bundle();
        bundle.putString("BRAND", brand);
        bundle.putString("NAME", text1);
        bundle.putString("COLOR", text3);
        bundle.putString("PRICE", text4);
        bundle.putInt("DESC", text5);
        bundle.putInt("IMAGE", image);

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

    }
}
