package com.example.healthyu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageView gambar1, gambar2, gambar3, gambar4, gambar5, gambar6;
    private TextView nama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gambar1 = findViewById(R.id.gambar1);
        gambar2 = findViewById(R.id.gambar2);
        gambar4 = findViewById(R.id.gambar4);
        gambar6 = findViewById(R.id.gambar6);

        nama = findViewById(R.id.Anonim);

        String username = getIntent().getStringExtra("USERNAME");
        nama.setText(username);

        gambar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getId() == R.id.gambar1) {
                    Intent artikel = new Intent(MainActivity.this, ArtikelActivity.class);
                    startActivity(artikel);
                }
            }
        });

        gambar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getId() == R.id.gambar2) {
                    Intent lab = new Intent(MainActivity.this, LabActivity.class);
                    startActivity(lab);
                }
            }
        });

        gambar4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getId() == R.id.gambar4) {
                    Intent dokter = new Intent(MainActivity.this, DokterActivity.class);
                    startActivity(dokter);
                }
            }
        });

        gambar6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getId() == R.id.gambar6) {
                    Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}