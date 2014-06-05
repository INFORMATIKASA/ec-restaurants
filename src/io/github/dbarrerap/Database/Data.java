package io.github.dbarrerap.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;

/**
 * Created by Dav3 on 5/24/13.
 */
public class Data extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "restaurants";
    public static final String ID_COL = BaseColumns._ID;
    public static final String TABLE_NAME = "restaurant";
    public static final String NAME_COL = "nombre";
    public static final String ADDR_COL = "direccion";
    public static final String CATEGORY_COL = "categoria";
    public static final String LAT_COL = "latitude";
    public static final String LONG_COL = "longitude";
    private static final String DATABASE_CREATE = "CREATE TABLE " + TABLE_NAME + " (" +
            ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            NAME_COL + " TEXT NOT NULL, " +
            ADDR_COL + " TEXT NOT NULL, " +
            CATEGORY_COL + " TEXT NOT NULL, " +
            LAT_COL + " REAL, " +
            LONG_COL + " REAL);";

    public Data(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion > oldVersion){
            Log.w(Data.class.getName(), "Migrando base de datos de version " + oldVersion + " a la version " + newVersion + ".");
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
            onCreate(db);
        }
    }
}
