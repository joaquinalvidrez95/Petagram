package com.joaquinalan.petagram.interactor;

import com.joaquinalan.petagram.model.PetFactory;
import com.joaquinalan.petagram.model.domain.Pet;

/**
 * Created by joaquinalan on 31/08/2017.
 */

public class PetsLatelyRatedInteractor implements PetsListInteractor {
    @Override
    public Iterable<Pet> getPets() {
        return PetFactory.getPetsLatelyLiked();
    }

    @Override
    public void ratePet(Pet pet, PetsListInteractorListener petsListInteractorListener) {

    }
}
