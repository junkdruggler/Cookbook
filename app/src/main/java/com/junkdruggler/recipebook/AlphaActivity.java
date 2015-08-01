package com.junkdruggler.recipebook;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.jahirfiquitiva.paperboard.activities.MainActivity;


public class AlphaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = new Intent(AlphaActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }



}
