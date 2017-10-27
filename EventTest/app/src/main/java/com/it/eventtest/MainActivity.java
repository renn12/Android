package com.it.eventtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    EditText editText;
    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);
        textView = (TextView) findViewById(R.id.textView);
        button = (Button) findViewById(R.id.button);

        ClickListener listener = new ClickListener();
        button.setOnClickListener(listener);
    }

    @Override
    public void onClick(View view) {

    }

    class ClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            String str = editText.getText().toString();
            textView.setText(str);
        }
    }
}
