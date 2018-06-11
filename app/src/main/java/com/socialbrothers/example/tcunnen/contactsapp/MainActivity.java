package com.socialbrothers.example.tcunnen.contactsapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
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

    private void exampleContacts(){
        contacts.add(new Contact("Kermit the Frog","Kermit@gmail.com",19551990,R.mipmap.ic_launcher_round));
        contacts.add(new Contact("Miss Piggy","MissPiggy@gmail.com",19762002,R.mipmap.ic_launcher_round));
        contacts.add(new Contact("Fozzie Bear","FozzieBear@gmail.com",19551990,R.mipmap.ic_launcher_round));
        contacts.add(new Contact("Gonzo","Gonzo@gmail.com",19551990,R.mipmap.ic_launcher_round));
        contacts.add(new Contact("Rowlf the Dog","RowlftheDog@gmail.com",19621990,R.mipmap.ic_launcher_round));
        contacts.add(new Contact("Scooter","Scooter@gmail.com",19761991,R.mipmap.ic_launcher_round));
        contacts.add(new Contact("Pepe the King Prawn","PepetheKingPrawn@gmail.com",19761991,R.mipmap.ic_launcher_round));
        contacts.add(new Contact("Rizzo the Rat","RizzotheRat@gmail.com",19802016,R.mipmap.ic_launcher_round));
        contacts.add(new Contact("Animal","Animal@gmail.com",19752000,R.mipmap.ic_launcher_round));
        contacts.add(new Contact("Walter","Walter@gmail.com",19761991,R.mipmap.ic_launcher_round));
    }
}
