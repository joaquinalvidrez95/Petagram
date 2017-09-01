package com.joaquinalan.petagram.presenter;

import com.joaquinalan.petagram.interactor.PetsListInteractor;
import com.joaquinalan.petagram.interactor.PetsListInteractorListener;
import com.joaquinalan.petagram.model.domain.Pet;
import com.joaquinalan.petagram.view.PetsListView;

/**
 * Created by joaquinalan on 31/08/2017.
 */

public class PetsListPresenter implements PetsListViewListener, PetsListInteractorListener {
    private PetsListView mView;
    private PetsListInteractor mInteractor;

    public PetsListPresenter(PetsListView petsListView, PetsListInteractor petsListInteractor) {
        mView = petsListView;
        mInteractor = petsListInteractor;
    }

    @Override
    public void onCreateView() {
        mView.setupRecyclerView(mInteractor.getPets());
    }

    @Override
    public void onButtonLikeBoneClicked(Pet pet) {
        mInteractor.ratePet(pet, this);
    }

    @Override
    public void onPetRated(Pet petRated) {
        petRated.likePet();
        mView.updatePets();
        mView.showPetRated(petRated.getName());
    }
}
