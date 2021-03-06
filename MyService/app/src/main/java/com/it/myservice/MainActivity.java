package com.it.myservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);
        button = (Button) findViewById(R.id.button);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editText.getText().toString();
                Intent intent = new Intent(MainActivity.this, MyService.class);
                intent.putExtra("name", editText.getText().toString());
                intent.putExtra("command", "com");
                startService(intent);
            }
        });

    }

    @Override
    protected void onNewIntent(Intent intent) {
        processIntent(intent);
        super.onNewIntent(intent);
    }

    private void processIntent(Intent intent){
        if(intent!=null){
            String command = intent.getStringExtra("command");
            String name = intent.getStringExtra("name")+"";
            Toast.makeText(getApplicationContext(), "command: " + command + ", name: "+name, Toast.LENGTH_SHORT).show();
        }
    }
}
