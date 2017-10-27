package com.it.samplelistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SingerItemView extends LinearLayout{
    TextView textView, textView2;
    public SingerItemView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.singer_item, this, true);

        textView = (TextView) findViewById(R.id.textView);
        textView2 = (TextView) findViewById(R.id.textView2);
    }
    public void setName(String name){
        textView.setText(name);
    }
    public void setMobile(String mobile){
        textView2.setText(mobile);
    }
}
