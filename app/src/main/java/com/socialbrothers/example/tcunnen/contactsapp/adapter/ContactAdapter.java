package com.socialbrothers.example.tcunnen.contactsapp.adapter;


import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.socialbrothers.example.tcunnen.contactsapp.R;
import com.socialbrothers.example.tcunnen.contactsapp.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {

    private Context context;
    private List<Contact> contactList;

    public ContactAdapter(Context context, List<Contact> contactList) {
        this.context = context;
        this.contactList = contactList;
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.layout_contact_card,parent,false);

        return new ContactViewHolder(view,context);
    }

    @Override
    public void onBindViewHolder(ContactViewHolder holder, int position) {

        Contact contact = contactList.get(position);

        holder.contactName.setText(contact.getName());
        holder.contactEmail.setText(contact.getEmail());
        holder.contactPhoneNumber.setText(String.valueOf(contact.getPhoneNumber()));

        if(contact.getBitmapProfilePicture()!=null){
            holder.profilePicture.setImageBitmap(contact.getBitmapProfilePicture());
        }else {
            Glide.with(context)
                    .load(R.drawable.ic_person_blue_24dp)
                    .into(holder.profilePicture);
        }
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    public void setContactList(List<Contact> contactList) {
        this.contactList = new ArrayList<>();
        this.contactList.addAll(contactList);
        notifyDataSetChanged();
    }

    class ContactViewHolder extends RecyclerView.ViewHolder {

        TextView contactName, contactEmail, contactPhoneNumber;
        ImageView profilePicture;
        Context context;

        private ContactViewHolder(View itemView , Context context) {
            super(itemView);

            this.context = context;

            this.contactName = itemView.findViewById(R.id.contactName);
            this.contactEmail = itemView.findViewById(R.id.contactEmail);
            this.contactPhoneNumber = itemView.findViewById(R.id.contactPhoneNumber);
            this.profilePicture = itemView.findViewById(R.id.profilePicture);

            initOnTextViewClick();
        }

        private void initOnTextViewClick() {

            contactEmail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent mailIntent = new Intent(Intent.ACTION_SEND);
                    mailIntent.setType("text/plain");
                    mailIntent.putExtra(Intent.EXTRA_EMAIL, new String[] { contactEmail.getText().toString() });

                    context.startActivity(Intent.createChooser(mailIntent, contactEmail.getText().toString()));
                }
            });

            contactPhoneNumber.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent callIntent = new Intent(Intent.ACTION_DIAL);
                    callIntent.setData(Uri.parse("tel:" +contactPhoneNumber.getText().toString()));
                    context.startActivity(callIntent);
                }
            });
        }
    }
}