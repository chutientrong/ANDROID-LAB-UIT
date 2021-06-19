package com.example.lab3_2;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ContactAdapter extends ArrayAdapter<Contact> {
    private Activity context;
    private List<Contact> contactList;

    public ContactAdapter(Activity context, int layoutID, List<Contact> objects){
        super(context,layoutID,objects);
        this.context = context;
    }

    @Override
    public View getView(final int position, View converView, ViewGroup parent) {
        if(converView == null) {
            converView = LayoutInflater.from(context).inflate(R.layout.item_contact, null, false);
        }

        Contact contact = getItem(position);

        // GetView
        TextView textView = (TextView) converView.findViewById(R.id.tv_contact);

        // Set contact
        if(contact.getName() != null) {
            textView.setText("Id: " + contact.getId() + ", Name: " + contact.getName() + ", Phone Number: "+ contact.getPhoneNumber());
        }
        return converView;
    }

    public void setContactList(List<Contact> object) {
        this.contactList = object;
    }
}
