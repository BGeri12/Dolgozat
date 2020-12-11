package com.example.logreg;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBhelper extends SQLiteOpenHelper {


    public static final String DB_NAME = "FELHASZNALOK.DB";
    public static final int DB_VERSION= 1;

    public static final String  FELHASZNALO_TABLE = "felhasznalo" ;

    private static final String COL_id = "A felhasználó azonosítója ";
    private static final String COL_email = "A felhasználó email címe";
    private static final String COL_felhnev = "A felhasználó bejelentkezési neve";
    private static final String COL_jelszo = "A felhasználó jelszava";
    private static final String COL_teljesnev = "A felhasználó teljes neve";

    public DBhelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = "CREATE TABLE IF NOT EXISTS "+ FELHASZNALO_TABLE +" (" +
                COL_id+" INTEGER PRIMARY KEY AUTOINCREMENT," +
                COL_email+" VARCHAR(255) NOT NULL , " +
                COL_felhnev+" VARCHAR(255) NOT NULL, " +
                COL_jelszo+" VARCHAR(255) NOT NULL," +
                COL_teljesnev+" VARCHAR(255) NOT NULL"+
                ")";
        db.execSQL(sql);

    }

    public boolean RegisztracipDB(String email, String felhasznalonev, String jelszo,String tejesnev){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_email,email);
        values.put(COL_felhnev,felhasznalonev);
        values.put(COL_jelszo,jelszo);
        values.put(COL_teljesnev,tejesnev);
        return db.insert(FELHASZNALO_TABLE,null,values) != -1;
    }

    public Cursor adatLekerdezes(){

        SQLiteDatabase db = this.getReadableDatabase();
        return db.query(FELHASZNALO_TABLE,new String[]{COL_teljesnev},"Setect"+COL_teljesnev+"Where"+COL_teljesnev+"LIKE ",null,null,null,null);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
