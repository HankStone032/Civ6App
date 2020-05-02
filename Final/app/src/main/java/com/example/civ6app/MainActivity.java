package com.example.civ6app;

        import androidx.appcompat.app.AppCompatActivity;

        import android.database.Cursor;
        import android.os.Bundle;
        import android.util.Log;
        import android.widget.AdapterView;
        import android.widget.ArrayAdapter;
        import android.widget.ListView;
        import android.widget.TextView;
        import android.widget.Toast;

        import java.util.ArrayList;
        import java.util.List;

public class MainActivity extends AppCompatActivity {
    MySQLiteHelper db;

    ArrayList<String> listItem;
    ArrayAdapter<Wonder> wdrAdapter;
    ListView wonderList;
    TextView tvSelect;
    TextView textViewName;
    WonderArrayList wdrArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new MySQLiteHelper(this);
        listItem = new ArrayList<>();
        long insert = db.insertWonder("Alhambra", "Medieval", "+2 Amenities from entertainment, +2 Great General points per turn, +1 Military Policy slot", "Must be built on Hills adjacent to an Encampment District.",
                "Castles", "710 production", "The Alhambra began as a small fortress, constructed in 889 AD by the Moors of Granada in Andalusia (Spain); then it was rebuilt and expanded by the emir Mohammed ben Al-Ahmar in the 11th Century and yet again expanded and converted into a royal palace by Sultan Yusuf I in 1333. The al-Hamra (literally, “the red one”), so named for its red clay fortress walls, was lavish – at least by European standards of the time – with all the comforts, including indoor plumbing. It integrated the natural beauty of the spot with structures and gardens designed and outfitted by the finest Muslim, Jewish, and even Christian craftsmen and artisans of the region. Among its most striking aspects, many of the interior walls and columns are inscribed in carved flowing Arabic script with poetry and verses from the Quran. The last sultan of the Nasrid dynasty, Muhammad XII, surrendered Granada to the Spanish in 1492 AD, without the Alhambra being attacked by the crusaders – otherwise it would be just another pile of rubble and memories of elegance.");
        db.insertWonder("Apadana", "Classical", "+2 Great Work slots, +2  Envoys when you build a wonder, including Apadana, in this city.", "Must be built adjacent to a  Capital.",
                                "Political Philosophy", "400 production", "Though an apadana was a specific style of ancient construction, the Apadana at Persepolis most typified the style. Dozens of columns supported a wooden roof, all built atop an elevated stone surface accessible by large staircases. The structure was open to the elements, though temporary “rooms” could be created by hanging cloth between columns. Darius the Great began construction of the Apadana at Persepolis, and Xerxes I completed it. The dynasty’s accomplishments were literally carved into the wall, whether text declarations or reliefs depicting the splendor and majesty of the Persian kings. Unfortunately for the Achaemenids, the Apadana was mostly destroyed by Alexander the Great’s forces during his Persian conquests. Some of its columns remain standing in the modern day.");

        WondersDataSource dataSource = new WondersDataSource(this);

        List<Wonder> WonderList = db.getAllWonders();

        wdrArrayList = new WonderArrayList();
        wdrArrayList.getListOfWonders();
        wonderList = findViewById(R.id.wonderListView);

        tvSelect = (TextView) findViewById(R.id.textViewSelect);

        wdrAdapter = new WonderAdapter(this, R.layout.activity_wonder_list_details, R.id.textViewWonderName, wdrArrayList);
        wdrAdapter.setDropDownViewResource(R.layout.activity_wonder_list_details);
        wonderList.setAdapter(wdrAdapter);
        Log.d("out", "insert" + wdrArrayList.toString());
    }

}