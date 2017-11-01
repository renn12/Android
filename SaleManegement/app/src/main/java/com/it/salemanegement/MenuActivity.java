package com.it.salemanegement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button btnMember = (Button) findViewById(R.id.btnMember);
        Button btnProduct = (Button) findViewById(R.id.btnProduct);
        Button btnFinance = (Button) findViewById(R.id.btnFinance);
        Button btnInfo = (Button) findViewById(R.id.btnInfo);

        btnFinance.setOnClickListener(this);
        btnInfo.setOnClickListener(this);
        btnMember.setOnClickListener(this);
        btnProduct.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.btnFinance) menuClick(FinanceActivity.class);
        else if(view.getId()==R.id.btnInfo) menuClick(InfoActivity.class);
        else if(view.getId()==R.id.btnMember) menuClick(MemberActivity.class);
        else if(view.getId()==R.id.btnProduct) menuClick(ProductActivity.class);
    }
    public void menuClick(Class c){
        Intent intent = new Intent(getApplicationContext(), c);
        startActivity(intent);
    }
}
