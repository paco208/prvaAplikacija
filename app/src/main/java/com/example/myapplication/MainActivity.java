package com.example.myapplication;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;
import android.graphics.Color;
import android.widget.TextView;

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

            View snackView = snackbar.getView();
            snackView.setBackgroundResource(R.drawable.toast_ozadje);
            snackView.setElevation(12);

            FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) snackView.getLayoutParams();
            params.width = FrameLayout.LayoutParams.WRAP_CONTENT;
            params.gravity = Gravity.CENTER;
            snackView.setLayoutParams(params);

            TextView tekst = snackView.findViewById(com.google.android.material.R.id.snackbar_text);
            tekst.setTextColor(Color.BLACK);
            tekst.setTextSize(14);

            snackbar.show();
            return true;
        });
    }
}