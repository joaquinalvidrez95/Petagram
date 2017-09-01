package com.joaquinalan.petagram.interactor;

import com.joaquinalan.petagram.model.domain.MyPet;

/**
 * Created by joaquinalan on 31/08/2017.
 */

public interface PetProfileInteractor {
    Iterable<MyPet> getPets();
}
