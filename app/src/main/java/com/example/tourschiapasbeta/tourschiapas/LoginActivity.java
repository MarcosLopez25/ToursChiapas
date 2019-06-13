package com.example.tourschiapasbeta.tourschiapas;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.w3c.dom.Text;

public class LoginActivity extends AppCompatActivity {

    ProgressDialog ventana;
    Spinner spinner1;
    EditText correo;
    EditText password;
    Button btnLogin;
    TextView olvidar;
    TextView registrar;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        firebaseAuth = FirebaseAuth.getInstance();
        correo = (EditText) findViewById(R.id.txtCorreo);
        password = (EditText) findViewById(R.id.txtContra);
        btnLogin = (Button) findViewById(R.id.btnInicio);
        olvidar = (TextView) findViewById(R.id.txForgot);
        registrar = (TextView) findViewById(R.id.txRegister);
        ventana = new ProgressDialog(this);
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        final NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

            btnLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    String email = correo.getText().toString();
                    String lock = password.getText().toString();


                    if(TextUtils.isEmpty(email)){
                        Toast.makeText(getApplicationContext(), "Ingrese su correo", Toast.LENGTH_LONG).show();
                    }
                    if(TextUtils.isEmpty(lock)){
                        Toast.makeText(getApplicationContext(), "Ingrese su contraseña", Toast.LENGTH_LONG).show();
                    }


                    if(networkInfo != null && networkInfo.isConnected()){
                        Toast.makeText(getApplicationContext(),"Conectado",Toast.LENGTH_SHORT).show();
                        ventana.setMessage("Iniciando Sesión...");
                        ventana.show();
                    }else{
                        Toast.makeText(getApplicationContext(),"Error de conexión",Toast.LENGTH_SHORT).show();
                    }

                    firebaseAuth.signInWithEmailAndPassword(email, lock)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {

                                    if(task.isSuccessful()){
                                        Intent menu = new Intent(LoginActivity.this, MainActivity.class);
                                        Toast.makeText(getApplicationContext(), "Usted ah iniciado sesión",Toast.LENGTH_LONG).show();
                                        startActivity(menu);
                                    }else{
                                        Intent login = new Intent(LoginActivity.this, LoginActivity.class);
                                        Toast.makeText(getApplicationContext(), "Su contraseña o su correo estan mal escritos", Toast.LENGTH_LONG).show();
                                        startActivity(login);
                                    }
                                    ventana.dismiss();
                                }
                            });
                    //Intent menu = new Intent(LoginActivity.this, MainActivity.class);
                    //startActivity(menu);

                }
            });
        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, RegistroActivity.class);
                startActivity(i);
            }
        });

        olvidar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent rest = new Intent(LoginActivity.this, RestablecerActivity.class);
                startActivity(rest);
            }
        });
    }
}
