package com.example.karisikproje;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    TextView textView;
    Button button;
    String userName;

    CheckBox male;
    CheckBox female;

    ImageView imageView;
    RadioGroup radioGroup;
    RadioButton red;
    RadioButton green;

    ConstraintLayout layout;

    ToggleButton toggleButton;
    Spinner spinner;
    ArrayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
       button=findViewById(R.id.button);
        editText = findViewById(R.id.editTextText);
        imageView = findViewById(R.id.imageView);
        male = findViewById(R.id.checkBox);
        female = findViewById(R.id.checkBox2);
        radioGroup = findViewById(R.id.radioGroup);
        red = findViewById(R.id.radioButton);
        green = findViewById(R.id.radioButton2);
        layout =findViewById(R.id.layout);
        toggleButton=findViewById(R.id.toggleButton);
        spinner = findViewById(R.id.spinner);

        //Adapter bağlantı kodları
        adapter = ArrayAdapter.createFromResource(this,R.array.countries, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //Iteme tıklanınca
              String country=  adapterView.getItemAtPosition(i).toString(); // ülke adları geldi
              textView.setText(country);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (toggleButton.isChecked()){
                    imageView.setVisibility(View.INVISIBLE);
                    textView.setText("Image is hidded ");
                }
                else {
                    imageView.setVisibility(View.VISIBLE);
                    textView.setText("Image is showed ");
                }
            }
        });
        male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (male.isChecked()){
                    textView.setText("Male");
                    female.setChecked(false);
                }
                else {
                    textView.setText("What is your gender ? ");
                }
            }
        });

        female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (male.isChecked()){
                    textView.setText("female");
                    male.setChecked(false);
                }
                else {
                    textView.setText("What is your gender ? ");
                }
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userName = editText.getText().toString();
                textView.setText("Tıklandı"+userName);
                imageView.setImageResource(R.drawable.ekran);


                if (green.isChecked()){
                    layout.setBackgroundColor(Color.GREEN);
                }
                else if(red.isChecked()){
                    layout.setBackgroundColor(Color.RED);
                }
            }
        });
    }




}