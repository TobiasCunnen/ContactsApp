package com.socialbrothers.example.tcunnen.contactsapp.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.socialbrothers.example.tcunnen.contactsapp.R;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;

public class AddContactActivity extends AppCompatActivity {

    private final int REQUEST_IMAGE_CAPTURE = 1;

    private EditText name, mail, phone;
    private ImageView profilePicture;
    private Bitmap imageBitmap;

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
        profilePicture = findViewById(R.id.profilePicture);

        profilePicture.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
                }
            }
        });
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            imageBitmap = (Bitmap) extras.get("data");
            profilePicture.setImageBitmap(imageBitmap);
        }
    }
}
