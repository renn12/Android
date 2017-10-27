package com.it.keyevent;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int x = 100, y = 100;
    class MyView extends View {

        public MyView(Context context) {
            super(context);
            setBackgroundColor(Color.YELLOW);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            Paint paint = new Paint();
            paint.setColor(Color.RED);
            canvas.drawRect(x, y, x+50, y+50, paint);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyView view = new MyView(this);
        view.setFocusable(true);
        view.setFocusableInTouchMode(true);
        setContentView(view);
        //setContentView(R.layout.activity_main);

        view.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent event) {
                if(event.getAction()==KeyEvent.ACTION_UP){
                    switch (keyCode){
                        case KeyEvent.KEYCODE_DPAD_LEFT:
                            if(x>0) x -= 30;
                            break;
                        case KeyEvent.KEYCODE_DPAD_RIGHT:
                            if(x<1050)x += 30;
                            break;
                        case KeyEvent.KEYCODE_DPAD_UP:
                            if(y>0)y -= 30;
                            break;
                        case KeyEvent.KEYCODE_DPAD_DOWN:
                            if(y<1800)y += 30;
                            break;
                    }
                    view.invalidate();
                    return true;
                }
                return false;
            }
        });
    }
}
