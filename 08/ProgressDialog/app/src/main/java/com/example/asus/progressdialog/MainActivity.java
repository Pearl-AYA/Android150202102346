package com.example.asus.progressdialog;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends Activity {

    private ProgressBar firstBar=null;
    private ProgressBar secondBar=null;
    private Button mybutton=null;
    private int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstBar = (ProgressBar) findViewById(R.id.firstBar);
        secondBar = (ProgressBar) findViewById(R.id.secondBar);
        mybutton = (Button) findViewById(R.id.myButton);
        mybutton.setOnClickListener(new ButtonListener());
    }
    class ButtonListener implements OnClickListener{
        public void onClick(View v){
            if (i==0){
                firstBar.setVisibility(View.VISIBLE);
                secondBar.setVisibility(View.VISIBLE);
                firstBar.setMax(150);
            }else if (i<firstBar.getMax()){
                firstBar.setProgress(i);
                firstBar.setSecondaryProgress(i+10);
            }else {
                firstBar.setVisibility(View.GONE);
                secondBar.setVisibility(View.GONE);
            }
            i=i+10;
        }
    }
}
