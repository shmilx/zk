package com.example.frameclass;

import java.util.ArrayList;
import java.util.List;

import com.example.androidframe.R;
import com.example.content.Module1;
import com.example.content.Module2;
import com.example.content.Module3;
import com.example.content.Module4;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class ContentFragment extends BaseFragment implements OnCheckedChangeListener
{
	
	MyViewPager vp;
	List<BasePage> contentpagers;
	RadioGroup rg;
	int i=0;
	@Override
	public View initView(Context context) {
		View v=View.inflate(context, R.layout.fragment_content, null);
		vp=(MyViewPager) v.findViewById(R.id.content);
		rg=(RadioGroup) v.findViewById(R.id.group);
		rg.setOnCheckedChangeListener(this);
		return v; 
	}
	@Override
	public  void initData() {
		if (contentpagers != null) {
		contentpagers.add(new Module1(getActivity()));
		contentpagers.add(new Module2(getActivity()));
		contentpagers.add(new Module3(getActivity()));
		contentpagers.add(new Module4(getActivity()));
		}else{
			contentpagers=new ArrayList<BasePage>();
			contentpagers.add(new Module1(getActivity()));
			contentpagers.add(new Module2(getActivity()));
			contentpagers.add(new Module3(getActivity()));
			contentpagers.add(new Module4(getActivity()));
		}
		vp.setAdapter(new MyPageAdapter());
		vp.setCurrentItem(0);
		vp.setOnPageChangeListener(new OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int position) {
				// radiobutton跟着改变
				((RadioButton)rg.getChildAt(position)).setChecked(true);
				if (position == 0) {
//					((EcommActivity) getActivity())
//							.getSlidingMenu()
//							.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
				} else {
//					((EcommActivity) getActivity()).getSlidingMenu()
//							.setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);
				}
				contentpagers.get(position).initData();
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		}

	

	class MyPageAdapter extends PagerAdapter{

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return contentpagers.size();
			
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			// TODO Auto-generated method stub
			return arg0==arg1;
		}


		// 销毁item
		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			container.removeView(contentpagers.get(position).getView());
		}

		// 实例化item
		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			System.out.println("position"+position);
			System.out.println("contentpages.size()"+contentpagers.size());
			System.out.println(contentpagers);
			System.out.println("container"+container);
			View view=contentpagers.get(position).getView();
			if(view!=null){
			container.addView(contentpagers.get(position).getView());
//			contentpagers.get(position).initData();
			}
			return contentpagers.get(position).getView();
		}
	
		}
	@Override
	public void onCheckedChanged(RadioGroup arg0, int checkedId) {
		// TODO Auto-generated method stub
		int item=-1;
		switch (checkedId) {
		case R.id.module1:
			item=0;
			System.out.println("执行到这111");
			break;
		case R.id.module2:
			item=1;
			System.out.println("执行到这222");
			break;
		case R.id.module3:
			item=2;
			System.out.println("执行到这333");
			break;
		case R.id.module4:
			item=3;
			System.out.println("执行到这444");
			break;
		}
		vp.setCurrentItem(item);
	}

	
	
}
