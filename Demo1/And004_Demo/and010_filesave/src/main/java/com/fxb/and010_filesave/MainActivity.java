package com.fxb.and010_filesave;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class MainActivity extends Activity {

    private Button btnSave, btnLoad;
    private Button btnSave1, btnLoad1;
    private EditText editText, editText1;
    private TextView tvShow, tvShow1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView(){
        btnSave = (Button)findViewById(R.id.btnSave);
        btnSave1 = (Button)findViewById(R.id.btnSave1);
        btnLoad = (Button)findViewById(R.id.btnLoad);
        btnLoad1 = (Button)findViewById(R.id.btnLoad1);

        editText = (EditText)findViewById(R.id.etText);
        editText1 = (EditText)findViewById(R.id.etText1);
        tvShow = (TextView)findViewById(R.id.tvShow);
        tvShow1 = (TextView)findViewById(R.id.tvShow1);

        btnSave.setOnClickListener(listener);
        btnLoad.setOnClickListener(listener);
        btnSave1.setOnClickListener(listener);
        btnLoad1.setOnClickListener(listener);
    }

    private View.OnClickListener listener = new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            if(view == btnSave){
                String strText = editText.getText().toString();
                saveData(strText);
            }
            else if(view == btnLoad){
                String strText = loadData();
                tvShow.setText(strText);
            }
            else if(view == btnSave1){
                String strText = editText1.getText().toString();
                saveData1(strText);
            }
            else if(view == btnLoad1){
                String strText = loadData1();
                tvShow1.setText(strText);
            }
        }
    };

    private void saveData(String strText){
        FileOutputStream out = null;
        BufferedWriter writer = null;
        try {
            out = openFileOutput("record", Context.MODE_PRIVATE);
            writer = new BufferedWriter(new OutputStreamWriter(out));
            writer.write(strText);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(writer != null){
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String loadData(){
        String strText = null;
        FileInputStream in = null;
        BufferedReader reader = null;
        StringBuilder builder = new StringBuilder();
        try {
            in = openFileInput("record");
            reader = new BufferedReader(new InputStreamReader(in));
            String strLine = "";
            while((strLine = reader.readLine()) != null){
                builder.append(strLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(reader != null){
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return builder.toString();
    }

    private void saveData1(String strName){
        SharedPreferences.Editor editor = getSharedPreferences("record1", MODE_PRIVATE).edit();
        editor.putString("name", strName);
        editor.commit();
    }
    private String loadData1(){
        SharedPreferences pref = getSharedPreferences("record1", MODE_PRIVATE);
        return pref.getString("name", "");
    }
}
