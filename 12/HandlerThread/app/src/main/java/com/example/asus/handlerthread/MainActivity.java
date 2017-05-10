package com.example.asus.handlerthread;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;

public class MainActivity extends Activity {

    private Button startButton=null;
    private Button endButton=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startButton=(Button)findViewById(R.id.startButton);
        startButton.setOnClickListener(new StartButtonListener());
        endButton=(Button)findViewById(R.id.endButton);
        endButton.setOnClickListener(new EndButtonListener());
    }
    Handler handler=new Handler();
    class StartButtonListener implements OnClickListener{
        public void onClick(View v){
            handler.post(updateThread);
        }
    }
    class EndButtonListener implements OnClickListener{
        public void onClick(View v){
            handler.removeCallbacks(updateThread);
        }
    }
    Runnable updateThread = new Runnable() {
        @Override
        public void run() {
            System.out.println("黄茂森是Gay");
            handler.postDelayed(updateThread, 2000);
        }
    };
}
