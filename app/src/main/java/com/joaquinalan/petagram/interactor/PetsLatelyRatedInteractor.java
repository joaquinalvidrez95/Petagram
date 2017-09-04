package com.joaquinalan.petagram.interactor;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.joaquinalan.petagram.data.PetagramContract;
import com.joaquinalan.petagram.model.domain.Pet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by joaquinalan on 31/08/2017.
 */

public class PetsLatelyRatedInteractor extends PetsListInteractor {

    public PetsLatelyRatedInteractor(SQLiteDatabase sqLiteDatabase) {
        super(sqLiteDatabase);
    }

    @Override
    public Iterable<Pet> getPets() {
        final int MAXIMUM_NUMBER_OF_ROWS = 5;
        List<Pet> pets = new ArrayList<>();

        Cursor cursor = mDb.query(
                PetagramContract.PetTable.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                PetagramContract.PetTable.COLUMN_TIMESTAMP + " DESC", String.valueOf(MAXIMUM_NUMBER_OF_ROWS)
        );
        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndex(PetagramContract.PetTable
                    ._ID));
            int rating = cursor.getInt(cursor.getColumnIndex(PetagramContract.PetTable
                    .COLUMN_RATING));
            int image = cursor.getInt(cursor.getColumnIndex(PetagramContract.PetTable
                    .COLUMN_IMAGE));
            String name = cursor.getString(cursor.getColumnIndex(PetagramContract.PetTable
                    .COLUMN_NAME));

            Pet pet = new Pet(id, name, rating, image);
            pets.add(pet);
        }
        return pets;
    }

}
