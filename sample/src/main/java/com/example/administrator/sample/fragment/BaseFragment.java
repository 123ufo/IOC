package com.example.administrator.sample.fragment;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.sample.R;
import com.ufo.simpleioc.anno.bind.InjectBind;
import com.ufo.simpleioc.annotation.InjectView;
import com.ufo.simpleioc.annotation.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class BaseFragment extends Fragment {

    @InjectView(R.id.tv)
    private TextView textView;

    public BaseFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_base, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        InjectBind.inject(this,view);
    }

    @OnClick(R.id.tv)
    public void show(View view){
        if(view.getId() == R.id.tv){
            Toast.makeText(getActivity(), ((TextView)view).getText(), Toast.LENGTH_SHORT).show();
        }

    }
}
