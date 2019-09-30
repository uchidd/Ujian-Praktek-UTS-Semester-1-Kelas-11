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
        db.execSQL(ListTransaction.CREATE_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + ListTransaction.TABLE_NAME);

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
        values.put(ListTransaction.COLUMN_BRAND, brand);
        values.put(ListTransaction.COLUMN_NAME, name);
        values.put(ListTransaction.COLUMN_COLOR, color);
        values.put(ListTransaction.COLUMN_PRICE, price);
        values.put(ListTransaction.COLUMN_SIZE, size);
        values.put(ListTransaction.COLUMN_QUANTITY, quantity);
        values.put(ListTransaction.COLUMN_SUBTOTAL, subtotal);
        values.put(ListTransaction.COLUMN_RECIPIENT, recipient);
        values.put(ListTransaction.COLUMN_PHONE, phone);
        values.put(ListTransaction.COLUMN_ADDRESS, address);
        values.put(ListTransaction.COLUMN_METHODSHIPPING, methodshipping);
        values.put(ListTransaction.COLUMN_TAX, tax);
        values.put(ListTransaction.COLUMN_METHODPAYMENT, methodpayment);
        values.put(ListTransaction.COLUMN_TOTAL, total);

        // insert row
        long id = db.insert(ListTransaction.TABLE_NAME, null, values);

        // close db connection
        db.close();

        // return newly inserted row id
        return id;
    }

    public ListTransaction getNote(long id) {
        // get readable database as we are not inserting anything
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(ListTransaction.TABLE_NAME,
                new String[]{
                        ListTransaction.COLUMN_ID,
                        ListTransaction.COLUMN_BRAND,
                        ListTransaction.COLUMN_NAME,
                        ListTransaction.COLUMN_COLOR,
                        ListTransaction.COLUMN_PRICE,
                        ListTransaction.COLUMN_SIZE,
                        ListTransaction.COLUMN_QUANTITY,
                        ListTransaction.COLUMN_SUBTOTAL,
                        ListTransaction.COLUMN_RECIPIENT,
                        ListTransaction.COLUMN_PHONE,
                        ListTransaction.COLUMN_ADDRESS,
                        ListTransaction.COLUMN_METHODSHIPPING,
                        ListTransaction.COLUMN_TAX,
                        ListTransaction.COLUMN_METHODPAYMENT,
                        ListTransaction.COLUMN_TOTAL,
                        ListTransaction.COLUMN_TRANSACTIONDATE
                },
                ListTransaction.COLUMN_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        // prepare note object
        ListTransaction list = new ListTransaction(
                cursor.getInt(cursor.getColumnIndex(ListTransaction.COLUMN_ID)),
                cursor.getString(cursor.getColumnIndex(ListTransaction.COLUMN_BRAND)),
                cursor.getString(cursor.getColumnIndex(ListTransaction.COLUMN_NAME)),
                cursor.getString(cursor.getColumnIndex(ListTransaction.COLUMN_COLOR)),
                cursor.getString(cursor.getColumnIndex(ListTransaction.COLUMN_PRICE)),
                cursor.getInt(cursor.getColumnIndex(ListTransaction.COLUMN_SIZE)),
                cursor.getInt(cursor.getColumnIndex(ListTransaction.COLUMN_QUANTITY)),
                cursor.getString(cursor.getColumnIndex(ListTransaction.COLUMN_SUBTOTAL)),
                cursor.getString(cursor.getColumnIndex(ListTransaction.COLUMN_RECIPIENT)),
                cursor.getString(cursor.getColumnIndex(ListTransaction.COLUMN_PHONE)),
                cursor.getString(cursor.getColumnIndex(ListTransaction.COLUMN_ADDRESS)),
                cursor.getString(cursor.getColumnIndex(ListTransaction.COLUMN_METHODSHIPPING)),
                cursor.getString(cursor.getColumnIndex(ListTransaction.COLUMN_TAX)),
                cursor.getString(cursor.getColumnIndex(ListTransaction.COLUMN_METHODPAYMENT)),
                cursor.getString(cursor.getColumnIndex(ListTransaction.COLUMN_TOTAL)),
                cursor.getString(cursor.getColumnIndex(ListTransaction.COLUMN_TRANSACTIONDATE)));
        // close the db connection
        cursor.close();

        return list;
    }

    public java.util.List getAllNotes() {
        java.util.List notes = new ArrayList<>();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + ListTransaction.TABLE_NAME + " ORDER BY " +
                ListTransaction.COLUMN_TRANSACTIONDATE + " DESC";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                ListTransaction list = new ListTransaction();
                list.setId(cursor.getInt(cursor.getColumnIndex(ListTransaction.COLUMN_ID)));
                list.setBrand(cursor.getString(cursor.getColumnIndex(ListTransaction.COLUMN_BRAND)));
                list.setName(cursor.getString(cursor.getColumnIndex(ListTransaction.COLUMN_NAME)));
                list.setColor(cursor.getString(cursor.getColumnIndex(ListTransaction.COLUMN_COLOR)));
                list.setPrice(cursor.getString(cursor.getColumnIndex(ListTransaction.COLUMN_PRICE)));
                list.setSize(cursor.getInt(cursor.getColumnIndex(ListTransaction.COLUMN_SIZE)));
                list.setQuantity(cursor.getInt(cursor.getColumnIndex(ListTransaction.COLUMN_QUANTITY)));
                list.setSubtotal(cursor.getString(cursor.getColumnIndex(ListTransaction.COLUMN_SUBTOTAL)));
                list.setRecipient(cursor.getString(cursor.getColumnIndex(ListTransaction.COLUMN_RECIPIENT)));
                list.setPhone(cursor.getString(cursor.getColumnIndex(ListTransaction.COLUMN_PHONE)));
                list.setAddress(cursor.getString(cursor.getColumnIndex(ListTransaction.COLUMN_ADDRESS)));
                list.setMethodshipping(cursor.getString(cursor.getColumnIndex(ListTransaction.COLUMN_METHODSHIPPING)));
                list.setTax(cursor.getString(cursor.getColumnIndex(ListTransaction.COLUMN_TAX)));
                list.setMethodpayment(cursor.getString(cursor.getColumnIndex(ListTransaction.COLUMN_METHODPAYMENT)));
                list.setTotal(cursor.getString(cursor.getColumnIndex(ListTransaction.COLUMN_TOTAL)));
                list.setTransactiondate(cursor.getString(cursor.getColumnIndex(ListTransaction.COLUMN_TRANSACTIONDATE)));

                notes.add(list);
            } while (cursor.moveToNext());
        }

        // close db connection
        db.close();

        // return notes list
        return notes;
    }

    public int getNotesCount() {
        String countQuery = "SELECT  * FROM " + ListTransaction.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();
        cursor.close();


        // return count
        return count;
    }

    public int updateNote(ListTransaction list) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(ListTransaction.COLUMN_NAME, list.getName());

        // updating row
        return db.update(ListTransaction.TABLE_NAME, values, ListTransaction.COLUMN_ID + " = ?",
                new String[]{String.valueOf(list.getId())});
    }

    public void deleteNote(ListTransaction list) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(ListTransaction.TABLE_NAME, ListTransaction.COLUMN_ID + " = ?",
                new String[]{String.valueOf(list.getId())});
        db.close();
    }
}