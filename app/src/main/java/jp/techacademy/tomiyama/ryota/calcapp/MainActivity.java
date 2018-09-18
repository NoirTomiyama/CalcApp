package jp.techacademy.tomiyama.ryota.calcapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.math.BigDecimal;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    EditText editText;
    EditText editText2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        editText2 = findViewById(R.id.editText2);

        Button button = findViewById(R.id.button);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);

        button.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        Boolean isValid = true;

        if(editText.getText().toString().isEmpty()){
            editText.setError("数字を入力してください");
            isValid = false;
        }
        if(editText2.getText().toString().isEmpty()) {
            editText2.setError("数字を入力してください");
            isValid = false;
        }

        if(isValid){


            // editTextの値取得
            BigDecimal value1 = new BigDecimal(editText.getText().toString());
            BigDecimal value2 = new BigDecimal(editText2.getText().toString());

            BigDecimal result;
            Intent intent = null;

            switch (id){
                case R.id.button:

                    result = value1.add(value2);
                    intent = new Intent(this,ResultActivity.class);
                    intent.putExtra("VALUE",result);
                    startActivity(intent);
                    break;

                case R.id.button2:

                    result = value1.subtract(value2);
                    intent = new Intent(this,ResultActivity.class);
                    intent.putExtra("VALUE",result);
                    startActivity(intent);
                    break;

                case R.id.button3:

                    result = value1.multiply(value2);
                    intent = new Intent(this,ResultActivity.class);
                    intent.putExtra("VALUE",result);
                    startActivity(intent);
                    break;

                case R.id.button4:

                    result = value1.divide(value2,2, BigDecimal.ROUND_HALF_UP);
                    intent = new Intent(this,ResultActivity.class);
                    intent.putExtra("VALUE",result);
                    startActivity(intent);
                    break;

                default:
                    // なにもしない
            }
        }

    }

}
