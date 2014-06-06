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
    public static final String ADDRESS_COL = "direccion";
    public static final String TEL_COL = "telefono";
    public static final String CATEGORY_COL = "categoria";
    public static final String LAT_COL = "latitude";
    public static final String LONG_COL = "longitude";
    private static final String DATABASE_CREATE = "CREATE TABLE " + TABLE_NAME + " (" +
            ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            NAME_COL + " TEXT NOT NULL, " +
            ADDRESS_COL + " TEXT NOT NULL, " +
            TEL_COL + " TEXT " +
            CATEGORY_COL + " TEXT NOT NULL, " +
            LAT_COL + " REAL, " +
            LONG_COL + " REAL);";
    private static final String SAMPLE_DATA = "INSERT INTO " + TABLE_NAME + " VALUES " +
            "(Malek Al Shawarma, Urdesa Central Ave. Victor Emilio Estrada y Guayacanes, 238-4162, ARABE, -2.165357, -79.911271)," +
            "(Burger King, Urdesa Central Ave. Victor Emilio Estrada #600, 288-8863, RAPIDA, -2.173302, -79.906591)," +
            "(Bhundeo Shawarma, Urbanización Entre Ríos Avenida Principal, 604-1390, ARABE, -2.148404, -79.864882)" +
            "(La Parrilla del Ñato, Víctor Emilio Estrada 1219 y Laureles, 2387098, PARRILLA, -2.161525, -79.916654)" +
            "(El Café de Tere, Avenida Hermano Miguel, Solar 7-21-22, 2237372, BARCAFE, -2.151184, -79.891983)" +
            "(Cocolón, Plaza Orellana Av Francisco de Orellana, 263-4181, TIPICA, -2.164173, -79.896409)" +
            "(Pique & Pase, Alejo Lascano # 1617 y Carchi, 2293309, TIPICA, 229-3309, -2.184591, -79.89437)" +
            "(Dulcería La Palma, Escobedo No. 1308, entre Vélez y Luque, 2326185, POSTRES, -2.192152, -79.883725)" +
            "(Akai Express, C.C. Riocentro Entrerios local C 6B, 283-6298, ORIENTAL, -2.141878, -79.864979)" +
            "(Chifa Asia, Centro Sucre #321 y Chile, 2328088, ORIENTAL, -2.195827, -79.882817)" +
            ";";

    public Data(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);
        db.execSQL(SAMPLE_DATA);
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
