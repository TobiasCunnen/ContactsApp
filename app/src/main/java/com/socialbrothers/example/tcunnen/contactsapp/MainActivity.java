package com.socialbrothers.example.tcunnen.contactsapp;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //a list to store all the products
    List<Contact> contacts;

    //the recyclerview
    RecyclerView recyclerView;

    private SectionsStatePagerAdapter sectionsStatePagerAdapter;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        sectionsStatePagerAdapter = new SectionsStatePagerAdapter(getSupportFragmentManager());

        viewPager = findViewById(R.id.containter);

        setupViewPager(viewPager);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(2);
            }
        });

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        contacts = new ArrayList<>();

        exampleContacts();

        ContactAdapter adapter = new ContactAdapter(this, contacts);

        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void setupViewPager(ViewPager viewPager){
        SectionsStatePagerAdapter adapter = new SectionsStatePagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new AddContactFragment(), "AddContactFragment");
        viewPager.setAdapter(adapter);
    }

    private void exampleContacts(){
        contacts.add(new Contact("Kermit the Frog","Kermit@gmail.com",19551990,R.drawable.ic_person_blue_24dp));
        contacts.add(new Contact("Miss Piggy","MissPiggy@gmail.com",19762002,R.drawable.ic_person_blue_24dp));
        contacts.add(new Contact("Fozzie Bear","FozzieBear@gmail.com",19551990,R.drawable.ic_person_blue_24dp));
        contacts.add(new Contact("Gonzo","Gonzo@gmail.com",19551990,R.drawable.ic_person_blue_24dp));
        contacts.add(new Contact("Rowlf the Dog","RowlftheDog@gmail.com",19621990,R.drawable.ic_person_blue_24dp));
        contacts.add(new Contact("Scooter","Scooter@gmail.com",19761991,R.drawable.ic_person_blue_24dp));
        contacts.add(new Contact("Pepe the King Prawn","PepetheKingPrawn@gmail.com",19761991,R.drawable.ic_person_blue_24dp));
        contacts.add(new Contact("Rizzo the Rat","RizzotheRat@gmail.com",19802016,R.drawable.ic_person_blue_24dp));
        contacts.add(new Contact("Animal","Animal@gmail.com",19752000,R.drawable.ic_person_blue_24dp));
        contacts.add(new Contact("Walter","Walter@gmail.com",19761991,R.drawable.ic_person_blue_24dp));
    }
}
