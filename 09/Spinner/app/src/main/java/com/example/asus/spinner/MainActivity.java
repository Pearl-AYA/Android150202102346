package com.example.asus.spinner;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private static final String[] countriesStr={"广州","从化","武汉","汕头"};
    private TextView myTextView;
    private Spinner mySpinner;
    private ArrayAdapter adapter;
    private EditText myEditText;
    private Button add;
    private Button remove;
    private List allCountries;
    Animation myAnimation;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        allCountries=new ArrayList();
        for (int i=0;i<countriesStr.length;i++){
            allCountries.add(countriesStr[i]);
        }
        adapter=new ArrayAdapter(this,android.R.layout.simple_spinner_item,allCountries);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        myTextView=(TextView)findViewById(R.id.myTextView);
        myEditText=(EditText)findViewById(R.id.myEditText);
        add=(Button)findViewById(R.id.myButton_add);
        remove=(Button)findViewById(R.id.myButton_remove);
        mySpinner=(Spinner)findViewById(R.id.mySpinner);
        mySpinner.setAdapter(adapter);
        add.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View arg0){
                String newCountry=myEditText.getText().toString();
                for (int i=0;i<adapter.getCount();i++){
                    if (newCountry.equals(adapter.getItem(i))){
                        return;
                    }
                }
                if (!newCountry.equals("")){
                    adapter.add(newCountry);
                    int position=adapter.getPosition(newCountry);
                    mySpinner.setSelection(position);
                    myEditText.setText("");
                }
            }
        });
        remove.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View arg0){
                if (mySpinner.getSelectedItem()!=null){
                    adapter.remove(mySpinner.getSelectedItem().toString());
                    myEditText.setText("");
                    if (adapter.getCount()==0){
                        myTextView.setText("");
                    }
                }
            }
        });
        mySpinner.setOnItemSelectedListener(new Spinner.OnItemSelectedListener(){
            public void onItemSelected(AdapterView arg0, View arg1,int arg2, long arg3){
                myTextView.setText("选择的是"+arg0.getSelectedItem().toString());
            }
            public void onNothingSelected(AdapterView arg0){

            }
        });
        myAnimation= AnimationUtils.loadAnimation(this,R.anim.my_anim);
        mySpinner.setOnTouchListener(new Spinner.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                v.startAnimation(myAnimation);
                v.setVisibility(View.INVISIBLE);
                return false;
            }
        });
        mySpinner.setOnFocusChangeListener(new Spinner.OnFocusChangeListener(){
            @Override
            public void onFocusChange(View v, boolean hasFocus) {

            }
        });
    }
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.spinner_demo,menu);
        return true;
    }
}
