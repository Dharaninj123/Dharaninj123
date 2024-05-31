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

public class result3 extends AppCompatActivity {

    private Button button221, button222, button223, button224, button22, button225, button226, button227, button228, buttone22;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_result3);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize buttons
        button221 = findViewById(R.id.button221);
        button222 = findViewById(R.id.button222);
        button223 = findViewById(R.id.button223);
        button224 = findViewById(R.id.button224);
        button22 = findViewById(R.id.button22);
        button225 = findViewById(R.id.button225);
        button226 = findViewById(R.id.button226);
        button227 = findViewById(R.id.button227);
        button228 = findViewById(R.id.button228);
        buttone22 = findViewById(R.id.buttone22);

        button221.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(result3.this, markscard.class);
                startActivity(intent);
            }
        });

        button222.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(result3.this, markscard.class);
                startActivity(intent);
            }
        });
        button223.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(result3.this, markscard.class);
                startActivity(intent);
            }
        });
        button224.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(result3.this, markscard.class);
                startActivity(intent);
            }
        });
        button22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(result3.this, markscard.class);
                startActivity(intent);
            }
        });
        button225.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(result3.this, markscard.class);
                startActivity(intent);
            }
        });
        button226.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(result3.this, markscard.class);
                startActivity(intent);
            }
        });
        button227.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(result3.this, markscard.class);
                startActivity(intent);
            }
        });
        button228.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(result3.this, markscard.class);
                startActivity(intent);
            }
        });
        buttone22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(result3.this, markscard.class);
                startActivity(intent);
            }
        });


    }
}
