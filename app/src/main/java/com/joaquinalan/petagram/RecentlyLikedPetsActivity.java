package com.joaquinalan.petagram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.joaquinalan.petagram.adapter.PetAdapter;
import com.joaquinalan.petagram.pojo.Pet;

import java.util.ArrayList;

public class RecentlyLikedPetsActivity extends AppCompatActivity {
    private ArrayList<Pet> mPetList;
    private RecyclerView rvPets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recentlylikedpets);

        Toolbar tbMyActionBar = (Toolbar) findViewById(R.id.toolbar_recentlylikedpets);
        setSupportActionBar(tbMyActionBar);
        getSupportActionBar().setTitle(R.string.recentlylikedpets_toolbartitle);
        getSupportActionBar().setIcon(R.drawable.ic_cat_footprint);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        rvPets = (RecyclerView) findViewById(R.id.recyclerview_recentlylikedpets);

        LinearLayoutManager llmMyLayout = new LinearLayoutManager(this);
        llmMyLayout.setOrientation(LinearLayoutManager.VERTICAL);

        rvPets.setLayoutManager(llmMyLayout);

        initializePetList();
        initializeAdapter();
    }

    public void initializePetList() {
        mPetList = new ArrayList<>();
        mPetList.add(new Pet("Mickey", 0, R.drawable.rat));
        mPetList.add(new Pet("Toño", 0, R.drawable.tiger));
        mPetList.add(new Pet("Bobby", 0, R.drawable.lion));
        mPetList.add(new Pet("Lassie", 0, R.drawable.rough_collie));
        mPetList.add(new Pet("Gatillo", 0, R.drawable.cat));
    }

    public void initializeAdapter() {
        PetAdapter adapter = new PetAdapter(mPetList, this);
        rvPets.setAdapter(adapter);
    }
}
