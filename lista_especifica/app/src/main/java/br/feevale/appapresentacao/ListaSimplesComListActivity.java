package br.feevale.appapresentacao;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by 0000782 on 12/03/2016.
 */
public class ListaSimplesComListActivity extends ListActivity {

    private String[] lista = {
            "Rio Grande do Sul",
            "Santa Catarina",
            "Paraná",
            "São Paulo",
            "Rio de Janeiro",
            "Minas Gerais",
            "Espirito Santo",
            "Bahia"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_lista_simples );

        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>( this,
                        android.R.layout.simple_list_item_1,
                        android.R.id.text1, lista );

        setListAdapter( adapter );
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {

    }
}














