package com.joaquinalan.petagram.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.joaquinalan.petagram.R;

public class PetsLatelyLikedActivity extends AppCompatActivity {
    //private RecyclerView mRecyclerViewPetsLatelyLiked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_petslatelyliked);

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
    }

//    public void initializeAdapter() {
//        PetAdapter adapter = new PetAdapter(PetsConstructor.getPetsLatelyLiked(), this);
//        mRecyclerViewPetsLatelyLiked.setAdapter(adapter);
//    }
}
