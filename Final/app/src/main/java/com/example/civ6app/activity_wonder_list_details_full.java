package com.example.civ6app;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class activity_wonder_list_details_full extends AppCompatActivity {

    WondersDataSource dataSource;
    WonderArrayList wdrArrayList;
    Wonder displayWonder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wonder_list_details_full);

        dataSource = new WondersDataSource(this);
        dataSource.open();
        wdrArrayList = new WonderArrayList(dataSource);

        String selectedWonder;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                selectedWonder = null;
            } else {
                selectedWonder = extras.getString("selectedWonder");
            }
        } else {
            selectedWonder = (String) savedInstanceState.getSerializable("selectedWonder");
        }

        displayWonder = dataSource.getWonderFullDetail(selectedWonder);

        TextView tvWonder = (TextView) findViewById(R.id.textViewWonderName);
        TextView tvEra = (TextView) findViewById(R.id.textViewEra);
        TextView tvProvides = (TextView) findViewById(R.id.textViewProvides);
        TextView tvTile = (TextView) findViewById(R.id.textViewTile);
        TextView tvTech = (TextView) findViewById(R.id.textViewTech);
        TextView tvCost = (TextView) findViewById(R.id.textViewCost);
        TextView tvDescription = (TextView) findViewById(R.id.textViewDescription);

        tvWonder.setText(displayWonder.getWonder());
        tvEra.setText(displayWonder.getEra());
        tvProvides.setText(displayWonder.getProvides());
        tvTile.setText(displayWonder.getTile());
        tvTech.setText(displayWonder.getTech());
        tvCost.setText(displayWonder.getCost());
        tvDescription.setText(displayWonder.getDescription());
    }
}
