package cat.paucasesnoves.activitat4;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class QuartaActivity extends AppCompatActivity implements View.OnClickListener {

    Button boto1;
    Button boto2;
    Button boto3;
    Button boto4;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.terceraactivity_layout);

        boto1 = (Button)findViewById(R.id.boto1);
        boto1.setOnClickListener(this);
        boto2 = (Button)findViewById(R.id.boto2);
        boto2.setOnClickListener(this);
        boto3 = (Button)findViewById(R.id.boto3);
        boto3.setOnClickListener(this);
        boto4 = (Button)findViewById(R.id.boto4);
        boto4.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == boto1) mostraMissatge("Boton 1");
        else if(view == boto2) mostraMissatge("Boton 2");
        else if(view == boto3) mostraMissatge("Boton 3");
        else if(view == boto4) mostraMissatge("Boton 4");
    }

    public void mostraMissatge(String nomBoto) {
        Toast.makeText(getApplicationContext(), nomBoto, Toast.LENGTH_SHORT).show();
    }
}
