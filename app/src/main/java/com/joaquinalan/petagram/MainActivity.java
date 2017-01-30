package com.joaquinalan.petagram;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Pet> mPetList;
    private RecyclerView rvPets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar tbMyActionBar = (Toolbar) findViewById(R.id.action_bar);
        setSupportActionBar(tbMyActionBar);

        getSupportActionBar().setTitle(R.string.app_name);
        getSupportActionBar().setIcon(R.drawable.ic_cat_footprint);

        rvPets = (RecyclerView) findViewById(R.id.rv_pets);

        LinearLayoutManager llmMyLayout = new LinearLayoutManager(this);
        llmMyLayout.setOrientation(LinearLayoutManager.VERTICAL);

        rvPets.setLayoutManager(llmMyLayout);

        initializePetList();
        initializeAdapter();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_options, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.m_options_star:
                Intent recentlyLikedIntent = new Intent(this, RecentlyLikedPetsActivity.class);
                startActivity(recentlyLikedIntent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void initializePetList() {
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

    public void initializeAdapter() {
        PetAdapter adapter = new PetAdapter(mPetList, this);
        rvPets.setAdapter(adapter);
    }
}
