package id.uchidd.ujianpraktekutssemester1kelas11.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;


public class DatabaseHelper extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 2;

    // DATABASE NAME
    private static final String DATABASE_NAME = "db_list_transaction.db";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Lists.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Lists.TABLE_NAME);
        onCreate(db);
    }

    public long insertList(String note) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Lists.COLUMN_LISTS, note);

        long id = db.insert(Lists.TABLE_NAME, null, values);

        db.close();

        return id;
    }

    public Lists getList(long id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(Lists.TABLE_NAME, new String[]{
                Lists.COLUMN_ID,
                Lists.COLUMN_LISTS,
                Lists.COLUMN_TIMESTAMP
        }, Lists.COLUMN_ID + "=?", new String[]{
                String.valueOf(id)
        }, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        Lists lists = new Lists(
                cursor.getInt(cursor.getColumnIndex(Lists.COLUMN_ID)),
                cursor.getString(cursor.getColumnIndex(Lists.COLUMN_LISTS)),
                cursor.getString(cursor.getColumnIndex(Lists.COLUMN_TIMESTAMP)));

        cursor.close();

        return lists;
    }

    public List<Lists> getAllList() {
        List<Lists> lists = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + Lists.TABLE_NAME + " ORDER BY  " + Lists.COLUMN_TIMESTAMP + " DESC";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Lists lists = new Lists();

                lists.setId(cursor.getInt(cursor.getColumnIndex(Lists.COLUMN_ID)));
                lists.setNote(cursor.getString(cursor.getColumnIndex(Lists.COLUMN_LISTS)));
                lists.setTimestamp(cursor.getString(cursor.getColumnIndex(Lists.COLUMN_TIMESTAMP)));

                lists.add(lists);

            } while (cursor.moveToNext());
        }

        db.close();

        return lists;
    }

    public int getListCount() {
        String countQuery = "SELECT * FROM " + Lists.TABLE_NAME;

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();

        cursor.close();

        return count;
    }

    public int updateList(Lists lists) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(Lists.COLUMN_LISTS, lists.getNote());

        return db.update(Lists.TABLE_NAME, values, Lists.COLUMN_ID + " = ?",
                new String[]{
                        String.valueOf(lists.getId())
                });
    }

    public void deleteList(Lists lists) {
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(Lists.TABLE_NAME, Lists.COLUMN_ID + " =?",
                new String[] {
                        String.valueOf(lists.getId())
                });
        db.close();
    }
}
