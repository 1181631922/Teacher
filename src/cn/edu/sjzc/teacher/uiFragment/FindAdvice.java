package cn.edu.sjzc.teacher.uiFragment;

import cn.edu.sjzc.teacher.R;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FindAdvice extends BaseFragment{
	
	public static BaseFragment newInstance(int index) {
		BaseFragment fragment = new FindAdvice();
		Bundle args = new Bundle();
		args.putInt("index", index);
		fragment.setArguments(args);
		fragment.setIndex(index);
		return fragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {	
		return inflater.inflate(R.layout.fragment_advice, null);		
	}	
}