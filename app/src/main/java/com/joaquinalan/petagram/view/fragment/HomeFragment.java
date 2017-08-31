package com.joaquinalan.petagram.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.joaquinalan.petagram.R;
import com.joaquinalan.petagram.data.PetsConstructor;
import com.joaquinalan.petagram.view.adapter.PetAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    private RecyclerView mRecyclerViewPets;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        mRecyclerViewPets = (RecyclerView) view.findViewById(R.id.recyclerview_home_pets);

        LinearLayoutManager llmMyLayout = new LinearLayoutManager(getActivity());
        llmMyLayout.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerViewPets.setLayoutManager(llmMyLayout);

        initiateAdapter();
        return view;
    }

    public void initiateAdapter() {
        PetAdapter adapter = new PetAdapter(PetsConstructor.getHomePets(), getActivity());
        mRecyclerViewPets.setAdapter(adapter);
    }

}
