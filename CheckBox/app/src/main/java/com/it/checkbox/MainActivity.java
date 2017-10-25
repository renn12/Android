package com.it.checkbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SwitchCompat;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    CheckBox cb01, cb02, cb03;
    TextView textView;
    String str = "";
    SwitchCompat switchCompat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cb01 = (CheckBox) findViewById(R.id.cb01);
        cb02 = (CheckBox) findViewById(R.id.cb02);
        cb03 = (CheckBox) findViewById(R.id.cb03);
        textView = (TextView) findViewById(R.id.textView);
        switchCompat = (SwitchCompat) findViewById(R.id.swit);

        cb01.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) str += buttonView.getText().toString();
                else str = str.replaceAll(buttonView.getText().toString(), "");
                textView.setText(str);
            }
        });
        cb02.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) str += buttonView.getText().toString();
                else str = str.replaceAll(buttonView.getText().toString(), "");
                textView.setText(str);
            }
        });
        cb03.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) str += buttonView.getText().toString();
                else str = str.replaceAll(buttonView.getText().toString(), "");
                textView.setText(str);
            }
        });

        switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) textView.setText("on");
                else textView.setText("off");
            }
        });
    }
}
