package com.example.asus.om;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;



public class OptionsMenu extends Activity {
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public boolean onCreateOptionsMenu(Menu menu){
        menu.add(0, 1, 1, R.string.save);
        menu.add(0, 2 ,2, R.string.exit);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item){
        if (item.getItemId()==2){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
