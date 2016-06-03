package com.example.content;

import com.example.androidframe.R;
import com.example.frameclass.BasePage;
import android.content.Context;
import android.view.View;

public class Module3 extends BasePage{

	public Module3(Context context) {
		super(context);
		initData();
	}

	@Override
	public View initView(Context context) {
		View v=View.inflate(context, R.layout.module3, null);
		System.out.println("Module1+20");
		return v;
	}

	@Override
	public void initData() {
		// TODO Auto-generated method stub
		
	}
	

}


