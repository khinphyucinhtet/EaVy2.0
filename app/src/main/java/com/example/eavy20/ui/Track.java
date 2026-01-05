package com.example.eavy20.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.eavy20.R;
import com.example.eavy20.database.UserDao;

public class Track extends AppCompatActivity {

    LinearLayout navHome, navMap, navTrack, navSettings;
    LinearLayout btnLogout, btnDeleteAccount;
    TextView tvUserName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.track);

        // ================= USER NAME =================
        tvUserName = findViewById(R.id.tvUserName);

        SharedPreferences prefs = getSharedPreferences("UserSession", MODE_PRIVATE);
        String username = prefs.getString("username", null);

        if (username != null) {
            UserDao userDao = new UserDao(this);
            String fullName = userDao.getFullNameByUsername(username);
            if (fullName != null) {
                tvUserName.setText(fullName);
            }
        }

        // ================= NAV BAR =================
        navHome = findViewById(R.id.navHome);
        navMap = findViewById(R.id.navMap);
        navTrack = findViewById(R.id.navTrack);
        navSettings = findViewById(R.id.navSettings);

        navHome.setOnClickListener(v -> {
            // already here
        });

        navMap.setOnClickListener(v ->
                startActivity(new Intent(this, Map.class)));

        navTrack.setOnClickListener(v ->
                startActivity(new Intent(this, Track.class)));

        navSettings.setOnClickListener(v ->
                startActivity(new Intent(this, Setting.class)));

        // ================= LOGOUT & DELETE =================
        btnLogout = findViewById(R.id.btnLogout);
        btnDeleteAccount = findViewById(R.id.btnDeleteAccount);

        // LOG OUT
        btnLogout.setOnClickListener(v -> {
            prefs.edit().clear().apply();

            Intent intent = new Intent(Track.this, SplashActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        });

        // DELETE ACCOUNT
        btnDeleteAccount.setOnClickListener(v -> showDeleteConfirmation());
    }

    // ================= DELETE CONFIRMATION POPUP =================
    private void showDeleteConfirmation() {
        new AlertDialog.Builder(this)
                .setTitle("Delete Account")
                .setMessage(
                        "You are going to delete your account.\n\n" +
                                "All details related to this account will be deleted.\n\n" +
                                "Are you sure you want to continue?"
                )
                .setCancelable(false)
                .setPositiveButton("Yes", (dialog, which) -> {

                    SharedPreferences prefs = getSharedPreferences("UserSession", MODE_PRIVATE);
                    String username = prefs.getString("username", null);

                    if (username != null) {
                        UserDao userDao = new UserDao(Track.this);
                        userDao.deleteUser(username); // 🔥 DELETE FROM DATABASE
                    }

                    // Clear session after deletion
                    prefs.edit().clear().apply();

                    Intent intent = new Intent(Track.this, SplashActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    finish();
                })
                .setNegativeButton("No", (dialog, which) -> dialog.dismiss())
                .show();
    }
}
