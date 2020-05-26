package com.jp.proyectocontacto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    MainActivity main = new MainActivity();
    Button editar;
    TextView nombreP,teleP,emailP,descP,fechaP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        final String nombre,telefono,email,descripcion,fecha;
        editar = findViewById(R.id.btnEditar);
        nombreP = findViewById(R.id.txtNombre2);
        teleP = findViewById(R.id.txtTelefono2);
        emailP = findViewById(R.id.txtCorreo2);
        descP = findViewById(R.id.txtDescripcion2);
        fechaP = findViewById(R.id.txtFechaNacimiento);

        Bundle bundle = getIntent().getExtras();
        nombre = bundle.getString("nombre");
        telefono = bundle.getString("telefono");
        email = bundle.getString("email");
        descripcion = bundle.getString("descripcion");
        fecha = bundle.getString("fecha");

        nombreP.setText("Nombre: "+nombre);
        teleP.setText("Teléfono: "+telefono);
        emailP.setText("Email: "+email);
        descP.setText("Descripción: "+descripcion);
        fechaP.setText("Fecha: "+fecha);

        editar.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View view)
                    {
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        intent.putExtra("nombre",nombre);
                        intent.putExtra("telefono",telefono);
                        intent.putExtra("email",email);
                        intent.putExtra("descripcion",descripcion);
                        intent.putExtra("fecha",fecha);

                        startActivity(intent);
                        finish();
                    }
                });
    }
}
