package com.joaquinalan.petagram.interactor;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.joaquinalan.petagram.data.PetagramContract;
import com.joaquinalan.petagram.model.domain.Pet;

/**
 * Created by joaquinalan on 31/08/2017.
 */

public abstract class PetsListInteractor {
    protected SQLiteDatabase mDb;

    public PetsListInteractor(SQLiteDatabase sqLiteDatabase) {
        this.mDb = sqLiteDatabase;
    }

    public abstract Iterable<Pet> getPets();

    public final void ratePet(Pet pet, PetsListInteractorListener petsListInteractorListener) {

        ContentValues contentValues = new ContentValues();
        contentValues.put(PetagramContract.PetTable._ID, pet.getId());
        contentValues.put(PetagramContract.PetTable.COLUMN_RATING, pet.getRating() + 1);
        contentValues.put(PetagramContract.PetTable.COLUMN_NAME, pet.getName());
        contentValues.put(PetagramContract.PetTable.COLUMN_IMAGE, pet.getImage());

//        mDb.update(
//                PetagramContract.PetTable.TABLE_NAME,
//                contentValues,
//                PetagramContract.PetTable._ID + "=?",
//                new String[]{String.valueOf(pet.getId())}
//        );

        mDb.delete(
                PetagramContract.PetTable.TABLE_NAME,
                PetagramContract.PetTable._ID + "=?",
                new String[]{String.valueOf(pet.getId())}
        );
        mDb.insert(PetagramContract.PetTable.TABLE_NAME, null, contentValues);
        petsListInteractorListener.onPetRated(pet);
    }

    private boolean hasPet(int petId) {
        Cursor cursor = mDb.query(
                PetagramContract.PetTable.TABLE_NAME,
                null,
                petId + "=" + PetagramContract.PetTable._ID,
                null,
                null,
                null,
                null
        );
        return cursor.moveToFirst();
    }
}
