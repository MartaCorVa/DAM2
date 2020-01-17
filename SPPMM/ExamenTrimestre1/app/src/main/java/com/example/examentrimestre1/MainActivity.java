package com.example.examentrimestre1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{

    private ArrayList<Item> items;
    private ArrayList<Item> items_comprats = new ArrayList<>();

    private Intent i;

    private ArrayAdapter<Item> ai,aic;

    private int CODI_PETICIO = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        muestraInfo();

        ListView llista_items = (ListView) findViewById(R.id.llista);
        ai = new ArrayItem(this,R.layout.item_llista,items);
        llista_items.setAdapter(ai);

        ListView llista_items_comprats = (ListView) findViewById(R.id.llistaComprats);
        aic = new ArrayItem(this,R.layout.item_llista,items_comprats);
        llista_items_comprats.setAdapter(aic);

        llista_items.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                System.out.println("ssnjss");
                Toast toast1 = Toast.makeText(getApplicationContext(), "Item nom!", Toast.LENGTH_SHORT);
                toast1.show();            }
        });

        Button btnEnviar = (Button) findViewById(R.id.afegeix);
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // código a ejecutar cuando sea pulsado
                i = new Intent(v.getContext(), NouItem.class);
                startActivityForResult(i,CODI_PETICIO);

            }
        });


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK && requestCode == CODI_PETICIO) {
            if (data.hasExtra("Nom") && data.hasExtra("Quantitat")) {
                String nom = data.getStringExtra("Nom");
                String quantitat = data.getStringExtra("Quantitat");
                Item nou_item = new Item(1,nom,quantitat,false);
                items.add(nou_item);

                Toast toast1 = Toast.makeText(getApplicationContext(), "Item afegit!", Toast.LENGTH_SHORT);
                toast1.show();
                ai.notifyDataSetChanged();
            }
        }
    }

    public void actualitza(Item item){
        if(item.isComprat()){
            items.add(item);
            items_comprats.remove(item);
            item.setComprat(false);
        }else{
            items.remove(item);
            items_comprats.add(item);
            item.setComprat(true);
        }


        ai.notifyDataSetChanged();
        aic.notifyDataSetChanged();
    }

    @Override
    protected void onPause() {
        super.onPause();
        guardaInfo();
    }

    private void guardaInfo() {
        // Instanciamos un SharedPreferences para guardar nuestros productos y le ponemos un nombre.
        SharedPreferences sharedPreferences = getSharedPreferences("productes", MODE_PRIVATE);
        // Creamos un editor para guardar los datos.
        SharedPreferences.Editor editor = sharedPreferences.edit();
        // Instanciamos un Gson.
        Gson gson = new Gson();
        // Creamos un String para guardar nuestra ArrayList en formato JSON.
        String json = gson.toJson(items);
        // Añadimos el string a nuestro SharedPreferences.
        editor.putString("llista items", json);
        editor.apply();
    }

    private void muestraInfo(){
        // Instanciamos un SharedPreferences para guardar nuestros productos y le damos un nombre.
        SharedPreferences sharedPreferences = getSharedPreferences("productes", MODE_PRIVATE);
        // Instanciamos un Gson
        Gson gson = new Gson();
        // Instanciamos un string y recogemos la lista del SharedPreferences.
        // Le ponemos null como valor por defecto.
        String json = sharedPreferences.getString("llista items", null);
        // Instanciamos un Type para devolver una cadena que incluye información sobre el parámetro.
        Type type = new TypeToken<ArrayList<Item>>() {}.getType();
        // Inicializamos nuestra lista con el String recibido y el tipo del que tiene que ser.
        items = gson.fromJson(json, type);

        // Si la lista esta vacia inicializamos la ArrayList
        if (items == null) {
            items = new ArrayList<Item>();
        }
    }
}
