package com.example.asus.dialer2;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.content.Intent;
import android.net.Uri;
import android.telephony.PhoneNumberUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by asus on 2017/4/27.
 */

public class MainActivity extends Activity {
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        final EditText phomeNum=(EditText)findViewById(R.id.phoneNum);
        final Button button=(Button)findViewById(R.id.Button01);
        button.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View b){
                String call=phomeNum.getText().toString();
                if (PhoneNumberUtils.isGlobalPhoneNumber(call)){
                    Intent I = new Intent(Intent.ACTION_DIAL,Uri.parse("tel://"+call));
                    startActivity(I);
                }
                else {
                    Toast.makeText(MainActivity.this,R.string.phoneNumError,Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
