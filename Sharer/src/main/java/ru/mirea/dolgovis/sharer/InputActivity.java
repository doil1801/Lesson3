package ru.mirea.dolgovis.sharer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class InputActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        EditText etInput = findViewById(R.id.etInput);
        Button btnSendBack = findViewById(R.id.btnSendBack);

        btnSendBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent data = new Intent();
                data.putExtra("RETURNED_DATA", etInput.getText().toString());
                setResult(Activity.RESULT_OK, data);
                finish();
            }
        });
    }
}