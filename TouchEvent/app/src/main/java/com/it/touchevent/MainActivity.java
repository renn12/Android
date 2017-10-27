package com.it.touchevent;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyView w = new MyView(this);
        setContentView(w);
    }

    protected class MyView extends View {
        int x = 100, y = 100;
        String str;

        public MyView(Context context) {
            super(context);
            setBackgroundColor(Color.YELLOW);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            Paint paint = new Paint();
            paint.setColor(Color.MAGENTA);
            canvas.drawRect(x,y,x+50,y+50,paint);
            canvas.drawText("action type: " + str, 0, 20, paint);
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            x = (int) event.getX();
            y = (int) event.getY();
            invalidate();
            return true;
        }
    }
}
