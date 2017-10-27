package com.it.samplelistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    SingerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);
        adapter = new SingerAdapter();
        for(int i=0; i<100000; i++) adapter.addItem(new SingerItem("a"+i, i+""));


        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                SingerItem item = (SingerItem) adapter.getItem(i);
                Toast.makeText(getApplicationContext(), "list: " + item.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    class SingerAdapter extends BaseAdapter {
        ArrayList<SingerItem> items = new ArrayList<SingerItem>();



        public int getCount(){
            return items.size();
        }
        public void addItem(SingerItem item){
            items.add(item);
        }
        public Object getItem(int position){
            return items.get(position);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            SingerItemView vieww = new SingerItemView(getApplicationContext());
            SingerItem item = items.get(i);
            vieww.setName(item.getName());
            vieww.setMobile(item.getMobile());
            return vieww;
        }
    }


}
