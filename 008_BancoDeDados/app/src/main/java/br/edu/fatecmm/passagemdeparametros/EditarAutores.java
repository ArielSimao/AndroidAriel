package br.edu.fatecmm.passagemdeparametros;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class EditarAutores extends Activity {

	private EditText txtEditarAutoresNome;
	private EditText txtEditarAutoresBio;
	private Button btnEditarAutoresGravar;
	private Button btnEditarAutoresVoltar;
	private Button btnEditarAutoresExcluir;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_editar_autores);
		
		// amarrando componentes
		txtEditarAutoresNome = (EditText) findViewById(R.id.txtEditarAutoresNome);
		txtEditarAutoresBio = (EditText) findViewById(R.id.txtEditarAutoresBio);
		btnEditarAutoresExcluir = (Button) findViewById(R.id.btnEditarAutoresExcluir);
		btnEditarAutoresGravar = (Button) findViewById(R.id.btnEditarAutoresGravar);
		btnEditarAutoresVoltar = (Button) findViewById(R.id.btnEditarAutoresVoltar);
		
		btnEditarAutoresVoltar.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent it = new Intent(getBaseContext(), TodosAutores.class);
				startActivity(it);
				finish();
			}
		});
		
		btnEditarAutoresExcluir.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent it = new Intent(getBaseContext(), TodosAutores.class);
				startActivity(it);
				finish();
			}
		});
		
		btnEditarAutoresGravar.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent it = new Intent(getBaseContext(), TodosAutores.class);
				startActivity(it);
				finish();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.editar_autores, menu);
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
