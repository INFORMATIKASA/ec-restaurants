package io.github.dbarrerap.Restaurants;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import com.actionbarsherlock.app.SherlockActivity;

/**
 * Created by david on 6/5/14.
 */
public class Busqueda extends SherlockActivity implements AdapterView.OnItemClickListener {

    Spinner categorias;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.busqueda);
        setupWidgets();
    }

    private void setupWidgets() {
        // Popular ListView con todos los restaurantes en la base


        // Popular Spinner con Categorias de Comida
        categorias = (Spinner)findViewById(R.id.spinner);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.string.categories, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        categorias.setAdapter(adapter);
        categorias.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // Filtrar de acuerdo a categoria seleccionada
    }
}