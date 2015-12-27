package com.fxb.and006_fragment;

import android.app.Fragment;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by Administrator on 2015/12/26.
 */
public class MyFragment1 extends Fragment{

    private int layoutId;

//    public MyFragment1(int layoutId){
//        this.layoutId = layoutId;
//    }
    private int num = 1;
    private ImageView img;

    public MyFragment1(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment1, container, false);
        img = (ImageView)view.findViewById(R.id.img1);
        return view;
    }

    public void switchNext(){
        num++;
//        img.setImageResource( getActivity().getResources().get );
        img.setImageResource(R.mipmap.ic_launcher+num);
    }
}
