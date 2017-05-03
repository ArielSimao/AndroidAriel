package br.edu.fatecmm.banco;

import java.util.ArrayList;
import java.util.List;

import br.edu.fatecmm.pojo.BeanLivros;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DAOLivros {
	private SQLiteDatabase banco;
	private GerenciaBanco gerenciaBanco;
	
	// Colunas
	public static final String ID_LIVRO = "id_livro";
	public static final String NM_LIVRO = "nm_livro";
	public static final String ID_AUTOR = "id_autor";
	public static final String ID_EDITORA = "id_editora";
	public static final String ANO_LIVRO = "ano_livro";
	public static final String DS_RESENHA = "ds_resenha";
	
	public static final String[] todasAsColunas = 
	{
		ID_LIVRO, NM_LIVRO, ID_AUTOR, ID_EDITORA, ANO_LIVRO, DS_RESENHA
	};
	
	// Tabela
	public static final String TABELA_LIVROS = "livros";
	
	public DAOLivros(Context contexto)
	{
		gerenciaBanco = new GerenciaBanco(contexto);
	}
	
	public void open() throws SQLException
	{
		banco = gerenciaBanco.getWritableDatabase();
	}
	
	public void close()
	{
		gerenciaBanco.close();
	}
	
	public void insert(BeanLivros item)
	{
		ContentValues valores = new ContentValues();
		valores.put(NM_LIVRO, item.getNmLivro());
		valores.put(ID_AUTOR, item.getIdAutor());
		valores.put(ID_EDITORA, item.getIdEditora());
		valores.put(ANO_LIVRO, item.getAnoLivro());
		valores.put(DS_RESENHA, item.getDsResenha());
		
		banco.insert(TABELA_LIVROS, null, valores);
	}
	
	public void update(BeanLivros item)
	{
		ContentValues valores = new ContentValues();
		
		valores.put(ID_LIVRO, item.getIdLivro());
		valores.put(ID_AUTOR, item.getIdAutor());
		valores.put(ID_EDITORA, item.getIdEditora());
		valores.put(ANO_LIVRO, item.getAnoLivro());
		valores.put(DS_RESENHA, item.getDsResenha());
		
		banco.update(TABELA_LIVROS, valores, ID_LIVRO + " = " + item.getIdLivro(), null);
	}
	
	public void delete(BeanLivros item)
	{
		int id = item.getIdLivro();
		banco.delete(TABELA_LIVROS, ID_LIVRO + " = " + id, null);
	}
	
	public List<BeanLivros> selectTodos()
	{
		List<BeanLivros> itens = new ArrayList<BeanLivros>();
		Cursor cursor = banco.query(TABELA_LIVROS, 
			todasAsColunas, null, null, null, null, NM_LIVRO);
		cursor.moveToFirst();
		while(!cursor.isAfterLast())
		{
			BeanLivros item = cursorToItem(cursor);
			itens.add(item);
			cursor.moveToNext();
		}
		cursor.close();
		return itens;
	}
	
	public BeanLivros selectUm(BeanLivros item)
	{
		Cursor cursor = banco.query(
				TABELA_LIVROS, 
				todasAsColunas, 
				ID_LIVRO + " = " + 
				item.getIdLivro(), null, null, null, null);
		cursor.moveToFirst();
		return cursorToItem(cursor);
	}
	
	private BeanLivros cursorToItem(Cursor cursor)
	{
		BeanLivros item = new BeanLivros();
		
		item.setIdAutor(cursor.getInt(0));
		item.setNmLivro(cursor.getString(1));
		item.setIdAutor(cursor.getInt(2));
		item.setIdEditora(cursor.getInt(3));
		item.setAnoLivro(cursor.getString(4));
		item.setDsResenha(cursor.getString(5));
		
		return item;
	}
}
