package com.it.first;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.btninput);
        textView = (TextView) findViewById(R.id.tv01);

    }
    public void onclicked(View v){
        Toast.makeText(getApplicationContext(), "onclicked", Toast.LENGTH_SHORT).show();
        textView.setText("onclicked");
    }
}
