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

public class result1 extends AppCompatActivity {

    private Button button241, button242, button243, button244, button24, button245, button246, button247, button248, buttone24;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_result1);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize buttons
        button241 = findViewById(R.id.button241);
        button242 = findViewById(R.id.button242);
        button243 = findViewById(R.id.button243);
        button244 = findViewById(R.id.button244);
        button24 = findViewById(R.id.button24);
        button245 = findViewById(R.id.button245);
        button246 = findViewById(R.id.button246);
        button247 = findViewById(R.id.button247);
        button248 = findViewById(R.id.button248);
        buttone24 = findViewById(R.id.buttone24);

        button241.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(result1.this, markscard.class);
                startActivity(intent);
            }
        });

        button242.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(result1.this, markscard.class);
                startActivity(intent);
            }
        });
        button243.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(result1.this, markscard.class);
                startActivity(intent);
            }
        });
        button244.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(result1.this, markscard.class);
                startActivity(intent);
            }
        });
        button24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(result1.this, markscard.class);
                startActivity(intent);
            }
        });
        button245.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(result1.this, markscard.class);
                startActivity(intent);
            }
        });
        button246.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(result1.this, markscard.class);
                startActivity(intent);
            }
        });
        button247.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(result1.this, markscard.class);
                startActivity(intent);
            }
        });
        button248.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(result1.this, markscard.class);
                startActivity(intent);
            }
        });
        buttone24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(result1.this, markscard.class);
                startActivity(intent);
            }
        });


    }
}
