package com.fxb.and004_hello;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity {

    public static MainActivity instance;
    private Button btnExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        instance = this;
    }

    private void initView(){
        btnExit = (Button)findViewById(R.id.btnExit);
        btnExit.setOnClickListener(listener);
    }

    private View.OnClickListener listener = new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            if(view == btnExit){
                DialogExit dialog = new DialogExit(MainActivity.this);
                dialog.show();
            }
        }
    };

}
