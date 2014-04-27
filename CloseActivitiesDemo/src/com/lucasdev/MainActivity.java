package com.lucasdev;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;

public class MainActivity extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		WebView wv = (WebView)findViewById(R.id.webView);
		wv.getSettings().setJavaScriptEnabled(true);
		wv.loadUrl("file:///android_asset/"+getPage());
		wv.addJavascriptInterface(this, "AndroidNative");
	}

	private String getPage() {
		String stringExtra = getIntent().getStringExtra("page");
		return stringExtra==null?"welcome.html":stringExtra;
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		int screenIndex = getIntent().getIntExtra("screenNumber",0) + 1;
		if( resultCode == RESULT_OK && screenIndex > 1){
			setResult(RESULT_OK);
			finish();
		}
	}
	
	@JavascriptInterface
	public void startTransaction(String html, int screenNumber){
		Intent intent = new Intent(this, MainActivity.class);
		intent.putExtra("page", html).putExtra("screenNumber", screenNumber);
		startActivityForResult(intent, 99);
	}
	
	@JavascriptInterface
	public void finishTransaction(){
		setResult(RESULT_OK);
		finish();
	}
	
}
