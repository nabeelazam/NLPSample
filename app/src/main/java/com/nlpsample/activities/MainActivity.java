package com.nlpsample.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.nlpsample.R;
import com.nlpsample.fragments.HomeFragment;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        replaceFragmentByTag(this, HomeFragment.newInstance());
    }


    /**
     *
     * @param context
     * @param fragment
     */
    public static void replaceFragmentByTag(FragmentActivity context, Fragment fragment) {

        if (context == null) {
            return;
        }
        String tag = fragment.getClass().getName();
        FragmentManager manager = context.getSupportFragmentManager();
        if (manager == null) {
            return;
        }
        boolean fragmentPopped = false;
        try {
            fragmentPopped = manager.popBackStackImmediate(tag, 0);
        } catch (Exception ignore) {
            ignore.printStackTrace();
        }
        //fragment not in back stack, create it.
        if (!fragmentPopped && manager.findFragmentByTag(tag) == null) {
            FragmentTransaction fragmentTransaction = manager.beginTransaction();
            fragmentTransaction.replace(R.id.content_container, fragment, tag);
            fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            fragmentTransaction.addToBackStack(tag);
            fragmentTransaction.commit();
        }
    }

//
//    @Override
//    public void onBackPressed() {
//        int fragments = getFragmentManager().getBackStackEntryCount();
//        if (fragments == 1) {
//            // make layout invisible since last fragment will be removed
//        }
//        super.onBackPressed();
//    }


    @Override
    public void onBackPressed() {
        int fragments = getSupportFragmentManager().getBackStackEntryCount();
        if (fragments == 1) {
            finish();
        } else {
            if (getFragmentManager().getBackStackEntryCount() > 1) {
                getFragmentManager().popBackStack();
            } else {
                super.onBackPressed();
            }
        }
    }

}
