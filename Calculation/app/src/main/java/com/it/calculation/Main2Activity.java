package com.it.calculation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class Main2Activity extends AppCompatActivity {
    LinearLayout ll1, ll2, ll3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ll1 = (LinearLayout) findViewById(R.id.linear1);
        ll2 = (LinearLayout) findViewById(R.id.linear2);
        ll3 = (LinearLayout) findViewById(R.id.linear3);

    }

    public void onclicked(View v){
        switch (v.getId()){
            case R.id.btn1:
                ll1.setVisibility(View.VISIBLE);
                ll2.setVisibility(View.INVISIBLE);
                ll3.setVisibility(View.INVISIBLE);
                break;
            case R.id.btn2:
                ll2.setVisibility(View.VISIBLE);
                ll1.setVisibility(View.INVISIBLE);
                ll3.setVisibility(View.INVISIBLE);
                break;
            case R.id.btn3:
                ll3.setVisibility(View.VISIBLE);
                ll2.setVisibility(View.INVISIBLE);
                ll1.setVisibility(View.INVISIBLE);
                break;
        }
    }
}
