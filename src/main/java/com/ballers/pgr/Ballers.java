package com.ballers.pgr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import android.view.View;

import android.os.Bundle;

public class Ballers extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.postgame_main);
    }

    public void pgrConfirmClick(View v)
    {
        Intent i = new Intent(getBaseContext(), PGRConfirmation.class);
        startActivity(i);
    }
}
