package com.nadxlib.dort;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class HotelDistrictPicker extends AppCompatActivity {

    TextView title,place;
    Spinner spinner;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_district_picker);
        spinner = findViewById(R.id.spinner);
        button = findViewById(R.id.button3);
        final String[] s = {""};
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.hotels, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                s[0] = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });




        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HotelDistrictPicker.this, HotelDetails.class);
                intent.putExtra("name",s[0]);
                startActivity(intent);

            }
        });
    }
}