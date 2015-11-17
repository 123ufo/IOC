package com.example.administrator.sample;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.sample.fragment.BaseFragment;
import com.ufo.simpleioc.anno.bind.InjectBind;
import com.ufo.simpleioc.annotation.InjectContentView;
import com.ufo.simpleioc.annotation.InjectView;
import com.ufo.simpleioc.annotation.OnClick;

@InjectContentView(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    @InjectView(R.id.textview)
    private TextView textView;

    @InjectView(R.id.button)
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        InjectBind.inject(this);
        getFragmentManager().beginTransaction().replace(R.id.fl_content,new BaseFragment()).commit();
    }

    @OnClick({R.id.textview,R.id.button})
    public void onclick(View view){
        switch (view.getId()){
            case R.id.textview:
                Toast.makeText(MainActivity.this, ((TextView)view).getText(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.button:
                Toast.makeText(this,((Button)view).getText() , Toast.LENGTH_SHORT).show();
                break;
        }
    }

}
