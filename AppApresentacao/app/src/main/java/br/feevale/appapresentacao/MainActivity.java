package br.feevale.appapresentacao;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
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

    public void executaLogin( View v ) {

        String nomeDigitado = nome.getText().toString();
        String senhaDigitada = senha.getText().toString();

        if( nomeDigitado.equals( "joao" ) &&
            senhaDigitada.equals( "123" ) ) {
            setContentView( R.layout.login_ok );
        } else {
            new AlertDialog.Builder( this )
                   .setTitle( "Atenção")
                   .setMessage( "Usuário ou Senha Inválida" )
                   .setNeutralButton( "OK", null )
                   .show();
        }
    }

    public void voltar( View v ) {
        setContentView(R.layout.tela_exemplo);
        Toast.makeText( this, "Voltando à tela original", Toast.LENGTH_LONG ).show();
    }
}
