package com.example.asus.a06;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

    private Button myButtton;
    static final String LIFT_TAG="MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Log.v(MainActivity.LIFT_TAG, "FirstAcvity ---> onCreate");
        Button myButton = (Button)findViewById(R.id.button);
        myButton.setText("启动第二个Activity");
        myButton.setOnClickListener(new ButtonOnClickListener());
    }

    class ButtonOnClickListener implements OnClickListener{
        public void onClick(View v) {
            Intent intent = new Intent();
            intent.setClass(MainActivity.this,MainActivity02.class);
            MainActivity.this.startActivity(intent);
        }
    }

    protected void onDestroy() {
        Log.v(MainActivity.LIFT_TAG,"FirstAcvity --->onDestory");
        super.onDestroy();
    }

    protected void onPause() {
        Log.v(MainActivity.LIFT_TAG, "FirstAcvity --->onPause");
        super.onPause();
    }

    protected void onRestart() {
        Log.v(MainActivity.LIFT_TAG, "FirstAcvity --->onRestart");
        super.onRestart();
    }

    protected void onResume() {
        Log.v(MainActivity.LIFT_TAG, "FirstAcvity --->onResume");
        super.onResume();
    }

    protected void onStart() {
        Log.v(MainActivity.LIFT_TAG, "FirstAcvity --->onStart");
        super.onStart();
    }

    protected void onStop() {
        Log.v(MainActivity.LIFT_TAG, "FirstAcvity --->onStop");
        super.onStop();
    }
}
