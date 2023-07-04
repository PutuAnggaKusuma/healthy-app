package com.example.healthyu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ArtikelActivity extends AppCompatActivity {

    private ImageView pindah;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artikel);

        pindah= findViewById(R.id.gambar2);

        pindah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getId() == R.id.gambar2){
                    Intent artikel = new Intent(ArtikelActivity.this, ArtikellActivity.class);
                    startActivity(artikel);
                }
            }
        });
    }
}