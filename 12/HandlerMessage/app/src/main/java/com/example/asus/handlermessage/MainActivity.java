package com.example.asus.handlermessage;

import android.app.Activity;
import android.os.Message;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.view.View.OnClickListener;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class MainActivity extends Activity {

    SeekBar bar=null;
    Button startButton=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bar=(SeekBar)findViewById(R.id.bar);
        startButton=(Button)findViewById(R.id.startButton);
        startButton.setOnClickListener(new ButtonListener());
    }
    class ButtonListener implements OnClickListener{
        public void onClick(View v){
            bar.setVisibility(View.VISIBLE);
            updateBarHandler.post(updateTherad);
        }
    }
    Handler updateBarHandler=new Handler(){
        public void handleMessage(Message msg){
            bar.setProgress(msg.arg1);
            updateBarHandler.post(updateTherad);
        }
    };

    Runnable updateTherad=new Runnable() {
        int i=0;
        @Override
        public void run() {
            System.out.println("开始");
            i=i+10;
            Message msg=updateBarHandler.obtainMessage();
            msg.arg1=i;
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            updateBarHandler.sendMessage(msg);
            if (i==100){
                updateBarHandler.removeCallbacks(updateTherad);
            }
        }
    };
}
