package org.pmdm.ejercicioguiado2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends Activity {

	private EditText p_et1, p_et2;
	private TextView p_tv3;
	private RadioButton p_r1,p_r2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		p_et1 = (EditText) findViewById(R.id.et1);
		p_et2 = (EditText) findViewById(R.id.et2);
		p_tv3 = (TextView) findViewById(R.id.tv3);
		
		p_r1 = (RadioButton) findViewById(R.id.r1);
		p_r2 = (RadioButton) findViewById(R.id.r2);
		
	}
	
	public void operar(View view){
		String valor1= p_et1.getText().toString();
		String valor2= p_et2.getText().toString();
		
		int nro1 = Integer.parseInt(valor1);
		int nro2 = Integer.parseInt(valor2);
		
		int result;
		
		if(p_r1.isChecked()){
			result=nro1+nro2;
		}else{
			result=nro1-nro2;
		}
		String resu = String.valueOf(result);
		p_tv3.setText(resu);
	}
}
