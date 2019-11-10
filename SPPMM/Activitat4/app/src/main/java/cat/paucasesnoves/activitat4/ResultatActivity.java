package cat.paucasesnoves.activitat4;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultatactivity_layout);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            TextView textElement = findViewById(R.id.textView);
            textElement.setText(extras.getString("Valor"));
        }
    }
}
