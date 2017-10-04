package com.example.horus.proyectosismors;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.Connection;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;


public class Registro extends AppCompatActivity implements Statement {
    Statement pst = null;
    EditText edtNombres, edtCorreo;
    Button btnAgregar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        edtNombres = (EditText) findViewById(R.id.edtNombre);
        edtCorreo = (EditText) findViewById(R.id.edtCorreo);
        btnAgregar = (Button) findViewById(R.id.btnAgregar);

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Conectar conectar = new Conectar();
                conectar.execute();
            }
        });
    }

    private class Conectar extends AsyncTask<Void, Integer, Boolean> {
        @Override
        protected Boolean doInBackground(Void... params) {
            try {
                String url = "jdbc:jtds:sqlserver://192.168.0.10;databaseName=TEST_CONECCION;user=sa;password=1234;";
                Log.i("url", url);
                Class.forName( "net.sourceforge.jtds.jdbc.Driver").newInstance();
                Connection conn = (Connection) DriverManager.getConnection(url);
                Toast.makeText(getBaseContext(), "Conectado", Toast.LENGTH_SHORT).show();
                Log.d("LOG:", "conectado");
                if (conn == null)
                {
                    return false;
                }
            } catch (NoClassDefFoundError e){
                Log.e("Definicion de clase",e.getMessage());
            } catch (ClassNotFoundException e) {
                Log.e("Clase no encontrada",e.getMessage());
            } catch (Exception e) {
                Log.e("ERROR Conexion:",e.getMessage());
                return false;
            }
            return true;
        }

        @Override
        protected void onPostExecute(Boolean resultado) {
            if(resultado) {
                Toast.makeText(getBaseContext(), "Conectado", Toast.LENGTH_SHORT).show();
                Log.d("LOG:", "conectado");
            }else {
                Toast.makeText(getBaseContext(), "No conectado", Toast.LENGTH_SHORT).show();
                Log.d("LOG:", "no conectado");
            }
        }
    }
/*
    public Connection conexionBD() {
        Connection conexion = null;
        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
            //conexion = android.telecom.Connection.("jdbc:jtds:sqlserver://192.168.0.10;databaseName=TEST_CONECCION;user=sa;password=1234;");
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return conexion;
    }
*/

    public void Agregarusuario() {
        try {
            Conectar conectar = new Conectar();
            conectar.execute();
            PreparedStatement pst = getConnection().prepareStatement("insert into usuario values (?,?)");
            pst.setString(1, edtNombres.getText().toString());
            pst.setString(2, edtCorreo.getText().toString());
            pst.executeUpdate();
            Toast.makeText(getApplicationContext(), "REGISTRO INSERTADO CON EXITO", Toast.LENGTH_SHORT).show();
        } catch (SQLException e) {
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    /*
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Registro Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }
    */
/*
    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();

    }
   */
}
