package com.socialbrothers.example.tcunnen.contactsapp.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.socialbrothers.example.tcunnen.contactsapp.R;
import com.socialbrothers.example.tcunnen.contactsapp.adapter.ViewPagerAdapter;
import com.socialbrothers.example.tcunnen.contactsapp.fragment.AccountFragment;
import com.socialbrothers.example.tcunnen.contactsapp.fragment.RecyclerFragment;
import com.socialbrothers.example.tcunnen.contactsapp.model.Contact;
import com.socialbrothers.example.tcunnen.contactsapp.viewmodel.ContactsViewModel;

public class MainActivity extends AppCompatActivity {

    public final int GET_CONTACT_REQUEST = 1;
    private ViewPager viewPager;
    private ContactsViewModel contacts;
    private Contact me;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.contacts = new ContactsViewModel();
        this.me = new Contact("Tobias Cunnen", "t.cunnen@gmail.com", "0640698529", null);

        TabLayout tabLayout = findViewById(R.id.tab_layout_id);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setupViewPager();

        tabLayout.setupWithViewPager(viewPager);

        setupFAB();
    }

    private void setupViewPager() {

        viewPager = findViewById(R.id.viewpager_id);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        setupFragments(viewPagerAdapter);

        viewPager.setAdapter(viewPagerAdapter);
    }

    private void setupFragments(ViewPagerAdapter viewPagerAdapter) {

        RecyclerFragment recyclerFragment = new RecyclerFragment();
        Bundle recyclerBundle = new Bundle();
        recyclerBundle.putParcelableArrayList("contacts", contacts.getContactList());
        recyclerFragment.setArguments(recyclerBundle);

        viewPagerAdapter.AddFragment(recyclerFragment, "Contacts");

        AccountFragment accountFragment = new AccountFragment();
        Bundle accountBundle = new Bundle();
        accountBundle.putParcelable("account", me);
        accountFragment.setArguments(accountBundle);

        viewPagerAdapter.AddFragment(accountFragment, "Account");
    }

    private void setupFAB() {
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddContactActivity.class);
                startActivityForResult(intent, GET_CONTACT_REQUEST);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (GET_CONTACT_REQUEST == requestCode && resultCode == Activity.RESULT_OK) {
            if (data != null) {
                String name = data.getStringExtra("name");
                String phone = data.getStringExtra("phone");
                String mail = data.getStringExtra("mail");

                contacts.addContact(new Contact(name, mail, phone, null));
            }
        }
    }
}

