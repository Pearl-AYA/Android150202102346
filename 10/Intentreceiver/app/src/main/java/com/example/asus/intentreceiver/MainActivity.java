package com.example.asus.intentreceiver;

/**
 * Created by asus on 2017/4/27.
 */
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity  extends Activity{
    private Button mybutton=null;
    private final String nobody="Who.care.the.name";
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        mybutton=(Button)findViewById(R.id.Button);
        mybutton.setOnClickListener(new MyButtonListener());
    }
    class MyButtonListener implements OnClickListener{
        public void onClick(View v){
            Intent intent=new Intent(nobody);
            intent.putExtra("testIntent","11111111111");
            sendBroadcast(intent);
        }
    }
}
