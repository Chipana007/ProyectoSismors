package com.example.horus.interfazinicio;

import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

public class ProductoActivity extends AppCompatActivity {
    private ImageView fotoImageView;
    private ImageView prodRecomendado1;
    private ImageView prodRecomendado2;
    private ImageView prodRecomendado3;
    private ImageView prodRecomendado4;
    TextView producto;
    TextView descripcion_principal;
    TextView precio_ahora;
    TextView nombreprod_rec1;
    TextView precioprod_rec1;
    TextView descripcionprod_rec1;
    TextView nombreprod_rec2;
    TextView precioprod_rec2;
    TextView descripcionprod_rec2;
    TextView nombreprod_rec3;
    TextView precioprod_rec3;
    TextView descripcionprod_rec3;
    TextView nombreprod_rec4;
    TextView precioprod_rec4;
    TextView descripcionprod_rec4;

    private static final String TAG = ProductoActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producto);
        Bundle extras = getIntent().getExtras();
        String cadena = extras.getString("id");
        //codebar = (TextView) findViewById(R.id.codebar);
        //hotel = (TextView) findViewById(R.id.producto);
        //precio = (TextView) findViewById(R.id.precio_actual);

        fotoImageView = (ImageView) findViewById(R.id.fotoImageView);
        prodRecomendado1 = (ImageView) findViewById(R.id.prodRecomendado1);
        prodRecomendado2 = (ImageView) findViewById(R.id.prodRecomendado2);
        prodRecomendado3 = (ImageView) findViewById(R.id.prodRecomendado3);
        prodRecomendado4 = (ImageView) findViewById(R.id.prodRecomendado4);

        producto = (TextView) findViewById(R.id.producto);
        descripcion_principal = (TextView) findViewById(R.id.descripcion_principal);
        precio_ahora = (TextView) findViewById(R.id.precio_ahora);

        nombreprod_rec1 = (TextView) findViewById(R.id.nombreprod_rec1);
        precioprod_rec1 = (TextView) findViewById(R.id.precioprod_rec1);
        descripcionprod_rec1 = (TextView) findViewById(R.id.descripcionprod_rec1);

        nombreprod_rec2 = (TextView) findViewById(R.id.nombreprod_rec2);
        precioprod_rec2 = (TextView) findViewById(R.id.precioprod_rec2);
        descripcionprod_rec2 = (TextView) findViewById(R.id.descripcionprod_rec2);

        nombreprod_rec3 = (TextView) findViewById(R.id.nombreprod_rec3);
        precioprod_rec3 = (TextView) findViewById(R.id.precioprod_rec3);
        descripcionprod_rec3 = (TextView) findViewById(R.id.descripcionprod_rec3);

        nombreprod_rec4 = (TextView) findViewById(R.id.nombreprod_rec4);
        precioprod_rec4 = (TextView) findViewById(R.id.precioprod_rec4);
        descripcionprod_rec4 = (TextView) findViewById(R.id.descripcionprod_rec4);

        String url = "https://wongfood.vteximg.com.br/arquivos/ids/157715/Vino-Blanco-Tabernero-Gran-Blanco-Semi-Seco-Botella-750-ml-3774001.jpg?v=636088742197170000";
        String url_r1 = "https://wongfood.vteximg.com.br/arquivos/ids/168299/Bife-de-Vacio-Nacional-Wong-x-Kilo-1-7299.jpg?v=636416322676800000";
        String url_r2 = "https://wongfood.vteximg.com.br/arquivos/ids/179755/Filete-de-Congrio-Wong-1-6661.jpg?v=636447386468030000";
        String url_r3 = "https://wongfood.vteximg.com.br/arquivos/ids/156982-1000-1000/Queso-Fresco-Laive-3519.jpg?v=636088709418530000";
        String url_r4 = "https://wongfood.vteximg.com.br/arquivos/ids/161850/Lasagna-de-Carne-Wong-Ready-Caja-1-Kg-460800.jpg?v=636119650351700000";
        String url1="";

        if(cadena.equals("7750533017763")){
            Glide.with(this)
                    .load(url)
                    .into(fotoImageView);
            Glide.with(this)
                    .load(url_r1)
                    .into(prodRecomendado1);
            Glide.with(this)
                    .load(url_r2)
                    .into(prodRecomendado2);
            Glide.with(this)
                    .load(url_r3)
                    .into(prodRecomendado3);
            Glide.with(this)
                    .load(url_r4)
                    .into(prodRecomendado4);
            //precio.setText("S/. 50.5");
            //hotel.setText("Vino Blanco");
            //codebar.setText(cadena);
            producto.setText("Gran Blanco Semi Seco. Botella 750 ml");
            descripcion_principal.setText("Antes: S/. 60.0");
            precio_ahora.setText("Ahora: S/. 50.5");

            nombreprod_rec1.setText("Bife de Vacío x Kilo");
            precioprod_rec1.setText("Los productos se venden en su estado original");
            descripcionprod_rec1.setText("S/52.90 x kg");

            nombreprod_rec2.setText("Filete de Congrio");
            precioprod_rec2.setText("Los productos se venden frescos en su estado original.");
            descripcionprod_rec2.setText("S/72.90 x kg");

            nombreprod_rec3.setText("Queso Fresco Laive x kg");
            precioprod_rec3.setText("Los productos se venden frescos en su estado original.");
            descripcionprod_rec3.setText("S/29.50 x kg");

            nombreprod_rec4.setText("Lasagna de Carne x Kg");
            precioprod_rec4.setText("Listo para calentar y servir.");
            descripcionprod_rec4.setText("S/23.73 x kg");

            //producto
            //descripcion_principal
            //precio_antes
            //precio_ahora
        }else{
            Glide.with(this)
                    .load(url1)
                    .into(fotoImageView);
            //precio.setText("S/. ");
            //hotel.setText("");
            //codebar.setText(cadena);
        }
    }
}
