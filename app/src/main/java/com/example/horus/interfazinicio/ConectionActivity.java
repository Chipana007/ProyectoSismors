package com.example.horus.interfazinicio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import org.xmlpull.v1.XmlPullParserException;
import java.io.IOException;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;


public class ConectionActivity extends AppCompatActivity implements View.OnClickListener{

    Button suma;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conection);
        suma = (Button) findViewById(R.id.suma);
        suma.setOnClickListener(this);
    }

    public void onClick(View view){
        switch(view.getId()){
            case R.id.suma:
                EnviarOnclickSuma(view);
                break;
            case R.id.enviarcodigo:
                //EnviarOnclickCodigo(view);
                break;
            case R.id.salir:
                Toast.makeText(getApplicationContext(), "Gracias por usar la aplicacion", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }

    public void EnviarOnclickSuma(View view){

        Thread nt = new Thread(){
            String res;
            final EditText et_numero1=(EditText) findViewById(R.id.campo_texto);
            EditText et_numero2=(EditText) findViewById(R.id.campo_texto2);

            public void run() {
                String NAMESPACE="http://demo.android.org/";
                String URL="http://192.168.0.10/WSProductos/Productos.asmx";
                String METHOD_NAME="suma";
                String SOAP_ACTION="http://demo.android.org/suma";

                SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
                request.addProperty("numero1",Integer.parseInt(et_numero1.getText().toString()));
                request.addProperty("numero2",Integer.parseInt(et_numero2.getText().toString()));

                SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
                envelope.dotNet=true;
                envelope.setOutputSoapObject(request);

                HttpTransportSE transporte = new HttpTransportSE(URL);
                try {
                    transporte.call(SOAP_ACTION, envelope);
                    SoapPrimitive resultado_xml = (SoapPrimitive) envelope.getResponse();
                    res = resultado_xml.toString();

                } catch (IOException e) {
                    e.printStackTrace();
                } catch (XmlPullParserException e) {
                    e.printStackTrace();
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(ConectionActivity.this, res, Toast.LENGTH_LONG).show();
                        TextView resul = (TextView)findViewById(R.id.resultado);
                        resul.setText(res);
                    }
                });
            }
        };
        nt.start();
    }
}
