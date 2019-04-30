package com.example.nh.datepicker;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
EditText editText,editText2;
int year;
int month;
int day;
int hours;
int minute;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Calendar calendar=Calendar.getInstance();
        year=calendar.get(Calendar.YEAR);
        month=calendar.get(Calendar.MONTH);
        day=calendar.get(Calendar.DAY_OF_MONTH);
        hours=calendar.get(Calendar.HOUR);
        minute=calendar.get(Calendar.MINUTE);



        editText2=findViewById(R.id.edtex2);

        editText=findViewById(R.id.edtex1);


        editText2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog tpd=new TimePickerDialog(MainActivity.this,AlertDialog.BUTTON_NEGATIVE, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        editText2.setText(hourOfDay+" "+minute);

                    }
                },hours,minute,true);
                tpd.show();
            }
        });


        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatePickerDialog dpd=new DatePickerDialog(MainActivity.this,AlertDialog.THEME_HOLO_DARK, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    editText.setText(year+" "+(month+1)+" "+dayOfMonth);
                    }
                },year,month,day);
                dpd.show();
            }
        });
    }
}


//    DatePickerDialog dpd=new DatePickerDialog(MainActivity.this,AlertDialog.THEME_HOLO_DARK, new DatePickerDialog.OnDateSetListener() {////


