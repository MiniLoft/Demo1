package com.fxb.and001_hello;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Administrator on 2015/12/26.
 */
public class SecondActivity extends Activity{

    private Button btnReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initView();
    }


    private void initView(){
        btnReturn = (Button)findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(listener);
    }

    private View.OnClickListener listener = new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            if(view == btnReturn){
//                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
//                startActivity(intent);
                Intent intent = new Intent();
                intent.putExtra("data_return", "Hello, FirstActivity");
                setResult(FirstActivity.RESULT_OK, intent);
                finish();
            }
        }
    };
}
