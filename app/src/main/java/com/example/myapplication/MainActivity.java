package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.Toast;
import android.graphics.Color;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button gumb = findViewById(R.id.gumb);
        FloatingActionButton fab = findViewById(R.id.fab);

        gumb.setOnClickListener(v ->
                Toast.makeText(MainActivity.this, R.string.toast_besedilo, Toast.LENGTH_SHORT).show());

        fab.setOnClickListener(v ->
                Snackbar.make(v, R.string.snackbar_besedilo, Snackbar.LENGTH_LONG).show());

        fab.setOnLongClickListener(v -> {
            Snackbar snackbar = Snackbar.make(v, R.string.snackbar_besedilo, Snackbar.LENGTH_LONG);
            snackbar.setAnimationMode(Snackbar.ANIMATION_MODE_FADE);
            snackbar.setTextColor(Color.BLACK);

            View snackView = snackbar.getView();
            snackView.setBackgroundResource(R.drawable.toast_ozadje);
            snackView.setBackgroundTintList(null);
            snackView.setElevation(12);

            FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) snackView.getLayoutParams();
            params.width = FrameLayout.LayoutParams.WRAP_CONTENT;
            params.gravity = Gravity.CENTER;
            snackView.setLayoutParams(params);

            snackbar.show();
            return true;
        });

        RadioButton moski = findViewById(R.id.radio_moski);
        RadioButton zenska = findViewById(R.id.radio_zenska);

        moski.setOnCheckedChangeListener((buttonView, isChecked) ->
                Log.d("RADIO", "Moški is checked: " + isChecked));

        zenska.setOnCheckedChangeListener((buttonView, isChecked) ->
                Log.d("RADIO", "Ženska is checked: " + isChecked));
    }
}