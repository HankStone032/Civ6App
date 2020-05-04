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
        wonder.setWonder(cursor.getString(cursor.getColumnIndex(MySQLiteHelper.COLUMN_WONDERS)));
        wonder.setEra(cursor.getString(cursor.getColumnIndex(MySQLiteHelper.COLUMN_ERA)));
//        wonder.setProvides(cursor.getString(cursor.getColumnIndex(MySQLiteHelper.COLUMN_PROVIDES)));
//        wonder.setTile(cursor.getString(cursor.getColumnIndex(MySQLiteHelper.COLUMN_TILE_REQ)));
//        wonder.setTech(cursor.getString(cursor.getColumnIndex(MySQLiteHelper.COLUMN_TECH_REQ)));
//        wonder.setCost(cursor.getString(cursor.getColumnIndex(MySQLiteHelper.COLUMN_COST)));
//        wonder.setDescription(cursor.getString(cursor.getColumnIndex(MySQLiteHelper.COLUMN_DESCRIPTION)));

//        wonder.setDominationFlag(cursor.getString(cursor.getColumnIndex(MySQLiteHelper.COLUMN_DOMINATION)));
//        wonder.setCultureFlag(cursor.getString(cursor.getColumnIndex(MySQLiteHelper.COLUMN_CULTURE)));
//        wonder.setScienceFlag(cursor.getString(cursor.getColumnIndex(MySQLiteHelper.COLUMN_SCIENCE)));
//        wonder.setReligionFlag(cursor.getString(cursor.getColumnIndex(MySQLiteHelper.COLUMN_RELIGION)));
//        wonder.setDiplomaticFlag(cursor.getString(cursor.getColumnIndex(MySQLiteHelper.COLUMN_DIPLOMATIC)));
//        wonder.setScoreFlag(cursor.getString(cursor.getColumnIndex(MySQLiteHelper.COLUMN_SCORE)));

        Log.d("out", "insert" + wonder.getId());
        Log.d("out", "insert" + wonder.getWonder());
        Log.d("out", "insert" + wonder.getEra());
        return wonder;
    }

    public ArrayList<Wonder> getWonderWithCondition(String conditionString) {

        db = dbHelper.getReadableDatabase();
        ArrayList<Wonder> wonders = new ArrayList<Wonder>();

        Cursor cursor = db.rawQuery(
                "SELECT "
                + MySQLiteHelper.TABLE_WONDERS
                + ".name, era FROM "
                + MySQLiteHelper.TABLE_WONDERS
                + " INNER JOIN "
                + MySQLiteHelper.TABLE_WIN_CONDITION
                + " ON "
                + MySQLiteHelper.TABLE_WONDERS
                + ".name = "
                + MySQLiteHelper.TABLE_WIN_CONDITION
                + ".name WHERE " + MySQLiteHelper.TABLE_WIN_CONDITION + "."
                + conditionString + " = '1'", null);


        if (cursor.moveToFirst()) {
            do {
            Wonder wonder = cursorToWonder(cursor);
            wonders.add(wonder);
        } while (cursor.moveToNext());
        }
//        while (!cursor.isAfterLast()) {
//            Wonder wonder = cursorToWonder(cursor);
//            wonders.add(wonder);
//            cursor.moveToNext();
//        }
        // make sure to close the cursor
        cursor.close();
        return wonders;
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

    public long insertWinCondition (String name, String domination, String culture, String science, String religion, String diplomatic, String score) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(MySQLiteHelper.COLUMN_WONDERS,name);
        contentValues.put(MySQLiteHelper.COLUMN_DOMINATION,domination);
        contentValues.put(MySQLiteHelper.COLUMN_CULTURE,culture);
        contentValues.put(MySQLiteHelper.COLUMN_SCIENCE,science);
        contentValues.put(MySQLiteHelper.COLUMN_RELIGION,religion);
        contentValues.put(MySQLiteHelper.COLUMN_DIPLOMATIC,diplomatic);
        contentValues.put(MySQLiteHelper.COLUMN_SCORE,score);
        long result = db.insert(MySQLiteHelper.TABLE_WIN_CONDITION, null, contentValues);
        return result;
    }
}