package com.socialbrothers.example.tcunnen.contactsapp.viewmodel;

import com.socialbrothers.example.tcunnen.contactsapp.R;
import com.socialbrothers.example.tcunnen.contactsapp.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class ContactsViewModel {

    private List<Contact> contactList;

    public ContactsViewModel(){

        contactList = new ArrayList<>();
        GenerateExampleData();
    }

    public List<Contact> getContactList() {
        return contactList;
    }

    private void GenerateExampleData(){


        contactList.add(new Contact("Kermit the Frog","Kermit@gmail.com",19551990, R.drawable.ic_person_blue_24dp));
        contactList.add(new Contact("Miss Piggy","MissPiggy@gmail.com",19762002,R.drawable.ic_person_blue_24dp));
        contactList.add(new Contact("Fozzie Bear","FozzieBear@gmail.com",19551990,R.drawable.ic_person_blue_24dp));
        contactList.add(new Contact("Gonzo","Gonzo@gmail.com",19551990,R.drawable.ic_person_blue_24dp));
        contactList.add(new Contact("Rowlf the Dog","RowlftheDog@gmail.com",19621990,R.drawable.ic_person_blue_24dp));
        contactList.add(new Contact("Scooter","Scooter@gmail.com",19761991,R.drawable.ic_person_blue_24dp));
        contactList.add(new Contact("Pepe the King Prawn","PepetheKingPrawn@gmail.com",19761991,R.drawable.ic_person_blue_24dp));
        contactList.add(new Contact("Rizzo the Rat","RizzotheRat@gmail.com",19802016,R.drawable.ic_person_blue_24dp));
        contactList.add(new Contact("Animal","Animal@gmail.com",19752000,R.drawable.ic_person_blue_24dp));
        contactList.add(new Contact("Walter","Walter@gmail.com",19761991,R.drawable.ic_person_blue_24dp));

    }
}
