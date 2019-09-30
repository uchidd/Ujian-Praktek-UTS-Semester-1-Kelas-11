//package id.uchidd.ujianpraktekutssemester1kelas11.utils;
//
//import android.content.Context;
//import android.support.annotation.NonNull;
//import android.support.v7.widget.RecyclerView;
//import android.view.GestureDetector;
//import android.view.MotionEvent;
//import android.view.View;
//
//public class RecycleTouchListener implements RecyclerView.OnItemTouchListener {
//
//    private ClickListener clickListener;
//    private GestureDetector gestureDetector;
//
//    public interface ClickListener {
//        void onClick(View view, int position);
//        void onLongClick(View view, int position);
//    }
//
//    // Tahapan 4: Membuat Action Click untuk RecyclerView
//    public RecyclerTouchListener(Context context, final RecyclerView recyclerView, final ClickListener clickListener) {
//        this.clickListener = clickListener;
//
//        // Tahapan 6: Membuat Gesture Detector dengan SimpleGestureDetector
//        gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
//            @Override
//            public boolean onSingleTapUp(MotionEvent e) {
//                return true;
//            }
//
//            @Override
//            public void onLongPress(MotionEvent e) {
//                View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
//
//                if (child != null && clickListener != null) {
//                    clickListener.onLongClick(child, recyclerView.getChildAdapterPosition(child));
//                }
//            }
//        });
//    }
//
//    @Override
//    public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
//        return false;
//    }
//
//    @Override
//    public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
//
//    }
//
//    @Override
//    public void onRequestDisallowInterceptTouchEvent(boolean b) {
//
//    }
//}
