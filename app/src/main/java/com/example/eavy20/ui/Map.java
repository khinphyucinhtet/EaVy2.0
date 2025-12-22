package com.example.eavy20.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.eavy20.R;

public class Map extends AppCompatActivity {

    // Popup card
    LinearLayout stationInfoCard;
    TextView stationName;
    ImageView btnClosePopup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map);

        // ================= TOP BAR =================
        findViewById(R.id.backButton).setOnClickListener(v -> finish());

        // ================= POPUP =================
        stationInfoCard = findViewById(R.id.stationInfoCard);
        stationName = findViewById(R.id.stationName);
        btnClosePopup = findViewById(R.id.btnClosePopup);

        stationInfoCard.setVisibility(View.GONE);

        btnClosePopup.setOnClickListener(v ->
                stationInfoCard.setVisibility(View.GONE)
        );

        // ================= STATION MARKERS =================
        setupStation(R.id.station1, "Station 1\n1.3 km • Sector 7");
        setupStation(R.id.station2, "Station 2\n1.6 km • Hayabusa Street");
        setupStation(R.id.station3, "Station 3\n3.7 km • Downtown Ring");
        setupStation(R.id.station4, "Station 4\n2.9 km • Central Avenue");
        setupStation(R.id.station5, "Station 5\n4.2 km • North Expressway");

        // ================= FOOTER NAV =================
        findViewById(R.id.navHome)
                .setOnClickListener(v ->
                        startActivity(new Intent(this, Home.class)));

        findViewById(R.id.navTrack)
                .setOnClickListener(v ->
                        startActivity(new Intent(this, Track.class)));

        findViewById(R.id.navSettings)
                .setOnClickListener(v ->
                        startActivity(new Intent(this, Setting.class)));
    }

    // ================= HELPER =================
    private void setupStation(int stationId, String title) {
        findViewById(stationId).setOnClickListener(v -> {
            stationName.setText(title);
            stationInfoCard.setVisibility(View.VISIBLE);
        });
    }
}
