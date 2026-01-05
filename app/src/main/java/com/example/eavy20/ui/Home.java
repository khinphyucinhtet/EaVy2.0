package com.example.eavy20.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.widget.TextView;

import com.example.eavy20.database.UserDao;

import com.example.eavy20.R;

public class Home extends AppCompatActivity {

    LinearLayout navHome, navMap, navTrack, navSettings;
    TextView tvGreeting;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        tvGreeting = findViewById(R.id.tvGreeting);

        SharedPreferences prefs = getSharedPreferences("UserSession", MODE_PRIVATE);
        String username = prefs.getString("username", null);

        if (username != null) {
            UserDao userDao = new UserDao(this);
            String fullName = userDao.getFullNameByUsername(username);

            if (fullName != null) {
                tvGreeting.setText("Hello, " + fullName);
            }
        }


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
