package com.example.content;

import com.example.androidframe.R;
import com.example.frameclass.BasePage;
import android.content.Context;
import android.view.View;

public class Module4 extends BasePage{

	public Module4(Context context) {
		super(context);
		initData();
	}

	@Override
	public View initView(Context context) {
		View v=View.inflate(context, R.layout.module4, null);
		System.out.println("Module1+21");
		return v;
	}

	@Override
	public void initData() {
		// TODO Auto-generated method stub
		
	}
	

}


