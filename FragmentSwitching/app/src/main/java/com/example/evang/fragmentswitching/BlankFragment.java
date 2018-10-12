package com.example.evang.fragmentswitching;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BlankFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link BlankFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String TAG = "Blank Fragment #";

    // TODO: Rename and change types of parameters
    private int fragmentNo;
    private String fragmentString;
    private TextView fragTV;

    private OnFragmentInteractionListener mListener;

    public BlankFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BlankFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BlankFragment newInstance(int param1, String param2) {
        BlankFragment fragment = new BlankFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        Log.d(TAG + String.valueOf(param1), "Fragment has been created");
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            fragmentNo = getArguments().getInt(ARG_PARAM1);
            fragmentString = getArguments().getString(ARG_PARAM2);
        }
        Log.d(TAG + String.valueOf(fragmentNo), "Fragment onCreate");
    }

    /**
     * creates the view
     *
     * @param inflater inflates a layout into a view
     * @param container a view to contain the inflated view
     * @param savedInstanceState bundle for potential arguments
     * @return the view
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_blank, container, false);
        //get the textview in the view
        fragTV = view.findViewById(R.id.fragment_string);
        //set the text based on params
        fragTV.setText(String.format(getString(R.string.hello_blank_fragment), fragmentNo, fragmentString));
        fragTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onFragmentTouch();
            }
        });
        Log.d(TAG + String.valueOf(fragmentNo), "Fragment onCreateView");
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        //make sure activity implements function
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
        Log.d(TAG + String.valueOf(fragmentNo), "Fragment onAttach");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
        Log.d(TAG + String.valueOf(fragmentNo), "Fragment onDetach");
    }

    public void switchText(String s) {
        fragTV.setText(s);
    }

    public void switchTextArgument(String s) {
        getArguments().putString(ARG_PARAM2, s);
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentTouch();
    }

}
