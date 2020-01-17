package cat.paucasesnoves.sppsptema02entrega02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import cat.paucasesnoves.sppsptema02entrega02.activitats.ActualitzaActivity;
import cat.paucasesnoves.sppsptema02entrega02.activitats.AfegirActivity;
import cat.paucasesnoves.sppsptema02entrega02.activitats.ConsultaActivity;
import cat.paucasesnoves.sppsptema02entrega02.activitats.EsborraActivity;
import cat.paucasesnoves.sppsptema02entrega02.activitats.LlistaActivity;
import cat.paucasesnoves.sppsptema02entrega02.entitats.DBInterface;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void botoAfegir(View view){
        Intent intent = new Intent(this, AfegirActivity.class);
        startActivity(intent);
    }

    public void botoConsulta(View view){
        Intent intent = new Intent(this, ConsultaActivity.class);
        startActivity(intent);
    }

    public void botoLlista(View view){
        Intent intent = new Intent(this, LlistaActivity.class);
        startActivity(intent);
    }

    public void botoActualitza(View view){
        Intent intent = new Intent(this, ActualitzaActivity.class);
        startActivity(intent);
    }

    public void botoEsborra(View view){
        Intent intent = new Intent(this, EsborraActivity.class);
        startActivity(intent);
    }

}
