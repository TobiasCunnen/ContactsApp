package com.socialbrothers.example.tcunnen.contactsapp.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.socialbrothers.example.tcunnen.contactsapp.R;
import com.socialbrothers.example.tcunnen.contactsapp.adapter.ContactAdapter;
import com.socialbrothers.example.tcunnen.contactsapp.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class RecyclerFragment extends Fragment  implements SearchView.OnQueryTextListener, MenuItem.OnActionExpandListener {

    private View view;
    private List<Contact> contacts;
    private ContactAdapter contactAdapter;

    public RecyclerFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.recycler_fragment, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        contactAdapter = new ContactAdapter(getContext(), contacts);
        recyclerView.setAdapter(contactAdapter);

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        contacts = new ArrayList<>();
        exampleContacts();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_main, menu);

        MenuItem search = menu.findItem(R.id.actionSearchContacts);
        SearchView searchView = (SearchView) search.getActionView();
        searchView.setOnQueryTextListener(this);
    }


    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String input) {

        String userInput = input.toLowerCase();

        List<Contact> filterContactList = new ArrayList<>();

        for (Contact contact : contacts){
            if (contact.getName().toLowerCase().contains(userInput) || contact.getEmail().toLowerCase().contains(userInput)){
                filterContactList.add(contact);
            }
        }

        contactAdapter.setContactList(filterContactList);

        return true;
    }

    @Override
    public boolean onMenuItemActionExpand(MenuItem menuItem) {
        return false;
    }

    @Override
    public boolean onMenuItemActionCollapse(MenuItem menuItem) {
        return false;
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
