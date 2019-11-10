package cat.paucasesnoves.activitat2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityBah extends AppCompatActivity {

    private static final String TAG = "Activitat 3";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manolo);
        Log.i(TAG, "OnCreate()");

        TextView bah = findViewById(R.id.bah);


        bah.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //ir(null);
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_V) {
            startActivity(new Intent(this,MainActivity.class));
        }
        return false;
    }

}
