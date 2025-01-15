package com.is360.me_azkar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class About extends AppCompatActivity {

    ImageView tiktok, facebook, youtube, instagram, web;
    CardView whatsappGroup;
    TextView mail,waNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            this.getSupportActionBar().hide();
            this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
        } catch (NullPointerException e) {
        }
        setContentView(R.layout.activity_about);

        // find views
        mail = findViewById(R.id.app_email);
        waNumber = findViewById(R.id.app_number);
        whatsappGroup = findViewById(R.id.joinWhatsapp);

        tiktok = findViewById(R.id.tiktok);
        facebook = findViewById(R.id.facebook);
        youtube = findViewById(R.id.youtube);
        instagram = findViewById(R.id.instagram);
        web = findViewById(R.id.web);


        tiktok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                openSocialMedia("https://www.tiktok.com/@islamstatus360", "com.android.chrome");
                openSocialMedia("https://tiktok.com/@thenasihun", "com.android.chrome");
            }
        });

        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                openSocialMedia("https://facebook.com/islamstatus360", "com.android.chrome");
                openSocialMedia("https://facebook.com/thenasihun", "com.android.chrome");
            }
        });

        youtube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                openSocialMedia("https://youtube.com/islamstatus360", "");
                openSocialMedia("https://youtube.com/@thenasihun", "");
            }
        });

        instagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                openSocialMedia("https://instagram.com/islamstatus360", "");
                openSocialMedia("https://instagram.com/thenasihun", "");
            }
        });

        web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                openSocialMedia("https://twitter.com/islamstatus360", "");
                openSocialMedia("https://nasihun.com", "");
            }
        });

        waNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSocialMedia("https://api.whatsapp.com/send?phone=923106162624", "");
            }
        });

        mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        whatsappGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                openSocialMedia("https://islamstatus360.github.io/wagroup", "com.android.chrome");
                openSocialMedia("https://whatsapp.com/channel/0029VaCXfSF1NCrXOeyGBk3l", "com.android.chrome");
            }
        });
    }

    private void openSocialMedia (String url, String packageName) {
        Intent intent;
        intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));

        if (packageName == "") {
            try {
                startActivity(intent);
            }
            catch (Exception e) {
                Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
            }
        }
        else {
            intent.setPackage(packageName);
            try {
                startActivity(intent);
            }
            catch (Exception e) {
                Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
            }

        }
    }
}