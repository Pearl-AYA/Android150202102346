package com.example.asus.intentreceiverjava;

/**
 * Created by asus on 2017/4/27.
 */
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;

public class SMSReceiver extends BroadcastReceiver {
    private static final String TAG="onReceive";
    public void onReceive(Context context,Intent intent){
        Log.i(TAG,"onReceive-->running!");
        Bundle bundle=intent.getExtras();
        Object[] myOBJpdus=(Object[])bundle.get("pdus");
        SmsMessage[] messages=new SmsMessage[myOBJpdus.length];
        System.out.println(messages.length);
        for (int i=0;i<myOBJpdus.length;i++){
            messages[i]=SmsMessage.createFromPdu((byte[])myOBJpdus[i]);
            System.out.println(messages[i].getDisplayMessageBody());
        }
    }
}
