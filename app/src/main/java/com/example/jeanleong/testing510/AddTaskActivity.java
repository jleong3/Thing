package com.example.jeanleong.testing510;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;

public class AddTaskActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{
    Spinner courseList;
    TextView assignment;
    Button dueDateButton;
    String name, date, subject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        dueDateButton = (Button) findViewById(R.id.dueDateButton);
        dueDateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HwDatePicker hwDatePicker = new HwDatePicker();
                hwDatePicker.show(getFragmentManager(), "Date Picker");
            }
        });



    }

    public void onDateSet(DatePicker datePicker, int year, int month, int day){
        /*Calendar calendar = Calendar.getInstance();
        calendar.set(year,month, day);
        this.date = calendar.getTime().toString();
        */
        int a = month + 1;
        this.date = "" + a + "/" + day + "/" + year;
        setText();
    }

    public void setText(){
        dueDateButton.setText(date);
    }
}
