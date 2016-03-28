package br.feevale.appapresentacao;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class NovaActivitie extends AppCompatActivity {

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

    public void voltar( View v ) {

        finish();
    }
}
