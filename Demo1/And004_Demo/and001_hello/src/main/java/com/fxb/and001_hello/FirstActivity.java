package com.fxb.and001_hello;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class FirstActivity extends Activity {

    public static int RESULT_OK = 1;
    private Button btnSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        initView();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == RESULT_OK){
            String strData = data.getStringExtra("data_return");
            Log.i("FirstActivity", strData);
        }
    }

    private void initView(){
        btnSwitch = (Button)findViewById(R.id.btnSwitch);
        btnSwitch.setOnClickListener(listener);
    }

    private View.OnClickListener listener = new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            if(view == btnSwitch){
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
//                startActivity(intent);
                startActivityForResult(intent, RESULT_OK);
            }
        }
    };
}
