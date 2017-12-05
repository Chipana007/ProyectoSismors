package com.example.horus.interfazinicio;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.google.zxing.Result;
import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener, ZXingScannerView.ResultHandler{
    private ZXingScannerView escanerView;
    Button scaner;
    Button tutorial;
    Button salir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        scaner = (Button) findViewById(R.id.scaner);
        scaner.setOnClickListener(this);
        tutorial = (Button) findViewById(R.id.tutorial);
        tutorial.setOnClickListener(this);
        salir = (Button) findViewById(R.id.salir);
        salir.setOnClickListener(this);
    }
    public void onClick(View view){
        switch(view.getId()){
            case R.id.scaner:
                EscanerQR(view);
                break;
            case R.id.tutorial:
                Toast.makeText(getApplicationContext(), "Video de muestra", Toast.LENGTH_SHORT).show();
            case R.id.salir:
                Toast.makeText(getApplicationContext(), "Gracias por usar la aplicacion", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
    @Override
    protected void onPause() {
        super.onPause();
        escanerView.stopCamera();
    }

    public void alert(String msg){
        Toast.makeText(MenuActivity.this,msg,Toast.LENGTH_SHORT).show();
    }

    public void lanzar(View view){
        Intent intent = new Intent(MenuActivity.this, ProductoActivity.class);
        startActivity(intent);
        MenuActivity.this.finish();
    }

    public void EscanerQR(View view){
        escanerView = new ZXingScannerView(this);
        setContentView(escanerView);
        escanerView.setResultHandler(this);
        escanerView.startCamera();
    }
    @Override
    public void handleResult(Result result) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Resultados del escaner");
        builder.setMessage("Resultado "+result.getText()+"\n"+"formato "+result.getBarcodeFormat());
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
        escanerView.resumeCameraPreview(this);
        Intent intent = new Intent(this, ProductoActivity.class);
        //Bundle bun = new Bundle();
        //bun.putInt("id", 10);
        //bun.putString("nombre", "Jorge");
        //bun.putInt("edad", 20);
        //intent.putExtra("bundle", bun);
        intent.putExtra("id",result.getText());
        startActivity(intent);
    }
}
