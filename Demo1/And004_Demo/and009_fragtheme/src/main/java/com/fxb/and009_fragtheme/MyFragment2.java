package com.fxb.and009_fragtheme;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2015/12/26.
 */
public class MyFragment2 extends Fragment{

    private int layoutId;

//    public MyFragment1(int layoutId){
//        this.layoutId = layoutId;
//    }

    public MyFragment2(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment2, container, false);
        return view;
    }
}
