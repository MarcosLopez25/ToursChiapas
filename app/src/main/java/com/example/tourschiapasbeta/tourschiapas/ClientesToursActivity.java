package com.example.tourschiapasbeta.tourschiapas;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ClientesToursActivity extends AppCompatActivity {


    Cliente cliente;
    //DatabaseReference bdCliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientes_tours);

        final Cliente cliente1,cliente2,cliente3,cliente4,cliente5;
        final ArrayList<Cliente> clientes;
        final ListView listClientes;


        /*bdCliente = FirebaseDatabase.getInstance("https://clientes-91dbc.firebaseio.com").getReference();

        bdCliente.child("Turista").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for(DataSnapshot snapshot : dataSnapshot.getChildren()){

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });*/

       listClientes = (ListView) findViewById(R.id.clientes);

       cliente1 = new Cliente();
       cliente2= new Cliente();
       cliente3 = new Cliente();
       cliente4 = new Cliente();
       cliente5 = new Cliente();
       clientes = new ArrayList<Cliente>();

       cliente1.setNombre("Jose");
       cliente1.setApellidos("Guzmán Gómez");
       cliente1.setCorreo("joseGG@gmail.com");
       cliente1.setHotel("Hilton Garden Inn");
       cliente1.setAsiento(0);
       clientes.add(cliente1);

       cliente2.setNombre("Lesly");
       cliente2.setApellidos("Gutierrez Ochoa");
       cliente2.setCorreo("lesly83@gmail.com");
       cliente2.setHotel("Marriot");
        cliente2.setAsiento(0);
       clientes.add(cliente2);

       cliente3.setNombre("Guadalupe");
       cliente3.setApellidos("Guzmán López");
       cliente3.setCorreo("ggl@gmail.com");
       cliente3.setHotel("Holiday Inn");
       cliente3.setAsiento(0);
       clientes.add(cliente3);

       cliente4.setNombre("Jorge");
       cliente4.setApellidos("Esponda Luna");
       cliente4.setCorreo("EspondaLuna@gmail.com");
       cliente4.setHotel("Palapa Palace Inn");
       cliente4.setAsiento(0);
       clientes.add(cliente4);

       cliente5.setNombre("Adrian");
       cliente5.setApellidos("Morales Pérez");
       cliente5.setCorreo("adrian98@gmail.com");
       cliente5.setHotel("City Express");
       cliente5.setAsiento(0);
       clientes.add(cliente5);

       ArrayAdapter<Cliente> arrayAdapter = new ArrayAdapter<>(ClientesToursActivity.this, R.layout.activity_listview, R.id.textView, clientes);

       arrayAdapter.toString();

       listClientes.setAdapter(arrayAdapter);

        arrayAdapter.notifyDataSetChanged();

       listClientes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

               Intent nuevo = new Intent(ClientesToursActivity.this, AsignarActivity.class);
               nuevo.putExtra("clientes",clientes);
               startActivity(nuevo);
           }
       });
    }

}
