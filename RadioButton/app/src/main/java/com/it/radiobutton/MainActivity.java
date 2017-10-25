package com.it.radiobutton;

import android.speech.tts.TextToSpeech;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    EditText editText;
    Button button;
    RadioGroup rg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView);
        editText = (EditText) findViewById(R.id.editText);
        button = (Button) findViewById(R.id.button);



        rg = (RadioGroup) findViewById(R.id.radioGroup);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                RadioButton rd = (RadioButton) findViewById(group.getCheckedRadioButtonId());
                textView.setText(rd.getText().toString());

            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(rg.getCheckedRadioButtonId()){
                    case R.id.rd1:
                        Toast.makeText(getApplicationContext(), "rd1", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rd2:
                        Toast.makeText(getApplicationContext(), "rd2", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }
}
