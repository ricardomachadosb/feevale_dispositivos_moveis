package br.feevale.appapresentacao;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText nome;
    private EditText senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_exemplo);

        nome = (EditText) findViewById( R.id.edtNome );
        senha = (EditText) findViewById( R.id.edtSenha );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate( R.menu.menu_main, menu );
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch ( item.getItemId() ) {
            case R.id.action_edit:
                // ...
                return true;
            case R.id.action_insert:
                // ...
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void executaLogin( View v ) {

        String nomeDigitado = nome.getText().toString();
        String senhaDigitada = senha.getText().toString();

        if( nomeDigitado.equals( "joao" ) &&
            senhaDigitada.equals( "123" ) ) {
            setContentView( R.layout.login_ok );
        } else {
            new AlertDialog.Builder( this )
                   .setTitle( R.string.msgAtencao )
                   .setMessage( R.string.msgUsuarioInvalido )
                   .setNeutralButton( "OK", null )
                   .show();
        }
    }

    public void executaLoginPorActivitie( View v ) {

        String nomeDigitado = nome.getText().toString();
        String senhaDigitada = senha.getText().toString();

        if( nomeDigitado.equals( "joao" ) &&
            senhaDigitada.equals( "123" ) ) {

            Intent i = new Intent( this, NovaActivitie.class );
            i.putExtra( "nomeUsuario", "João da Silva" );
            startActivity( i );

        } else {
            new AlertDialog.Builder( this )
                    .setTitle( R.string.msgAtencao )
                    .setMessage( R.string.msgUsuarioInvalido )
                    .setNeutralButton("OK", null)
                    .show();
        }
    }

    public void voltar( View v ) {
        setContentView(R.layout.tela_exemplo);
        Toast.makeText( this, "Voltando à tela original", Toast.LENGTH_LONG ).show();
    }


}
