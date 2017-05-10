package com.example.asus.a5;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class otherActivity extends Activity {
    private Intent intent;
    private Bundle bunde;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.other);

        Bundle bunde= this.getIntent().getExtras();
        String ans = bunde.getString("ans");
        String sextext="";
        if (ans.equals("in")){
            sextext="正确";
        }else {
            sextext="错误";
        }
        TextView tv=(TextView) findViewById(R.id.text1);
        tv.setText("你选择的答案是："+sextext);

        Button back=(Button) findViewById(R.id.back);
        back.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                otherActivity.this.setResult(RESULT_OK,intent);

                otherActivity.this.finish();
            }
        });
    }
}
