package com.socialbrothers.example.tcunnen.contactsapp;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ProductViewHolder> {


    private Context context;

    private List<Contact> contactList;

    public ContactAdapter(Context context, List<Contact> contactList) {
        this.context = context;
        this.contactList = contactList;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.layout_contact_card, null);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {

        Contact contact = contactList.get(position);

        holder.contactName.setText(contact.getName());
        holder.contactEmail.setText(contact.getEmail());
        holder.contactPhoneNumber.setText(String.valueOf(contact.getPhoneNumber()));

        holder.profilePicture.setImageDrawable(context.getResources().getDrawable(contact.getProfilePicture()));

    }


    @Override
    public int getItemCount() {
        return contactList.size();
    }


    class ProductViewHolder extends RecyclerView.ViewHolder {

        TextView contactName, contactEmail, contactPhoneNumber;
        ImageView profilePicture;

        public ProductViewHolder(View itemView) {
            super(itemView);

            contactName = itemView.findViewById(R.id.contactName);
            contactEmail = itemView.findViewById(R.id.contactEmail);
            contactPhoneNumber = itemView.findViewById(R.id.contactPhoneNumber);
            profilePicture = itemView.findViewById(R.id.profilePicture);
        }
    }
}