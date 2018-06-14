package com.socialbrothers.example.tcunnen.contactsapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;

import com.socialbrothers.example.tcunnen.contactsapp.fragment.ContactFragment;
import com.socialbrothers.example.tcunnen.contactsapp.R;
import com.socialbrothers.example.tcunnen.contactsapp.fragment.RecyclerFragment;
import com.socialbrothers.example.tcunnen.contactsapp.adapter.ViewPagerAdapter;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabLayout tabLayout = findViewById(R.id.tab_layout_id);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setupViewPager();

        tabLayout.setupWithViewPager(viewPager);

        setupFAB();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

    private void setupViewPager(){

        viewPager = findViewById(R.id.viewpager_id);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        viewPagerAdapter.AddFragment(new RecyclerFragment(), "Contacts");
        viewPagerAdapter.AddFragment(new ContactFragment(), "Account");

        viewPager.setAdapter(viewPagerAdapter);
    }

    private void setupFAB(){
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addContactIntent = new Intent(MainActivity.this,AddContactActivity.class);
                startActivity(addContactIntent);
            }
        });
    }
}
