package com.joaquinalan.petagram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        Toolbar tbMyActionBar = (Toolbar) findViewById(R.id.toolbar_about);
        setSupportActionBar(tbMyActionBar);
        getSupportActionBar().setTitle(R.string.about_toolbartitle);
        getSupportActionBar().setIcon(R.drawable.about_smileicon);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
}
