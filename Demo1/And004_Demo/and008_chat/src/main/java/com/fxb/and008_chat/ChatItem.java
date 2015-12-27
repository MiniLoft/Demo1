package com.fxb.and008_chat;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

/**
 * Created by Administrator on 2015/12/26.
 */
public class ChatItem extends LinearLayout{

    public ChatItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public ChatItem(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context){
        LayoutInflater.from(context).inflate(R.layout.chat_item, this);
    }
}
