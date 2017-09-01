package com.joaquinalan.petagram.interactor;

import com.joaquinalan.petagram.model.domain.Pet;

/**
 * Created by joaquinalan on 31/08/2017.
 */

public interface PetsListInteractor {
    Iterable<Pet> getPets();

    void ratePet(Pet pet, PetsListInteractorListener petsListInteractorListener);
}
