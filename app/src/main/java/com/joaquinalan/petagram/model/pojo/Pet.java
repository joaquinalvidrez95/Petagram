package com.joaquinalan.petagram.model.pojo;

/**
 * Created by joaquinalan on 29/01/2017.
 */

public class Pet {
    private String mName;
    private int mRating;
    private int mImage;

    public Pet(String name, int rating, int image) {
        this.mName = name;
        this.mRating = rating;
        this.mImage = image;
    }

    // Getters
    public int getRating() {
        return mRating;
    }

    public void setRating(int rating) {
        this.mRating = rating;
    }

    public int getImage() {
        return mImage;
    }

    public void setImage(int image) {
        this.mImage = image;
    }

    public String getName() {
        return mName;
    }

    // Setters
    public void setName(String name) {
        this.mName = name;
    }

    public void likePet() {
        mRating++;
    }

}
