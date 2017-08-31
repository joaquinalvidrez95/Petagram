package com.joaquinalan.petagram.interactor;

import com.joaquinalan.petagram.data.PetFactory;
import com.joaquinalan.petagram.model.domain.Pet;

/**
 * Created by joaquinalan on 31/08/2017.
 */

public class HomeInteractor implements PetsListInteractor {
    @Override
    public Iterable<Pet> getPets() {
        return PetFactory.getHomePets();
    }
}
