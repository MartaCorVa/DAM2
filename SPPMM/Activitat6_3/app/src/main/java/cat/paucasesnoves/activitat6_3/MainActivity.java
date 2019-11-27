package cat.paucasesnoves.activitat6_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    private static final String PREFERENCIA_BARRA = "hola";
    private static final String NOM_PREFERENCIES = "Preferencies";
    private static final String CLAU_MIDA_TEXT = "MidaText";
    private static final String CLAU_TEXT = "NomText";
    SeekBar barraMida;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);

        barraMida = (SeekBar) findViewById(R.id.seekBar);
        editText = (EditText) findViewById(R.id.editText);

        SharedPreferences pref = getSharedPreferences(PREFERENCIA_BARRA,
                MODE_PRIVATE);
        //Barra de mida
        int midaFont=pref.getInt(CLAU_MIDA_TEXT,12);
        barraMida.setProgress(midaFont);
        //TextView
        editText.setText(pref.getString(CLAU_TEXT,""));
        editText.setTextSize(midaFont);

        barraMida.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            //@Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
            //@Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            //@Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean
                    fromUser) {
                editText.setTextSize(progress);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        //Obtenim les preferències
        SharedPreferences settings = getSharedPreferences(PREFERENCIA_BARRA,
                MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        //Guardam el nom
        editText = (EditText) findViewById(R.id.editText);
        editor.putString(CLAU_TEXT, editText.getText().toString());
        //Guardam la mida del text
        barraMida = (SeekBar) findViewById(R.id.seekBar);
        editor.putInt(CLAU_MIDA_TEXT, barraMida.getProgress());
        //Confirma els canvis
        editor.commit();
    }
}
