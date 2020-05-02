package com.example.civ6app;


import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class WondersDataSource {

    // Database fields
    private SQLiteDatabase database;
    private MySQLiteHelper dbHelper;
    private String[] allColumns = { MySQLiteHelper.COLUMN_ID,
            MySQLiteHelper.COLUMN_WONDERS, MySQLiteHelper.COLUMN_ERA, MySQLiteHelper.COLUMN_PROVIDES, MySQLiteHelper.COLUMN_TILE_REQ, MySQLiteHelper.COLUMN_TECH_REQ, MySQLiteHelper.COLUMN_COST, MySQLiteHelper.COLUMN_DESCRIPTION };

    public WondersDataSource(Context context) {
        dbHelper = new MySQLiteHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }
    public void close() {
        dbHelper.close();
    }


}