package com.joaquinalan.petagram.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.joaquinalan.petagram.R;
import com.joaquinalan.petagram.interactor.PorkProfileInteractor;
import com.joaquinalan.petagram.model.domain.MyPet;
import com.joaquinalan.petagram.presenter.PetProfileListener;
import com.joaquinalan.petagram.presenter.PetProfilePresenter;
import com.joaquinalan.petagram.ui.adapter.MyPetAdapter;
import com.joaquinalan.petagram.view.PetProfileView;


/**
 * A simple {@link Fragment} subclass.
 */
public class PetProfileFragment extends Fragment implements PetProfileView {
    //private List<MyPetImage> mMyPetImages;
    private RecyclerView mRecyclerViewMyPetImages;
    private PetProfileListener mPresenter;

    public PetProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_petprofile, container, false);
        mRecyclerViewMyPetImages = (RecyclerView) view.findViewById(R.id.recyclerview_petprofile_images);

        mPresenter = new PetProfilePresenter(this, new PorkProfileInteractor());

        //mPresenter.onCreateView();

        return view;
    }

    @Override
    public void setupGridRecyclerView(Iterable<MyPet> pets) {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 3);
        mRecyclerViewMyPetImages.setLayoutManager(gridLayoutManager);

        MyPetAdapter adapter = new MyPetAdapter(pets);
        mRecyclerViewMyPetImages.setAdapter(adapter);
    }
}
