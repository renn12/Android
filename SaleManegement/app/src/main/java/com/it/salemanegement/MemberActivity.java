package com.it.salemanegement;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MemberActivity extends AppCompatActivity {
    EditText memberId, memberPhone, memberName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member);

        memberId = (EditText) findViewById(R.id.memberId);
        memberName = (EditText) findViewById(R.id.memberName);
        memberPhone = (EditText) findViewById(R.id.memberPhone);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = memberId.getText().toString();
                String name = memberName.getText().toString();
                String phone = memberPhone.getText().toString();
            }
        });
    }
}
