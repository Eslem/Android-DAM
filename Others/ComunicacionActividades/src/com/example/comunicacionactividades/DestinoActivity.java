package com.example.comunicacionactividades;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DestinoActivity extends Activity {
	TextView txtDestino;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_destino);

		Bundle extras = getIntent().getExtras();
		String s = extras.getString("usuario");
		txtDestino = (TextView) findViewById(R.id.txtDestino);
		txtDestino.setText("Hola	" + s + ".	¿Aceptas	las	condiciones?");

	}

	public void pulsarAceptar(View view) {
		Intent intent = new Intent();
		intent.putExtra("resultado", "ACEPTADO");
		setResult(RESULT_OK, intent);
		finish();
	}

	public void pulsarRechazar(View view) {
		Intent intent = new Intent();
		intent.putExtra("resultado", "RECHAZADO");
		setResult(RESULT_CANCELED, intent);
		finish();
	}
}
