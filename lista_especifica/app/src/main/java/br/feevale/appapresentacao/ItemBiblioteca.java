package br.feevale.appapresentacao;

import java.io.Serializable;

public class ItemBiblioteca implements Serializable {

	private static final long serialVersionUID = 5955000904670440886L;

	public enum TipoItem { LIVRO, REVISTA, DVD, CD, ARTIGO }

	private Integer idItem;
	private TipoItem tpItem;
	private String dsNome;
	private String dsComentarios;

	public ItemBiblioteca( Integer idItem, TipoItem tpItem, String dsNome, String dsComentarios ) {

		this.idItem = idItem;
		this.tpItem = tpItem;
		this.dsNome = dsNome;
		this.dsComentarios = dsComentarios;
	}

	public Integer getIdItem() {
		return idItem;
	}

	public void setIdItem( Integer idItem ) {
		this.idItem = idItem;
	}

	public TipoItem getTpItem() {
		return tpItem;
	}

	public void setTpItem( TipoItem tpItem ) {
		this.tpItem = tpItem;
	}

	public String getDsNome() {
		return dsNome;
	}

	public void setDsNome( String dsNome ) {
		this.dsNome = dsNome;
	}

	public String getDsComentarios() {
		return dsComentarios;
	}

	public void setDsComentarios( String dsComentarios ) {
		this.dsComentarios = dsComentarios;
	}
}