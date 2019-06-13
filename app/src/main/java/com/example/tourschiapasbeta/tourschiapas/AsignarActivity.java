package com.example.tourschiapasbeta.tourschiapas;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.Serializable;
import java.util.ArrayList;

public class AsignarActivity extends AppCompatActivity implements Serializable {

int valor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asignar);
        
        final Cliente miClient = new Cliente();
        Button btnAsignar = findViewById(R.id.btnAsignar);
        final EditText edAsientos = findViewById(R.id.asientos);
        Button btnLista = findViewById(R.id.btnLista);

        final Button asiento1 = findViewById(R.id.btn1);
        final Button asiento2 = findViewById(R.id.btn2);
        final Button asiento3 = findViewById(R.id.btn3);
        final Button asiento4 = findViewById(R.id.btn4);
        final Button asiento5 = findViewById(R.id.btn5);
        final Button asiento6 = findViewById(R.id.btn6);
        final Button asiento7 = findViewById(R.id.btn7);
        final Button asiento8 = findViewById(R.id.btn8);
        final Button asiento9 = findViewById(R.id.btn9);
        final Button asiento10 = findViewById(R.id.btn10);
        final Button asiento11 = findViewById(R.id.btn11);
        final Button asiento12 = findViewById(R.id.btn12);
        final Button asiento13 = findViewById(R.id.btn13);
        final Button asiento14 = findViewById(R.id.btn14);
        final Button asiento15 = findViewById(R.id.btn15);
        final Button asiento16 = findViewById(R.id.btn16);
        final Button asiento17 = findViewById(R.id.btn17);
        final Button asiento18 = findViewById(R.id.btn18);
        final Button asiento19 = findViewById(R.id.btn19);
        final Button asiento20 = findViewById(R.id.btn20);





        btnAsignar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valor = Integer.parseInt(edAsientos.getText().toString());
                //miClient.setAsiento(valor);
                Toast.makeText(getApplicationContext(),"Asiento asignado",Toast.LENGTH_SHORT).show();

                    if(valor == 1){
                        asiento1.setVisibility(View.VISIBLE);
                        asiento1.setBackgroundColor(Color.parseColor("#F30707"));
                    }
                    if(valor == 2){
                        asiento2.setVisibility(View.VISIBLE);
                        asiento2.setBackgroundColor(Color.parseColor("#F30707"));
                    }
                    if(valor == 3){
                        asiento3.setVisibility(View.VISIBLE);
                        asiento3.setBackgroundColor(Color.parseColor("#F30707"));
                    }
                    if(valor == 4){
                        asiento4.setVisibility(View.VISIBLE);
                        asiento4.setBackgroundColor(Color.parseColor("#F30707"));
                    }
                    if(valor == 5){
                        asiento5.setVisibility(View.VISIBLE);
                        asiento5.setBackgroundColor(Color.parseColor("#F30707"));
                    }
            }
        });

        btnLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent lista = new Intent(AsignarActivity.this, ListaActivity.class);
                lista.putExtra("valores", valor);
                startActivity(lista);
                Log.i("VALORES", "valor:"+valor);

            }
        });
    }
}
