package com.example.content;

import com.example.androidframe.R;
import com.example.frameclass.BasePage;
import android.content.Context;
import android.view.View;

public class Module1 extends BasePage{

	public Module1(Context context) {
		super(context);
		initData();
	}

	@Override
	public View initView(Context context) {
		View v=View.inflate(context, R.layout.module1, null);
		System.out.println("Module1+18");
		return v;
	}

	@Override
	public void initData() {
		System.out.println("Module1+24");
		
	}
	

}


