package com.topa.techpark;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class find_parking extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_parking);

        Button student = (Button)findViewById(R.id.button_student);
        student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(find_parking.this, student.class);
                startActivity(intent);
            }
        });

        Button faculty = (Button)findViewById(R.id.button_faculty);
        faculty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(find_parking.this, student.class);
                startActivity(intent);
            }
        });

        Button visitor = (Button)findViewById(R.id.button_visitor);
        visitor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(find_parking.this, student.class);
                startActivity(intent);
            }
        });
    }
}
