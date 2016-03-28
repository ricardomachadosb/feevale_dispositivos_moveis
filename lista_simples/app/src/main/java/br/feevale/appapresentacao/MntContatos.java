package br.feevale.appapresentacao;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class MntContatos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_mnt_contatos);



    }

    public void cancelaAcao( View v ) {

        setResult(RESULT_CANCELED);
        finish();
    }

    public void confirmaAcao( View v ) {

        // Testar se todos os campos obrigatórios estão preenchidos
        EditText edtNome = (EditText) findViewById( R.id.edtNome );
        // buscar os demais campos de texto ou elementos de entrada

        Bundle b = new Bundle();

        b.putString("p1", edtNome.getText().toString());
        // alimentar o bundle com todos os resultados

        Intent i = getIntent();
        i.putExtras( b );

        setResult(RESULT_OK);
        finish();
    }

}
