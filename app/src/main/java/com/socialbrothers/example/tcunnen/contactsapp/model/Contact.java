package com.socialbrothers.example.tcunnen.contactsapp.model;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

public class Contact implements Parcelable {

    private String name;
    private String email;
    private String phoneNumber;
    private Bitmap bitmapProfilePicture;

    public Contact(String name, String email, String phoneNumber, Bitmap profilePhoto) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.bitmapProfilePicture = profilePhoto;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Bitmap getBitmapProfilePicture() {
        return bitmapProfilePicture;
    }

    public void setBitmapProfilePicture(Bitmap bitmapProfilePicture) {
        this.bitmapProfilePicture = bitmapProfilePicture;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

    }
}
