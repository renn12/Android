package com.it.calculation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    double result = 0;
    String cal = "";
    boolean isDone = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);
    }
    public void calc(View v){

        String b = ((Button) v).getText().toString();
        if(b.matches("1|2|3|4|5|6|7|8|9|0")){
            if(isDone) {
                textView.setText("");
                isDone = false;
            }
            textView.setText(textView.getText().toString()+b);
        }else if(b.equals(".") && textView.getText().toString().length()>0 && textView.getText().toString().indexOf(".")==-1){
            textView.setText(textView.getText().toString()+b);
        }else if(b.equals("=")){
            if(cal.equals("+")) result += Double.parseDouble(textView.getText().toString());
            else if(cal.equals("-")) result -= Double.parseDouble(textView.getText().toString());
            else if(cal.equals("*")) result *= Double.parseDouble(textView.getText().toString());
            else if(cal.equals("/")) result /= Double.parseDouble(textView.getText().toString());
            textView.setText(result+"");
            isDone = true;
            cal="";
        }else if(textView.getText().toString().length()>0){
            cal = b;
            result = Double.parseDouble(textView.getText().toString());
            textView.setText("");
        }
    }
}
