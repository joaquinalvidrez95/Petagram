package com.joaquinalan.petagram.view.fragment;


import android.os.Bundle;
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
import com.joaquinalan.petagram.view.PetsListView;
import com.joaquinalan.petagram.view.adapter.PetAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class PetsListFragment extends Fragment implements PetsListView {
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

//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
//        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
//        mRecyclerViewPets.setLayoutManager(linearLayoutManager);
        mPresenter.onCreateView();
        //initiateAdapter(pets);
        return view;
    }

    public void setInteractor(PetsListInteractor petsListInteractor) {
        mPresenter = new PetsListPresenter(this, petsListInteractor);
    }

//    public void initiateAdapter(Iterable<Pet> pets) {
//        PetAdapter adapter = new PetAdapter(pets, getActivity());
//        mRecyclerViewPets.setAdapter(adapter);
//    }

    @Override
    public void setupRecyclerView(Iterable<Pet> pets) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerViewPets.setLayoutManager(linearLayoutManager);

        PetAdapter adapter = new PetAdapter(pets, getActivity());
        mRecyclerViewPets.setAdapter(adapter);
    }
}
