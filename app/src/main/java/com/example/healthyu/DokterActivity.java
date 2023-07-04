package com.example.healthyu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class DokterActivity extends AppCompatActivity {
    private ImageView dentistView, psikiatrisView, dietitianView, cardiologistView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dokter);

        dentistView = findViewById(R.id.dentistView);
        psikiatrisView = findViewById(R.id.psikiatrisView);
        cardiologistView = findViewById(R.id.cardiologistView);
        dietitianView = findViewById(R.id.dentitistView);

        dentistView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getId() == R.id.dentistView) {
                    Intent dokterDetail = new Intent(DokterActivity.this, doctorDetails.class);
                    dokterDetail.putExtra("Title", "Dentist");
                    startActivity(dokterDetail);
                }
            }
        });

        cardiologistView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getId() == R.id.cardiologistView) {
                    Intent dokterDetail = new Intent(DokterActivity.this, doctorDetails.class);
                    dokterDetail.putExtra("Title", "Cardiologist");
                    startActivity(dokterDetail);
                }
            }
        });

        dietitianView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getId() == R.id.dentitistView) {
                    Intent dokterDetail = new Intent(DokterActivity.this, doctorDetails.class);
                    dokterDetail.putExtra("Title", "Dietitian");
                    startActivity(dokterDetail);
                }
            }
        });
        psikiatrisView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getId() == R.id.psikiatrisView) {
                    Intent dokterDetail = new Intent(DokterActivity.this, doctorDetails.class);
                    dokterDetail.putExtra("Title", "Psikiater");
                    startActivity(dokterDetail);

                }
            }
        });
    }
}
