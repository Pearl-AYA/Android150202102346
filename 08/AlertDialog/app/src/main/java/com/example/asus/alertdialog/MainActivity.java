package com.example.asus.alertdialog;

import android.app.Activity;
import android.os.Bundle;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Builder dialog = new AlertDialog.Builder(MainActivity.this);
        dialog.setIcon(android.R.drawable.ic_dialog_info);
        dialog.setTitle(R.string.welcome);
        dialog.setMessage(R.string.message);
        dialog.setPositiveButton("肯定", new OnClickListener() {
            @Override
            public void onClick(DialogInterface a0, int a1) {

            }
        });
        dialog.setNegativeButton("否定", new OnClickListener() {
            @Override
            public void onClick(DialogInterface a0, int a1) {

            }
        });
        dialog.create();
        dialog.show();
    }
}
