package com.example.frameclass;

import android.content.Context;
import android.view.View;

public abstract class BasePage {
	
	View v;
	public Context context;
	public BasePage(Context context){
		this.context = context;
		v = initView(context);
		
	}
	abstract public View initView(Context context);
	abstract public void initData();
	
	public View getView(){
		return v;
	}
	public Context getContext(){
		return context;
		
	}
}

