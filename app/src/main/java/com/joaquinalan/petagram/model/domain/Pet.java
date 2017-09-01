package com.joaquinalan.petagram.model.domain;

/**
 * Created by joaquinalan on 29/01/2017.
 */

public class Pet implements MyPet {
    private String mName;
    private int mRating;
    private int mImage;
    private int mId;

    public Pet(int id, String name, int rating, int image) {
        this.mId = id;
        this.mName = name;
        this.mRating = rating;
        this.mImage = image;
    }

    // Getters
    @Override
    public int getRating() {
        return mRating;
    }

    @Override
    public int getImage() {
        return mImage;
    }

    public String getName() {
        return mName;
    }

    public void likePet() {
        mRating++;
    }

    public int getId() {
        return mId;
    }

//    public void setId(int id) {
//        this.mId = id;
//    }
}
