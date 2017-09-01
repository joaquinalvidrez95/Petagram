package com.joaquinalan.petagram.interactor;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.joaquinalan.petagram.data.PetagramContract;
import com.joaquinalan.petagram.model.domain.Pet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by joaquinalan on 31/08/2017.
 */

public class HomeInteractor implements PetsListInteractor {
    private SQLiteDatabase mDb;

    public HomeInteractor(SQLiteDatabase sqLiteDatabase) {
        mDb = sqLiteDatabase;
    }

    @Override
    public Iterable<Pet> getPets() {
        List<Pet> pets = new ArrayList<>();

        Cursor cursor = mDb.query(
                PetagramContract.PetTable.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                null
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

    @Override
    public void ratePet(Pet pet, PetsListInteractorListener petsListInteractorListener) {

        ContentValues contentValues = new ContentValues();
        contentValues.put(PetagramContract.PetTable._ID, pet.getId());
        contentValues.put(PetagramContract.PetTable.COLUMN_RATING, pet.getRating() + 1);
        contentValues.put(PetagramContract.PetTable.COLUMN_NAME, pet.getName());
        contentValues.put(PetagramContract.PetTable.COLUMN_IMAGE, pet.getImage());
        //dateTime()
        //mDb.insert(PetagramContract.PetTable.TABLE_NAME, null, contentValues);
        mDb.update(
                PetagramContract.PetTable.TABLE_NAME,
                contentValues,
                PetagramContract.PetTable._ID + "=?",
                new String[]{String.valueOf(pet.getId())}
        );

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

//    private boolean isFull() {
//        final int MAXIMUM_NUMBER_OF_ROWS = 5;
//        String COUNT = "count";
//
//        Cursor cursor = mDb.query(
//                PetagramContract.PetTable.TABLE_NAME,
//                new String[]{"COUNT(" + PetagramContract.PetTable._ID + ") AS " + COUNT},
//                null,
//                null,
//                null,
//                null,
//                null
//        );
//
//        cursor.moveToFirst();
//        int numberOfRows = cursor.getInt(cursor.getColumnIndex(COUNT));
//        return numberOfRows >= MAXIMUM_NUMBER_OF_ROWS;
//    }

//    public Iterable<Contact> getContacts() {
//        List<Contact> contacts = new ArrayList<>();
//
//        String query = "SELECT* FROM " + PetagramContract.PetTable.TABLE_NAME;
//        Cursor records = mSqLiteDatabase.rawQuery(query, null);
//
//        while (records.moveToNext()) {
//            Contact currentContact = new Contact();
//            currentContact.setId(records.getInt(records
//                    .getColumnIndex(PetagramContract.PetTable._ID)));
//            currentContact.setName(records.getString(records
//                    .getColumnIndex(PetagramContract.PetTable.COLUMN_NAME)));
//            currentContact.setPhone(records.getString(records
//                    .getColumnIndex(PetagramContract.PetTable.COLUMN_PHONE)));
//            currentContact.setEmail(records.getString(records
//                    .getColumnIndex(PetagramContract.PetTable.COLUMN_EMAIL)));
//            currentContact.setImage(records.getInt(records
//                    .getColumnIndex(PetagramContract.PetTable.COLUMN_IMAGE)));
//
//            String queryLikes = "SELECT COUNT (" +
//                    PetagramContract.LikeTable.COLUMN_NUMBER_OF_LIKES + ") AS LIKES " +
//                    "FROM " + PetagramContract.LikeTable.TABLE_NAME +
//                    " WHERE " + PetagramContract.LikeTable.COLUMN_CONTACT_ID + "=" +
//                    currentContact.getId();
//            Cursor likesRecords = mSqLiteDatabase.rawQuery(queryLikes, null);
//
//            if (likesRecords.moveToNext()) {
//                currentContact.setNumberOfLikes(likesRecords.getInt(0));
//            } else {
//                currentContact.setNumberOfLikes(0);
//            }
//
//            contacts.add(currentContact);
//        }
//        //mSqLiteDatabase.close();
//        return contacts;
//    }


//    @Override
//    public int getContactLikes(Contact contact) {
//        int likes = 0;
//        String query = "SELECT COUNT (" + PetagramContract.LikeTable.COLUMN_NUMBER_OF_LIKES + ")" +
//                " FROM " + PetagramContract.LikeTable.TABLE_NAME +
//                " WHERE " + PetagramContract.LikeTable.COLUMN_CONTACT_ID + "=" + contact.getId();
//
//        Cursor records = mSqLiteDatabase.rawQuery(query, null);
//
//        if (records.moveToNext()) {
//            likes = records.getInt(0);
//        }
//        //mSqLiteDatabase.close();
//        return likes;
//    }

//    public Pet getPet(int petId) {
//        Cursor contactCursor = mSqLiteDatabase.query(
//                PetagramContract.PetTable.TABLE_NAME,
//                null,
//                petId + " = " + PetagramContract.PetTable._ID,
//                null,
//                null,
//                null,
//                null);
//
//        if (contactCursor.moveToNext()) {
//            String name = contactCursor.getString(contactCursor
//                    .getColumnIndex(PetagramContract.PetTable.COLUMN_NAME));
//            String phone = contactCursor.getString(contactCursor
//                    .getColumnIndex(PetagramContract.PetTable.COLUMN_PHONE));
//            String email = contactCursor.getString(contactCursor
//                    .getColumnIndex(PetagramContract.PetTable.COLUMN_EMAIL));
//            int image = contactCursor.getInt(contactCursor
//                    .getColumnIndex(PetagramContract.PetTable.COLUMN_IMAGE));
//            int id = contactCursor.getInt(contactCursor
//                    .getColumnIndex(PetagramContract.PetTable._ID));
//
//            Contact pet = new Contact(
//                    name,
//                    phone,
//                    email,
//                    image
//            );
//            pet.setId(id);
//
//            Cursor likesCursor = mSqLiteDatabase.query(
//                    PetagramContract.LikeTable.TABLE_NAME,
//                    new String[]{"COUNT(" + PetagramContract.LikeTable._ID + ") AS count"},
//                    PetagramContract.LikeTable.COLUMN_CONTACT_ID + " = " + petId,
//                    null,
//                    null,
//                    null,
//                    null);
//
//            if (likesCursor.moveToNext()) {
//                int numberOfLikes = likesCursor.getInt(0);
//                pet.setNumberOfLikes(numberOfLikes);
//            }
//
//            return pet;
//        }
//
//        return null;
//    }
}
