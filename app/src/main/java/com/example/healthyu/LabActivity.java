package com.example.healthyu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.AdapterView;
import java.util.ArrayList;
import java.util.HashMap;

public class LabActivity extends AppCompatActivity {

    private String[][] packages =
            {
                    {"Package 1  : Full Body Checkup", "", "", "", "899"},
                    {"Package 2  : Blood Glucose Fasting", "", "", "", "600"},
                    {"Package 3  : COVID-19 Antibody", "", "", "", "700"},
                    {"Package 4  : Thyroid Check", "", "", "", "800"},
                    {"Package 5  : Immunity Check", "", "", "", "450"}
            };
    private String[] package_detail = {
            "Blood Glucose Fasting\n" +
            "Complete Hemogram\n" +
            "HbA1c\n"+
    "Iron Studies\n" +
            "Kidney Function Testin" +
            "LOH Lactate Dehydrogenase, Serum\n" +
            "Lipid Profile\n" +
            "Liver Function Test",
            "Blood Glucose Fasting",
            "COVID-19 Antibody- Ige",
            "Thyroid Profile-Total T3, T4 & TSH Ultra-sensitive)",
            "Complete Henogram\n" +
            "CRP (C Reactive Protein) Quantitative, Serum\n" +
    "Iron Studies\n" +
            "Kidney Function Testin\n" +
            "Vitamin D Total-25 Hydroxy\n"+
            "Liver Function Test\n" +
            "Lipid Profile"
    };

    HashMap<String, String> item;
        ArrayList list;
        SimpleAdapter sa;
        Button btnGoToCart;
        ListView listlab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab);

        btnGoToCart = findViewById(R.id.gochart);
        listlab = findViewById(R.id.listlab);

        btnGoToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getId() == R.id.gochart) {
                    Intent gochart = new Intent(LabActivity.this, DokterActivity.class);
                    startActivity(gochart);
                }
            }
        });
        list = new ArrayList();
        for (int i=0;i<packages.length; i++) {
            item = new HashMap<String, String>();
            item.put("Line1", packages[i][0]);
            item.put("line2", packages[i][1]);
            item.put("Line3", packages[i][2]);
            item.put("Line4", packages[i][3]);
            item.put("Line5", "Total Cost: " + packages[i][4] + "/-");
            list.add(item);
        }
                sa = new SimpleAdapter(this, list,
                R.layout.multi_lines,
                new String[] { "Line1","line2", "lines", "Line4", "line5" },
                new int[] {R.id.lineA, R.id.lineB, R.id.lineC, R.id.lineD, R.id.lineE});
        listlab.setAdapter(sa);

        listlab.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(LabActivity.this, LabDetailActivity.class);
                it.putExtra("text1", packages[i][0]);
                it.putExtra("text2", package_detail[i]);
                it.putExtra("text3", packages[i][4]);
                startActivity(it);
            }
        });
    }
}