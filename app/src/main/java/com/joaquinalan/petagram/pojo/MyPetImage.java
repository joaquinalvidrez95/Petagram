package com.joaquinalan.petagram.pojo;

/**
 * Created by joaquinalan on 01/02/2017.
 */

public class MyPetImage {
    private int mRating;
    private int mImage;

    public MyPetImage(int image, int rating) {
        this.mRating = rating;
        this.mImage = image;
    }

    // Setters
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



}
