package com.lucasdev.baseactivitydemo;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingActivity;
import com.lucasdev.baseactivity.R;

public abstract class BaseActivity extends SlidingActivity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setUpLayout();
		setContentView(getLayoutResourceId());
		setUpSlideMenu();
			
		initGUI();
		goNext();
	}


	private void setUpSlideMenu() {
		setBehindContentView(R.layout.menu);
		getSlidingMenu().setBehindOffset(100);
		getSlidingMenu().setTouchModeAbove(showSideMenu()?SlidingMenu.TOUCHMODE_FULLSCREEN:SlidingMenu.TOUCHMODE_NONE);
	}

	
	protected abstract int getLayoutResourceId();

	protected abstract void goNext();

	protected abstract void initGUI();
	
	protected abstract boolean showSideMenu();
	
	private void setUpLayout() {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
	}
	
	protected void showToast(String msg) {
		Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
