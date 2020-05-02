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

        WondersDataSource dataSource = new WondersDataSource(this);

        //List<Wonder> WonderList = db.getAllWonders();

   //     wdrArrayList = new WonderArrayList();
     //   wdrArrayList.getListOfWonders();
        wonderList = findViewById(R.id.wonderListView);

        tvSelect = (TextView) findViewById(R.id.textViewSelect);

        wdrAdapter = new WonderAdapter(this, R.layout.activity_wonder_list_details, R.id.textViewWonderName, wdrArrayList);
        wdrAdapter.setDropDownViewResource(R.layout.activity_wonder_list_details);
        wonderList.setAdapter(wdrAdapter);
        Log.d("out", "insert" + wdrArrayList.toString());
    }

}