package com.example.dibujarab;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class SpecialView extends View{
	
	private Paint painter = new Paint();
	float x=0;
	float y=0;

	public SpecialView(Context context) {
		super(context);
		painter.setStyle(Paint.Style.STROKE);
		painter.setStrokeWidth(5);
		painter.setColor(Color.CYAN);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event){
		x = event.getX();
		y = event.getY();
		
		return true;
	}
	
	@Override
	protected void onDraw(Canvas canvas){
		canvas.drawPoint(x, y, painter);
	}

}
