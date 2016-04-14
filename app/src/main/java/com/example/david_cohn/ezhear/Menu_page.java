package com.example.david_cohn.ezhear;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Menu_page extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menulayout);
    }

    public void wordsClick(View v) {
        Intent i = new Intent(this, Categories.class);
        startActivity(i);
    }

    public void diffClick(View v) {
        Intent i = new Intent(this, DiffPronounce.class);
        startActivity(i);
    }


}
