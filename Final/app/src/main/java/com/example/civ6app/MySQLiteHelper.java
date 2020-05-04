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

    public static final String TABLE_WONDERS = "wonders";                //The name of the wonders table
    public static final String COLUMN_ID = "_id";                        //The column name of the primary key
    public static final String COLUMN_WONDERS = "name";                  //The column name of the wonder field
    public static final String COLUMN_ERA = "era";                       //The column era of the wonder field
    public static final String COLUMN_PROVIDES = "provide";              //The column provides of the wonder field
    public static final String COLUMN_TILE_REQ = "tile";                 //The column tile requirement of the wonder field
    public static final String COLUMN_TECH_REQ = "tech";                 //The column technology requirement of the wonder field
    public static final String COLUMN_COST = "cost";                     //The column cost of the wonder field
    public static final String COLUMN_DESCRIPTION = "description";       //The column description of the wonder field

    public static final String TABLE_WIN_CONDITION = "win";               // The name of the table that holds the win conditions
    public static final String COLUMN_DOMINATION = "domination";         // The column name for the domination flag
    public static final String COLUMN_CULTURE = "culture";               // The column name for the culture flag
    public static final String COLUMN_SCIENCE = "science";               // The column name for the science flag
    public static final String COLUMN_RELIGION = "religion";             // The column name for the religion flag
    public static final String COLUMN_DIPLOMATIC = "diplomatic";         // The column name for the diplomatic flag
    public static final String COLUMN_SCORE = "score";                   // The column name for the score flag

    private static final String DATABASE_NAME = "civ6.db";
    private static final int DATABASE_VERSION = 11;

    // Database creation sql statement
    private static final String DATABASE_CREATE = "create table "
            + TABLE_WONDERS + "( " + COLUMN_ID
            + " integer primary key autoincrement, " + COLUMN_WONDERS
            + " text not null, " + COLUMN_ERA + " text not null, " + COLUMN_PROVIDES + " text not null, "
            + COLUMN_TILE_REQ + " text not null, " + COLUMN_TECH_REQ + " text not null, " + COLUMN_COST
            + " text not null, " + COLUMN_DESCRIPTION + " text not null);";

    private static final String DATABASE_CREATE2 = "create table "
            + TABLE_WIN_CONDITION + "( " + COLUMN_WONDERS
            + " text not null, " + COLUMN_DOMINATION + " text not null, " + COLUMN_CULTURE + " text not null, "
            + COLUMN_SCIENCE + " text not null, " + COLUMN_RELIGION + " text not null, " + COLUMN_DIPLOMATIC
            + " text not null, " + COLUMN_SCORE + " text not null);";

    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE);
        database.execSQL(DATABASE_CREATE2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(MySQLiteHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_WONDERS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_WIN_CONDITION);
        onCreate(db);
    }
}