package com.joaquinalan.petagram.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.joaquinalan.petagram.R;
import com.joaquinalan.petagram.view.adapter.PageAdapter;
import com.joaquinalan.petagram.view.fragment.HomeFragment;
import com.joaquinalan.petagram.view.fragment.PetProfileFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*Toolbar tbMyActionBar = (Toolbar) findViewById(R.id.tb_activity_main);
        setSupportActionBar(tbMyActionBar);

        getSupportActionBar().setTitle(R.string.app_name);
        getSupportActionBar().setIcon(R.drawable.ic_cat_footprint);*/

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_main);
        mTabLayout = (TabLayout) findViewById(R.id.tablayout_main);
        mViewPager = (ViewPager) findViewById(R.id.viewpager_main);

        setupViewPager();

        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle(R.string.app_name);
            getSupportActionBar().setIcon(R.drawable.ic_cat_footprint);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_options, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_optionsmenu_star:
                Intent recentlyLikedIntent = new Intent(this, RecentlyLikedPetsActivity.class);
                startActivity(recentlyLikedIntent);
                break;
            case R.id.item_optionsmenu_contact:
                Intent contactIntent = new Intent(this, ContactActivity.class);
                startActivity(contactIntent);
                break;
            case R.id.item_optionsmenu_about:
                Intent aboutIntent = new Intent(this, AboutActivity.class);
                startActivity(aboutIntent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setupViewPager() {
        mViewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), getFragments()));
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.getTabAt(0).setIcon(R.drawable.ic_home);
        mTabLayout.getTabAt(1).setIcon(R.drawable.ic_dog);
    }

    private List<Fragment> getFragments() {
        ArrayList<Fragment> fragmentArrayList = new ArrayList<>();

        fragmentArrayList.add(new HomeFragment());
        fragmentArrayList.add(new PetProfileFragment());
        return fragmentArrayList;
    }
}
