package com.jp.proyectocontacto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button siguiente;
    EditText nombre,telefono,correo,descripcion;
    DatePicker fecha;
    String nombreEdit,telefonoEdit,emailEdit,descripcionEdit,fechaEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        siguiente = findViewById(R.id.btnSiguiente);
        nombre = findViewById(R.id.txtNombre);
        telefono = findViewById(R.id.txtTelefono);
        correo = findViewById(R.id.txtCorreo);
        descripcion = findViewById(R.id.txtDescripcion);
        fecha = findViewById(R.id.datePicker);

        Bundle bundle = getIntent().getExtras();
        if (bundle!=null){
            nombreEdit = bundle.getString("nombre");
            telefonoEdit = bundle.getString("telefono");
            emailEdit = bundle.getString("email");
            descripcionEdit = bundle.getString("descripcion");
            fechaEdit = bundle.getString("fecha");

            nombre.setText(nombreEdit);
            telefono.setText(telefonoEdit);
            correo.setText(emailEdit);
            descripcion.setText(descripcionEdit);

        }


        siguiente.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View view)
                    {
                        Intent intent = new Intent(getApplicationContext(), Activity2.class);
                        intent.putExtra("nombre",nombre.getText().toString());
                        intent.putExtra("telefono",telefono.getText().toString());
                        intent.putExtra("email",correo.getText().toString());
                        intent.putExtra("descripcion",descripcion.getText().toString());
                        intent.putExtra("fecha", (fecha.getDayOfMonth()+"/"+fecha.getMonth()+"/"+fecha.getYear()));
                        startActivity(intent);
                    }
                });
    }
}
