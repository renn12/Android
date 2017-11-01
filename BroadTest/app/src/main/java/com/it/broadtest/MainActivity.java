package com.it.broadtest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView iv;
    EditText ed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv = (ImageView) findViewById(R.id.imageView);
        ed = (EditText) findViewById(R.id.editText);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(br);
    }

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_BATTERY_CHANGED);
        registerReceiver(br, filter);
    }

    BroadcastReceiver br = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if(action.equals(Intent.ACTION_BATTERY_CHANGED)){
                int remain = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);
                ed.setText("현재 충전량: " + remain+"\n");
                if(remain>90) iv.setImageResource(R.drawable.battery_100);
                else if(remain>70) iv.setImageResource(R.drawable.battery_80);
                else if(remain>50) iv.setImageResource(R.drawable.battery_60);
                else if(remain>10) iv.setImageResource(R.drawable.battery_20);
                else iv.setImageResource(R.drawable.battery_0);

                int plug = intent.getIntExtra(BatteryManager.EXTRA_PLUGGED, 0);
                switch(plug){
                    case 0:
                        ed.append("전원 연결 안됨");
                        break;
                    case BatteryManager.BATTERY_PLUGGED_AC:
                        ed.append("AC");
                        break;
                    case BatteryManager.BATTERY_PLUGGED_USB:
                        ed.append("USB");
                        break;
                }
            }
        }
    };
}
