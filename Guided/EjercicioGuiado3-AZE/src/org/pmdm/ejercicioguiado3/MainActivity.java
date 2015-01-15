package org.pmdm.ejercicioguiado3;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends Activity {

	private EditText p_et1, p_et2;
	private TextView p_tv3;
	private RadioButton p_r1, p_r2;
	private Spinner p_spinner1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		p_et1 = (EditText) findViewById(R.id.et1);
		p_et2 = (EditText) findViewById(R.id.et2);
		p_tv3 = (TextView) findViewById(R.id.tv3);

		p_spinner1 = (Spinner) findViewById(R.id.spinner1);

		String[] opciones = { "sumar", "restar", "multiplicar", "dividir" };
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, opciones);
		p_spinner1.setAdapter(adapter);

	}

	public void operar(View view) {

		String valor1 = p_et1.getText().toString();
		String valor2 = p_et2.getText().toString();
		int nro1 = Integer.parseInt(valor1);
		int nro2 = Integer.parseInt(valor2);
		String selec = p_spinner1.getSelectedItem().toString();
		if (selec.equals("sumar")) {
			int suma = nro1 + nro2;
			String resu = String.valueOf(suma);
			p_tv3.setText(resu);
		} else if (selec.equals("restar")) {
			int resta = nro1 - nro2;
			String resu = String.valueOf(resta);
			p_tv3.setText(resu);
		} else if (selec.equals("multiplicar")) {
			int multi = nro1 * nro2;
			String resu = String.valueOf(multi);
			p_tv3.setText(resu);
		} else if (selec.equals("dividir")) {
			int divi = nro1 / nro2;
			String resu = String.valueOf(divi);
			p_tv3.setText(resu);
		}
	}
}
