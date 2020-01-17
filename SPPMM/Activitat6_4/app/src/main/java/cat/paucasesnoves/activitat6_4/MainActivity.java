package cat.paucasesnoves.activitat6_4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int CALLBACK_CAMERA = 823;
    private static final int CALLBACK_STORAGE = 123;
    private static final int CAMERA_PIC_REQUEST = 1;
    private static final int READ_REQUEST_CODE = 42;
    Button camera;
    Button storage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);

        camera = (Button) findViewById(R.id.camera);
        storage = (Button) findViewById(R.id.storage);

        camera.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                checkPermission(Manifest.permission.CAMERA, CALLBACK_CAMERA);
            }
        });

        storage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkPermission(Manifest.permission.READ_EXTERNAL_STORAGE, CALLBACK_STORAGE);
            }
        });
    }

    public void checkPermission(String permission, int constant) {
        int permissionCheck = ContextCompat.checkSelfPermission(this, permission);
        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{permission}, constant);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case CALLBACK_CAMERA: {
                // Si es cancela la petició l'aray de tornada es buit.
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                {
                    // permís concedit
                    Toast.makeText(getApplicationContext(),"Uso de camara concedido.", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(intent, CAMERA_PIC_REQUEST);
                } else {
                    // permís denegat
                    // Desactivar la funcionalitat relacionada amb el permís
                    Toast.makeText(getApplicationContext(),"Uso de camara denegado.", Toast.LENGTH_SHORT).show();
                }
                return;
            }
            case CALLBACK_STORAGE: {
                // Si es cancela la petició l'aray de tornada es buit.
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                {
                    // permís concedit
                    Toast.makeText(getApplicationContext(),"Uso de almacenamiento externo concedido.", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
                    intent.addCategory(Intent.CATEGORY_OPENABLE);
                    intent.setType("image/*");
                    startActivityForResult(intent, READ_REQUEST_CODE);
                } else {
                    // permís denegat
                    // Desactivar la funcionalitat relacionada amb el permís
                    Toast.makeText(getApplicationContext(),"Uso de almacenamiento externo denegado.", Toast.LENGTH_SHORT).show();
                }
                return;
            }

        }
    }

    private boolean demanaPermisos(){
        return(Build.VERSION.SDK_INT>Build.VERSION_CODES.LOLLIPOP_MR1);
    }
}
