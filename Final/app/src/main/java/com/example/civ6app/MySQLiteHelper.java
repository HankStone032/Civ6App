package com.example.civ6app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * This class servers as a helper class to ope and create a database, Constant variables are created fort table wonders,
 * a constructor is defined to create a table, and execute database SQL is executed in onCreate and code is provided
 * to assist with upgrading the database.
 */

public class MySQLiteHelper extends SQLiteOpenHelper {

    public static final String TABLE_WONDERS = "wonders";                //The name of the table
    public static final String COLUMN_ID = "_id";                        //The column name of the primary key
    public static final String COLUMN_WONDERS = "name";                  //The column name of the wonder field
    public static final String COLUMN_ERA = "era";                       //The column era of the wonder field
    public static final String COLUMN_PROVIDES = "provide";              //The column provides of the wonder field
    public static final String COLUMN_TILE_REQ = "tile";                 //The column tile requirement of the wonder field
    public static final String COLUMN_TECH_REQ = "tech";                 //The column technology requirement of the wonder field
    public static final String COLUMN_COST = "cost";                     //The column cost of the wonder field
    public static final String COLUMN_DESCRIPTION = "description";       //The column description of the wonder field

    private static final String DATABASE_NAME = "civ6.db";
    private static final int DATABASE_VERSION = 9;

    // Database creation sql statement
    private static final String DATABASE_CREATE = "create table "
            + TABLE_WONDERS + "( " + COLUMN_ID
            + " integer primary key autoincrement, " + COLUMN_WONDERS
            + " text not null, " + COLUMN_ERA + " text not null, " + COLUMN_PROVIDES + " text not null, "
            + COLUMN_TILE_REQ + " text not null, " + COLUMN_TECH_REQ + " text not null, " + COLUMN_COST
            + " text not null, " + COLUMN_DESCRIPTION + " text not null);";

    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE);
    }

//    public long insertWonder (String name, String era, String provide, String tile, String tech, String cost, String description) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//        contentValues.put(COLUMN_WONDERS,name);
//        contentValues.put(COLUMN_ERA,era);
//        contentValues.put(COLUMN_PROVIDES,provide);
//        contentValues.put(COLUMN_TILE_REQ,tile);
//        contentValues.put(COLUMN_TECH_REQ,tech);
//        contentValues.put(COLUMN_COST,cost);
//        contentValues.put(COLUMN_DESCRIPTION,description);
//        long result = db.insert(TABLE_WONDERS, null, contentValues);
//      return result;
//    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(MySQLiteHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_WONDERS);
        onCreate(db);
    }

//    public ArrayList<Wonder> getAllWonders() {
//        SQLiteDatabase database = this.getReadableDatabase();
//        ArrayList<Wonder> wonders = new ArrayList<Wonder>();
//
//        Cursor cursor = database.query(MySQLiteHelper.TABLE_WONDERS,
//                allColumns, null, null, null, null, null);
//
//        cursor.moveToFirst();
//        while (!cursor.isAfterLast()) {
//            Wonder wonder = cursorToWonder(cursor);
//            wonders.add(wonder);
//            cursor.moveToNext();
//        }
//        // make sure to close the cursor
//        cursor.close();
//        return wonders;
//    }
//
//    private Wonder cursorToWonder(Cursor cursor) {
//        Wonder wonder = new Wonder();
//        wonder.setId(cursor.getLong(cursor.getColumnIndex(MySQLiteHelper.COLUMN_ID)));
//        wonder.setWonder(cursor.getString(cursor.getColumnIndex(MySQLiteHelper.COLUMN_WONDERS)));
//        wonder.setEra(cursor.getString(cursor.getColumnIndex(MySQLiteHelper.COLUMN_ERA)));
//        return wonder;
//    }

}