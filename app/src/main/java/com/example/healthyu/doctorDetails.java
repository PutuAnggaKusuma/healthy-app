package com.example.healthyu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class doctorDetails extends AppCompatActivity {
private String [][] detailDokter1 =
        {
                {"Nama : Dummy1", "Alamat Kerja : RSUD UDAYANA", "Pengalaman : 6 Tahun", "No telp : 14022", "250.000"},
                {"Nama : Nanda ", "Alamat Kerja : RSUD Kab Jembrana", "Pengalaman : 10 Tahun", "No telp : 14022", "250.000"},
                {"Nama : Zur ", "Alamat Kerja : RSUD Kab Tabanan", "Pengalaman :2 Tahun", "No telp : 14022", "250.000"},
                {"Nama : Orisa", "Alamat Kerja : RS Mahotama", "Pengalaman : 6 Tahun", "No telp : 14022", "250.000"}
        };

    private String [][] detailDokter2=
            {
                    {"Nama : Dummy2", "Alamat Kerja : RSUD UDAYANA", "Pengalaman : 6 Tahun", "No telp : 14022", "250.000"},
                    {"Nama : Nanda ", "Alamat Kerja : RSUD Kab Jembrana", "Pengalaman : 10 Tahun", "No telp : 14022", "250.000"},
                    {"Nama : Zur ", "Alamat Kerja : RSUD Kab Tabanan", "Pengalaman :2 Tahun", "No telp : 14022", "250.000"},
                    {"Nama : Orisa", "Alamat Kerja : RS Mahotama", "Pengalaman : 6 Tahun", "No telp : 14022", "250.000"}
            };

    private String [][] detailDokter3=
            {
                    {"Nama : Dummy3", "Alamat Kerja : RSUD UDAYANA", "Pengalaman : 6 Tahun", "No telp : 14022", "250.000"},
                    {"Nama : Nanda ", "Alamat Kerja : RSUD Kab Jembrana", "Pengalaman : 10 Tahun", "No telp : 14022", "250.000"},
                    {"Nama : Zur ", "Alamat Kerja : RSUD Kab Tabanan", "Pengalaman :2 Tahun", "No telp : 14022", "250.000"},
                    {"Nama : Orisa ", "Alamat Kerja : RS Mahotama", "Pengalaman : 6 Tahun", "No telp : 14022", "250.000"}
            };

    private String [][] detailDokter4=
            {
                    {"Nama : Dummy4", "Alamat Kerja : RSUD UDAYANA", "Pengalaman : 6 Tahun", "No telp : 14022", "250.000"},
                    {"Nama : Nanda", "Alamat Kerja : RSUD Kab Jembrana", "Pengalaman : 10 Tahun", "No telp : 14022", "250.000"},
                    {"Nama : Zur", "Alamat Kerja : RSUD Kab Tabanan", "Pengalaman :2 Tahun", "No telp : 14022", "250.000"},
                    {"Nama : Orisa", "Alamat Kerja : RS Mahotama", "Pengalaman : 6 Tahun", "No telp : 14022", "250.000"}
            };

    private String [][] detailDokter5=
            {
                    {"Nama : Dummy5  ", "Alamat Kerja : RSUD UDAYANA", "Pengalaman : 6 Tahun", "No telp : 14022", "250.000"},
                    {"Nama : Nanda ", "Alamat Kerja : RSUD Kab Jembrana", "Pengalaman : 10 Tahun", "No telp : 14022", "250.000"},
                    {"Nama : Zur ", "Alamat Kerja : RSUD Kab Tabanan", "Pengalaman :2 Tahun", "No telp : 14022", "250.000"},
                    {"Nama : Orisa ", "Alamat Kerja : RS Mahotama", "Pengalaman : 6 Tahun", "No telp : 14022", "250.000"}
            };


    TextView TV;
    ArrayList list;
    HashMap<String,String> item;
    SimpleAdapter Sa;

    String [][] detailDokter = {};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);
        TV = findViewById(R.id.judulDetailDokter);
        Intent dokterDetail = getIntent();
        String judulDetail = dokterDetail.getStringExtra("Title");
        TV.setText(judulDetail);

        if(judulDetail.compareTo("Dentist")==0)
            detailDokter = detailDokter1;
        else if (judulDetail.compareTo("Cardiologist")==0)
            detailDokter = detailDokter2;
        else if (judulDetail.compareTo("Psikiater")==0)
            detailDokter = detailDokter3;
        else if (judulDetail.compareTo("Dietitian")==0)
            detailDokter = detailDokter4;

        list = new ArrayList();
        for(int i = 0;i<detailDokter.length;i++ ){
        item = new HashMap<String,String>();
        item.put("line1",detailDokter[i][0]);
        item.put("line2",detailDokter[i][1]);
        item.put("line3",detailDokter[i][2]);
        item.put("line4",detailDokter[i][3]);
        item.put("line5","Biaya :" + detailDokter[i][4]);
        list.add(item);
        }
        Sa = new SimpleAdapter(this,list, R.layout.multi_lines,
                new String[] {"line1","line2","line3","line4","line5"},
                new int[] {R.id.lineA, R.id.lineB,R.id.lineC, R.id.lineD, R.id.lineE});
        ListView list =findViewById(R.id.listDokter);
        list.setAdapter(Sa);



        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(doctorDetails.this, bookingAppointment.class);
                it.putExtra("text1",detailDokter[i][0]);
                it.putExtra("text2",detailDokter[i][3]);
                it.putExtra("text3",detailDokter[i][4]);
                startActivity(it);
            }
        });

    }
    }

