package com.example.android1lesson1.ui.profile_info_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android1lesson1.R;
import com.example.android1lesson1.constants.Constants;

import java.util.ArrayList;

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
        ArrayList<String> info = intent.getStringArrayListExtra("info");
        //intent.getData();
        //Uri uri = Uri.parse("uri");
        imAvatar.setImageURI(intent.getData());
        tvUserEmail.setText(info.get(0));
        tvUserPassword.setText(info.get(1));
    }

}