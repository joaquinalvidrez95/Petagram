package com.joaquinalan.petagram.presenter;

import com.joaquinalan.petagram.interactor.PetsListInteractor;
import com.joaquinalan.petagram.view.PetsListView;

/**
 * Created by joaquinalan on 31/08/2017.
 */

public class PetsListPresenter implements PetsListViewListener {
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
}
