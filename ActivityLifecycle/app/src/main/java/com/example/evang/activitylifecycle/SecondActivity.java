package com.example.evang.activitylifecycle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    public static String TAG = "Lifecycle Activity 2"; // a tag to use for debugging purposes, check Logcat when you run this app
    private TextView currentLifecycle; //an object to reference to current_lifecycle TextView
    private TextView pastLifecycle; //an object to reference to past_lifecycle TextView
    private Button buttonActivity; // a button object to switch activities
    private String current, past; // strings to hold the past and current lifecycle phase

    /**
     * makes the system create the activity and initialized certain components like TextViews
     * @param savedInstanceState anything that was saved before this activity starts can be retrieved through this
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // always use the super class' method for onCreate
        setContentView(R.layout.activity_main);// get the activity_main.xml file from the layout folder in the resources folder and create it

        currentLifecycle = findViewById(R.id.current_lifecycle); // get the current_lifecycle textview from the content view
        pastLifecycle = findViewById(R.id.past_lifecycle); // get the past_lifecycle textview from the content view
        buttonActivity = findViewById(R.id.button);
        buttonActivity.setVisibility(View.INVISIBLE);
        current = "OnCreate"; // set the current lifecycle to onCreate
        Log.d(TAG, "Currently in " + current);// android's debugging tool, check Logcat when you run this app
    }

    /**
     * activity that makes the UI visible to the user
     */
    @Override
    protected void onStart() {
        changeText("OnStart");// change text views
        super.onStart();
        Log.d(TAG, "Currently in " + current);// android's debugging tool
    }

    /**
     * the user can now interact with the activity
     */
    @Override
    protected void onResume() {
        changeText("OnResume");
        super.onResume();
        Log.d(TAG, "Currently in " + current);
    }

    /**
     * The activity is not the main focus of the app, but the activity can still change the UI
     */
    @Override
    protected void onPause(){
        changeText("OnPause");
        super.onPause();
        Log.d(TAG, "Currently in " + current);
    }

    /**
     * activity is no longer visible to user
     */
    @Override
    protected void onStop() {
        changeText("OnStop");
        super.onStop();
        Log.d(TAG, "Currently in " + current);

    }

    /**
     * the activity is restored after the onStop is called
     */
    @Override
    protected void onRestart(){
        changeText("onRestart");
        super.onRestart();
        Log.d(TAG, "Currently in " + current);

    }

    /**
     * the activity is destroyed and all the resources used at the more are free
     */
    @Override
    protected void onDestroy() {
        changeText("OnDestroy");
        super.onDestroy();
        Log.d(TAG, "Currently in " + current);
    }

    /**
     * changes the textviews to show what the current and past lifecycle moments are
     * @param status the status of the activity
     */
    private void changeText(String status) {
        past = current;
        current = status;
        String pastText = String.format(getResources().getString(R.string.past_lifecycle), past);
        String currentText = String.format(getResources().getString(R.string.current_lifecycle), status);
        pastLifecycle.setText(pastText);
        currentLifecycle.setText(currentText);
    }


    /**
     * the method called for when an object is about to be destroyed
     * @throws Throwable just an exception handler
     */
    @Override
    protected void finalize() throws Throwable {
        Log.d(TAG, "Finalized called,  object is being destroyed");
        super.finalize();
    }
}
