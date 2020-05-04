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
    private WondersDataSource dataSource;
    public ArrayList<Wonder> wonderArrayList = new ArrayList<Wonder>();

    /**
     * Constructor that initializes the array list
     */
    public WonderArrayList(WondersDataSource dataSourceIn) {
        dataSource = dataSourceIn;
        wonderArrayList = new ArrayList<Wonder>();
    }

    public void setWonderArrayList() {
    wonderArrayList = new ArrayList<Wonder>(dataSource.getAllWonders());
    }

    public void setWinCondition(String condition) {
        wonderArrayList = new ArrayList<Wonder>(dataSource.getWonderWithCondition(condition));
    }

    public List getList() {
        return wonderArrayList;
    }

    public Wonder getWonders(Integer index) {
        return wonderArrayList.get(index);
    }

    public List getDominationWonders() {

        ArrayList<Wonder> Domination = new ArrayList<Wonder>();

        return wonderArrayList;
    }

    public void remove(Integer index) {
        wonderArrayList.remove(index);
    }
}
