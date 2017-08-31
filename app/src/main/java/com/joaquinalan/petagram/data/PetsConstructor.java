package com.joaquinalan.petagram.data;

import com.joaquinalan.petagram.R;
import com.joaquinalan.petagram.model.domain.Pet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by joaquinalan on 30/08/2017.
 */

public class PetsConstructor {
    public static Iterable<Pet> getHomePets() {
        List<Pet> pets = new ArrayList<>();

        pets.add(new Pet("Melanie", 0, R.drawable.pig));
        pets.add(new Pet("Bobby", 0, R.drawable.lion));
        pets.add(new Pet("Lassie", 0, R.drawable.rough_collie));
        pets.add(new Pet("Ramón", 0, R.drawable.schnauzer));
        pets.add(new Pet("Gatillo", 0, R.drawable.cat));
        pets.add(new Pet("Toño", 0, R.drawable.tiger));
        pets.add(new Pet("Omar", 0, R.drawable.nigga));
        pets.add(new Pet("Mickey", 0, R.drawable.rat));
        pets.add(new Pet("Rathalos", 0, R.drawable.dragon));

        return pets;
    }

    public static Iterable<Pet> getPetsLatelyLiked() {
        List<Pet> pets = new ArrayList<>();

        pets.add(new Pet("Mickey", 0, R.drawable.rat));
        pets.add(new Pet("Toño", 0, R.drawable.tiger));
        pets.add(new Pet("Bobby", 0, R.drawable.lion));
        pets.add(new Pet("Lassie", 0, R.drawable.rough_collie));
        pets.add(new Pet("Gatillo", 0, R.drawable.cat));

        return pets;
    }
}
