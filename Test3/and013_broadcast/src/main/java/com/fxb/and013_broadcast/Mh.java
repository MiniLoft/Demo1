package com.fxb.and013_broadcast;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Administrator on 2015/12/27.
 */
public class Mh {

    public static Button getButton(Activity activity, int id, View.OnClickListener listener){
        Button button = (Button)activity.findViewById(id);
        if(listener != null) button.setOnClickListener(listener);
        return button;
    }

    public static Button getButton(Activity activity, int id){
        return getButton(activity, id, null);
    }

    public static TextView getTextView(Activity activity, int id){
        TextView tv = (TextView)activity.findViewById(id);
        return tv;
    }
}
