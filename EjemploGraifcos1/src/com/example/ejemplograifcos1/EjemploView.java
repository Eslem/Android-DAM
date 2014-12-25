package com.example.ejemplograifcos1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Typeface;
import android.view.View;

public class EjemploView extends View {

	public EjemploView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	protected void onDraw(Canvas canvas) {
		//drawCircles(canvas);
		//drawPath(canvas);
		drawPath2(canvas);
	}

	public int getColor() {
		int color = 0;
		color = Color.BLUE;
		color = Color.argb(127, 0, 255, 0);
		color = 0x7F00FF00;
		color = getResources().getColor(R.color.color_circulo);

		return color;
	}
	
	public void drawPath(Canvas canvas){
		Path	trazo	=	new Path();
		trazo.addCircle(150,	150,	100,	Direction.CW);
		canvas.drawColor(Color.WHITE);
		
		
		Paint	pincel	=	new Paint();
		pincel.setColor(Color.BLUE);
		pincel.setStrokeWidth(8);
		pincel.setStyle(Style.STROKE);
		canvas.drawPath(trazo,	pincel);
		pincel.setStrokeWidth(1);
		pincel.setStyle(Style.FILL);
		pincel.setTextSize(20);
		pincel.setTypeface(Typeface.SANS_SERIF);
		canvas.drawTextOnPath("Desarrollo de aplicaciones para móviles con Android", trazo,	10,	-30, pincel);
	}

	public void drawPath2(Canvas canvas){
		Path		trazo	=	new Path();
		trazo.moveTo(50,	100);
		trazo.cubicTo(60,70,	150,90,	200,110);
		trazo.lineTo(300,200);
		
		canvas.drawColor(Color.WHITE);
			
		Paint	pincel	=	new Paint();
		pincel.setColor(Color.BLUE);
		pincel.setStrokeWidth(8);
		pincel.setStyle(Style.STROKE);
		canvas.drawPath(trazo,	pincel);
		pincel.setStrokeWidth(1);
		pincel.setStyle(Style.FILL);
		pincel.setTextSize(20);
		pincel.setTypeface(Typeface.SANS_SERIF);
		canvas.drawTextOnPath("Desarrollo de aplicaciones para móviles con Android", trazo,	10,	-30, pincel);
	}

	public void drawCircles(Canvas canvas) {
		Paint pincel = new Paint();
		pincel.setColor(getColor());
		pincel.setStrokeWidth(8);
		pincel.setStyle(Style.STROKE);
		canvas.drawCircle(150, 150, 100, pincel);

		pincel.setColor(Color.argb(127, 255, 0, 0));
		canvas.drawCircle(150, 250, 100, pincel);
	}

}
