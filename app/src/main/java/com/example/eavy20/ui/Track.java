package com.example.eavy20.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.eavy20.R;

public class Track extends AppCompatActivity {

    LinearLayout navHome, navMap, navTrack, navSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.track);

        navHome = findViewById(R.id.navHome);
        navMap = findViewById(R.id.navMap);
        navTrack = findViewById(R.id.navTrack);
        navSettings = findViewById(R.id.navSettings);

        navHome.setOnClickListener(v -> {
            // already on Home
        });

        navMap.setOnClickListener(v ->
                startActivity(new Intent(this, Map.class)));

        navTrack.setOnClickListener(v ->
                startActivity(new Intent(this, Track.class)));

        navSettings.setOnClickListener(v ->
                startActivity(new Intent(this, Setting.class)));
    }
}
