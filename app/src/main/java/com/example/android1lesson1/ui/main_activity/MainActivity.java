package com.example.android1lesson1.ui.main_activity;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.android1lesson1.R;
import com.example.android1lesson1.constants.Constants;
import com.example.android1lesson1.ui.profile_info_activity.ProfileInfoActivity;

public class MainActivity extends AppCompatActivity {
    ImageView imIcfb;
    Button btnLogin;
    EditText etEmail, etPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialisation();
        setupListener();

    }

    private void initialisation() {
        imIcfb = findViewById(R.id.im_icfb);
        btnLogin = findViewById(R.id.btn_login);
        etEmail = findViewById(R.id.et_email);
        etPassword = findViewById(R.id.et_password);

    }

    private void setupListener() {

        imIcfb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultLauncher.launch("image/*");

            }

        });
        imIcfb.buildDrawingCache();


        btnLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();
                Intent intent = new Intent(MainActivity.this, ProfileInfoActivity.class);
                intent.putExtra(Constants.EMAIL, email);
                intent.putExtra(Constants.PASSWORD, password);
                if (email.length() == 0 || password.length() == 0) {
                    etEmail.setError("Введите Email");
                    etPassword.setError("Введите пароль");
                } else startActivity(intent);

            }
        });
    }

    ActivityResultLauncher<String> resultLauncher = registerForActivityResult(new ActivityResultContracts.GetContent(),
            new ActivityResultCallback<Uri>() {
                @Override
                public void onActivityResult(Uri result) {
                    imIcfb.setImageURI(result);

                }
            });
}