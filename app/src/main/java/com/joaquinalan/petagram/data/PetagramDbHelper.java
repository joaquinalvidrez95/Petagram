package com.joaquinalan.petagram.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.joaquinalan.petagram.model.PetFactory;
import com.joaquinalan.petagram.model.domain.Pet;

/**
 * Created by joaquinalan on 06/02/2017.
 */

public class PetagramDbHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "petagram.db";
    public static final int DATABASE_VERSION = 1;
    //private static final int LIKE = 1;


    public PetagramDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String queryCreateContactTable = "CREATE TABLE " +
                PetagramContract.PetTable.TABLE_NAME + "(" +
                //PetagramContract.PetTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                PetagramContract.PetTable._ID + " INTEGER NOT NULL PRIMARY KEY, " +
                PetagramContract.PetTable.COLUMN_NAME + " TEXT, " +
                PetagramContract.PetTable.COLUMN_RATING + " INTEGER, " +
                PetagramContract.PetTable.COLUMN_IMAGE + " INTEGER, " +
                PetagramContract.PetTable.COLUMN_TIMESTAMP + " TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP" +
                ")";

        sqLiteDatabase.execSQL(queryCreateContactTable);
        setupDatabase(sqLiteDatabase);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXIST " + PetagramContract.PetTable.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    private void setupDatabase(SQLiteDatabase sqLiteDatabase) {
        ContentValues contentValues = new ContentValues();

        for (Pet pet : PetFactory.getHomePets()) {
            contentValues.put(PetagramContract.PetTable._ID, pet.getId());
            contentValues.put(PetagramContract.PetTable.COLUMN_NAME, pet.getName());
            contentValues.put(PetagramContract.PetTable.COLUMN_RATING, pet.getRating());
            contentValues.put(PetagramContract.PetTable.COLUMN_IMAGE, pet.getImage());

            sqLiteDatabase.insert(PetagramContract.PetTable.TABLE_NAME, null, contentValues);
            //sqLiteDatabase.close();
        }

    }


}
