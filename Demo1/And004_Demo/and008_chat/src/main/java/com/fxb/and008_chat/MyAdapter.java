package com.fxb.and008_chat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by Administrator on 2015/12/26.
 */
public class MyAdapter extends BaseAdapter{

    private ArrayList<MsgItem> listMsg;
    private Context context;

    public MyAdapter(Context context, ArrayList<MsgItem> list){
        this.context = context;
        this.listMsg = list;
    }

    @Override
    public int getCount() {
        return listMsg.size();
    }

    @Override
    public Object getItem(int position) {
        return listMsg.get(position);
    }

    @Override
    public long getItemId(int id) {
        return id;
    }

    @Override
    public View getView(int position, View viewConvert, ViewGroup viewGroup) {
//        return null;
        View view;
        SaveItem saveItem;
        if(viewConvert == null){
            view = LayoutInflater.from(context).inflate(R.layout.chat_item, null);

            RelativeLayout layoutFrom = (RelativeLayout)view.findViewById(R.id.layoutChatFrom);
            RelativeLayout layoutTo = (RelativeLayout)view.findViewById(R.id.layoutChatTo);

            TextView tvFrom = (TextView)view.findViewById(R.id.tvFrom);
            TextView tvTo = (TextView)view.findViewById(R.id.tvTo);

            saveItem = new SaveItem(layoutFrom, layoutTo, tvFrom, tvTo);
            view.setTag(saveItem);
        }
        else{
            view = viewConvert;
            saveItem = (SaveItem)viewConvert.getTag();
        }


        MsgItem msgItem = listMsg.get(position);
        if(msgItem.type == MsgItem.MSG_FROM){
            saveItem.layoutFrom.setVisibility(View.VISIBLE);
            saveItem.layoutTo.setVisibility(View.GONE);
            saveItem.tvFrom.setText(msgItem.strMsg);
        }
        else{
            saveItem.layoutFrom.setVisibility(View.GONE);
            saveItem.layoutTo.setVisibility(View.VISIBLE);
            saveItem.tvTo.setText(msgItem.strMsg);
        }

        return view;
    }


    static class SaveItem {
        public RelativeLayout layoutFrom;
        public RelativeLayout layoutTo;

        public TextView tvFrom;
        public TextView tvTo;

        public SaveItem(RelativeLayout layoutFrom, RelativeLayout layoutTo, TextView tvFrom, TextView tvTo){
            this.layoutFrom = layoutFrom;
            this.layoutTo = layoutTo;
            this.tvFrom = tvFrom;
            this.tvTo = tvTo;
        }
    }
}
