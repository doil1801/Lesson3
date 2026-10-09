package ru.mirea.dolgovis.sharer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private ActivityResultLauncher<Intent> activityResultLauncher;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResult = findViewById(R.id.tvResult);

        ActivityResultCallback<ActivityResult> callback =
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == Activity.RESULT_OK) {
                            Intent data = result.getData();
                            if (data != null) {
                                String returnedText = data.getStringExtra("RETURNED_DATA");
                                tvResult.setText("Получено: " + returnedText);
                            }
                        }
                    }
                };

        activityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(), callback);

        Button btnOpenInput = findViewById(R.id.btnOpenInput);
        btnOpenInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, InputActivity.class);
                activityResultLauncher.launch(intent);
            }
        });
    }
}