package com.example.administrator.annotation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.annotation.annotation.ContentViewInject;
import com.example.administrator.annotation.annotation.Inject;
import com.example.administrator.annotation.annotation.ViewInject;


@ContentViewInject(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    @Inject(R.id.button)
    private Button button;
    @Inject(R.id.tv)
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ViewInject.inject(this);
        button.setText("按钮");
        tv.setText("成功注入");
    }

}
