package com.fxb.and008_chat;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity {

    private LinearLayout chatContainer;
//    private ChatItem chat1, chat2, chat3;
    private Button btnSend;
    private EditText etInput;

    private int count = 0;
    private ListView listView;
    private ArrayList<MsgItem> listMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView(){
//        chat1 = (ChatItem)findViewById(R.id.chat1);
//        chat2 = (ChatItem)findViewById(R.id.chat2);
//        chat3 = (ChatItem)findViewById(R.id.chat3);
//
//        chat1.findViewById(R.id.layoutChatTo).setVisibility(View.GONE);
//        chat2.findViewById(R.id.layoutChatFrom).setVisibility(View.GONE);
//        chat3.findViewById(R.id.layoutChatTo).setVisibility(View.GONE);

//        chatContainer = (LinearLayout)findViewById(R.id.chatContainer);

        etInput = (EditText)findViewById(R.id.etInput);
        btnSend = (Button)findViewById(R.id.btnSend);
        btnSend.setOnClickListener(listener);


        listMsg = new ArrayList<MsgItem>();
        MyAdapter adapter = new MyAdapter(this, listMsg);
        listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(adapter);
    }

    private View.OnClickListener listener = new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            if(view == btnSend){
                String strMsg = etInput.getText().toString();
//                ChatItem chatItem = new ChatItem(MainActivity.this);

//                if(count%2 == 0){
//                    chatItem.findViewById(R.id.layoutChatTo).setVisibility(View.GONE);
//                    ((TextView)chatItem.findViewById(R.id.tvFrom)).setText(strMsg);
//                }
//                else{
//                    chatItem.findViewById(R.id.layoutChatFrom).setVisibility(View.GONE);
//                    ((TextView)chatItem.findViewById(R.id.tvTo)).setText(strMsg);
//                }
//                ViewGroup.LayoutParams param = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//                chatContainer.addView(chatItem, param);


                MsgItem msgItem = new MsgItem();
                msgItem.strMsg = strMsg;
                if(count%2 == 0){
                    msgItem.type = MsgItem.MSG_FROM;
                }
                else{
                    msgItem.type = MsgItem.MSG_TO;
                }

                listMsg.add(msgItem);
                listView.deferNotifyDataSetChanged();
                listView.setSelection(listMsg.size());

                count++;
                etInput.setText("");
            }
        }
    };
}
