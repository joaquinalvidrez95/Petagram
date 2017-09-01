package com.joaquinalan.petagram.presenter;

import com.joaquinalan.petagram.model.domain.Pet;

/**
 * Created by joaquinalan on 31/08/2017.
 */

public interface PetsListViewListener {
    void onCreateView();

    void onButtonLikeBoneClicked(Pet pet);
}
