package com.example.civ6app;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    ImageButton cultureBtn;
    ImageButton diplomacyBtn;
    ImageButton dominationBtn;
    ImageButton religionBtn;
    ImageButton scienceBtn;
    ImageButton scoreBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cultureBtn = (ImageButton) findViewById(R.id.imageButtonCulture);
        diplomacyBtn = (ImageButton) findViewById(R.id.imageButtonDiplomacy);
        dominationBtn = (ImageButton) findViewById(R.id.imageButtonDomination);
        religionBtn = (ImageButton) findViewById(R.id.imageButtonReligion);
        scienceBtn = (ImageButton) findViewById(R.id.imageButtonScience);
        scoreBtn = (ImageButton) findViewById(R.id.imageButtonScore);

        cultureBtn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // Do something in response to button click
                Intent i = new Intent(MainActivity.this, WonderListActivity.class);
                i.putExtra("condition", MySQLiteHelper.COLUMN_CULTURE);
                startActivity(i);
            }
        });

        diplomacyBtn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // Do something in response to button click
                Intent i = new Intent(MainActivity.this, WonderListActivity.class);
                i.putExtra("condition", MySQLiteHelper.COLUMN_DIPLOMATIC);
                startActivity(i);
            }
        });


        dominationBtn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // Do something in response to button click
                Intent i = new Intent(MainActivity.this, WonderListActivity.class);
                i.putExtra("condition", MySQLiteHelper.COLUMN_DOMINATION);
                startActivity(i);
            }
        });

        religionBtn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // Do something in response to button click
                Intent i = new Intent(MainActivity.this, WonderListActivity.class);
                i.putExtra("condition", MySQLiteHelper.COLUMN_RELIGION);
                startActivity(i);
            }
        });

        scienceBtn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // Do something in response to button click
                Intent i = new Intent(MainActivity.this, WonderListActivity.class);
                i.putExtra("condition", MySQLiteHelper.COLUMN_SCIENCE);
                startActivity(i);
            }
        });

        scoreBtn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // Do something in response to button click
                Intent i = new Intent(MainActivity.this, WonderListActivity.class);
                i.putExtra("condition", MySQLiteHelper.COLUMN_SCORE);
                startActivity(i);
            }
        });
    }
}