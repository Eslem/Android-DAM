package com.example.benderanimation;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class MainActivity extends Activity {
	
	AnimationDrawable animation;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		animation = (AnimationDrawable) getResources().getDrawable(R.drawable.animacion);
		
		ImageView vista = new ImageView(this);
		vista.setBackgroundColor(Color.WHITE);
		vista.setImageDrawable(animation);
		vista.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				animation.start();
			}
		});
		
		setContentView(vista);
	}
}
