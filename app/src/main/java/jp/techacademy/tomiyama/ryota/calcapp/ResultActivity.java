package jp.techacademy.tomiyama.ryota.calcapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.math.BigDecimal;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView resultText = findViewById(R.id.resultText);

        Intent intent = getIntent();
        BigDecimal resultNumber = (BigDecimal) intent.getSerializableExtra("VALUE");

        resultText.setText(String.valueOf(resultNumber));

    }
}
