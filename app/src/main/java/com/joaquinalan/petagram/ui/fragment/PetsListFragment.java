package com.joaquinalan.petagram.ui.fragment;


import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.joaquinalan.petagram.R;
import com.joaquinalan.petagram.interactor.PetsListInteractor;
import com.joaquinalan.petagram.model.domain.Pet;
import com.joaquinalan.petagram.presenter.PetsListPresenter;
import com.joaquinalan.petagram.presenter.PetsListViewListener;
import com.joaquinalan.petagram.ui.adapter.PetsListAdapter;
import com.joaquinalan.petagram.view.PetsListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class PetsListFragment extends Fragment implements PetsListView, PetsListAdapter.PetsListAdapterListener {
    PetsListAdapter mAdapter;
    private RecyclerView mRecyclerViewPets;
    private PetsListViewListener mPresenter;

    public PetsListFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_petslist, container, false);
        mRecyclerViewPets = (RecyclerView) view.findViewById(R.id.recyclerview_petslist);

        mPresenter.onCreateView();
        return view;
    }

    public void setInteractor(PetsListInteractor petsListInteractor) {
        mPresenter = new PetsListPresenter(this, petsListInteractor);
    }

    @Override
    public void setupRecyclerView(Iterable<Pet> pets) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerViewPets.setLayoutManager(linearLayoutManager);

        mAdapter = new PetsListAdapter(pets, this);
        mRecyclerViewPets.setAdapter(mAdapter);
    }

    @Override
    public void showPetRated(String name) {
        Snackbar.make(mRecyclerViewPets, getString(R.string.petadapter_likesnackbarmessage) +
                " " + name, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void updatePets() {
        mAdapter.updatePets();
    }

    @Override
    public void onButtonLikeBoneClicked(Pet pet, View view) {
        mPresenter.onButtonLikeBoneClicked(pet);
    }
}
