package com.example.tourschiapasbeta.tourschiapas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class LugaresActivity extends AppCompatActivity {
    int valor=0;
    int asignado=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lugares);

        Button btnAgregar = (Button) findViewById(R.id.btnAdd);
        final Button btnAsiento1 = (Button) findViewById(R.id.asiento1);
        final Button btnAsiento2 = (Button) findViewById(R.id.asiento2);
        final Button btnAsiento3 = (Button) findViewById(R.id.asiento3);
        final Button btnAsiento4 = (Button) findViewById(R.id.asiento4);
        final Button btnAsiento5 = (Button) findViewById(R.id.asiento5);
        final Button btnAsiento6 = (Button) findViewById(R.id.asiento6);
        final Button btnAsiento7 = (Button) findViewById(R.id.asiento7);
        final Button btnAsiento8 = (Button) findViewById(R.id.asiento8);
        final Button btnAsiento9 = (Button) findViewById(R.id.asiento9);
        final Button btnAsiento10 = (Button) findViewById(R.id.asiento10);
        Button btnAsiento11 = (Button) findViewById(R.id.asiento11);
        Button btnAsiento12 = (Button) findViewById(R.id.asiento12);
        Button btnAsiento13 = (Button) findViewById(R.id.asiento13);
        Button btnAsiento14 = (Button) findViewById(R.id.asiento14);
        Button btnAsiento15 = (Button) findViewById(R.id.asiento15);
        Button btnAsiento16 = (Button) findViewById(R.id.asiento16);

        btnAsiento1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                asignado = 0;
                Toast.makeText(getApplicationContext(), "Asiento vacio", Toast.LENGTH_SHORT).show();
            }
        });

        btnAsiento2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                asignado = 0;
                Toast.makeText(getApplicationContext(), "Asiento vacio", Toast.LENGTH_SHORT).show();
            }
        });

        btnAsiento3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                asignado = 0;
                Toast.makeText(getApplicationContext(), "Asiento vacio", Toast.LENGTH_SHORT).show();
            }
        });

        btnAsiento4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                asignado = 0;
                Toast.makeText(getApplicationContext(), "Asiento vacio", Toast.LENGTH_SHORT).show();
            }
        });

        btnAsiento5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                asignado = 0;
                Toast.makeText(getApplicationContext(), "Asiento vacio", Toast.LENGTH_SHORT).show();
            }
        });

        btnAsiento6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                asignado = 0;
                Toast.makeText(getApplicationContext(), "Asiento vacio", Toast.LENGTH_SHORT).show();
            }
        });

        btnAsiento7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                asignado = 0;
                Toast.makeText(getApplicationContext(), "Asiento vacio", Toast.LENGTH_SHORT).show();
            }
        });

        btnAsiento8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                asignado = 0;
                Toast.makeText(getApplicationContext(), "Asiento vacio", Toast.LENGTH_SHORT).show();
            }
        });

        btnAsiento9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                asignado = 0;
                Toast.makeText(getApplicationContext(), "Asiento vacio", Toast.LENGTH_SHORT).show();
            }
        });

        btnAsiento10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                asignado = 0;
                Toast.makeText(getApplicationContext(), "Asiento vacio", Toast.LENGTH_SHORT).show();
            }
        });

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (valor == 0){
                    btnAsiento1.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View v) {
                            asignado = 1;
                            Toast.makeText(getApplicationContext(), "Asiento ocupado", Toast.LENGTH_SHORT).show();
                        }
                    });

                }else{
                    asignado = 1;
                    if(asignado == 1){
                        btnAsiento1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(getApplicationContext(), "Asiento vacio", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                }
            }
        });
    }
}
