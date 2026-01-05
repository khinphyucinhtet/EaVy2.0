package com.example.eavy20.ui;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.eavy20.R;

public class Map extends AppCompatActivity {

    // Popup card
    LinearLayout stationInfoCard;
    TextView stationName, stationAddress, stationPower, stationAvailability;
    ImageView btnClosePopup;
    Button btnDirections;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map);

        // ================= TOP BAR =================
        findViewById(R.id.backButton).setOnClickListener(v -> finish());

        // ================= POPUP =================
        stationInfoCard = findViewById(R.id.stationInfoCard);
        stationName = findViewById(R.id.stationName);
        stationAddress = findViewById(R.id.stationAddress);
        stationPower = findViewById(R.id.stationPower);
        stationAvailability = findViewById(R.id.stationAvailability);
        btnClosePopup = findViewById(R.id.btnClosePopup);
        btnDirections = findViewById(R.id.btnDirections);

        stationInfoCard.setVisibility(View.GONE);

        btnClosePopup.setOnClickListener(v ->
                stationInfoCard.setVisibility(View.GONE)
        );

        btnDirections.setOnClickListener(v -> showRoutingDialog());

        // ================= STATION MARKERS =================
        setupStation(
                R.id.station1,
                "Station 1 · 1.3 km",
                "Sector 7, Kojro",
                "120 kW · 12 min to 100%",
                "3 of 8 Available Connectors"
        );

        setupStation(
                R.id.station2,
                "Station 2 · 1.6 km",
                "Hayabusa Street",
                "100 kW · 18 min to 100%",
                "5 of 10 Available Connectors"
        );

        setupStation(
                R.id.station3,
                "Station 3 · 3.7 km",
                "Downtown Ring",
                "80 kW · 25 min to 100%",
                "2 of 6 Available Connectors"
        );

        setupStation(
                R.id.station4,
                "Station 4 · 2.9 km",
                "Central Avenue",
                "150 kW · 10 min to 100%",
                "6 of 8 Available Connectors"
        );

        setupStation(
                R.id.station5,
                "Station 5 · 4.2 km",
                "North Expressway",
                "60 kW · 30 min to 100%",
                "1 of 4 Available Connectors"
        );

        // ================= CURRENT LOCATION =================
        findViewById(R.id.currentLocation).setOnClickListener(v -> {
            stationName.setText("Your Location");
            stationAddress.setText("GPS-based location");
            stationPower.setText("—");
            stationAvailability.setText("Location active");

            btnDirections.setVisibility(View.GONE); // hide directions
            stationInfoCard.setVisibility(View.VISIBLE);
        });

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
    private void setupStation(int stationId,
                              String name,
                              String address,
                              String power,
                              String availability) {

        findViewById(stationId).setOnClickListener(v -> {
            stationName.setText(name);
            stationAddress.setText(address);
            stationPower.setText(power);
            stationAvailability.setText(availability);

            btnDirections.setVisibility(View.VISIBLE); // show directions
            stationInfoCard.setVisibility(View.VISIBLE);
        });
    }

    // ================= ROUTING DIALOG =================
    private void showRoutingDialog() {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_routing);
        dialog.setCancelable(false);

        if (dialog.getWindow() != null) {
            dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        }

        Button btnClose = dialog.findViewById(R.id.btnCloseRouting);
        btnClose.setOnClickListener(v -> dialog.dismiss());

        dialog.show();
    }
}
