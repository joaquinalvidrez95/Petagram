package com.joaquinalan.petagram.interactor;

import com.joaquinalan.petagram.model.domain.Pet;

/**
 * Created by joaquinalan on 31/08/2017.
 */

public interface PetsListInteractorListener {
    void onPetRated(Pet petRated);
}
