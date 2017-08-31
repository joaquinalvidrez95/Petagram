package com.joaquinalan.petagram.view.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.joaquinalan.petagram.R;
import com.joaquinalan.petagram.interactor.PetsLatelyRatedInteractor;
import com.joaquinalan.petagram.view.fragment.PetsListFragment;

public class PetsLatelyRatedActivity extends AppCompatActivity {
    //private RecyclerView mRecyclerViewPetsLatelyLiked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_petslatelyrated);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_recentlylikedpets);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.recentlylikedpets_toolbartitle);
        getSupportActionBar().setIcon(R.drawable.ic_cat_footprint);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

//        mRecyclerViewPetsLatelyLiked = (RecyclerView) findViewById(R.id.recyclerview_recentlylikedpets);
//
//        LinearLayoutManager llmMyLayout = new LinearLayoutManager(this);
//        llmMyLayout.setOrientation(LinearLayoutManager.VERTICAL);
//
//        mRecyclerViewPetsLatelyLiked.setLayoutManager(llmMyLayout);
//
//        initializeAdapter();

        PetsListFragment petsListFragment = new PetsListFragment();
        petsListFragment.setInteractor(new PetsLatelyRatedInteractor());

        // Add the fragment to its container using a FragmentManager and a Transaction
        FragmentManager fragmentManager = getSupportFragmentManager();

        fragmentManager.beginTransaction()
                .add(R.id.fragment_petslatelyrated_petslist, petsListFragment)
                .commit();
    }

//    public void initializeAdapter() {
//        PetAdapter adapter = new PetAdapter(PetFactory.getPetsLatelyLiked(), this);
//        mRecyclerViewPetsLatelyLiked.setAdapter(adapter);
//    }
}
