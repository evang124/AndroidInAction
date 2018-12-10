package com.example.androidinaction.recyclerviewinaction;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.MyViewHolder>{
    /**
     * the data received from the constructor
     */
    ArrayList<String> receivedData;
    private final String TAG = "Recycler View Adapter";

    /**
     * gets the Item View based on the position
     *
     * @param position the position of the view
     * @return the layout for the recycler view
     */
    @Override
    public int getItemViewType(int position) {
        Log.d(TAG, "returning item view for position #"+String.valueOf(position));
        return R.layout.item_view;
    }

    /**
     * Constructor to get data into the Adapter
     *
     * @param data data received
     */
    public RVAdapter(ArrayList<String>  data) {
        receivedData = data;
    }

    /**
     * creates the viewholder to put the data into the adapter
     *
     * @param viewGroup a view that contains other views
     * @param i the view type, ununsed if you don't want to use getItemViewType
     * @return a viewholder
     */
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Log.d(TAG, "Creating View view item_view = #"+ String.valueOf(i +1));
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(i, viewGroup, false);
        MyViewHolder viewholder = new MyViewHolder(view);
        Log.d(TAG, "Created: View item_view =  #"+ String.valueOf(i + 1));
        return viewholder;
    }

    /**
     * Bind the data received to the viewholder
     *
     * @param myViewHolder the viewholder that we are binding data to
     * @param position the location of where the viewholder is
     */
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int position) {
        Log.d(TAG, "Binding View Holder #"+ String.valueOf(position+1));
        if(position*2  >= receivedData.size()) return;
        myViewHolder.string.setText(receivedData.get(position*2));
        myViewHolder.number.setText(receivedData.get(position*2+1));
        Log.d(TAG, "Done Binding View Holder #"+ String.valueOf(position+1));
    }

    /**
     * the size of the dataset
     *
     * @return data size
     */
    @Override
    public int getItemCount() {
        Log.d(TAG, "Item Count Called");
        return receivedData.size()/2;
    }


    /**
     * to help access certain parts of the view
     */
    public static class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView string, number;

        /**
         * constructor to provide view reference, super call required
         *
         * @param itemView the view we want to reference
         */
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            string = itemView.findViewById(R.id.textString);
            number = itemView.findViewById(R.id.textNumber);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    string.setText("Don't touch me");
                    string.setTextSize(12f);
                }
            });

        }


    }
}
