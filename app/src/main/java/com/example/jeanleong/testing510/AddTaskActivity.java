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
        list.add("AP Calculus");
        list.add("Economics");
        list.add("Public Affairs");
        list.add("AP Statistics");
        list.add("SUPA Forensics");
        list.add("Chorus");
        list.add("Band");
        list.add("Orchestra");
        list.add("Geometry");
        list.add("Algebra 2 & Trigonometry");
        list.add("AP Chemistry");
        list.add("AP Biology");
        list.add("Living Environment R");
        list.add("Chemistry R");
        list.add("Chemistry H");
        list.add("Earth Science R");
        list.add("AP Environmental Science");
        list.add("Science Research");
        list.add("Introduction to Engineering Design");
        list.add("Principles of Engineering");
        list.add("Computer Integrated Manufacturing");
        list.add("Astronomy");
        list.add("Bioethics");
        list.add("Clmate & Meteorology");
        list.add("SUNY Oneonta – Planet Earth");
        list.add("Sustainability: Action for Change");
        //list.add("");
        list.add("Computer Science 1");
        list.add("Introduction to Computer Science");
        list.add("Pre-Calculus");
        list.add("Film Writing & Analysis");
        list.add("Creative Writing");
        list.add("World Mythology");
        list.add("Public Speaking & Speech Writing");
        list.add("Journalism/Writing to Publish");
        list.add("Race & Gender in Literature");
        list.add("Modern Literature");
        list.add("Philosophy of the Wild");
        list.add("ESOL");
        list.add("AP Language & Composition");
        list.add("SLT");
        list.add("AP Literature & Composition");
        list.add("Mastering Microsoft");
        list.add("English 1R");
        list.add("English 2R");
        list.add("English 2H");
        list.add("English 3R");
        list.add("English 3H");
        list.add("Global History");
        list.add("AP World History");
        list.add("AP U.S. History");
        list.add("U.S. History R");
        list.add("Accounting");
        list.add("Physics R");
        list.add("Integrated Algebra");
        list.add("AP Music Theory");
        list.add("AP European History");
        list.add("Introduction to Engineering Design");
        list.add("");
        //list.sort();
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
