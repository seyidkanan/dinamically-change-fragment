package az.kanan.fragmenttesting;


import android.app.Fragment;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import az.kanan.fragmenttesting.fragments.FirstFragment;
import az.kanan.fragmenttesting.listener.FragmentHelperListener;

public class MainActivity extends AppCompatActivity implements FragmentHelperListener {

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initToolbar();

        Fragment newFragment = new FirstFragment();
        changeFragment(newFragment, false);

    }

    public void changeFragment(Fragment newFragment, Boolean isBackButtonActivateInFragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.container, newFragment);

        if (isBackButtonActivateInFragment)
            transaction.addToBackStack(null);

        transaction.commit();
    }

    @Override
    public void nextFragment(Fragment nextFragment) {
        changeFragment(nextFragment, true);
    }

    public void initToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar); // Attaching the layout to the toolbar object
        setSupportActionBar(toolbar);
    }

}
