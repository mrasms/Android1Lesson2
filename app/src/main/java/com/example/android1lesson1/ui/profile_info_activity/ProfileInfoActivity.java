package com.example.android1lesson1.ui.profile_info_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android1lesson1.R;
import com.example.android1lesson1.constants.Constants;

public class ProfileInfoActivity extends AppCompatActivity {
    ImageView imAvatar;
    TextView tvUserEmail, tvUserPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_info);
        initialisation();
        setupData();

    }

    private void initialisation() {
        imAvatar = findViewById(R.id.im_avatar);
        tvUserEmail = findViewById(R.id.tv_user_email_address);
        tvUserPassword = findViewById(R.id.tv_user_password);
    }

    private void setupData() {
        Intent intent = getIntent();
        String nameMain = intent.getStringExtra(Constants.EMAIL);
        String passwordMain = intent.getStringExtra(Constants.PASSWORD);
        tvUserEmail.setText(nameMain.trim());
        tvUserPassword.setText(passwordMain.trim());

    }

}