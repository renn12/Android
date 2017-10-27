package com.it.dialog2;

import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    TextView tvResult, toastText;
    Button btn;
    EditText edName, edTel, edEmail;
    View dialogView, toastView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResult = (TextView)findViewById(R.id.tvResult);
        btn = (Button) findViewById(R.id.btnDlg);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogView = (View) View.inflate(MainActivity.this, R.layout.dialog1, null);
                AlertDialog.Builder dia = new AlertDialog.Builder(MainActivity.this);
                dia.setTitle("사용자 정보 입력");
                dia.setIcon(R.mipmap.ic_launcher);
                dia.setView(R.layout.dialog1);
                dia.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String result = "";
                        edName = (EditText) dialogView.findViewById(R.id.edName);
                        edEmail = (EditText) dialogView.findViewById(R.id.edEmail);
                        edTel = (EditText) dialogView.findViewById(R.id.edTel);
                        result += "이름: " + edName.getText().toString()+"\n";
                        result += "이메일: " + edEmail.getText().toString()+"\n";
                        result += "전화번호: " + edTel.getText().toString()+"\n";
                        tvResult.setText(result);
                    }
                });
                dia.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast toast = new Toast(MainActivity.this);
                        toastView = (View) View.inflate(MainActivity.this, R.layout.toast1, null);
                        toastText = (TextView) toastView.findViewById(R.id.tvToast);
                        toastText.setText("취소했습니다.");
                        toast.setView(toastView);
                        toast.show();
                    }
                });

                dia.show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        menu.add(0, 1, 0, "red");
        menu.add(0, 2, 0, "blue");
        menu.add(0, 3, 0, "green");
        SubMenu sub = menu.addSubMenu("버튼 변경");
        sub.add(0, 4, 0, "크기변경");
        sub.add(0, 5, 0, "회전");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case 1:
                tvResult.setBackgroundColor(Color.RED);
                break;
            case 2:
                tvResult.setBackgroundColor(Color.BLUE);
                break;
            case 5:
                tvResult.setRotation(tvResult.getRotation()+15);
                break;
            /*case R.id.itemRed:
                tvResult.setBackgroundColor(Color.RED);
                break;
            case R.id.itemBlue:
                tvResult.setBackgroundColor(Color.BLUE);
                break;
            case R.id.itemGreen:
                tvResult.setBackgroundColor(Color.GREEN);
                break;
            case R.id.subRotate:
                tvResult.setRotation(tvResult.getRotation()+15);
                break;
            case R.id.subSize:
                Toast.makeText(getApplicationContext(), btn.getScaleX()+"", Toast.LENGTH_SHORT).show();
                btn.setScaleX(btn.getScaleX()*2);
                break;*/
        }
        return super.onOptionsItemSelected(item);
    }
}
