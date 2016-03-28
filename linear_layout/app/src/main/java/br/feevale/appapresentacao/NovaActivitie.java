package br.feevale.appapresentacao;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class NovaActivitie extends AppCompatActivity {

    private static final int MNT_CONTATO = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_ok);

        Intent i = getIntent();
        Bundle b = i.getExtras();

        if( b != null ) {
            String nome = b.getString( "nomeUsuario" );

            TextView tv = (TextView) findViewById( R.id.txNomeUsuario );
            tv.setText( nome );
        }
    }

    public void insereNovoContato( View v ) {

        Intent i = new Intent( this, MntContatos.class );
        startActivityForResult(i, MNT_CONTATO);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if( resultCode == RESULT_OK ) {
            switch ( requestCode ) {
                case MNT_CONTATO:
                    Bundle result = data.getExtras();
                    String nome = result.getString( "p1" );
            }
        }

    }

    public void voltar( View v ) {

        finish();
    }
}
