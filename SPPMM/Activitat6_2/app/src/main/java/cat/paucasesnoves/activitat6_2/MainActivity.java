package cat.paucasesnoves.activitat6_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    private ArrayList<Joc> jocs = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);

        jocs.add(new Joc(1,"Counter Strike Source","FPS","2004","88","8,19","source"));
        jocs.add(new Joc(2,"Playerunknown's Battlegrounds","Battle Royale","2017","86","14,99","pubg"));
        jocs.add(new Joc(3,"Counter-Strike: Global Offensive","FPS","2012","83","0","csgo"));

        JocsArray jocsAdapter = new JocsArray(this,R.layout.activity_main, jocs);
        listView.setAdapter(jocsAdapter);
    }
}
