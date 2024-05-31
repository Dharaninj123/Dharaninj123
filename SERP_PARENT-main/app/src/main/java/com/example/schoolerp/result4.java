package com.example.schoolerp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class result4 extends AppCompatActivity {

    private Button button211, button212, button213, button214, button21, button215, button216, button217, button218, buttone21;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_result4);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize buttons
        button211 = findViewById(R.id.button211);
        button212 = findViewById(R.id.button212);
        button213 = findViewById(R.id.button213);
        button214 = findViewById(R.id.button214);
        button21 = findViewById(R.id.button21);
        button215 = findViewById(R.id.button215);
        button216 = findViewById(R.id.button216);
        button217 = findViewById(R.id.button217);
        button218 = findViewById(R.id.button218);
        buttone21 = findViewById(R.id.buttone21);

        button211.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(result4.this, markscard.class);
                startActivity(intent);
            }
        });


        button212.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(result4.this, markscard.class);
                startActivity(intent);
            }
        });
        button213.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(result4.this, markscard.class);
                startActivity(intent);
            }
        });
        button214.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(result4.this, markscard.class);
                startActivity(intent);
            }
        });
        button21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(result4.this, markscard.class);
                startActivity(intent);
            }
        });
        button215.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(result4.this, markscard.class);
                startActivity(intent);
            }
        });
        button216.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(result4.this, markscard.class);
                startActivity(intent);
            }
        });
        button217.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(result4.this, markscard.class);
                startActivity(intent);
            }
        });
        button218.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(result4.this, markscard.class);
                startActivity(intent);
            }
        });
        buttone21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(result4.this, markscard.class);
                startActivity(intent);
            }
        });


    }
}
