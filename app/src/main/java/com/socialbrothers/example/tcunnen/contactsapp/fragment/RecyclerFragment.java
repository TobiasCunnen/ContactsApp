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
import com.socialbrothers.example.tcunnen.contactsapp.activity.MainActivity;
import com.socialbrothers.example.tcunnen.contactsapp.adapter.ContactAdapter;
import com.socialbrothers.example.tcunnen.contactsapp.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class RecyclerFragment extends Fragment implements SearchView.OnQueryTextListener  {

    private List<Contact> contacts;
    private ContactAdapter contactAdapter;

    public RecyclerFragment() {
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recycler_fragment, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        Bundle bundle = this.getArguments();

        assert bundle != null;
        contacts = bundle.getParcelableArrayList("contacts");

        contactAdapter = new ContactAdapter(getContext(), contacts);
        recyclerView.setAdapter(contactAdapter);

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
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
}
