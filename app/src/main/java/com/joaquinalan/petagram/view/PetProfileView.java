package com.joaquinalan.petagram.view;

import com.joaquinalan.petagram.model.domain.MyPet;

/**
 * Created by joaquinalan on 31/08/2017.
 */

public interface PetProfileView {
    void setupGridRecyclerView(Iterable<MyPet> pets);
}
