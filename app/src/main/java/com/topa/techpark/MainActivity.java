package com.topa.techpark;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button findPark = (Button)findViewById(R.id.button_find_park);
        findPark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, find_parking.class);
                startActivity(intent);
            }
        });

        Button niteShuttle = (Button)findViewById(R.id.button_nite);
        niteShuttle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, nite_shuttle.class);
                startActivity(intent);
            }
        });

        Button safeRide = (Button)findViewById(R.id.button_safe);
        safeRide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, safe_ride.class);
                startActivity(intent);
            }
        });
    }
}

