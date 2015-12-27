package com.fxb.and012_progressbar;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;


public class MainActivity extends Activity {

    private TextView tvShow;
    private ProgressBar progressBar;

    private static final int MSG_TAG = 0x1234;

    private Handler handler = new Handler(){
        @Override
        public void dispatchMessage(Message msg) {
            if(msg.what == MSG_TAG){
                int progress = msg.arg1;
                progressBar.setProgress(progress);
                tvShow.setText(Integer.toString(progress));

                if(progress >= 100){
                    progressBar.setVisibility(View.INVISIBLE);
                }
            }
            super.dispatchMessage(msg);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initThread();
    }

    private void initView(){
//        tvShow = (TextView)findViewById(R.id.tvShow);
        tvShow = Mh.getTextView(this, R.id.tvShow);
        progressBar = (ProgressBar)findViewById(R.id.proBar);

    }

    private void initThread(){
        Thread thread = new Thread(){
            private int progress = 0;
            @Override
            public void run() {
                try {
                    while(true){
                        Thread.sleep(100);
                        progress += 1;
                        Message msg = Message.obtain();
                        msg.what = MSG_TAG;
                        msg.arg1 = progress;
                        handler.sendMessage(msg);

                        if(progress >= 100){
                            break;
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();
    }

    private View.OnClickListener listener = new View.OnClickListener(){
        @Override
        public void onClick(View view) {

        }
    };
}
