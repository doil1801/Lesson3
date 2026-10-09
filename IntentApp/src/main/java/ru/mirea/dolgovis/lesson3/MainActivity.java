package ru.mirea.dolgovis.lesson3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnOpenSecond = findViewById(R.id.btnOpenSecond);

        btnOpenSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long dateInMillis = System.currentTimeMillis();
                String format = "yyyy-MM-dd HH:mm:ss";
                final SimpleDateFormat sdf = new SimpleDateFormat(format);
                String dateString = sdf.format(new Date(dateInMillis));

                int myNumber = 10;
                int square = myNumber * myNumber;

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("SQUARE", square);
                intent.putExtra("TIME", dateString);
                startActivity(intent);
            }
        });
    }
}