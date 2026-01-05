package com.example.eavy20.ui;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences; // ✅ ADD
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.eavy20.R;
import com.example.eavy20.database.UserDao;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        UserDao userDao = new UserDao(this);

        EditText username = findViewById(R.id.usernameInput);
        EditText password = findViewById(R.id.passwordInput);
        Button loginBtn = findViewById(R.id.loginButton);
        TextView signUpText = findViewById(R.id.signUpText);

        // Navigate to Register page
        signUpText.setOnClickListener(v -> {
            startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
        });

        // Login Button Logic (REAL AUTH)
        loginBtn.setOnClickListener(v -> {

            String user = username.getText().toString().trim();
            String pass = password.getText().toString();

            if (user.isEmpty() || pass.isEmpty()) {
                showError("Please enter username and password");
                return;
            }

            boolean success = userDao.loginUser(user, pass);

            if (success) {

                // ✅ SAVE LOGGED-IN USER SESSION (THIS IS THE FIX)
                SharedPreferences prefs = getSharedPreferences("UserSession", MODE_PRIVATE);
                prefs.edit().putString("username", user).apply();

                // Existing navigation (keep as-is or change to Track if needed)
                startActivity(new Intent(LoginActivity.this, Home.class));
                finish(); // prevent back to login

            } else {
                showError("Invalid username or password");
            }
        });
    }

    private void showError(String message) {
        new AlertDialog.Builder(this)
                .setTitle("Login Failed")
                .setMessage(message)
                .setPositiveButton("OK", (dialog, which) -> dialog.dismiss())
                .setCancelable(true)
                .show();
    }
}
