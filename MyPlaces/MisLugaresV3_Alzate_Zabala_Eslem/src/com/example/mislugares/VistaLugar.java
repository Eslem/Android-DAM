package com.example.mislugares;

import java.sql.Date;
import java.text.DateFormat;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.TextView;

public class VistaLugar extends Activity {
	private long id;
	private Lugar lugar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.vista_lugar);
		actualizarVistas();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.vista_lugar, menu);
		return true;
	}

	public void borrar() {
		new AlertDialog.Builder(this).setTitle("Borrado de lugar")
				.setMessage("�Estas seguro que quieres eliminar este lugar?")
				.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int whichButton) {
						Lugares.borrar((int) id);
						finish();
					}
				}).setNegativeButton("Cancelar", null).show();
	}

	public void lanzarEdicion(View view) {
		Intent i = new Intent(this, EdicionLugar.class);
		i.putExtra("id", id);
		startActivityForResult(i, 1234);
	}

	public void actualizarVistas() {
		Bundle extras = getIntent().getExtras();
		id = extras.getLong("id", -1);
		lugar = Lugares.elemento((int) id);
		TextView nombre = (TextView) findViewById(R.id.nombre);
		nombre.setText(lugar.getNombre());
		ImageView logo_tipo = (ImageView) findViewById(R.id.logo_tipo);
		logo_tipo.setImageResource(lugar.getTipo().getRecurso());
		TextView tipo = (TextView) findViewById(R.id.tipo);
		tipo.setText(lugar.getTipo().getTexto());
		TextView direccion = (TextView) findViewById(R.id.direccion);
		direccion.setText(lugar.getDireccion());
		if (lugar.getTelefono() == 0) {
			findViewById(R.id.telefono).setVisibility(View.GONE);
		} else {
			TextView telefono = (TextView) findViewById(R.id.telefono);
			telefono.setText(Integer.toString(lugar.getTelefono()));
		}
		TextView url = (TextView) findViewById(R.id.url);
		url.setText(lugar.getUrl());
		TextView comentario = (TextView) findViewById(R.id.comentario);
		comentario.setText(lugar.getComentario());
		TextView fecha = (TextView) findViewById(R.id.fecha);
		fecha.setText(DateFormat.getDateInstance().format(
				new Date(lugar.getFecha())));
		TextView hora = (TextView) findViewById(R.id.hora);
		hora.setText(DateFormat.getTimeInstance().format(
				new Date(lugar.getFecha())));
		RatingBar valoracion = (RatingBar) findViewById(R.id.valoracion);
		valoracion.setRating(lugar.getValoracion());
		valoracion
				.setOnRatingBarChangeListener(new OnRatingBarChangeListener() {
					@Override
					public void onRatingChanged(RatingBar ratingBar,
							float valor, boolean fromUser) {
						lugar.setValoracion(valor);
					}
				});
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == 1234) {
			actualizarVistas();
			findViewById(R.id.scrollView1).invalidate();
		}
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.accion_compartir:
			return true;
		case R.id.accion_llegar:
			return true;
		case R.id.accion_editar:
			lanzarEdicion(null);
			return true;
		case R.id.accion_borrar:
			borrar();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

}