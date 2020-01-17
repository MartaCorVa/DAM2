package cat.paucasesnoves.activitat7;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;

import static androidx.core.content.ContextCompat.getSystemService;

public class DetallFragment extends Fragment {

    Button b;
    private static final String CHANNEL_ID = "HI";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // layout de la llista
        return inflater.inflate(R.layout.fragment_detall, container, false);
    }

    public void mostrarDetall(String vi) {
        TextView t = getView().findViewById(R.id.NomVi);
        t.setText(vi);
        //Accions de música
        Button botomp3 = getActivity().findViewById(R.id.btnMP3);
        botomp3.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                MediaPlayer mp = MediaPlayer.create(getActivity(), R.raw.a);
                mp.start(); // per aturar faríem servir mp.stop()
            }
        });
        //Accions de barra de puntuació
            // Quan seleccionem una puntuació
        final RatingBar rating = getActivity().findViewById(R.id.ratingBar);
        rating.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Toast.makeText(getActivity(), getString(R.string.puntuacio) + " " + rating, Toast.LENGTH_SHORT).show();
            }
        });

    }

//    public void notificar(String item) {
//        // Create an explicit intent for an Activity in your app
//        Intent intent = new Intent(getContext(), MainActivity.class);
//        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//        PendingIntent pendingIntent = PendingIntent.getActivity(getContext(), 0, intent, 0);
//
//        NotificationCompat.Builder builder = new NotificationCompat.Builder(getContext(), CHANNEL_ID)
//                .setSmallIcon(R.drawable.icona_notificacio)
//                .setContentTitle("Ha elegit el vi: ")
//                .setContentText(item)
//                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
//                // Set the intent that will fire when the user taps the notification
//                .setContentIntent(pendingIntent)
//                .setAutoCancel(true);
//
//        int notificationId = 10;
//        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(getContext());
//        // notificationId is a unique int for each notification that you must define
//        notificationManager.notify(notificationId, builder.build());
//
//
//    }

//    public void createNotificationChannel() {
//        // Create the NotificationChannel, but only on API 26+ because
//        // the NotificationChannel class is new and not in the support library
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            CharSequence name = getString(R.string.channel_name);
//            String description = getString(R.string.channel_description);
//            int importance = NotificationManager.IMPORTANCE_DEFAULT;
//            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
//            channel.setDescription(description);
//            // Register the channel with the system; you can't change the importance
//            // or other notification behaviors after this
//            NotificationManager notificationManager = getSystemService(getContext(), NotificationManager.class);
//            notificationManager.createNotificationChannel(channel);
//        }
//    }
}
