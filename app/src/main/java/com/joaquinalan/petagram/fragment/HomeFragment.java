package com.joaquinalan.petagram.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.joaquinalan.petagram.R;
import com.joaquinalan.petagram.adapter.PetAdapter;
import com.joaquinalan.petagram.pojo.Pet;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    private ArrayList<Pet> mPetList;
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

        initiatePetList();
        initiateAdapter();
        return view;
    }

    public void initiatePetList() {
        mPetList = new ArrayList<>();
        mPetList.add(new Pet("Melanie", 0, R.drawable.pig));
        mPetList.add(new Pet("Bobby", 0, R.drawable.lion));
        mPetList.add(new Pet("Lassie", 0, R.drawable.rough_collie));
        mPetList.add(new Pet("Ramón", 0, R.drawable.schnauzer));
        mPetList.add(new Pet("Gatillo", 0, R.drawable.cat));
        mPetList.add(new Pet("Toño", 0, R.drawable.tiger));
        mPetList.add(new Pet("Omar", 0, R.drawable.nigga));
        mPetList.add(new Pet("Mickey", 0, R.drawable.rat));
        mPetList.add(new Pet("Rathalos", 0, R.drawable.dragon));
    }

    public void initiateAdapter() {
        PetAdapter adapter = new PetAdapter(mPetList, getActivity());
        mRecyclerViewPets.setAdapter(adapter);
    }

}
