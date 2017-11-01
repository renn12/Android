package com.it.myservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    private static final String TAG = "MyService";

    public MyService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG,"onCreate 호출");
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand() 호출됨.");
        if(intent==null) return Service.START_STICKY;
        else processCommand(intent);

        return super.onStartCommand(intent, flags, startId);
    }

    private void processCommand(Intent intent){
        String command = intent.getStringExtra("command");
        if(command.equals("com")){
            String name = intent.getStringExtra("name");
            Log.d(TAG, "command: "+ command+", name: " + name);
            for (int i=0; i<10; i++){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Log.d(TAG, "waiting: " + i + " second");
                }
            }

            Intent showIntent = new Intent(getApplicationContext(), MainActivity.class);
            showIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_SINGLE_TOP|Intent.FLAG_ACTIVITY_CLEAR_TOP);
            showIntent.putExtra("command", "show");
            showIntent.putExtra("name", "name");
            startActivity(showIntent);
        }else if(command.equals("fa")){
            int result =1;
            int num = Integer.parseInt(intent.getStringExtra("name"));
            for(int i=0; i<num; i++){
                result *= (i+1);
            }
            Intent showIntent = new Intent(getApplicationContext(), MainActivity.class);
            showIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_SINGLE_TOP|Intent.FLAG_ACTIVITY_CLEAR_TOP);
            showIntent.putExtra("command", "show");
            showIntent.putExtra("name", result);
            startActivity(showIntent);
        }

    }
}
