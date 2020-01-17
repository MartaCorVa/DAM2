package cat.paucasesnoves.activitat7;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DetallActivity extends AppCompatActivity{

    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_detall);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            TextView t = findViewById(R.id.NomVi);
            t.setText(extras.getString("nomvi"));
        }

        //Accions de música
        Button botomp3 = findViewById(R.id.btnMP3);
        botomp3.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.a);
                mp.start(); // per aturar faríem servir mp.stop()
            }
        });
        //Accions de barra de puntuació
        // Quan seleccionem una puntuació
        final RatingBar rating = findViewById(R.id.ratingBar);
        rating.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Toast.makeText(getApplicationContext(), getString(R.string.puntuacio) + " " + rating, Toast.LENGTH_SHORT).show();
            }
        });
    }


}
