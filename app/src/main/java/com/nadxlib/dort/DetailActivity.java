package com.nadxlib.dort;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.smnadim21.api.BdApps;
import com.smnadim21.api.Constants;
import com.smnadim21.api.SubscriptionStatusListener;

public class DetailActivity extends AppCompatActivity {

    Button news,fixt,stan,trans,hotels;
    boolean flag=false;

    int c = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //button finding
        news = findViewById(R.id.button2);
        fixt = findViewById(R.id.button);
        stan = findViewById(R.id.button7);
        trans = findViewById(R.id.button8);
        hotels = findViewById(R.id.hotels);




        //hotels
        hotels.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),TicketBookActivity.class));
            }
        });










         // button actions
        news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DetailActivity.this, MapsActivity.class));
            }
        });

        fixt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(DetailActivity.this, DistrictPicker.class));
            }
        });

        stan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(DetailActivity.this, HotelDistrictPicker.class));
               // Toast.makeText(getApplicationContext(),"not added yet",Toast.LENGTH_LONG).show();

            }
        });

        trans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                                Intent intent = new Intent(getApplicationContext(),WV.class);
                intent.putExtra("name","Book Bus Ticket");
                intent.putExtra("url","https://www.shohoz.com/bus-tickets/dhaka-to-dinajpur");
                startActivity(intent);


            }
        });

    }


}