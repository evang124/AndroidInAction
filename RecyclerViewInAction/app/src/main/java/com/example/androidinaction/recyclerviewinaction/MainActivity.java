package com.example.androidinaction.recyclerviewinaction;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;


/**
 * Links to refer by:
 * https://developer.android.com/guide/topics/ui/layout/recyclerview
 * https://willowtreeapps.com/ideas/android-fundamentals-working-with-the-recyclerview-adapter-and-viewholder-pattern/
 */
public class MainActivity extends AppCompatActivity {
    private RecyclerView rv;
    private RecyclerView.Adapter rvAdapter;
    private RecyclerView.LayoutManager rvLayout;
    private ArrayList<String>  data;
    private final String TAG = "Main Activity";

    /**
     * Create the application, in this case we are setting up the recycler view
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv = (RecyclerView) findViewById(R.id.recyclerView);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        rv.setHasFixedSize(true);

        //  This recycler view will use a linear layout manager
        // the layout manager will provide the view and make calls to RVadapter
        rvLayout = new LinearLayoutManager(this);
        rv.setLayoutManager(rvLayout);

        //get data
        data = getData();
        //create custom adapter
        rvAdapter = new RVAdapter(data);

        //connect adapter to recycler view
        rv.setAdapter(rvAdapter);
    }

    /**
     * to simulate grabbing data from somewhere(server, internet, etc.)
     *
     * @return created data
     */
    private ArrayList<String> getData() {
        ArrayList<String> holder = new ArrayList<>();
        for(int key = 1 ; key <= 5 ; key++){
            holder.add("String " + String.valueOf(key));
            int number = (int)(Math.random()*10);
            holder.add(String.valueOf(number));
        }
        return holder;
    }

}
