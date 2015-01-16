package com.example.multitouchscreen;

import com.example.touchscreen.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;

public class TouchScreenActivity extends Activity implements OnTouchListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		TextView entrada = (TextView) findViewById(R.id.TextViewEntrada);
		entrada.setOnTouchListener(this);

	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		TextView salida = (TextView) findViewById(R.id.TextViewSalida);
		String acciones[] = { "ACTION_DOWN", "ACTION_UP", "ACTION_MOVE",
				"ACTION_CANCEL", "ACTION_OUTSIDE", "ACTION_POINTER_DOWN",
				"ACTION_POINTER_UP" };
		int accion = event.getAction();
		int codigoAccion = accion & MotionEvent.ACTION_MASK;
		//int idPuntero = codigoAccion >> MotionEvent.ACTION_POINTER_INDEX_SHIFT;
		salida.append(acciones[codigoAccion]);

		for (int i = 0; i < event.getPointerCount(); i++) {
			salida.append(" puntero:" + event.getPointerId(i) + " x:"
					+ event.getX(i) + " y:" + event.getY(i));
		}

		salida.append("\n");
		return false;
	}
}
