package com.example.ejemplograficos2;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;

public class EjemploView extends View {
	
	private Drawable myImg;

	public EjemploView(Context context) {
		super(context);
		Resources res = getResources();
		myImg = res.getDrawable(R.drawable.bender);
		myImg.setBounds(30, 30, 250, 382);
		// TODO Auto-generated constructor stub
	}
	
	protected void onDraw(Canvas canvas){
		myImg.draw(canvas);
	}

}
