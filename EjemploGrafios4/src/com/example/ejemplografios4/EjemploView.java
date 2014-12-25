package com.example.ejemplografios4;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.util.AttributeSet;
import android.view.View;

public class EjemploView extends View {

	private ShapeDrawable miImg;

	public EjemploView(Context context, AttributeSet attrs) {
		super(context, attrs);
		miImg = new ShapeDrawable(new OvalShape());
		miImg.getPaint().setColor(0xff0000ff);
	}

	protected void onDraw(Canvas canvas) {
		miImg.draw(canvas);
	}

	@Override
	protected void onSizeChanged(int ancho, int alto, int ancho_anterior,
			int alto_anterior) {
		miImg.setBounds(0, 0, ancho, alto);
	}
}
