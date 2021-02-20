package com.example.myimplintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    Button btnCall, mapBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCall = findViewById(R.id.CallBtn);
        mapBtn = findViewById(R.id.mapBtn);

        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL);
                intentCall.setData(Uri.parse("tel:123456789"));
                startActivity(intentCall);
            }
        });

        mapBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentMap = new Intent(Intent.ACTION_VIEW);
                intentMap.setData(Uri.parse("geo:42.87 74.59"));
                Intent chooser = Intent.createChooser(intentMap, "Launch Google Maps");
                startActivity(chooser);
            }
        });
    }

    public void webBrowser(View view) {
        openUrl("https://www.google.com/");
    }

    public void openUrl(String url) {
        Uri uri = Uri.parse(url);
        Intent launchWeb = new Intent(Intent.ACTION_VIEW);
        Intent choosingWeb = Intent.createChooser(launchWeb, "Launch with");
        if (!url.startsWith("http://") && url.startsWith("https://")) {
            url = "http://" + url;
        }
        if (launchWeb.resolveActivity(getPackageManager()) != null) {
            startActivity(choosingWeb);
        }

    }
}