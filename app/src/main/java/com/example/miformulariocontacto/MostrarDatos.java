package com.example.miformulariocontacto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MostrarDatos extends AppCompatActivity {
    TextView tvnombre,tvtelefono,tvemail,tvdescripcion,tvfechanacimiento;
    Button btneditar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_datos);

        tvnombre=(TextView) findViewById(R.id.tvNombre);
        tvtelefono=(TextView)findViewById(R.id.tvTelefono);
        tvemail=(TextView)findViewById(R.id.tvEmail);
        tvdescripcion=(TextView) findViewById(R.id.tvDescripcion);
        tvfechanacimiento=(TextView)findViewById(R.id.tvFechaNacimiento);
        btneditar=(Button)findViewById(R.id.btnEditar) ;
        btneditar.setOnClickListener(new View.OnClickListener() {
                                                 @Override
                                                 public void onClick(View v) {

                                                     String name=tvnombre.getText().toString();
                                                     String tele=tvtelefono.getText().toString();
                                                     String email=tvemail.getText().toString();
                                                     String descrip=tvdescripcion.getText().toString();
                                                     String naci=tvfechanacimiento.getText().toString();

                                                     Intent intent=new Intent(MostrarDatos.this,MainActivity.class);

                                                     intent.putExtra("name1", name);
                                                     intent.putExtra("telefon",tele);
                                                     intent.putExtra("email",email);
                                                     intent.putExtra("descript",descrip);
                                                     intent.putExtra("fechana", naci);

                                                     startActivity(intent);

                                                 }
                                             });
        
        mostrarDatos();
    }

    private void mostrarDatos() {

        Bundle datos=this.getIntent().getExtras();
        String nombre=datos.getString("name");
        String telefono=datos.getString("tele");
        String email=datos.getString("correo");
        String descripcion=datos.getString("descrip");
        String eFecha=datos.getString("naci");

        tvnombre.setText(nombre);
        tvtelefono.setText(telefono);
        tvemail.setText(email);
        tvdescripcion.setText(descripcion);
        tvfechanacimiento.setText(eFecha);
    }
}