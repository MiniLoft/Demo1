package com.fxb.and013_broadcast;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity {

    private static final String ACTION = "TodayNice";
    private Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView(){
        btnSend = Mh.getButton(this, R.id.btnSend, listener);
    }

    private View.OnClickListener listener = new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            if(view == btnSend){
                Intent intent = new Intent(ACTION);
                intent.putExtra("name", "Jack");
                sendBroadcast(intent);
            }
        }
    };

}
