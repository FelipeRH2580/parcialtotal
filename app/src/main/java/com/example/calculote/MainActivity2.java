package com.example.calculote;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import java.io.Serializable;
public class MainActivity2 extends AppCompatActivity implements Serializable {

    EditText operand1EditText, operand2EditText, operand3EditText, operand4EditText,  numberEditText;
    double operand1, operand2, operand3, operand4, total, total_todo;
    String operation;
    private double result;


    public void performOperation(View view) {



        operand1 = 2000;
        operand2 = 1800;
        operand3 = 900;
        operand4 = 2500;

        // Determinar la operación según el botón presionado
        if (view.getId() == R.id.COMPRAR5) {
            total= total+operand1;
        } else if (view.getId() == R.id.COMPRAR4) {
            total= total+operand2;
        } else if (view.getId() == R.id.COMPRAR5) {
            total= total+operand3;
        } else if (view.getId() == R.id.COMPRAR6) {
            total= total+operand4;
        }

        total_todo=total;



        // Crear un objeto ResultData y pasarlo mediante Intent serializado
        ResultData resultData = new ResultData(total_todo, operation);
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("serialized_data", resultData);
        startActivity(intent);

        // Crear un Bundle para pasar datos a la actividad de resultados
        Bundle bundle = new Bundle();
        bundle.putDouble("result", result);
        bundle.putString("operation", operation);
        // Agregar el Bundle al Intent
        intent.putExtras(bundle);
        // Iniciar la actividad de resultados
        startActivity(intent);


    }

}
