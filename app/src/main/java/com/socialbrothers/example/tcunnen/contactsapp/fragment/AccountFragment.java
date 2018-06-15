package com.socialbrothers.example.tcunnen.contactsapp.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.socialbrothers.example.tcunnen.contactsapp.R;
import com.socialbrothers.example.tcunnen.contactsapp.model.Contact;

public class AccountFragment extends Fragment {

    private Contact contact;

    private TextView name, mail, phone;
    private ImageView profilePicture;

    public AccountFragment(){

    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.account_fragment,container,false);

        name = view.findViewById(R.id.contactName);
        mail = view.findViewById(R.id.contactEmail);
        phone = view.findViewById(R.id.contactPhoneNumber);
        profilePicture = view.findViewById(R.id.profilePicture);

        Bundle bundle = this.getArguments();

        assert bundle != null;
        contact = bundle.getParcelable("account");


        name.setText(contact.getName());
        mail.setText(contact.getEmail());
        phone.setText(contact.getPhoneNumber());
        profilePicture.setImageResource(R.drawable.ic_person_blue_24dp);

        return view;
    }
}
