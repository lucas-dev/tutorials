package com.lucasdev.baseactivitydemo;

import com.lucasdev.baseactivity.R;

public class ActivityWithMenu extends BaseActivity{

	@Override
	protected int getLayoutResourceId() {
		return R.layout.activity_with_menu;
	}

	@Override
	protected void goNext() {
		
	}

	@Override
	protected void initGUI() {
		showToast("Entering "+this.getClass().getSimpleName());
	}

	@Override
	protected boolean showSideMenu() {
		return true;
	}

}
