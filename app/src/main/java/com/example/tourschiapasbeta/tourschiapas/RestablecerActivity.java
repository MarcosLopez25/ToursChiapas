package com.example.tourschiapasbeta.tourschiapas;

import android.content.Intent;
import android.nfc.Tag;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class RestablecerActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restablecer);

        final EditText txtCorreo = (EditText) findViewById(R.id.txtRestablecer);
        Button btnReenviar = (Button) findViewById(R.id.btnEnviar);

        btnReenviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String correo = txtCorreo.getText().toString();
                firebaseAuth.setLanguageCode("es");
                if (TextUtils.isEmpty(correo)){
                    Toast.makeText(getApplicationContext(), "Ingrese su correo", Toast.LENGTH_LONG).show();
                }
                firebaseAuth.sendPasswordResetEmail(correo)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if(task.isSuccessful()){
                                    Toast.makeText(getApplicationContext(), "Su contraseña se ha enviado a su correo", Toast.LENGTH_LONG).show();
                                }
                                else{
                                    Toast.makeText(getApplicationContext(), "No hemos podido enviar su contraseña", Toast.LENGTH_LONG).show();
                                }
                            }
                        });
                Intent forgot = new Intent(RestablecerActivity.this, LoginActivity.class);
                startActivity(forgot);
            }
        });
    }
}
