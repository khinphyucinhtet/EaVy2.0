package com.example.eavy20.ui;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.eavy20.R;
import com.example.eavy20.database.UserDao;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);

        UserDao userDao = new UserDao(this);

        EditText fullName = findViewById(R.id.inputFullName);
        EditText email = findViewById(R.id.inputEmail);
        EditText username = findViewById(R.id.inputUsername);
        EditText password = findViewById(R.id.inputPassword);
        EditText confirmPassword = findViewById(R.id.inputConfirmPassword);
        Button signUpBtn = findViewById(R.id.btnSignUp);
        TextView loginText = findViewById(R.id.loginText);

        // Navigate back to Login Screen
        loginText.setOnClickListener(v -> {
            startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            finish();
        });

        // Sign Up Button Logic
        signUpBtn.setOnClickListener(v -> {

            String name = fullName.getText().toString().trim();
            String mail = email.getText().toString().trim();
            String user = username.getText().toString().trim();
            String pass = password.getText().toString();
            String confirmPass = confirmPassword.getText().toString();

            // Validation
            if (name.isEmpty() || mail.isEmpty() || user.isEmpty() || pass.isEmpty()) {
                showDialog("Error", "Please fill in all fields");
                return;
            }

            if (!pass.equals(confirmPass)) {
                showDialog("Error", "Passwords do not match!");
                return;
            }

            // 🔥 INSERT INTO DATABASE
            boolean success = userDao.registerUser(name, mail, user, pass);

            if (success) {
                Toast.makeText(this, "Successfully Registered", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                finish();
            } else {
                showDialog("Error", "Username already exists!");
            }
        });
    }

    private void showDialog(String title, String message) {
        new AlertDialog.Builder(this)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton("OK", (dialog, which) -> dialog.dismiss())
                .setCancelable(true)
                .show();
    }
}
