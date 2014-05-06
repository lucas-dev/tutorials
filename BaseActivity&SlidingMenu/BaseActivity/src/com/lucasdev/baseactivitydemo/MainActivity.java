package com.lucasdev.baseactivitydemo;

import com.lucasdev.baseactivity.R;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class MainActivity extends BaseActivity{
	private Button btnWithMenu, btnNoMenu;
	@Override
	protected int getLayoutResourceId() {
		return R.layout.activity_main;
	}

	@Override
	protected void goNext() {
		btnWithMenu.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				nextActivity(ActivityWithMenu.class);
			}
		});
		btnNoMenu.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				nextActivity(ActivityNoMenu.class);
			}
		});
	}

	@Override
	protected void initGUI(){ 
		btnWithMenu = (Button)findViewById(R.id.btnMenu);
		btnNoMenu = (Button)findViewById(R.id.btnNoMenu);
	}
	
	private void nextActivity(Class<?> nextActivity){
		Intent intent = new Intent(this, nextActivity);
		startActivity(intent);
	}

	@Override
	protected boolean showSideMenu() {
		return false;
	}

}
