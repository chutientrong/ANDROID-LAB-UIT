package com.example.lab3_2;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final DatabaseHandler db = new DatabaseHandler(this);

        db.addContact(new Contact("Ravi", "9100000000"));
        db.addContact(new Contact("Srinivas", "9199999999"));
        db.addContact(new Contact("Tommy", "9522222222"));
        db.addContact(new Contact("Karthik", "9533333333"));

        final List<Contact> contactList = db.getAllContacts();
        ListView listView = (ListView) findViewById(R.id.lv_contact);
        final ContactAdapter contactAdapter = new ContactAdapter(MainActivity.this, R.layout.item_contact, contactList);
        listView.setAdapter(contactAdapter);
        for (Contact cn : contactList) {
            String log = "Id: "+cn.getId()+" ,Name: " + cn.getName() + " ,Phone: " + cn.getPhoneNumber();
            // Writing Contacts to log
            Log.e("Name: ", log);
        }

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
//                String seletedItem = parent.getItemAtPosition(position).toString();
//                contacts.remove(seletedItem);
                Contact contact = contactList.get(position);
                db.deleteContact(contact);
                contactList.remove(contact);
                contactAdapter.setContactList(contactList);
                contactAdapter.notifyDataSetChanged();
                return false;
            }
        });
    }
}
