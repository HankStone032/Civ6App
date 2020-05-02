package com.example.civ6app;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class WondersDataSource {

    // Database fields
    private SQLiteDatabase db;
    private MySQLiteHelper dbHelper;
    private String[] allColumns = { MySQLiteHelper.COLUMN_ID,
            MySQLiteHelper.COLUMN_WONDERS, MySQLiteHelper.COLUMN_ERA, MySQLiteHelper.COLUMN_PROVIDES, MySQLiteHelper.COLUMN_TILE_REQ, MySQLiteHelper.COLUMN_TECH_REQ, MySQLiteHelper.COLUMN_COST, MySQLiteHelper.COLUMN_DESCRIPTION };

    public WondersDataSource(Context context) {
        dbHelper = new MySQLiteHelper(context);
    }

    public void open() throws SQLException {
        db = dbHelper.getWritableDatabase();
    }
    public void close() {
        dbHelper.close();
    }

    public ArrayList<Wonder> getAllWonders() {
        db = dbHelper.getReadableDatabase();
        ArrayList<Wonder> wonders = new ArrayList<Wonder>();

        Cursor cursor = db.query(MySQLiteHelper.TABLE_WONDERS,
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
        wonder.setId(cursor.getLong(cursor.getColumnIndex(MySQLiteHelper.COLUMN_ID)));
        wonder.setWonder(cursor.getString(cursor.getColumnIndex(MySQLiteHelper.COLUMN_WONDERS)));
        wonder.setEra(cursor.getString(cursor.getColumnIndex(MySQLiteHelper.COLUMN_ERA)));
        Log.d("out", "insert" + wonder.getId());
        Log.d("out", "insert" + wonder.getWonder());
        Log.d("out", "insert" + wonder.getEra());
        return wonder;
    }

    public long insertWonder (String name, String era, String provide, String tile, String tech, String cost, String description) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(MySQLiteHelper.COLUMN_WONDERS,name);
        contentValues.put(MySQLiteHelper.COLUMN_ERA,era);
        contentValues.put(MySQLiteHelper.COLUMN_PROVIDES,provide);
        contentValues.put(MySQLiteHelper.COLUMN_TILE_REQ,tile);
        contentValues.put(MySQLiteHelper.COLUMN_TECH_REQ,tech);
        contentValues.put(MySQLiteHelper.COLUMN_COST,cost);
        contentValues.put(MySQLiteHelper.COLUMN_DESCRIPTION,description);
        long result = db.insert(MySQLiteHelper.TABLE_WONDERS, null, contentValues);
        return result;
    }

}