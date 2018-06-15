package com.socialbrothers.example.tcunnen.contactsapp.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;

import com.socialbrothers.example.tcunnen.contactsapp.R;

public class AddContactActivity extends AppCompatActivity {

    private EditText name, mail, phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        ActionBar actionBar = getSupportActionBar();

        if(actionBar != null){
            actionBar.setTitle(R.string.add_contact_title);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        name = findViewById(R.id.contactName);
        mail = findViewById(R.id.contactEmail);
        phone = findViewById(R.id.contactPhoneNumber);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_add_contact_activity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.actionSave:
                createResultIntent();
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void createResultIntent() {
        Intent returnIntent = new Intent();

        returnIntent.putExtra("name",name.getText().toString());
        returnIntent.putExtra("phone",phone.getText().toString());
        returnIntent.putExtra("mail",mail.getText().toString());

        setResult(Activity.RESULT_OK,returnIntent);
    }
}
