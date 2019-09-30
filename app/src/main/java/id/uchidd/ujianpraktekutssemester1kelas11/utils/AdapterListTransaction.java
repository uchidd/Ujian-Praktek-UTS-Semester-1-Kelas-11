package id.uchidd.ujianpraktekutssemester1kelas11.utils;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

public class AdapterListTransaction extends RecyclerView.Adapter<AdapterListTransaction.MyViewHolder> {

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public MyViewHolder(View itemView) {
            super(itemView);
        }
    }
}
