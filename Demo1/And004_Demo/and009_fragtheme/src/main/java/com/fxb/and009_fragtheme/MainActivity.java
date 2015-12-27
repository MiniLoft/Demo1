package com.fxb.and009_fragtheme;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;


public class MainActivity extends  Activity{

    private Button button1, button2, button3, button4;

    private Fragment fragment1, fragment2, fragment3, fragment4;
    private int num = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView(){
        button1 = (Button)findViewById(R.id.button1);
        button2 = (Button)findViewById(R.id.button2);
        button3 = (Button)findViewById(R.id.button3);
        button4 = (Button)findViewById(R.id.button4);

        button1.setOnClickListener(listener);
        button2.setOnClickListener(listener);
        button3.setOnClickListener(listener);
        button4.setOnClickListener(listener);

        fragment1 = new MyFragment1();
        fragment2 = new MyFragment2();
        fragment3 = new MyFragment3();
        fragment4 = new MyFragment4();

        getFragmentManager().beginTransaction().replace(R.id.frag_container, fragment1).commit();
    }

    private View.OnClickListener listener = new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            if(view == button1){
                ((MyFragment1)fragment1).switchNext();
                getFragmentManager().beginTransaction().replace(R.id.frag_container, fragment1).commit();
            }
            else if(view == button2){
                getFragmentManager().beginTransaction().replace(R.id.frag_container, fragment2).commit();
            }
            else if(view == button3){
                getFragmentManager().beginTransaction().replace(R.id.frag_container, fragment3).commit();
            }
            else if(view == button4){
                getFragmentManager().beginTransaction().replace(R.id.frag_container, fragment4).commit();

            }
        }
    };

}
