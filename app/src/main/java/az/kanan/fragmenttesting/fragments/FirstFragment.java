package az.kanan.fragmenttesting.fragments;

import android.app.Activity;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import az.kanan.fragmenttesting.listener.FragmentHelperListener;
import az.kanan.fragmenttesting.R;

public class FirstFragment extends Fragment {

    FragmentHelperListener fragmentHelperListener;

    Button button;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.first_fragment, null);

        button = (Button) v.findViewById(R.id.btn1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentHelperListener.nextFragment(new SecondFragment());
            }
        });

        return v;
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            fragmentHelperListener = (FragmentHelperListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement OnArticleSelectedListener");
        }
    }

}
