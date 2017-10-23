package com.it.first;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btninput;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btninput = (Button) findViewById(R.id.btninput);
        btninput.setText("버튼1111");
        textView = (TextView) findViewById(R.id.tv01);

    }
    public void click(View v) {
        Button button = (Button) v;
        textView.setText("click");
        setContentView(R.layout.test_layout);
    }

    public void click02(View v){
        setContentView(R.layout.xml_layout);
    }

    public void click5(View v){
        switch(v.getId()){
            case R.id.button2:
                Toast.makeText(getApplicationContext(), "222", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button4:
                Toast.makeText(getApplicationContext(), "444", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button5:
                Toast.makeText(getApplicationContext(), "555", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
