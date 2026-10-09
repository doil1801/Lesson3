package ru.mirea.dolgovis.favoritebook;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ShareActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);

        TextView tvBookName = findViewById(R.id.tvBookName);
        TextView tvQuote = findViewById(R.id.tvQuote);
        EditText etBookName = findViewById(R.id.etBookName);
        EditText etQuote = findViewById(R.id.etQuote);
        Button btnSendBack = findViewById(R.id.btnSendBack);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String bookName = extras.getString(MainActivity.BOOK_NAME_KEY);
            String quotesName = extras.getString(MainActivity.QUOTES_KEY);

            tvBookName.setText(bookName);
            tvQuote.setText(quotesName);
        }

        btnSendBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userBook = etBookName.getText().toString();
                String userQuote = etQuote.getText().toString();

                String text = "Название Вашей любимой книги: " + userBook +
                        "\nЦитата: " + userQuote;

                Intent data = new Intent();
                data.putExtra(MainActivity.USER_MESSAGE, text);

                setResult(Activity.RESULT_OK, data);
                finish();
            }
        });
    }
}