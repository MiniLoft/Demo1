package com.fxb.and002_hello;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by Administrator on 2015/12/26.
 */
public class MyTitleBar extends LinearLayout{

    private Button btnReturn, btnEdit;

    public MyTitleBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.title_bar, this);
        initView();
    }

    private void initView(){
        btnReturn = (Button)findViewById(R.id.btnReturn);
        btnEdit = (Button)findViewById(R.id.btnEdit);

        btnReturn.setOnClickListener(listener);
        btnEdit.setOnClickListener(listener);
    }

    private View.OnClickListener listener = new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            if(view == btnReturn){
//                Toast.makeText(getContext(), "You clicked edit button.", Toast.LENGTH_SHORT).show();
                ((Activity)getContext()).finish();
            }
            else if(view == btnEdit){
                Toast.makeText(getContext(), "You clicked edit button.", Toast.LENGTH_SHORT).show();
            }
        }
    };
}
