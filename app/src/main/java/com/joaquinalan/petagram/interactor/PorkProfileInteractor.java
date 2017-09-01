package com.joaquinalan.petagram.interactor;

import com.joaquinalan.petagram.model.PetFactory;
import com.joaquinalan.petagram.model.domain.MyPet;

/**
 * Created by joaquinalan on 31/08/2017.
 */

public class PorkProfileInteractor implements PetProfileInteractor {
    @Override
    public Iterable<MyPet> getPets() {
        return PetFactory.getMyPetImages();
    }
}
