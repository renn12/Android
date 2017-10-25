package com.it.calc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText edNum1, edNum2;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edNum1 = (EditText) findViewById(R.id.edNum1);
        edNum2 = (EditText) findViewById(R.id.edNum2);
        textView = (TextView) findViewById(R.id.tvResult);
    }

    public void calc(View v){
        int result = 0;
        int num1 = Integer.parseInt(edNum1.getText().toString());
        int num2 = Integer.parseInt(edNum2.getText().toString());

        if(v.getId() == R.id.btnAdd) result = num1 + num2;
        else if(v.getId() == R.id.btnSub) result = num1 - num2;
        else if(v.getId() == R.id.btnMul) result = num1 * num2;
        else if(v.getId() == R.id.btnDiv) result = num1 / num2;
        textView.setText(result+"");
    }
}
