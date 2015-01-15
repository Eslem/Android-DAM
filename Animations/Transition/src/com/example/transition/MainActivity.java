package com.example.transition;

import android.app.Activity;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_main);
		transitionImg();
	}
	
	public void transitionImg(){
		ImageView	image	=	new ImageView(this);
		setContentView(image);
		TransitionDrawable	transition	=	(TransitionDrawable)	
		getResources().getDrawable(R.drawable.transition);
		image.setImageDrawable(transition);
		transition.startTransition(2000);
	}
}
