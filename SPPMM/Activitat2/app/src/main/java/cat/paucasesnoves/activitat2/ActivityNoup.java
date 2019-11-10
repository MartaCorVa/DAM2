package cat.paucasesnoves.activitat2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityNoup extends AppCompatActivity {

    private static final String TAG = "Activitat 2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.joselito_layout);
        Log.i(TAG, "OnCreate()");

        TextView bye = findViewById(R.id.bye);


        bye.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //ir(null);
                startActivity(new Intent(getApplicationContext(),ActivityBah.class));
            }
        });
    }

    public void ir(View v){
        Intent i = new Intent(this, ActivityBah.class);
        startActivity(i);
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_V) {
            startActivity(new Intent(this,ActivityBah.class));
        }
        return false;
    }
}
