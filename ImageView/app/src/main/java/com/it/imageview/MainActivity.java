package com.it.imageview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SwitchCompat;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    CheckBox checkBox;
    LinearLayout linear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.imageView);

        checkBox = (CheckBox) findViewById(R.id.checkBox);
        linear = (LinearLayout) findViewById(R.id.linear);
        Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
        startActivity(intent);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) linear.setVisibility(View.VISIBLE);
                else linear.setVisibility(View.INVISIBLE);
            }
        });

        SwitchCompat switchCompat = (SwitchCompat) findViewById(R.id.swit);
        switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) imageView.setImageResource(R.drawable.p007);
                else imageView.setImageResource(R.drawable.p312);
            }
        });
    }
}
