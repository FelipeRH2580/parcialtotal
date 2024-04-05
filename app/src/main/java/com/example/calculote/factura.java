package com.example.calculote;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.Serializable;

public class factura extends AppCompatActivity {

    TextView TOTALVALOR, IVA;
    Button backButton;
    private View normalResultTextView, normalResultTextView1, normalResultTextView2, normalResultTextView3;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        normalResultTextView = findViewById(R.id.textView14);
        normalResultTextView1 = findViewById(R.id.textView18);
        normalResultTextView2 = findViewById(R.id.textView17);
        normalResultTextView3 = findViewById(R.id.textView19);
        backButton = findViewById(R.id.backButton);

        Serializable serializable = getIntent().getSerializableExtra("serialized_data");
        if (serializable != null && serializable instanceof MainActivity2) {
            ResultData resultData = (ResultData) serializable;

            double result = resultData.getResult();
            String operation = resultData.getOperationType();

            normalResultTextView.setTextDirection((int) result);


            backButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }
    }
}

