package com.fxb.and013_broadcast;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.WindowManager;
import android.widget.Toast;

/**
 * Created by Administrator on 2015/12/27.
 */
public class NameReceiver extends BroadcastReceiver{

    private Context context;

    @Override
    public void onReceive(final Context context, Intent intent) {
        String strName = intent.getStringExtra("name");
        Toast.makeText(context, strName, Toast.LENGTH_SHORT).show();

        AlertDialog dialog = new AlertDialog.Builder(context)
                        .setTitle("Info").setMessage("This is a dialog")
                        .setPositiveButton("Yes0", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(context, "you clicked yes", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("No0", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(context, "you clicked no", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .create();
        dialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
        dialog.show();
    }
}
