package com.joaquinalan.petagram.presenter;

import com.joaquinalan.petagram.interactor.PetProfileInteractor;
import com.joaquinalan.petagram.view.PetProfileView;

/**
 * Created by joaquinalan on 31/08/2017.
 */

public class PetProfilePresenter implements PetProfileListener {
    private PetProfileView mView;
    private PetProfileInteractor mInteractor;

    public PetProfilePresenter(PetProfileView petProfileView, PetProfileInteractor petProfileInteractor) {
        mView = petProfileView;
        mInteractor = petProfileInteractor;

        mView.setupGridRecyclerView(mInteractor.getPets());
    }

    @Override
    public void onCreateView() {

    }
}
