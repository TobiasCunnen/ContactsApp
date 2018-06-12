package com.socialbrothers.example.tcunnen.contactsapp;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.layout_contact_card, null);

        return new ContactViewHolder(view,context);
    }

    @Override
    public void onBindViewHolder(ContactViewHolder holder, int position) {

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

                    context.startActivity(Intent.createChooser(mailIntent, "Send Email"));


                }
            });

            contactPhoneNumber.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:" +contactPhoneNumber.getText().toString()));
                    context.startActivity(intent);
                }
            });
        }
    }
}