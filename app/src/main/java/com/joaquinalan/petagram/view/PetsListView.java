package com.joaquinalan.petagram.view;

import com.joaquinalan.petagram.model.domain.Pet;

/**
 * Created by joaquinalan on 31/08/2017.
 */

public interface PetsListView {
    void setupRecyclerView(Iterable<Pet> pets);

    void showPetRated(String name);

    void updatePets();
}
