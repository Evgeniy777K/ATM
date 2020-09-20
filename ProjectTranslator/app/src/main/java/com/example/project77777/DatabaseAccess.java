package com.example.project77777;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseAccess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;
    private static DatabaseAccess instance;

    /**
     * Private constructor to avoid object creation from outside classes.
     *
     * @param context
     */
    private DatabaseAccess(Context context) {
        this.openHelper = new DatabaseOpenHelper(context);
    }

    /**
     * Return a singleton instance of DatabaseAccess.
     *
     * @param context the Context
     * @return the instance of DabaseAccess
     */
    public static DatabaseAccess getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseAccess(context);
        }
        return instance;
    }

    /**
     * Open the database connection.
     */
    public void open() {
        this.database = openHelper.getWritableDatabase();
    }

    /**
     * Close the database connection.
     */
    public void close() {
        if (database != null) {
            this.database.close();
        }
    }

    /**
     * Read all getVerbs from the database.
     *
     * @return a List of getVerbs
     */
    public List<VerbRow> getVerbs() {
        List<VerbRow> list = new ArrayList<>();

        Cursor cursor = database.rawQuery("SELECT * FROM tbl1",null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            list.add(
                    new VerbRow(cursor.getString(0),
                            cursor.getString(1),
                            cursor.getString(2),
                            cursor.getString(3),
                            cursor.getString(4)
                    )
            );
            cursor.moveToNext();
        }
        cursor.close();

        return list;
    }

    public List<VerbRow> getVerbsByShoresh(String shoresh) {
        List<VerbRow> list = new ArrayList<>();

        Cursor cursor = database.rawQuery("SELECT * FROM tbl1 WHERE base_form = ?",new String[] {shoresh});
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            list.add(
                    new VerbRow(cursor.getString(0),
                            cursor.getString(1),
                            cursor.getString(2),
                            cursor.getString(3),
                            cursor.getString(4)
                    )
            );
            cursor.moveToNext();
        }
        cursor.close();

        return list;
    }
}

