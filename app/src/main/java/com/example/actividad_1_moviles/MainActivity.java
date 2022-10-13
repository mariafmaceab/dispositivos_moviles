package com.example.actividad_1_moviles;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText editTextUserName, editTextUserEdad, editTextIngresoVoto;
    public Button btnVotar;
    public Button btnValidarEdad;

    boolean flag = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextIngresoVoto = findViewById(R.id.editTextIngresoVoto);
        editTextUserEdad = findViewById(R.id.editTextUserEdad);
        editTextUserName = findViewById(R.id.editTextUserName);
        btnVotar = findViewById(R.id.btnVotar);
        btnValidarEdad = findViewById(R.id.btnValidarEdad);




    }

    @Override
    public void onClick(View view) {
        int edad = Integer.parseInt(editTextUserEdad.getText().toString());
            if (edad < 18) {
                editTextIngresoVoto.setEnabled(false);
                btnVotar.setEnabled(false);
                editTextUserName.setText("");
                editTextUserEdad.setText("");
                Toast.makeText(MainActivity.this, "Eres menor de edad, no puedes votar, ve con tus padres para que ellos voten", Toast.LENGTH_LONG).show();

                flag = false;
            }else{
                flag = true;
                btnVotar.setEnabled(true);
                editTextIngresoVoto.setEnabled(true);

            }

    }
    int contador =  0;
    public void onClickVote(View view){
        String userName = editTextUserName.getText().toString();
        int edad = Integer.parseInt(editTextUserEdad.getText().toString());
        int ingresoVoto = Integer.parseInt(editTextIngresoVoto.getText().toString());
        int candidatoUno = 0;
        int candidatoDos = 0;
        int candidatoTres = 0;


        if (userName != "" && edad != 0 && flag == true) {
            if (ingresoVoto == 1) {
                candidatoUno = candidatoUno + 1;
            } else if (ingresoVoto == 2) {
                candidatoDos = candidatoDos + 1;
            } else if (ingresoVoto == 3) {
                candidatoTres = candidatoTres + 1;
            }
            contador += 1;
            editTextIngresoVoto.setText("");
            editTextUserEdad.setText("");
            editTextUserName.setText("");
            }


        if (contador == 10) {
            Toast.makeText(MainActivity.this, "Votación completa, total votos: " + contador + "", Toast.LENGTH_LONG).show();
            btnVotar.setEnabled(false);
            btnValidarEdad.setEnabled(false);
            editTextIngresoVoto.setEnabled(false);
            editTextUserName.setEnabled(false);
            editTextUserEdad.setEnabled(false);
            if (candidatoUno > candidatoDos && candidatoUno > candidatoTres){
                Toast.makeText(MainActivity.this, "El candidato uno es el ganador", Toast.LENGTH_LONG).show();
            }else if(candidatoDos > candidatoUno && candidatoDos > candidatoTres){
                Toast.makeText(MainActivity.this, "El candidato dos es el ganador", Toast.LENGTH_LONG).show();
            }else if (candidatoTres > candidatoDos && candidatoTres > candidatoUno){
                Toast.makeText(MainActivity.this, "El candidato tres es el ganador", Toast.LENGTH_LONG).show();
            }

        }





    }
}