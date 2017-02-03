package com.joaquinalan.petagram.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.joaquinalan.petagram.R;
import com.joaquinalan.petagram.adapter.MyPetAdapter;
import com.joaquinalan.petagram.adapter.PetAdapter;
import com.joaquinalan.petagram.pojo.MyPetImage;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class PetProfileFragment extends Fragment {
    private ArrayList<MyPetImage> mMyPetImage;
    private RecyclerView rvMyPetImages;

    public PetProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_petprofile, container, false);
        rvMyPetImages = (RecyclerView) view.findViewById(R.id.recyclerview_petprofile_images);

        GridLayoutManager glm = new GridLayoutManager(getActivity(), 3);
        rvMyPetImages.setLayoutManager(glm);

        initializeMyPetImageList();
        initializeAdapter();
        return view;
    }

    public void initializeMyPetImageList() {
        mMyPetImage = new ArrayList<>();
        mMyPetImage.add(new MyPetImage(R.drawable.petprofile_babypig,0));
        mMyPetImage.add(new MyPetImage(R.drawable.petprofile_dirtypig,5));
        mMyPetImage.add(new MyPetImage(R.drawable.petprofile_humanpig,8));
        mMyPetImage.add(new MyPetImage(R.drawable.petprofile_smartpig,9));
        mMyPetImage.add(new MyPetImage(R.drawable.pig,9));
        mMyPetImage.add(new MyPetImage(R.drawable.pig,9));
        mMyPetImage.add(new MyPetImage(R.drawable.pig,9));
        mMyPetImage.add(new MyPetImage(R.drawable.pig,9));
        mMyPetImage.add(new MyPetImage(R.drawable.pig,9));
        mMyPetImage.add(new MyPetImage(R.drawable.pig,9));
        mMyPetImage.add(new MyPetImage(R.drawable.pig,9));
        mMyPetImage.add(new MyPetImage(R.drawable.pig,9));
    }

    public void initializeAdapter() {
        MyPetAdapter adapter = new MyPetAdapter(mMyPetImage, getActivity());
        rvMyPetImages.setAdapter(adapter);
    }

}
