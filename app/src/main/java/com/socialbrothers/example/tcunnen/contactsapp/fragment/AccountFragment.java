package com.socialbrothers.example.tcunnen.contactsapp.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.socialbrothers.example.tcunnen.contactsapp.R;
import com.socialbrothers.example.tcunnen.contactsapp.dto.RootQuoteDTO;
import com.socialbrothers.example.tcunnen.contactsapp.model.Contact;
import com.socialbrothers.example.tcunnen.contactsapp.model.Quote;

import org.json.JSONObject;

public class AccountFragment extends Fragment {

    private Contact contact;

    private TextView name, mail, phone, quoteView;
    private ImageView profilePicture;

    public AccountFragment() {

    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.account_fragment, container, false);

        name = view.findViewById(R.id.contactName);
        mail = view.findViewById(R.id.contactEmail);
        phone = view.findViewById(R.id.contactPhoneNumber);
        profilePicture = view.findViewById(R.id.profilePicture);
        quoteView = view.findViewById(R.id.quote);

        Bundle bundle = this.getArguments();

        assert bundle != null;
        contact = bundle.getParcelable("account");

        getQuote();

        name.setText(contact.getName());
        mail.setText(contact.getEmail());
        phone.setText(contact.getPhoneNumber());
        profilePicture.setImageResource(R.drawable.ic_person_blue_24dp);

        return view;
    }

    public void getQuote() {

        RequestQueue requestQueue = Volley.newRequestQueue(getContext());

        String url = "http://quotes.rest/qod.json";

        JsonObjectRequest objectRequest = new JsonObjectRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        response.remove("success");

                        Gson gson = new Gson();
                        RootQuoteDTO rootObject = gson.fromJson(response.toString(), RootQuoteDTO.class);

                        Quote quote = new Quote();

                        quote.setQuote(rootObject.getContents().getQuote(0).getQuote());
                        quote.setAuthor(rootObject.getContents().getQuote(0).getAuthor());

                        String dailyQuote = quote.getQuote() + " -" + quote.getAuthor();
                        quoteView.setText(dailyQuote);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Rest error", error.toString());
                    }
                }
        );
        requestQueue.add(objectRequest);
    }


}
