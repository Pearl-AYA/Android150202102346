package com.example.asus.intentreceiverjava;

/**
 * Created by asus on 2017/4/27.
 */
import android.app.Activity;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class IntentReceiverInJava extends Activity {
    private Button registerButton=null;
    private Button unregisterButton=null;
    private SMSReceiver smsReceiver=null;

    private static final String SMS_ACTION="android.provider.Telephony.SMS_RECEIVED";

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        registerButton=(Button)findViewById(R.id.button1);
        registerButton.setOnClickListener(new RegisterReceiverListener());
        unregisterButton=(Button)findViewById(R.id.button2);
        unregisterButton.setOnClickListener(new UnRegisterReceiverListener());
    }
    class RegisterReceiverListener implements OnClickListener{
        public void onClick(View v){
            smsReceiver=new SMSReceiver();
            IntentFilter filter=new IntentFilter();
            filter.addAction(SMS_ACTION);
            IntentReceiverInJava.this.registerReceiver(smsReceiver,filter);
        }
    }
    class UnRegisterReceiverListener implements OnClickListener{
        public void onClick(View v){
            IntentReceiverInJava.this.unregisterReceiver(smsReceiver);
        }
    }
}
