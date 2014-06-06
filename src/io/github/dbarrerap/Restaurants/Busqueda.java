package io.github.dbarrerap.Restaurants;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import com.actionbarsherlock.app.SherlockActivity;
import io.github.dbarrerap.Database.DAO;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by david on 6/5/14.
 */
public class Busqueda extends SherlockActivity implements AdapterView.OnItemClickListener {

    Spinner categorias;
    private DAO dao;
    ListView lista;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.busqueda);
        setupWidgets();
    }

    private void setupWidgets() {
        // Popular ListView con todos los restaurantes en la base
        lista = (ListView)findViewById(R.id.listView);
        dao = new DAO(this);
        try {
            dao.open();
            List<Restaurant> values = dao.allRestaurants();
            ArrayAdapter<Restaurant> adapter = new ArrayAdapter<Restaurant>(this, android.R.layout.simple_list_item_1, values);
            lista.setAdapter(adapter);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Popular Spinner con Categorias de Comida
        categorias = (Spinner)findViewById(R.id.spinner);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.string.categories, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        categorias.setAdapter(adapter);
        categorias.setOnItemClickListener(this);
    }

    @Override
    protected void onResume() {
        try {
            dao.open();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        super.onResume();
    }

    @Override
    protected void onPause() {
        dao.close();
        super.onPause();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // Filtrar de acuerdo a categoria seleccionada
        List<Restaurant> values = dao.filterRestaurants(parent.getSelectedItem().toString());
        ArrayAdapter<Restaurant> adapter = new ArrayAdapter<Restaurant>(this, android.R.layout.simple_list_item_1, values);
        lista.setAdapter(adapter);
    }
}