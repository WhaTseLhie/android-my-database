package pardillo.john.jv.mydatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDatabase extends SQLiteOpenHelper {

    Context context;
    final static String DATABASE = "db_app";
    final static String TABLE = "tbl_person";

    public MyDatabase(Context context) {
        // creates database
        super(context,  DATABASE, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // create table
        String sql = "CREATE TABLE " +TABLE+ "(id integer primary key autoincrement, name varchar(50), phone varchar(11))";
        // execute sql
        db.execSQL(sql);
    }

    public long addPerson(String name, String phone) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        long id;

        cv.put("name", name);
        cv.put("phone", phone);
        id = db.insert(TABLE, null, cv);

        db.close();
        return id;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
