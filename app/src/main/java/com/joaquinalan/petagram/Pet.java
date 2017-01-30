package com.joaquinalan.petagram;

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

    // Setters
    public void setName(String name) {
        this.mName = name;
    }

    public void setRating(int rating) {
        this.mRating = rating;
    }

    public void setImage(int image) {
        this.mImage = image;
    }

    // Getters
    public int getRating() {
        return mRating;
    }

    public int getImage() {
        return mImage;
    }

    public String getName() {
        return mName;
    }

    public void likePet() {
        mRating++;
    }

}
