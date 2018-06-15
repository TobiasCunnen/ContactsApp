package com.socialbrothers.example.tcunnen.contactsapp.dto;

import java.util.ArrayList;

public class ContentsDTO {
    private ArrayList<QuoteDTO> quotes;

    public ArrayList<QuoteDTO> getQuotes() { return this.quotes; }

    public QuoteDTO getQuote (int i){return this.quotes.get(i);}

    public void setQuotes(ArrayList<QuoteDTO> quotes) { this.quotes = quotes; }

    private String copyright;

    public String getCopyright() { return this.copyright; }

    public void setCopyright(String copyright) { this.copyright = copyright; }
}
