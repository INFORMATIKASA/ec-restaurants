package io.github.dbarrerap.Restaurants;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;

public class MyActivity extends SherlockActivity implements View.OnClickListener{
    /**
     * Called when the activity is first created.
     */

    Button buscar, ayuda;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        setupWidgets();
    }

    private void setupWidgets() {
        buscar = (Button)findViewById(R.string.search);
        buscar.setOnClickListener(this);
        ayuda = (Button)findViewById(R.string.help);
        ayuda.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.searchButton:
                Intent iSearch = new Intent(this, Busqueda.class);
                startActivity(iSearch);
                break;
            case R.id.helpButton:
                Toast.makeText(this, "Unimplemented", Toast.LENGTH_SHORT).show();
                break;
        }

    }
}
