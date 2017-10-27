package com.topa.techpark;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class student extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        Button commNorth = (Button)findViewById(R.id.button_commNorth);
        commNorth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(student.this,commNorth.class);
                startActivity(intent);
            }
        });

        Button commWest = (Button)findViewById(R.id.button_commWest);
        commWest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(student.this, commNorth.class);
                startActivity(intent);
            }
        });

        Button satellite = (Button)findViewById(R.id.button_satellite);
        satellite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(student.this, commNorth.class);
                startActivity(intent);
            }
        });
    }
}
