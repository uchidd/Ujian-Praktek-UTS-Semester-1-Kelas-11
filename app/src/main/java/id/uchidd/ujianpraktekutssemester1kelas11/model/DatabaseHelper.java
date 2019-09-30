package id.uchidd.ujianpraktekutssemester1kelas11.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 2;

    // Database Name
    private static final String DATABASE_NAME = "db_list_transaction";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {

        // create notes table
        db.execSQL(List.CREATE_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + List.TABLE_NAME);

        // Create tables again
        onCreate(db);
    }

    public long insertNote(String brand,
                           String name,
                           String color,
                           String price,
                           int size,
                           int quantity,
                           String subtotal,
                           String recipient,
                           String phone,
                           String address,
                           String methodshipping,
                           String tax,
                           String methodpayment,
                           String total) {
        // get writable database as we want to write data
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        // `id` and `timestamp` will be inserted automatically.
        // no need to add them
        values.put(List.COLUMN_BRAND, brand);
        values.put(List.COLUMN_NAME, name);
        values.put(List.COLUMN_COLOR, color);
        values.put(List.COLUMN_PRICE, price);
        values.put(List.COLUMN_SIZE, size);
        values.put(List.COLUMN_QUANTITY, quantity);
        values.put(List.COLUMN_SUBTOTAL, subtotal);
        values.put(List.COLUMN_RECIPIENT, recipient);
        values.put(List.COLUMN_PHONE, phone);
        values.put(List.COLUMN_ADDRESS, address);
        values.put(List.COLUMN_METHODSHIPPING, methodshipping);
        values.put(List.COLUMN_TAX, tax);
        values.put(List.COLUMN_METHODPAYMENT, methodpayment);
        values.put(List.COLUMN_TOTAL, total);

        // insert row
        long id = db.insert(List.TABLE_NAME, null, values);

        // close db connection
        db.close();

        // return newly inserted row id
        return id;
    }

    public List getNote(long id) {
        // get readable database as we are not inserting anything
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(List.TABLE_NAME,
                new String[]{
                        List.COLUMN_ID,
                        List.COLUMN_BRAND,
                        List.COLUMN_NAME,
                        List.COLUMN_COLOR,
                        List.COLUMN_PRICE,
                        List.COLUMN_SIZE,
                        List.COLUMN_QUANTITY,
                        List.COLUMN_SUBTOTAL,
                        List.COLUMN_RECIPIENT,
                        List.COLUMN_PHONE,
                        List.COLUMN_ADDRESS,
                        List.COLUMN_METHODSHIPPING,
                        List.COLUMN_TAX,
                        List.COLUMN_METHODPAYMENT,
                        List.COLUMN_TOTAL,
                        List.COLUMN_TRANSACTIONDATE
                },
                List.COLUMN_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        // prepare note object
        List list = new List(
                cursor.getInt(cursor.getColumnIndex(List.COLUMN_ID)),
                cursor.getString(cursor.getColumnIndex(List.COLUMN_BRAND)),
                cursor.getString(cursor.getColumnIndex(List.COLUMN_NAME)),
                cursor.getString(cursor.getColumnIndex(List.COLUMN_COLOR)),
                cursor.getString(cursor.getColumnIndex(List.COLUMN_PRICE)),
                cursor.getInt(cursor.getColumnIndex(List.COLUMN_SIZE)),
                cursor.getInt(cursor.getColumnIndex(List.COLUMN_QUANTITY)),
                cursor.getString(cursor.getColumnIndex(List.COLUMN_SUBTOTAL)),
                cursor.getString(cursor.getColumnIndex(List.COLUMN_RECIPIENT)),
                cursor.getString(cursor.getColumnIndex(List.COLUMN_PHONE)),
                cursor.getString(cursor.getColumnIndex(List.COLUMN_ADDRESS)),
                cursor.getString(cursor.getColumnIndex(List.COLUMN_METHODSHIPPING)),
                cursor.getString(cursor.getColumnIndex(List.COLUMN_TAX)),
                cursor.getString(cursor.getColumnIndex(List.COLUMN_METHODPAYMENT)),
                cursor.getString(cursor.getColumnIndex(List.COLUMN_TOTAL)),
                cursor.getString(cursor.getColumnIndex(List.COLUMN_TRANSACTIONDATE)));
        // close the db connection
        cursor.close();

        return list;
    }

    public java.util.List getAllNotes() {
        java.util.List notes = new ArrayList<>();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + List.TABLE_NAME + " ORDER BY " +
                List.COLUMN_TRANSACTIONDATE + " DESC";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                List list = new List();
                list.setId(cursor.getInt(cursor.getColumnIndex(List.COLUMN_ID)));
                list.setBrand(cursor.getString(cursor.getColumnIndex(List.COLUMN_BRAND)));
                list.setName(cursor.getString(cursor.getColumnIndex(List.COLUMN_NAME)));
                list.setColor(cursor.getString(cursor.getColumnIndex(List.COLUMN_COLOR)));
                list.setPrice(cursor.getString(cursor.getColumnIndex(List.COLUMN_PRICE)));
                list.setSize(cursor.getInt(cursor.getColumnIndex(List.COLUMN_SIZE)));
                list.setQuantity(cursor.getInt(cursor.getColumnIndex(List.COLUMN_QUANTITY)));
                list.setSubtotal(cursor.getString(cursor.getColumnIndex(List.COLUMN_SUBTOTAL)));
                list.setRecipient(cursor.getString(cursor.getColumnIndex(List.COLUMN_RECIPIENT)));
                list.setPhone(cursor.getString(cursor.getColumnIndex(List.COLUMN_PHONE)));
                list.setAddress(cursor.getString(cursor.getColumnIndex(List.COLUMN_ADDRESS)));
                list.setMethodshipping(cursor.getString(cursor.getColumnIndex(List.COLUMN_METHODSHIPPING)));
                list.setTax(cursor.getString(cursor.getColumnIndex(List.COLUMN_TAX)));
                list.setMethodpayment(cursor.getString(cursor.getColumnIndex(List.COLUMN_METHODPAYMENT)));
                list.setTotal(cursor.getString(cursor.getColumnIndex(List.COLUMN_TOTAL)));
                list.setTransactiondate(cursor.getString(cursor.getColumnIndex(List.COLUMN_TRANSACTIONDATE)));

                notes.add(list);
            } while (cursor.moveToNext());
        }

        // close db connection
        db.close();

        // return notes list
        return notes;
    }

    public int getNotesCount() {
        String countQuery = "SELECT  * FROM " + List.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();
        cursor.close();


        // return count
        return count;
    }

    public int updateNote(List list) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(List.COLUMN_NAME, list.getName());

        // updating row
        return db.update(List.TABLE_NAME, values, List.COLUMN_ID + " = ?",
                new String[]{String.valueOf(list.getId())});
    }

    public void deleteNote(List list) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(List.TABLE_NAME, List.COLUMN_ID + " = ?",
                new String[]{String.valueOf(list.getId())});
        db.close();
    }
}