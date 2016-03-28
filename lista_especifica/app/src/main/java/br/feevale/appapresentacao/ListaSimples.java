package br.feevale.appapresentacao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class ListaSimples extends AppCompatActivity implements AdapterView.OnItemClickListener {

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
        setContentView(R.layout.activity_lista_simples);

        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>( this,
                        R.layout.layout_linha_simples,
                        R.id.txTextoLinha, lista );

        ListView lista = (ListView) findViewById( android.R.id.list );
        lista.setAdapter( adapter );

        lista.setOnItemClickListener( this );
    }

    @Override
    public void onItemClick( AdapterView<?> parent,
                             View view,
                             int position,
                             long id ) {

        String textoSel = lista[ position ];

        EditText edt = (EditText) findViewById( R.id.edtTextoSel );
        edt.setText( textoSel );
    }
}



























