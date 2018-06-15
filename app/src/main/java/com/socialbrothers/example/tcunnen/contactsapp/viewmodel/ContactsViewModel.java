package com.socialbrothers.example.tcunnen.contactsapp.viewmodel;

import android.content.Context;
import com.socialbrothers.example.tcunnen.contactsapp.model.Contact;

import java.util.ArrayList;


public class ContactsViewModel {

    private ArrayList<Contact> contactList;

    public ContactsViewModel(Context context){

        contactList = new ArrayList<>();
        GenerateExampleData(context);
    }

    public ArrayList<Contact> getContactList() {
        return contactList;
    }

    private void GenerateExampleData(Context context){

        contactList.add(new Contact("Kermit the Frog","Kermit@gmail.com","19551990",null));
        contactList.add(new Contact("Miss Piggy","MissPiggy@gmail.com", "19762002",null));
        contactList.add(new Contact("Fozzie Bear","FozzieBear@gmail.com","19551990",null));
        contactList.add(new Contact("Gonzo","Gonzo@gmail.com","19551990",null));
        contactList.add(new Contact("Rowlf the Dog","RowlftheDog@gmail.com","19621990",null));
        contactList.add(new Contact("Scooter","Scooter@gmail.com","19761991",null));
        contactList.add(new Contact("Pepe the King Prawn","PepetheKingPrawn@gmail.com","19761991",null));
        contactList.add(new Contact("Rizzo the Rat","RizzotheRat@gmail.com","19802016",null));
        contactList.add(new Contact("Animal","Animal@gmail.com","19752000",null));
        contactList.add(new Contact("Walter","Walter@gmail.com","19761991",null));

    }

    public void addContact(Contact contact) {
        this.contactList.add(contact);
    }
}
