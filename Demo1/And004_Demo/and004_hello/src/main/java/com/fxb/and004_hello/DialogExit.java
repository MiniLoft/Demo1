package com.fxb.and004_hello;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;

/**
 * Created by Administrator on 2015/12/26.
 */
public class DialogExit extends Dialog{

    Button btnYes, btnNo;

    public DialogExit(Context context) {
        super(context);
        init();
    }

    public DialogExit(Context context, int theme) {
        super(context, theme);
        init();
    }

    private void init(){
        setContentView(R.layout.dialog_exit);
        initView();
    }

    private void initView(){
        btnYes = (Button)findViewById(R.id.btnYes);
        btnYes.setOnClickListener(listener);

        btnNo = (Button)findViewById(R.id.btnNo);
        btnNo.setOnClickListener(listener);
    }

    private View.OnClickListener listener = new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            if(view == btnYes){
                MainActivity.instance.finish();
            }
            else if(view == btnNo){
                dismiss();
            }
        }
    };
}
