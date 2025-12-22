package com.example.eavy20.ui;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import com.example.eavy20.R;

import androidx.appcompat.app.AppCompatActivity;

public class Setting extends AppCompatActivity {

    LinearLayout navHome, navMap, navTrack, navSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting);

        // ---------- HEADER ----------
        findViewById(R.id.backButton).setOnClickListener(v -> finish());

        // ---------- FOOTER NAV ----------
        navHome = findViewById(R.id.navHome);
        navMap = findViewById(R.id.navMap);
        navTrack = findViewById(R.id.navTrack);
        navSettings = findViewById(R.id.navSettings);

        navHome.setOnClickListener(v ->
                startActivity(new Intent(this, Home.class)));

        navMap.setOnClickListener(v ->
                startActivity(new Intent(this, Map.class)));

        navTrack.setOnClickListener(v ->
                startActivity(new Intent(this, Track.class)));

        navSettings.setOnClickListener(v -> {
            // already on Setting
        });

        // ---------- BUTTONS ----------
        findViewById(R.id.btnAboutUs).setOnClickListener(v ->
                showPopup(R.layout.about_us));

        findViewById(R.id.btnHelp).setOnClickListener(v ->
                showPopup(R.layout.help));

        findViewById(R.id.btnContactUs).setOnClickListener(v ->
                showPopup(R.layout.popup_contact_us));

        findViewById(R.id.btnPrivacyPolicy).setOnClickListener(v ->
                showPopup(R.layout.privacy_policy));
    }

    // ---------- POPUP HELPER ----------
    private void showPopup(int layoutId) {
        View view = LayoutInflater.from(this).inflate(layoutId, null);

        AlertDialog dialog = new AlertDialog.Builder(this)
                .setView(view)
                .setCancelable(true)
                .create();

        dialog.show();

        View close = view.findViewById(R.id.btnClose);
        if (close != null) {
            close.setOnClickListener(v -> dialog.dismiss());
        }
    }
}
