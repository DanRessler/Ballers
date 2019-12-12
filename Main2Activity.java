package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Main2Activity extends AppCompatActivity {

    private ImageButton backButton;
    private Spinner spinner1;
    private Spinner spinner2;
    private Spinner spinner3;
    private Spinner spinner4;
    TextView dateTextView;
    ImageButton calendarButton;
    Calendar c;
    DatePickerDialog dpd;
    private Button confirmMatch;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        spinner1 = (Spinner) findViewById(R.id.spinner1);

        ArrayAdapter <String>  myAdapter = new ArrayAdapter<String>(Main2Activity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.hours));

        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(myAdapter);

        spinner2 = (Spinner) findViewById(R.id.spinner);

        ArrayAdapter <String>  myAdapter2 = new ArrayAdapter<String>(Main2Activity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.minutes));

        myAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(myAdapter2);

        spinner3 = (Spinner) findViewById(R.id.spinner4);

        ArrayAdapter <String>  myAdapter3 = new ArrayAdapter<String>(Main2Activity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.morningOrNight));

        myAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(myAdapter3);

        spinner4 = (Spinner) findViewById(R.id.spinner5);

        ArrayAdapter <String>  myAdapter5 = new ArrayAdapter<String>(Main2Activity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.courts));

        myAdapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner4.setAdapter(myAdapter5);

        backButton = findViewById(R.id.imageButton);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity1();
            }
        });

        dateTextView = (TextView) findViewById(R.id.textView4);
        calendarButton = (ImageButton) findViewById(R.id.imageButton2);
        calendarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c = Calendar.getInstance();
                int day = c.get(Calendar.DAY_OF_MONTH);
                int month = c.get(Calendar.MONTH);
                int year = c.get(Calendar.YEAR);

                dpd = new DatePickerDialog(Main2Activity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int nYear, int nMonth, int nDay) {
                       dateTextView.setText((nMonth+1) + "/" + nDay + "/" + nYear);
                    }
                },month,day, year);
                dpd.show();
            }
        });

        confirmMatch = findViewById(R.id.button3);

        confirmMatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity4();
            }
        });
    }

    public void openActivity4(){
        Intent intent = new Intent(this, Main4Activity.class);
        startActivity(intent);
    }

    public void openActivity1(){
        Intent intent = new Intent(this, Main3Activity.class);
        startActivity(intent);
    }
}
