package com.example.comunicacionactividades;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	private EditText edNombre;
	private TextView txtResultado;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		edNombre = (EditText) findViewById(R.id.edNombre);
		txtResultado = (TextView) findViewById(R.id.txtResultado);

	}

	public void pulsarVerificar(View view) {
		Intent intent = new Intent(this, DestinoActivity.class);
		intent.putExtra("usuario", edNombre.getText().toString());
		startActivityForResult(intent, 100);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		String s = data.getExtras().getString("resultado");
		if (requestCode == 100 && resultCode == RESULT_OK) {
			txtResultado.setText("Resultado:	" + s);
		} else if (requestCode == 100 && resultCode == RESULT_CANCELED) {
			txtResultado.setText("Resultado:	" + s);
		} else {
			txtResultado.setText("Resultado:	ERROR");
		}
	}
}
