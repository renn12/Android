package com.it.salemanegement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.it.salemanegement.vo.MemberVO;

public class MainActivity extends AppCompatActivity {
    EditText txtId, txtPass, joinId, joinName, joinPassword, joinPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtId = (EditText) findViewById(R.id.txtId);
        txtPass = (EditText) findViewById(R.id.txtPass);
        joinId = (EditText) findViewById(R.id.joinId);
        joinName = (EditText) findViewById(R.id.joinName);
        joinPassword = (EditText) findViewById(R.id.joinPassword);
        joinPhone = (EditText) findViewById(R.id.joinPhone);

        Button btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = txtId.getText().toString();
                String pass = txtPass.getText().toString();
                if(id.equals("1111")&&pass.equals("1111")){
                    Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                    startActivity(intent);
                }
            }
        });

        Button btnJoin = (Button) findViewById(R.id.btnJoin);
        btnJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHelper db = new DBHelper(getApplicationContext(), "mydb.db", null, 1);
                MemberVO memberVO = new MemberVO();
                memberVO.setId(joinId.getText().toString());
                memberVO.setName(joinName.getText().toString());
                memberVO.setPassword(joinPassword.getText().toString());
                memberVO.setPhone(joinPhone.getText().toString());
                int result = db.exist(memberVO);
                if(result==0) {
                    db.join(memberVO);
                    Toast.makeText(getApplicationContext(), "가입완료", Toast.LENGTH_SHORT).show();
                }
                else Toast.makeText(getApplicationContext(), "이미 존재하는 아이디", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
