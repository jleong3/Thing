package com.example.jeanleong.testing510;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class AddTaskActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, AdapterView.OnItemSelectedListener{
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

        courseList = (Spinner) findViewById(R.id.courseSpinner);
        addItemsOnTypeSpinner(courseList);
        addListenerOnSpinnerItemSelection(courseList);
    }
    //Spinner Methods
    public void addItemsOnTypeSpinner(Spinner spinner) {

        List<String> list = new ArrayList<String>();
        list.add("AP Computer Science");
        list.add("AP Physics");
        list.add("AP Calculus BC");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);
    }

    public void addListenerOnSpinnerItemSelection(Spinner spinner) {
        //spinner.setOnItemSelectedListener(new SpinnerOnItemSelectedListener());
        spinner.setOnItemSelectedListener(this);
        Log.d("[addListenerOnSpinner]", "setSpinner");
    }

    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id){
        Log.d("It works :D", "It really does");
    }

    public void onNothingSelected(AdapterView<?> parent){
        //another interface callback
        Log.i("Nothing was Selected??", "" + subject);
    }

    //Date Picker Methods
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
