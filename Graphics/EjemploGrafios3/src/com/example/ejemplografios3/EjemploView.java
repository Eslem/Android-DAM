package com.example.ejemplografios3;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.view.View;

public class EjemploView extends View {

	private ShapeDrawable miImg;

	public EjemploView(Context context) {
		super(context);
		miImg = new ShapeDrawable(new OvalShape());
		miImg.getPaint().setColor(0xff0000ff);
		miImg.setBounds(10, 10, 310, 60);
	}

	protected void onDraw(Canvas canvas) {
		miImg.draw(canvas);
	}

}
