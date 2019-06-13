package com.example.tourschiapasbeta.tourschiapas;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.regex.Pattern;


public class RegistroActivity extends AppCompatActivity {

    EditText txtName, txtLastName, txtPassword, txtEmail, txtId;
    Button btnRegistrar;
    CheckBox cbTerminos;
    ProgressDialog progreso;
    private DatabaseReference databaseReference;
    private FirebaseAuth firebaseAuth;
    final public static String REGEX_TEXTO =  "^[a-zA-ZáÁéÉíÍóÓúÚñÑüÜ\\s]+$";
    final public static String REGEX_CLAVE = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*(_|[^\\w])).+$";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        txtName = (EditText) findViewById(R.id.txtNombre);
        txtLastName = (EditText) findViewById(R.id.txtApellido);
        txtPassword = (EditText) findViewById(R.id.txtPassword);
        txtEmail = (EditText) findViewById(R.id.txtEmail);
        txtId = (EditText) findViewById(R.id.txtId_Empresa);
        btnRegistrar = (Button) findViewById(R.id.btnRegistrar);
        cbTerminos = (CheckBox) findViewById(R.id.checkBox);
        databaseReference = FirebaseDatabase.getInstance().getReference();
        progreso = new ProgressDialog(this);
        firebaseAuth = FirebaseAuth.getInstance();



        if(cbTerminos.isChecked()==false){
            btnRegistrar.setEnabled(false);
        }

        cbTerminos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cbTerminos.isChecked()){
                    btnRegistrar.setEnabled(true);

                    btnRegistrar.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String name = txtName.getText().toString().trim();
                            String apellido = txtLastName.getText().toString();
                            String email = txtEmail.getText().toString();
                            String password = txtPassword.getText().toString().trim();
                            String ID = txtId.getText().toString();

                            Pattern patron = Pattern.compile(REGEX_TEXTO);
                            Pattern claves = Pattern.compile(REGEX_CLAVE);

                            if(TextUtils.isEmpty(name) || TextUtils.isEmpty(email) || TextUtils.isEmpty(password) ) {
                                Toast.makeText(getApplicationContext(), "Ingrese los datos correspondientes", Toast.LENGTH_SHORT).show();
                                return;
                            }

                            if (patron.matcher(name).matches() && patron.matcher(apellido).matches()){
                                Toast.makeText(getApplicationContext(), "Campo correcto", Toast.LENGTH_SHORT).show();
                            }else{
                                Toast.makeText(getApplicationContext(),"Solo se permiten letras",Toast.LENGTH_SHORT).show();
                                return;
                            }

                            if (claves.matcher(password).matches()){
                                Toast.makeText(getApplicationContext(), "Contraseña segura", Toast.LENGTH_SHORT).show();
                            } else{
                                Toast.makeText(getApplicationContext(), "Contraseña muy corta o insegura", Toast.LENGTH_SHORT).show();
                                return;
                            }


                            String idUsers = databaseReference.push().getKey();

                            Socios socio = new Socios(name, apellido, email, Integer.valueOf(ID));

                            databaseReference.child("Socio").child(idUsers).setValue(socio);

                            progreso.setMessage("Registrando socio en línea...");
                            progreso.show();

                            firebaseAuth.createUserWithEmailAndPassword(email, password)
                                    .addOnCompleteListener(RegistroActivity.this, new OnCompleteListener<AuthResult>() {
                                        @Override
                                        public void onComplete(@NonNull Task<AuthResult> task) {
                                            if(task.isSuccessful()){
                                                Toast.makeText(getApplicationContext(), "Se ha registrado el usuario",Toast.LENGTH_LONG).show();
                                            }else{
                                                Toast.makeText(getApplicationContext(), "No se pudo registrar el usuario", Toast.LENGTH_LONG).show();
                                            }
                                            progreso.dismiss();
                                        }
                                    });
                            Intent ventana = new Intent(RegistroActivity.this, LoginActivity.class);
                            startActivity(ventana);
                        }
                    });
                }
            }
        });

    }
}
