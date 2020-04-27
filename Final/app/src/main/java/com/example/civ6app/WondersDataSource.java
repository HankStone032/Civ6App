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

    public List<Wonder> getAllWonders() {
        database = dbHelper.getWritableDatabase();
        List<Wonder> wonders = new ArrayList<Wonder>();

        Cursor cursor = database.query(MySQLiteHelper.TABLE_WONDERS,
                allColumns, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Wonder wonder = cursorToWonder(cursor);
            wonders.add(wonder);
            cursor.moveToNext();
        }
        // make sure to close the cursor
        cursor.close();
        return wonders;
    }

    private Wonder cursorToWonder(Cursor cursor) {
        Wonder wonder = new Wonder();
        wonder.setId(cursor.getLong(0));
        wonder.setWonder(cursor.getString(1));
        return wonder;
    }
}