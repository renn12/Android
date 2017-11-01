package com.it.salemanegement;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.it.salemanegement.vo.MemberVO;

public class JoinService extends Service {
    public JoinService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if(intent == null){
            return Service.START_STICKY;
        }else{
            DBHelper db = new DBHelper(getApplicationContext(), "mydb.db", null, 1);
            MemberVO memberVO = (MemberVO) intent.getSerializableExtra("member");
        }
        return super.onStartCommand(intent, flags, startId);
    }
}
