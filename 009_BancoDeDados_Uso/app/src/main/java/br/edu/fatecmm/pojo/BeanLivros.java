package br.edu.fatecmm.pojo;

public class BeanLivros {
	private int idLivro;
	private String nmLivro;
	private int idAutor;
	private int idEditora;
	private String anoLivro;
	private String dsResenha;
	
	public BeanLivros()
	{
		idLivro = -1;
		nmLivro = "";
		idAutor = -1;
		idEditora = -1;
		anoLivro = "";
		dsResenha = "";
	}

	public int getIdLivro() {
		return idLivro;
	}

	public void setIdLivro(int idLivro) {
		this.idLivro = idLivro;
	}

	public String getNmLivro() {
		return nmLivro;
	}

	public void setNmLivro(String nmLivro) {
		this.nmLivro = nmLivro;
	}

	public int getIdAutor() {
		return idAutor;
	}

	public void setIdAutor(int idAutor) {
		this.idAutor = idAutor;
	}

	public int getIdEditora() {
		return idEditora;
	}

	public void setIdEditora(int idEditora) {
		this.idEditora = idEditora;
	}

	public String getAnoLivro() {
		return anoLivro;
	}

	public void setAnoLivro(String anoLivro) {
		this.anoLivro = anoLivro;
	}

	public String getDsResenha() {
		return dsResenha;
	}

	public void setDsResenha(String dsResenha) {
		this.dsResenha = dsResenha;
	}
}
