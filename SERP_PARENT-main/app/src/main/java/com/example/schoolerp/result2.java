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

public class result2 extends AppCompatActivity {

    private Button button231, button232, button233, button234, button23, button235, button236, button237, button238, buttone23;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_result2);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize buttons
        button231 = findViewById(R.id.button231);
        button232 = findViewById(R.id.button232);
        button233 = findViewById(R.id.button233);
        button234 = findViewById(R.id.button234);
        button23 = findViewById(R.id.button23);
        button235 = findViewById(R.id.button235);
        button236 = findViewById(R.id.button236);
        button237 = findViewById(R.id.button237);
        button238 = findViewById(R.id.button238);
        buttone23 = findViewById(R.id.buttone23);

        button231.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(result2.this, markscard.class);
                startActivity(intent);
            }
        });

        button232.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(result2.this, markscard.class);
                startActivity(intent);
            }
        });
        button233.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(result2.this, markscard.class);
                startActivity(intent);
            }
        });
        button234.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(result2.this, markscard.class);
                startActivity(intent);
            }
        });
        button23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(result2.this, markscard.class);
                startActivity(intent);
            }
        });
        button235.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(result2.this, markscard.class);
                startActivity(intent);
            }
        });
        button236.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(result2.this, markscard.class);
                startActivity(intent);
            }
        });
        button237.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(result2.this, markscard.class);
                startActivity(intent);
            }
        });
        button238.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(result2.this, markscard.class);
                startActivity(intent);
            }
        });
        buttone23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(result2.this, markscard.class);
                startActivity(intent);
            }
        });
    }
}