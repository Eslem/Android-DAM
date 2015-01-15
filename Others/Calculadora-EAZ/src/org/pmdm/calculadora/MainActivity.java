package org.pmdm.calculadora;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	Double valorGuardado = 0.0;
	String operator;
	Boolean mostrando = true, inicio=true;
	TextView resultTV;
	TextView operationsTV;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		resultTV = (TextView) findViewById(R.id.result);
		operationsTV = (TextView) findViewById(R.id.operations);
	}

	public void equalsClick(View v) {
		calcularAnterior();
        operator = "";
        resultTV.setText(""+valorGuardado);
	}

	public void numberClick(View v) {
		if (mostrando) {
			resultTV.setText("");
			mostrando = false;
		}
		Button number = (Button) v;

		resultTV.setText(resultTV.getText().toString()
				+ number.getText().toString());
		if(inicio){
			operationsTV.setText("");
			inicio=false;
		}
		operationsTV.setText(operationsTV.getText().toString()+number.getText().toString());

	}

	public void cClick(View v) {
		resultTV.setText("");
		operationsTV.setText("");
		mostrando = false;
		valorGuardado = 0.0;
	}

	public void calcularAnterior() {
		if (valorGuardado == 0.0) {
			valorGuardado = Double.valueOf(resultTV.getText().toString());
			resultTV.setText("");
		} else {
						
			if (operator.equals("+")) {
				valorGuardado = valorGuardado
						+ Double.valueOf(resultTV.getText().toString());
			} else if (operator.equals("-")) {
				valorGuardado = valorGuardado
						- Double.valueOf(resultTV.getText().toString());
			} else if (operator.equals("x")) {
				valorGuardado = valorGuardado
						* Double.valueOf(resultTV.getText().toString());
			} else if (operator.equals("/")) {
				valorGuardado = valorGuardado
						/ Double.valueOf(resultTV.getText().toString());
			}

			resultTV.setText("" + valorGuardado);
			mostrando = true;

		}
	}

	public void operation(View v) {
		calcularAnterior();
		Button operador = (Button) v;
		operator = operador.getText().toString();
		operationsTV.setText(operationsTV.getText().toString()+operator);
	}

}
