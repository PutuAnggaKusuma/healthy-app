package com.example.healthyu;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class bookingAppointment extends AppCompatActivity {
    EditText ed1, ed2, ed3;
    private DatePickerDialog datePicker;
    private TimePickerDialog timePicker;

    private Button dateButton, timeButton, booking;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_appointment);
        ed1 = findViewById(R.id.editName);
        ed2 = findViewById(R.id.editTextContact);
        ed3 = findViewById(R.id.editTextFees);
        dateButton = findViewById(R.id.dateButton);
        timeButton = findViewById(R.id.timeButton);
        booking = findViewById(R.id.booking);

        ed1.setKeyListener(null);
        ed2.setKeyListener(null);
        ed3.setKeyListener(null);

        Intent it = getIntent();
        String fullname = it.getStringExtra("text1");
        String contact = it.getStringExtra("text2");
        String Fees = it.getStringExtra("text3");


        ed1.setText(fullname);
        ed2.setText(contact);
        ed3.setText(Fees);


        initDatePicker();
        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePicker.show();
            }
        });

        initTimePicker();
        timeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timePicker.show();
            }
        });

        booking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent berhasil = new Intent(bookingAppointment.this, BerhasilActivity.class);
                startActivity(berhasil);
            }
        });
}


    private void initDatePicker(){

        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                i1 = i1 +1;
                dateButton.setText(i2 + "/"+ i1 + "/" + i);


            }
        };

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int date = cal.get(Calendar.DATE);
        int style = AlertDialog.THEME_HOLO_DARK;
        datePicker = new DatePickerDialog(this, style, dateSetListener, year, month, date);
        datePicker.getDatePicker().setMinDate(cal.getTimeInMillis()+8640000);
    }

    private void initTimePicker(){

        TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {
                timeButton.setText(i + ":" + i1);

            }

        };

        Calendar cal = Calendar.getInstance();
        int hrs = cal.get(Calendar.HOUR);
        int mnt = cal.get(Calendar.MINUTE);
        int style = AlertDialog.THEME_HOLO_DARK;
        timePicker = new TimePickerDialog(this, style, timeSetListener, hrs, mnt, true);

    }

}