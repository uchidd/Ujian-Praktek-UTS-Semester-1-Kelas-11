package id.uchidd.ujianpraktekutssemester1kelas11.utils;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import id.uchidd.ujianpraktekutssemester1kelas11.R;
import id.uchidd.ujianpraktekutssemester1kelas11.model.ListTransaction;

public class AdapterListTransaction extends RecyclerView.Adapter<AdapterListTransaction.MyViewHolder> {

    private Context context;
    private List<ListTransaction>transactionlist;

    public AdapterListTransaction(Context context, List <ListTransaction> transactionlist) {
        this.context = context;
        this.transactionlist = transactionlist;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_adapter_transaction, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ListTransaction listTransaction = transactionlist.get(position);

        holder.brand.setText(listTransaction.getBrand());
        holder.name.setText(listTransaction.getName());
        holder.color.setText(listTransaction.getColor());
        holder.size.setText(listTransaction.getSize());
        holder.quantity.setText(listTransaction.getQuantity());
        holder.price.setText(listTransaction.getPrice());
        holder.date.setText(formatDate(listTransaction.getTransactiondate()));

    }

    private String formatDate(String transactiondate) {

        try {
            SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = fmt.parse(transactiondate);
            SimpleDateFormat fmtOut = new SimpleDateFormat("dd MMMM yyyy");
            return fmtOut.format(date);
        } catch (ParseException e) {

        }

        return "";
    }

    @Override
    public int getItemCount() {
        return transactionlist.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView brand;
        public TextView name;
        public TextView color;
        public TextView size;
        public TextView quantity;
        public TextView price;
        public TextView date;

        public MyViewHolder(View itemView) {
            super(itemView);

            brand = (TextView)itemView.findViewById(R.id.tv1);
            name = (TextView)itemView.findViewById(R.id.tv2);
            color = (TextView)itemView.findViewById(R.id.tv3);
            size = (TextView)itemView.findViewById(R.id.tv4);
            quantity = (TextView)itemView.findViewById(R.id.tv5);
            price = (TextView)itemView.findViewById(R.id.tv6);
            date = (TextView)itemView.findViewById(R.id.tv7);
        }
    }
}
