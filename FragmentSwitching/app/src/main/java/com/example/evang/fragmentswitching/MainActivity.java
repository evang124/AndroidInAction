package com.example.evang.fragmentswitching;

import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements BlankFragment.OnFragmentInteractionListener{

    private final String TAG = "Main Activity";

    public Button frag1, frag2; // buttons to switch fragments
    public BlankFragment firstFragment, secondFragment; //blank fragments

    /**
     * create the activity
     *
     * @param savedInstanceState the bundle for the activity
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Check that the activity is using the layout version with
        // the fragment_container FrameLayout
        if (findViewById(R.id.frameLayout) != null) {
            // However, if we're being restored from a previous state,
            // then we don't need to do anything and should return or else
            // we could end up with overlapping fragments.
            if (savedInstanceState != null) {
                return;
            }
            // Create a new Fragment to be placed in the activity layout
            firstFragment = BlankFragment.newInstance(1, "Hello World!");
            secondFragment = BlankFragment.newInstance(2, "How are you?");

            //set up the buttons
            frag1 = findViewById(R.id.button);
            frag2 = findViewById(R.id.button2);

            // Add the fragment to the 'frameLayout' FrameLayout
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.frameLayout, firstFragment).commit();
        }
    }

    /**
     * Implementation of the function in the fragment
     */
    @Override
    public void onFragmentTouch() {
        //grab current fragment displayed
        BlankFragment currentFragment = (BlankFragment) getSupportFragmentManager().findFragmentById(R.id.frameLayout);
        currentFragment.switchText("don't touch me");
        if(currentFragment == firstFragment){
            secondFragment.switchTextArgument("did you touch the other fragment?");
        }
        else{
            firstFragment.switchTextArgument("did you touch the other fragment?");
        }
    }

    /**
     * click function to switch to fragment 1
     *
     * @param view the button
     */
    public void switchFragmentOne(View view){
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frameLayout, firstFragment).commit();

    }

    /**
     * click function to switch to fragment 1
     *
     * @param view the button
     */
    public void switchFragmentTwo(View view){
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frameLayout, secondFragment).commit();

    }
}
