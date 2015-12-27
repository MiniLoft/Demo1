package com.fxb.and007_listview;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.IOError;
import java.util.ArrayList;

/**
 * Created by Administrator on 2015/12/26.
 */
public class MyAdapter extends BaseAdapter {

    private ArrayList<InfoItem> listInfo;
    private Context context;

    public MyAdapter(Context context, ArrayList<InfoItem> listInfo){
        this.context = context;
        this.listInfo = listInfo;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
//        return null;
        View view = null;
        ViewItem viewItem = null;
        if(convertView == null){
            view = LayoutInflater.from(context).inflate(R.layout.info_item, null);
            viewItem = new ViewItem();
            viewItem.tvName = (TextView)view.findViewById(R.id.tvName);
            viewItem.tvNumber = (TextView)view.findViewById(R.id.tvNumber);
            view.setTag(viewItem);
        }else{
            view = convertView;
            viewItem = (ViewItem)view.getTag();
        }

//        TextView tvName = (TextView)view.findViewById(R.id.tvName);
//        TextView tvNumber = (TextView)view.findViewById(R.id.tvNumber);

        InfoItem item = listInfo.get(position);
//        tvName.setText(item.strName);
//        tvNumber.setText(item.strNumber);

        viewItem.tvName.setText(item.strName);
        viewItem.tvNumber.setText(item.strNumber);

        return view;
    }

    @Override
    public int getCount() {
        return listInfo.size();
    }

    @Override
    public Object getItem(int i) {
        return listInfo.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    static class ViewItem{
        public TextView tvName;
        public TextView tvNumber;
    }

}
