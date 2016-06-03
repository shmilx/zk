package com.example.androidframe;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

import com.example.content.MenuFragment;
import com.example.frameclass.ContentFragment;



public class MainActivity extends Activity {

	ImageView mIV;
	Button opensild;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);

//		mIV=(ImageView) findViewById(R.id.topButton);
//		final SlidingMenu menu = new SlidingMenu(this);
//		menu.setMode(SlidingMenu.LEFT);
//		// 璁剧疆瑙︽懜灞忓箷鐨勬ā寮�
//		menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_MARGIN);
//		menu.setShadowWidthRes(R.dimen.shadow_width);//璁剧疆闃村奖鍥剧墖鐨勫搴� 
//		menu.setShadowDrawable(R.drawable.shadow);//璁剧疆闃村奖鍥剧墖  
//
//		// 璁剧疆婊戝姩鑿滃崟瑙嗗浘鐨勫搴�
//		menu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
//		// 璁剧疆娓愬叆娓愬嚭鏁堟灉鐨勫�
//		menu.setFadeDegree(0.35f);
//		/**
//		 * SLIDING_WINDOW will include the Title/ActionBar in the content
//		 * section of the SlidingMenu, while SLIDING_CONTENT does not.
//		 */
//		//鎶婃粦鍔ㄨ彍鍗曟坊鍔犺繘鎵�湁鐨凙ctivity涓紝鍙�鍊糞LIDING_CONTENT 锛�SLIDING_WINDOW
//		menu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
//		//涓轰晶婊戣彍鍗曡缃竷灞�
//		menu.setMenu(R.layout.menu_left);
//		
//		//鐐瑰嚮鎵撳紑渚ф粦鑿滃崟
//		mIV.setOnClickListener(new OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				// TODO Auto-generated method stub
//				if (!menu.isMenuShowing()) {
//					menu.toggle();
//				}else {
//					return;
//				}
//			}
//		});
//		
		getFragmentManager().beginTransaction().replace(R.id.fram_content, new ContentFragment(),"content").commit();
		
//		getFragmentManager().beginTransaction().replace(R.id.frame_menu, new MenuFragment(),"menu").commit();
     
	}
	


	
}
