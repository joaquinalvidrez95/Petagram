package com.joaquinalan.petagram.model;

import com.joaquinalan.petagram.R;
import com.joaquinalan.petagram.model.domain.MyPet;
import com.joaquinalan.petagram.model.domain.Pet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by joaquinalan on 30/08/2017.
 */

public class PetFactory {

    public static Iterable<Pet> getHomePets() {
        List<Pet> pets = new ArrayList<>();

        pets.add(new Pet(1, "Melanie", 0, R.drawable.pig));
        pets.add(new Pet(2, "Bobby", 0, R.drawable.lion));
        pets.add(new Pet(3, "Lassie", 0, R.drawable.rough_collie));
        pets.add(new Pet(4, "Ramón", 0, R.drawable.schnauzer));
        pets.add(new Pet(5, "Gatillo", 0, R.drawable.cat));
        pets.add(new Pet(6, "Toño", 0, R.drawable.tiger));
        pets.add(new Pet(7, "Omar", 0, R.drawable.nigga));
        pets.add(new Pet(8, "Mickey", 0, R.drawable.rat));
        pets.add(new Pet(9, "Rathalos", 0, R.drawable.dragon));

        return pets;
    }

    public static Iterable<Pet> getPetsLatelyLiked() {
        List<Pet> pets = new ArrayList<>();

        pets.add(new Pet(1, "Mickey", 0, R.drawable.rat));
        pets.add(new Pet(2, "Toño", 0, R.drawable.tiger));
        pets.add(new Pet(3, "Bobby", 0, R.drawable.lion));
        pets.add(new Pet(4, "Lassie", 0, R.drawable.rough_collie));
        pets.add(new Pet(5, "Gatillo", 0, R.drawable.cat));

        return pets;
    }

    public static Iterable<MyPet> getMyPetImages() {
        List<MyPet> myPetImages = new ArrayList<>();
        String myPetName = "Pork";

        myPetImages.add(new Pet(1, myPetName, 5, R.drawable.petprofile_babypig));
        myPetImages.add(new Pet(1, myPetName, 8, R.drawable.petprofile_humanpig));
        myPetImages.add(new Pet(1, myPetName, 2, R.drawable.petprofile_smartpig));
        myPetImages.add(new Pet(1, myPetName, 3, R.drawable.petprofile_dirtypig));
        myPetImages.add(new Pet(1, myPetName, 7, R.drawable.pig));
        myPetImages.add(new Pet(1, myPetName, 8, R.drawable.petprofile_babypig));
        myPetImages.add(new Pet(1, myPetName, 1, R.drawable.petprofile_babypig));
        myPetImages.add(new Pet(1, myPetName, 2, R.drawable.petprofile_babypig));
        myPetImages.add(new Pet(1, myPetName, 3, R.drawable.petprofile_babypig));
        myPetImages.add(new Pet(1, myPetName, 4, R.drawable.petprofile_babypig));
        myPetImages.add(new Pet(1, myPetName, 6, R.drawable.petprofile_babypig));
        myPetImages.add(new Pet(1, myPetName, 6, R.drawable.petprofile_babypig));

        return myPetImages;
    }
}
