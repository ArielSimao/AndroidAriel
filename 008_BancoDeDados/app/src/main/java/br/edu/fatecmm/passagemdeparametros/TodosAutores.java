package br.edu.fatecmm.passagemdeparametros;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class TodosAutores extends Activity {

	private ListView lstTodosAutores;
	private Button btnTodosAutoresVoltar;
	private Button btnTodosAutoresNovo;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_todos_autores);
		
		lstTodosAutores = (ListView) findViewById(R.id.lstTodosAutores);
		btnTodosAutoresNovo = (Button) findViewById(R.id.btnTodosAutoresNovo);
		btnTodosAutoresVoltar = (Button) findViewById(R.id.btnTodosAutoresVoltar);
		
		// Carrega Lista de autores modelo para teste visual
		String[] autores = { "Autor1", "Autor2", "Autor3", "Autor4", 
				             "Autor5", "Autor6", "Autor7", "Autor8", 
				             "Autor9", "Autor10" };
		ArrayAdapter<String> adapter = new 
				ArrayAdapter<String>(getBaseContext(),
						android.R.layout.simple_list_item_1,autores);
		lstTodosAutores.setAdapter(adapter);
		
		// botão voltar
		btnTodosAutoresVoltar.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				finish();
			}
		});
		
		// botão novo
		btnTodosAutoresNovo.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent it = new Intent(getBaseContext(), EditarAutores.class);
				startActivity(it);
				finish();
			}
		});
		
		// lista
		lstTodosAutores.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Intent it = new Intent(getBaseContext(), EditarAutores.class);
				startActivity(it);
				finish();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.todos_autores, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
