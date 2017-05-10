package com.example.asus.a06;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
/**
 * Created by asus on 2017/3/30.
 */

public class MainActivity02 extends Activity {
    private static final String LIFT_TAG="MainActivity";
    protected void onCreate(Bundle savedInstanceState) {
        Log.v(MainActivity.LIFT_TAG,"SecondActivity--->onCreate");
        super.onCreate(savedInstanceState);

    }

    protected void onDestroy() {
        Log.v(MainActivity.LIFT_TAG,"SecondActivity --->onDestory");
        super.onDestroy();
    }

    protected void onPause() {
        Log.v(MainActivity.LIFT_TAG, "SecondActivity --->onPause");
        super.onPause();
    }

    protected void onRestart() {
        Log.v(MainActivity.LIFT_TAG, "SecondActivity --->onRestart");
        super.onRestart();
    }

    protected void onResume() {
        Log.v(MainActivity.LIFT_TAG, "SecondActivity --->onResume");
        super.onResume();
    }

    protected void onStart() {
        Log.v(MainActivity.LIFT_TAG, "SecondActivity --->onStart");
        super.onStart();
    }

    protected void onStop() {
        Log.v(MainActivity.LIFT_TAG, "SecondActivity --->onStop");
        super.onStop();
    }
}
