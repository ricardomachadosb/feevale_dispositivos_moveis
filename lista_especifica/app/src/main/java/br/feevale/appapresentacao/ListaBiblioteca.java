package br.feevale.appapresentacao;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ListaBiblioteca extends Activity implements AdapterView.OnItemClickListener {

    private ArrayList<ItemBiblioteca> itens;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_biblioteca);
        itens = new ArrayList<ItemBiblioteca>();
        carregaItensBiblioteca();

        ListView lista = (ListView) findViewById( android.R.id.list );
        ItensBibliotecaAdapter adapter = new ItensBibliotecaAdapter( this,
                R.layout.linha_lista_biblioteca, itens );

        lista.setAdapter( adapter );

        lista.setOnItemClickListener( this );
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        ItemBiblioteca item = itens.get( position );
        Intent i = new Intent( this, EditaItemBiblioteca.class );
        i.putExtra("item", item);

        startActivityForResult(i, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if( resultCode == RESULT_OK ) {

        }
    }

    private class ItensBibliotecaAdapter extends ArrayAdapter<ItemBiblioteca> {

        private int resource;
        public ItensBibliotecaAdapter( Context context, int resource, List<ItemBiblioteca> itens ) {
            super(context, resource, itens);
            this.resource = resource;
        }

        @Override
        public View getView( int position, View convertView, ViewGroup parent ) {

            RelativeLayout itemBibliotecaView;
            ItemBiblioteca este = getItem( position );

            if( convertView == null ) {
                itemBibliotecaView = new RelativeLayout( getContext() );
                LayoutInflater vi = (LayoutInflater) getContext().getSystemService( Context.LAYOUT_INFLATER_SERVICE );
                vi.inflate( resource, itemBibliotecaView, true );
            } else {
                itemBibliotecaView = (RelativeLayout) convertView;
            }

            ImageView imageView = (ImageView) itemBibliotecaView.findViewById( R.id.imageView );
            TextView txTitulo = (TextView) itemBibliotecaView.findViewById( R.id.txtTitulo );
            TextView txObservacoes = (TextView) itemBibliotecaView.findViewById( R.id.txtObservacoes );

            txTitulo.setText(este.getDsNome());
            txObservacoes.setText(este.getDsComentarios());

            switch ( este.getTpItem() ) {
                case ARTIGO:
                    imageView.setImageResource( R.drawable.artigo );
                    break;
                case CD:
                    imageView.setImageResource( R.drawable.cd );
                    break;
                case DVD:
                    imageView.setImageResource( R.drawable.dvd );
                    break;
                case LIVRO:
                    imageView.setImageResource( R.drawable.livro );
                    break;
                case REVISTA:
                    imageView.setImageResource( R.drawable.revista );
                    break;
            }

            return itemBibliotecaView;
        }
    }

    private void carregaItensBiblioteca() {

        itens.add( new ItemBiblioteca( 1, ItemBiblioteca.TipoItem.ARTIGO, "A Volta dos Que Não Foram", "o artigo descreve a saga daqueles um um dia voltaram, sem jamais terem ido." ) );
        itens.add( new ItemBiblioteca( 1, ItemBiblioteca.TipoItem.LIVRO, "Android Básico", "complia‹o das principais técnicas de programa‹o em Android" ) );
        itens.add( new ItemBiblioteca( 1, ItemBiblioteca.TipoItem.LIVRO, "Seis Mil Milhas Subterraneas", "famoso clássico de Jœlio Verme em edi‹o de bolso" ) );
        itens.add( new ItemBiblioteca( 1, ItemBiblioteca.TipoItem.DVD, "Guerra nas Estrelas", "refilmagem da famosa produ‹o em 3D" ) );
        itens.add( new ItemBiblioteca( 1, ItemBiblioteca.TipoItem.LIVRO, "Astronautas for Dumies", "livro ensinando passo a passo como ingressar nesta promissora carreira" ) );
        itens.add( new ItemBiblioteca( 1, ItemBiblioteca.TipoItem.REVISTA, "Quase Interessante", "revista contendo artigos rejeitados em edi›es de outras revistas" ) );
        itens.add( new ItemBiblioteca( 1, ItemBiblioteca.TipoItem.REVISTA, "Mechânica Básica de Automóveis", "livro técnico detalha em profundidade todas as atividades relacionadas aos problemas da rebimboca da parafuseta - especialmente dirigido ao pœblico feminino" ) );
        itens.add( new ItemBiblioteca( 1, ItemBiblioteca.TipoItem.CD, "Grandes Sucessos de Michel Teló", "cd single" ) );
        itens.add( new ItemBiblioteca( 1, ItemBiblioteca.TipoItem.LIVRO, "Chapéuzinho Vermelho", "livro de auto-ajuda, mostra por A + B que o crime n‹o compensa"));
        itens.add( new ItemBiblioteca( 1, ItemBiblioteca.TipoItem.DVD, "Um Exocet", "o filme conta a singela e emocionante história da doce K‡tia Fl‡via, a Godiva do Iraj‡."));
    }

    public void salvaAtributosDefault() {

        SharedPreferences pref = getApplicationContext().getSharedPreferences( "br.feevale.MeuApp", MODE_PRIVATE );
        SharedPreferences.Editor editor = pref.edit();

        editor.putBoolean("autoConect", true);
        editor.putString("nomeLogin", "Joãozinho");
        editor.putLong("corFundo", 0xAABBFF);

        editor.commit();  // salva as preferencias
    }

    public void leAtributos() {
        SharedPreferences pref = getApplicationContext().getSharedPreferences( "br.feevale.MeuApp", MODE_PRIVATE );

        String nomeLogin = pref.getString("nomeLogin", null);
        boolean autoCnt = pref.getBoolean( "autoConect", false );
    }

    public void removeAtributos() {

        SharedPreferences pref = getApplicationContext().getSharedPreferences( "br.feevale.MeuApp", MODE_PRIVATE );
        SharedPreferences.Editor editor = pref.edit();

        editor.remove( "autoConect" );
        editor.remove( "nomeLogin" );
        editor.remove( "corFundo" );

        editor.commit();
    }

    public void clearAtributes() {

        SharedPreferences pref = getApplicationContext().getSharedPreferences( "br.feevale.MeuApp", MODE_PRIVATE );
        SharedPreferences.Editor editor = pref.edit();
        editor.clear();
        editor.commit();
    }
}
