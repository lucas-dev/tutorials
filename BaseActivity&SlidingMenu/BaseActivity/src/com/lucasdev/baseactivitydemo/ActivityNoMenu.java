package com.lucasdev.baseactivitydemo;

import com.lucasdev.baseactivity.R;

public class ActivityNoMenu extends BaseActivity{

	@Override
	protected int getLayoutResourceId() {
		return R.layout.activity_no_menu;
	}

	@Override
	protected void goNext() {
		// TODO Auto-generated method stub
	}

	@Override
	protected void initGUI() {
		showToast("Entering "+this.getClass().getName());
	}

	@Override
	protected boolean showSideMenu() {
		return false;
	}

}
