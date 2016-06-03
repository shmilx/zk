package com.example.frameclass;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

//����������������ʲô
public abstract class BaseFragment extends Fragment {

	

	//����fragment��View
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		return initView(getActivity());
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		initData();
	}
	
	//Ҫ�����е����඼ʵ�ֳ�ʼ��view,������д��һ�����󷽷�����������Ϳ�������
	abstract public View initView(Context context);
	//view���ˣ�����ʾ����˰ɣ���ʼ������������ʾ��ݣ�������棬initData()
	abstract public void initData();
	
	
}