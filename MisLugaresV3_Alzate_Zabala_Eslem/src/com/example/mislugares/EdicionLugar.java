package com.example.mislugares;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.Spinner;

public class EdicionLugar extends Activity {

	private EditText nombre;
	private Spinner tipo;
	private EditText direccion;
	private EditText telefono;
	private EditText url;
	private EditText comentario;
	private long id;
	private Lugar lugar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.edicion_lugar);

		Bundle extras = getIntent().getExtras();
		id = extras.getLong("id", -1);
		lugar = Lugares.elemento((int) id);
		nombre = (EditText) findViewById(R.id.e_nombre);
		nombre.setText(lugar.getNombre());

		tipo = (Spinner) findViewById(R.id.e_tipo);
		ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, TipoLugar.getNombres());
		adaptador
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		tipo.setAdapter(adaptador);
		tipo.setSelection(lugar.getTipo().ordinal());

		direccion = (EditText) findViewById(R.id.e_direccion);
		direccion.setText(lugar.getDireccion());
		if (lugar.getTelefono() == 0) {
			findViewById(R.id.telefono).setVisibility(View.GONE);
		} else {
			telefono = (EditText) findViewById(R.id.e_telefono);
			telefono.setText(Integer.toString(lugar.getTelefono()));
		}
		url = (EditText) findViewById(R.id.e_url);
		url.setText(lugar.getUrl());

		comentario = (EditText) findViewById(R.id.e_comentario);
		comentario.setText(lugar.getComentario());
	}
	
	public void save(View v){
		lugar.setNombre(nombre.getText().toString());																
		lugar.setTipo(TipoLugar.values()[tipo.getSelectedItemPosition()]);
		lugar.setDireccion(direccion.getText().toString());																
		lugar.setTelefono(Integer.parseInt(telefono.getText().toString()));
		lugar.setUrl(url.getText().toString());
		lugar.setComentario(comentario.getText().toString());
		finish();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.edicion_lugar, menu);
		return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.accion_guardar:
			save(null);
			return true;
		case R.id.accion_cancelar:
			finish();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}
	
}
