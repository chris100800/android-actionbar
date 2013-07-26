package com.chris.android.flipper;

import com.chris.android.flipper.R;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class MainActivity extends Activity {
	
	private ViewFlipper viewFlipper;
	private GestureDetector gesture;
	private OnGestureListener listener = new OnGestureListener() {

		@Override
		public boolean onDown(MotionEvent e) {
			Log.d("d", "onDown");
			return false;
		}

		@Override
		public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
				float velocityY) {
			if (e1.getX() - e2.getX() > 120) {
				viewFlipper.setInAnimation(AnimationUtils.loadAnimation(getApplicationContext(), 
						R.anim.left_in));
				viewFlipper.setOutAnimation(AnimationUtils.loadAnimation(getApplicationContext(), 
						R.anim.left_out));
				viewFlipper.showNext();
			} else if (e1.getX() - e2.getX() < 120) {
				viewFlipper.setInAnimation(AnimationUtils.loadAnimation(getApplicationContext(), 
						R.anim.right_in));
				viewFlipper.setOutAnimation(AnimationUtils.loadAnimation(getApplicationContext(), 
						R.anim.right_out));
				viewFlipper.showPrevious();
			}
			
			return false;
		}

		@Override
		public void onLongPress(MotionEvent e) {
			Log.d("d", "onLongPress");	
		}

		@Override
		public boolean onScroll(MotionEvent e1, MotionEvent e2,
				float distanceX, float distanceY) {
			
			return false;
		}

		@Override
		public void onShowPress(MotionEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public boolean onSingleTapUp(MotionEvent e) {
			// TODO Auto-generated method stub
			return false;
		}
		
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		viewFlipper = (ViewFlipper) findViewById(R.id.viewFlipper);
		gesture = new GestureDetector(listener);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		return gesture.onTouchEvent(event);
	}	

}
