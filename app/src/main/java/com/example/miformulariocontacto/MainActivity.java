package com.example.miformulariocontacto;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText nombre,telefono,email,descripcion,eFecha;
    Button siguiente;
    Button bFecha;

    private int dia,mes,ano;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bFecha=(Button)findViewById(R.id.botonFecha);
        eFecha=(EditText)findViewById(R.id.editTextTextPersonName);
        nombre=(EditText)findViewById(R.id.etNombre);
        telefono=(EditText)findViewById(R.id.etTelefono);
        email=(EditText)findViewById(R.id.etEmail);
        descripcion=(EditText)findViewById(R.id.etDescripcion);
        siguiente=(Button)findViewById(R.id.btnSiguiente);
        bFecha.setOnClickListener(this::onClick);

        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=nombre.getText().toString();
                String tele=telefono.getText().toString();
                String correo=email.getText().toString();
                String descrip=descripcion.getText().toString();
                String naci=eFecha.getText().toString();

                Intent i=new Intent(MainActivity.this,MostrarDatos.class);

                i.putExtra("name",name);
                i.putExtra("tele",tele);
                i.putExtra("correo",correo);
                i.putExtra("descrip",descrip);
                i.putExtra("naci",naci);

                startActivity(i);

            }
        });

        mostrarDatosMainActivity();


    }




    @RequiresApi(api = Build.VERSION_CODES.N)
    public void onClick (View v){

        if(v==bFecha){

            final Calendar c=Calendar.getInstance();
            dia=c.get(Calendar.DAY_OF_MONTH);
            mes= c.get(Calendar.MONTH);
            ano= c.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog=new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                            eFecha.setText(dayOfMonth+"/"+(month+1)+"/"+(year)+"/");

                        }
                    }
                    ,dia,mes,ano);
            datePickerDialog.show();


        }
    }



    private void startActivities(Intent i){

    }
private void mostrarDatosMainActivity(){

Bundle dato=this.getIntent().getExtras();
if (dato!= null){

String nombreRetorno=dato.getString("name1");
String numeroTelefono=dato.getString("telefon");
String email1=dato.getString("email");
String descrip=dato.getString("descript");
String verfecha =dato.getString("fechana");

nombre.setText(nombreRetorno);
telefono.setText(numeroTelefono);
email.setText(email1);
descripcion.setText(descrip);
eFecha.setText(verfecha);


}
}
private void starActivities(Intent i){

}
}