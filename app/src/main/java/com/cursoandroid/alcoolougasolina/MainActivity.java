package com.cursoandroid.alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText editPrecoAlcool, editPrecoGasolina;
    private TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editPrecoAlcool = findViewById(R.id.editPrecoAlcool);
        editPrecoGasolina = findViewById(R.id.editPrecoGasolina);
        textResultado = findViewById(R.id.textResultado);

    }

    public void calcularPreco (View view){

        //RECUPERAR VALORES

        String precoAlcool = editPrecoAlcool.getText().toString();
        String precoGasolina = editPrecoGasolina.getText().toString();

        //Validar os campos digitados
        boolean valdarCampos = valdarCampos(precoAlcool, precoGasolina);
        if (valdarCampos) {
            //CONVERTER STRING PARA NUMEROS
            Double valorAlcool = Double.parseDouble(precoAlcool);
            Double valorGasolina = Double.parseDouble(precoGasolina);

            //CALCULO
            Double resultado = valorAlcool / valorGasolina;
            if (resultado >= 0.7) {
                textResultado.setText("Melhor utilizar Gasolina");
            }else {
                textResultado.setText("Melhor utilizar Álcool");
            }

        }else{

            textResultado.setText("Preecha os preços primeiro!");
        }


    }

    public boolean valdarCampos (String pAlcool, String pGasolina){

        boolean camposValidados = true;

        if (pAlcool == null || pAlcool.equals("")){
            camposValidados = false;

        }else if (pGasolina == null || pGasolina.equals(""))
        {
            camposValidados = false;
        }
        return camposValidados;

    }

}
