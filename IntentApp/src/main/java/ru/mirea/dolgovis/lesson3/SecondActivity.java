package ru.mirea.dolgovis.lesson3;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView tvResult = findViewById(R.id.tvResult);

        int square = getIntent().getIntExtra("SQUARE", 0);
        String time = getIntent().getStringExtra("TIME");

        String result = "КВАДРАТ ЗНАЧЕНИЯ МОЕГО НОМЕРА ПО СПИСКУ В ГРУППЕ СОСТАВЛЯЕТ ЧИСЛО "
                + square + ", а текущее время " + time;

        tvResult.setText(result);
    }
}