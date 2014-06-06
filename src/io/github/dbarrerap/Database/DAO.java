package io.github.dbarrerap.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import io.github.dbarrerap.Restaurants.Restaurant;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by david on 6/5/14.
 */
public class DAO {
    private SQLiteDatabase database;
    private Data dbHelper;
    private String[] allColumns = { Data.ID_COL, Data.NAME_COL };

    public DAO(Context context) {
        dbHelper = new Data(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        database.close();
    }

    public Restaurant createRestaurant(String nombre, String direccion, String telefono, String categoria, double latitude, double longitude) {
        ContentValues locales = new ContentValues();
        locales.put(Data.NAME_COL, nombre);
        locales.put(Data.ADDRESS_COL, direccion);
        locales.put(Data.TEL_COL, telefono);
        locales.put(Data.CATEGORY_COL, categoria);
        locales.put(Data.LAT_COL, latitude);
        locales.put(Data.LONG_COL, longitude);
        long insert_id = database.insert(Data.TABLE_NAME, null, locales);
        Cursor cursor = database.query(Data.TABLE_NAME, allColumns, Data.ID_COL + " = " + insert_id, null, null, null, null);
        cursor.moveToFirst();
        Restaurant newRest = cursorToRestaurant(cursor);
        cursor.close();
        return newRest;
    }

    public List<Restaurant> filterRestaurants(String categoria) {
        List<Restaurant> restaurants = new ArrayList<Restaurant>();

        Cursor cursor = database.query(Data.TABLE_NAME, allColumns, Data.CATEGORY_COL + " = " + categoria, null, null, null, null);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            Restaurant restaurant = cursorToRestaurant(cursor);
            restaurants.add(restaurant);
            cursor.moveToNext();
        }

        cursor.close();
        return restaurants;
    }

    public List<Restaurant> allRestaurants() {
        List<Restaurant> restaurants = new ArrayList<Restaurant>();

        Cursor cursor = database.query(Data.TABLE_NAME, allColumns, null, null, null, null, null);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            Restaurant restaurant = cursorToRestaurant(cursor);
            restaurants.add(restaurant);
            cursor.moveToNext();
        }

        cursor.close();
        return restaurants;
    }

    private Restaurant cursorToRestaurant(Cursor cursor) {
        Restaurant restaurant = new Restaurant();
        restaurant.setNombre(cursor.getColumnName(1));
        return restaurant;
    }
}
