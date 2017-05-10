package com.example.asus.a5;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends Activity {
    RadioButton r1 = null;
    RadioButton r2 = null;
    RadioButton r3 = null;
    RadioButton r4 = null;
    RadioGroup radioGroup = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radioGroup=(RadioGroup) findViewById(R.id.radioGroup);
        r1=(RadioButton) findViewById(R.id.a);
        r2=(RadioButton) findViewById(R.id.b);
        r3=(RadioButton) findViewById(R.id.c);
        r4=(RadioButton) findViewById(R.id.d);
        r1.setClickable(true);

        Button sure=(Button) findViewById(R.id.sure);
        Button cancel=(Button) findViewById(R.id.cancel );
        sure.setOnClickListener(new sure());
        cancel.setOnClickListener(new cancel());
    }
    class sure implements View.OnClickListener {
        public void onClick(View v){
            String ans="";
            if (r1.isChecked()){
                ans="on";
            }else if (r2.isChecked()){
                ans="at";
            }else if (r3.isChecked()){
                ans="of";
            }else if (r4.isChecked()){
                ans="in";
            }

            Intent intent=new Intent();
            intent.setClass(MainActivity.this, otherActivity.class);

            Bundle bundle=new Bundle();
            bundle.putString("ans", ans);
            intent.putExtras(bundle);
            startActivityForResult(intent, 0);
        }
    }
    class cancel implements View.OnClickListener {
        public void onClick(View v){
            radioGroup.clearCheck();
            setTitle("");
        }
    }
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if (requestCode == 0 && resultCode == 0){
            Bundle bunde = data.getExtras();
            String ans = bunde.getString("ans");
        }
    }
}
