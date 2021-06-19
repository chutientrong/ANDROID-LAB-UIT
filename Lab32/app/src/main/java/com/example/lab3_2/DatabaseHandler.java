package com.example.lab3_2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {
    private static final String DATABASE_CREATE = "create table contactsManager (_id integer primary key autoincrement, name text not null, phone_number text not null)";
    private static final int DATABASE_VERSION = 1;
    private SQLiteDatabase sqLiteDatabase;

    private static final String DATABASE_NAME = "DBManagers";
    private static final String DATABASE_TABLE = "contactsManager";

    public static final String KEY_ID = "_id";
    public static final String KEY_NAME = "name";
    public static final String KEY_PH_NO = "phone_number";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME,null,DATABASE_VERSION);
        sqLiteDatabase = this.getWritableDatabase();
    }

    public void close(){
        this.close();
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS contactsManager");
        onCreate(db);
    }

    // Add new contact
    public void addContact(Contact contact) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_NAME, contact.getName());
        contentValues.put(KEY_PH_NO, contact.getPhoneNumber());
        long result = sqLiteDatabase.insert(DATABASE_TABLE, null, contentValues);
    }

    // Getting single contact
    public Contact getContact(int id) {
        Contact contact = new Contact();
        Cursor cursor = sqLiteDatabase.query(DATABASE_TABLE, new String[] {KEY_ID,KEY_NAME,KEY_PH_NO}, KEY_ID + "=" + id, null, null, null, null);
        while (cursor.moveToNext()) {
            contact.setId(cursor.getInt(cursor.getColumnIndex(KEY_ID)));
            contact.setName(cursor.getString(cursor.getColumnIndex(KEY_NAME)));
            contact.setPhoneNumber(cursor.getString(cursor.getColumnIndex(KEY_PH_NO)));
        }

        return contact;
    }

    // Getting All Contacts
    public List<Contact> getAllContacts() {
        Cursor cursor = sqLiteDatabase.query(DATABASE_TABLE, new String[] {KEY_ID,KEY_NAME,KEY_PH_NO}, null,null,null,null,null);
        List<Contact> list_contact = new ArrayList<Contact>();
        while(cursor.moveToNext()){
            Contact contact = new Contact();
            contact.setId(cursor.getInt(cursor.getColumnIndex(KEY_ID)));
            contact.setName(cursor.getString(cursor.getColumnIndex(KEY_NAME)));
            contact.setPhoneNumber(cursor.getString(cursor.getColumnIndex(KEY_PH_NO)));
            list_contact.add(contact);
        }
        return list_contact;
    }

    // Updating single contact
    public int updateContact(Contact contact) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_ID, contact.getId());
        contentValues.put(KEY_NAME, contact.getName());
        contentValues.put(KEY_PH_NO,contact.getPhoneNumber());
        return sqLiteDatabase.update(DATABASE_TABLE,contentValues, KEY_ID + "=" + contact.getId(),null);
    }

    // Deleting single contact
    public void deleteContact(Contact contact) {
        sqLiteDatabase.delete(DATABASE_TABLE, KEY_ID + "=" + contact.getId(), null);
    }

}
