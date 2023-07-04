package com.example.healthyu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LabDetailActivity extends AppCompatActivity {
    TextView tvPackageName, tvTotalCost;
    EditText edDetails;

    Button addtochart ;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_lab_detail);
            tvPackageName = findViewById(R.id.textViewLDPackageName);
            tvTotalCost = findViewById(R.id.textviewLDTotalCost);
            edDetails = findViewById(R.id.editTextLDTextMultiline);
            addtochart = findViewById(R.id.buttonLDAddToCart);

            edDetails.setKeyListener(null);

            Intent intent=getIntent();
            tvPackageName.setText(intent.getStringExtra(  "text1"));
            edDetails.setText (intent.getStringExtra( "text2"));
            tvTotalCost.setText("Total Cost: "+intent.getStringExtra( "text3")+"/-");

            addtochart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent berhasil = new Intent(LabDetailActivity.this, BerhasilActivity.class);
                    startActivity(berhasil);
                }
            });
        }
    }