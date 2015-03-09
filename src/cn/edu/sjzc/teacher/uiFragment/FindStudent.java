package cn.edu.sjzc.teacher.uiFragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.edu.sjzc.teacher.R;
import cn.edu.sjzc.teacher.adapter.StudentAdapter;
import cn.edu.sjzc.teacher.bean.StudentUserBean;
import cn.edu.sjzc.teacher.util.PinyinComparatorUtils;
import cn.edu.sjzc.teacher.util.PinyinUtils;
import cn.edu.sjzc.teacher.view.StudentSideBarView;
import cn.edu.sjzc.teacher.view.StudentSideBarView.OnTouchingLetterChangedListener;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class FindStudent extends Fragment implements
		OnTouchingLetterChangedListener {

	private ListView lvShow;
	private List<StudentUserBean> studentUserBeans;
	private TextView overlay;
	private StudentSideBarView myView;
	private StudentAdapter adapter;

	private OverlayThread overlayThread = new OverlayThread();

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View root = inflater.inflate(R.layout.fragment_findteacher, container,
				false);
		return root;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

		init();

	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}

	@Override
	public void onTouchingLetterChanged(String s) {
		// TODO Auto-generated method stub
		Log.i("coder", "s:" + s);

		overlay.setText(s);
		overlay.setVisibility(View.VISIBLE);
		handler.removeCallbacks(overlayThread);
		handler.postDelayed(overlayThread, 1000);
		if (alphaIndexer(s) > 0) {
			int position = alphaIndexer(s);
			Log.i("coder", "position:" + position);
			lvShow.setSelection(position);

		}
	}

	private class OverlayThread implements Runnable {

		public void run() {
			overlay.setVisibility(View.GONE);
		}

	}

	public void init() {
		lvShow = (ListView) getActivity().findViewById(R.id.lvShow);
		myView = (StudentSideBarView) getActivity().findViewById(R.id.myView);

		overlay = (TextView) getActivity().findViewById(R.id.tvLetter);

		lvShow.setTextFilterEnabled(true);
		overlay.setVisibility(View.INVISIBLE);

		getUserInfos();

		Log.i("coder", "studentUserBeans.size" + studentUserBeans.size());
		adapter = new StudentAdapter(getActivity(), studentUserBeans);

		lvShow.setAdapter(adapter);

		myView.setOnTouchingLetterChangedListener(this);

		lvShow.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				Toast.makeText(getActivity(), "���ǵڼ���"+position, 1000).show();
			}
		});
	}

	private void getUserInfos() {
		StudentUserBean[] userinfoArray = new StudentUserBean[] {
				new StudentUserBean("��ɮ", "18765432345",
						PinyinUtils.getAlpha("��ɮ")),
				new StudentUserBean("��ʦ��", "18765432345",
						PinyinUtils.getAlpha("��ʦ��")),
				new StudentUserBean("����", "18909876545",
						PinyinUtils.getAlpha("����")),
				new StudentUserBean("��С��", "18909876545",
						PinyinUtils.getAlpha("��С��")),
				new StudentUserBean("������", "18909876545",
						PinyinUtils.getAlpha("������")),
				new StudentUserBean("����", "18909876545",
						PinyinUtils.getAlpha("����")),
				new StudentUserBean("�����", "18765432345",
						PinyinUtils.getAlpha("�����")),
				new StudentUserBean("����", "18765432345",
						PinyinUtils.getAlpha("����")),
				new StudentUserBean("����", "18765432345",
						PinyinUtils.getAlpha("����")),
				new StudentUserBean("�Ŷ�B", "18876569008",
						PinyinUtils.getAlpha("�Ŷ�B")),
				new StudentUserBean("����", "18765432345",
						PinyinUtils.getAlpha("����")),
				new StudentUserBean("����", "18765432345",
						PinyinUtils.getAlpha("����")),
				new StudentUserBean("�Ŷ�B", "18876569008",
						PinyinUtils.getAlpha("�Ŷ�B")),
				new StudentUserBean("����", "18765432345",
						PinyinUtils.getAlpha("����")),
				new StudentUserBean("����", "18765432345",
						PinyinUtils.getAlpha("����")),
				new StudentUserBean("�Ŷ�B", "18876569008",
						PinyinUtils.getAlpha("�Ŷ�B")),
				new StudentUserBean("����", "18765432345",
						PinyinUtils.getAlpha("����")),
				new StudentUserBean("����", "18765432345",
						PinyinUtils.getAlpha("����")),
				new StudentUserBean("�Ŷ�B", "18876569008",
						PinyinUtils.getAlpha("�Ŷ�B")),
				new StudentUserBean("����", "18909876545",
						PinyinUtils.getAlpha("����")),
				new StudentUserBean("��С��", "18909876545",
						PinyinUtils.getAlpha("��С��")),
				new StudentUserBean("������", "18909876545",
						PinyinUtils.getAlpha("������")),
				new StudentUserBean("���޼�", "18909876545",
						PinyinUtils.getAlpha("���޼�")),
				new StudentUserBean("��С��", "18909876545",
						PinyinUtils.getAlpha("��С��")) };

		Arrays.sort(userinfoArray, new PinyinComparatorUtils());

		studentUserBeans = Arrays.asList(userinfoArray);
	}

	private Handler handler = new Handler() {
	};

	public int alphaIndexer(String s) {
		int position = 0;
		for (int i = 0; i < studentUserBeans.size(); i++) {

			if (studentUserBeans.get(i).getPy().startsWith(s)) {
				position = i;
				break;
			}
		}
		Log.i("coder", "i" + position + studentUserBeans.get(position));
		return position;
	}

}