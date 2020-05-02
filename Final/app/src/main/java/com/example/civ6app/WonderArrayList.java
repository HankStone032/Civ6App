package com.example.civ6app;


import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * For the CIS 3334 class at St. Scholastica
 */

public class WonderArrayList extends AppCompatActivity {
    //
    private MySQLiteHelper dbHelper;
    private ArrayList<Wonder> wonderArrayList = new ArrayList<Wonder>();

    /**
     * Constructor that initializes the array list
     */
    public WonderArrayList() {
        wonderArrayList = new ArrayList<Wonder>();
    }



    public void getListOfWonders() {
        WondersDataSource dbSource = new WondersDataSource(this);
        dbHelper = new MySQLiteHelper(this);
        wonderArrayList = new ArrayList<Wonder>(dbHelper.getAllWonders());
    }
    /**

     */
    public List getList() {
        return wonderArrayList;
    }

    /**
     *
     */
    public Wonder getWonders(Integer index) {
        return wonderArrayList.get(index);
    }


    public void remove(Integer index) {
        wonderArrayList.remove(index);
    }
}
