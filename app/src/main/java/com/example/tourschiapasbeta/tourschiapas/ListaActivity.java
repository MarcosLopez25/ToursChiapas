package com.example.tourschiapasbeta.tourschiapas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListaActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        ListView listaNueva = findViewById(R.id.listaNew);


        ArrayList<Cliente> clientesnuevos = new ArrayList<Cliente>();

        final int valorAsiento = getIntent().getIntExtra("valores", 0);

        ArrayAdapter<Cliente> arrayAdapter = new ArrayAdapter<Cliente>(ListaActivity.this, R.layout.activity_listview2, R.id.textView2, clientesnuevos);

        Cliente cliente1 = new Cliente();
        Cliente cliente2 = new Cliente();
        Cliente cliente3 = new Cliente();
        Cliente cliente4 = new Cliente();
        Cliente cliente5 = new Cliente();

        cliente1.setNombre("Jose");
        cliente1.setApellidos("Guzmán Gómez");
        cliente1.setCorreo("joseGG@gmail.com");
        cliente1.setHotel("Hilton Garden Inn");
        cliente1.setAsiento(0);
        clientesnuevos.add(cliente1);

        cliente2.setNombre("Lesly");
        cliente2.setApellidos("Gutierrez Ochoa");
        cliente2.setCorreo("lesly83@gmail.com");
        cliente2.setHotel("Marriot");
        cliente2.setAsiento(0);
        clientesnuevos.add(cliente2);

        cliente3.setNombre("Guadalupe");
        cliente3.setApellidos("Guzmán López");
        cliente3.setCorreo("ggl@gmail.com");
        cliente3.setHotel("Holiday Inn");
        cliente3.setAsiento(0);
        clientesnuevos.add(cliente3);

        cliente4.setNombre("Jorge");
        cliente4.setApellidos("Esponda Luna");
        cliente4.setCorreo("EspondaLuna@gmail.com");
        cliente4.setHotel("Palapa Palace Inn");
        cliente4.setAsiento(0);
        clientesnuevos.add(cliente4);

        cliente5.setNombre("Adrian");
        cliente5.setApellidos("Morales Pérez");
        cliente5.setCorreo("adrian98@gmail.com");
        cliente5.setHotel("City Express");
        cliente5.setAsiento(0);
        clientesnuevos.add(cliente5);

        cliente2.setAsiento(valorAsiento);
        clientesnuevos.add(cliente2);
        clientesnuevos.remove(1);

            /*if(clientesnuevos.get(0).getAsiento()<=0){
                //for(int i=0; i<clientesnuevos.size();i++){
                    cliente1.setAsiento(valorAsiento);
                    //arrayAdapter.notifyDataSetChanged();
                //}
                //clientesnuevos.add(cliente1);
                Toast.makeText(getApplicationContext(),"Se agrego correctamente",Toast.LENGTH_SHORT).show();
                /*if(cliente1.getAsiento()==cliente2.getAsiento()){
                    cliente2.setAsiento(1);
                }

            }
            if (clientesnuevos.get(1).getAsiento() == clientesnuevos.get(0).getAsiento()){
                cliente2.setAsiento(valor1);
            }

                /*if(clientesnuevos.get(1).getAsiento()==1){
                cliente2.setAsiento(valorAsiento);
                clientesnuevos.add(1,cliente2);
                Toast.makeText(getApplicationContext(),"Se agrego correctamente",Toast.LENGTH_SHORT).show();
            }if(clientesnuevos.get(2).getAsiento()==2){
                cliente3.setAsiento(valorAsiento);
                clientesnuevos.add(2,cliente3);
                Toast.makeText(getApplicationContext(),"Se agrego correctamente",Toast.LENGTH_SHORT).show();
            }if(clientesnuevos.get(3).getAsiento()==3){
                cliente4.setAsiento(valorAsiento);
                clientesnuevos.add(3,cliente4);
                Toast.makeText(getApplicationContext(),"Se agrego correctamente",Toast.LENGTH_SHORT).show();
            }if(clientesnuevos.get(4).getAsiento()==4){
                cliente5.setAsiento(valorAsiento);
                clientesnuevos.add(4,cliente5);
                Toast.makeText(getApplicationContext(),"Se agrego correctamente",Toast.LENGTH_SHORT).show();
            }*/



        //Log.i("PRUEBA","valor:"+valorAsiento);



        arrayAdapter.toString();

        listaNueva.setAdapter(arrayAdapter);

        arrayAdapter.notifyDataSetChanged();


    }
}
