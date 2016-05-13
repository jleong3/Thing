package com.example.jeanleong.testing510;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class AddTaskActivity extends AppCompatActivity {
    Spinner courseList;
    TextView assignment;
    Button dueDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

    }
}
