package com.socialbrothers.example.tcunnen.contactsapp;

public class Contact {

    private String name;
    private String email;
    private int phoneNumber;
    private int profilePicture;

    public Contact(String name, String email, int phoneNumber, int profilePhoto) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.profilePicture = profilePhoto;
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

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(int profilePicture) {
        this.profilePicture = profilePicture;
    }
}
