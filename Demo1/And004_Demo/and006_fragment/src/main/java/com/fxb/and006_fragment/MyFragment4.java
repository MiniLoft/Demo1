package com.fxb.and006_fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2015/12/26.
 */
public class MyFragment4 extends Fragment{

    private int layoutId;

//    public MyFragment1(int layoutId){
//        this.layoutId = layoutId;
//    }

    public MyFragment4(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment4, container, false);
        return view;
    }
}
