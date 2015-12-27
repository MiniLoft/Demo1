package com.fxb.and007_listview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends Activity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        initView();
        initView2();
    }

    private void initView1(){
        String[] strs = new String[50];
        for(int i=0; i<strs.length; ++i){
            strs[i] = Integer.toString(100+i);
        }

        listView = (ListView)findViewById(R.id.listView1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_gallery_item, strs);
        listView.setAdapter(adapter);
    }

    private void initView2(){
        InfoItem item1 = new InfoItem("Jack", "2345");
        InfoItem item2 = new InfoItem("Jim", "2346");
        InfoItem item3 = new InfoItem("Tinkle", "3456");
        InfoItem item4 = new InfoItem("Mashengxi", "4567");
        InfoItem item5 = new InfoItem("Wist", "5678");
        InfoItem item6 = new InfoItem("Piple", "6789");
        InfoItem item7 = new InfoItem("Piple", "6789");
        InfoItem item8 = new InfoItem("Piple", "6789");
        InfoItem item9 = new InfoItem("Piple", "6789");
        InfoItem item10 = new InfoItem("Piple", "6789");
        InfoItem item11 = new InfoItem("Piple", "6789");

        ArrayList<InfoItem> listInfo = new ArrayList<InfoItem>();
        listInfo.add(item1);
        listInfo.add(item2);
        listInfo.add(item3);
        listInfo.add(item4);
        listInfo.add(item5);
        listInfo.add(item6);
        listInfo.add(item7);
        listInfo.add(item8);
        listInfo.add(item9);
        listInfo.add(item10);
        listInfo.add(item11);

        listView = (ListView)findViewById(R.id.listView1);
        MyAdapter adapter = new MyAdapter(this, listInfo);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(itemClickListener);
        listView.setOnItemLongClickListener(itemLongListener);
    }

    private View.OnClickListener btnListener = new View.OnClickListener(){
        @Override
        public void onClick(View view) {

        }
    };

    private ListView.OnItemClickListener itemClickListener = new ListView.OnItemClickListener(){
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
            InfoItem item = (InfoItem)listView.getAdapter().getItem(position);
            String str = item.strName+","+item.strNumber;
            Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT).show();
        }
    };

    private AdapterView.OnItemLongClickListener itemLongListener = new AdapterView.OnItemLongClickListener() {
        @Override
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long id) {
            InfoItem item = (InfoItem)listView.getAdapter().getItem(position);
            String str = item.strName+"-----"+item.strNumber;
            Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT).show();

            return true;
        }
    };

}
