package cn.edu.sjzc.teacher.uiFragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.edu.sjzc.teacher.R;
import cn.edu.sjzc.teacher.adapter.StudentAdapter;
import cn.edu.sjzc.teacher.bean.StudentUserBean;
import cn.edu.sjzc.teacher.uiActivity.AdvStudentInfoActivity;
import cn.edu.sjzc.teacher.uiActivity.PerPersonalInfoActivity;
import cn.edu.sjzc.teacher.util.PinyinComparatorUtils;
import cn.edu.sjzc.teacher.util.PinyinUtils;
import cn.edu.sjzc.teacher.view.StudentSideBarView;
import cn.edu.sjzc.teacher.view.StudentSideBarView.OnTouchingLetterChangedListener;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
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
import android.webkit.WebView.FindListener;
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
	private static List<Map<String, Object>> studentList = new ArrayList<Map<String, Object>>();
	private String sname, sphone;

	private OverlayThread overlayThread = new OverlayThread();

	// public String[] userinfoArray;

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

		lvShow.setOnItemClickListener(new studentInfoOnItemClickListener());
	}

	public void getUserInfos() {
		StudentUserBean[] userinfoArray = new StudentUserBean[] {
				new StudentUserBean("����", "13303116239"),
				new StudentUserBean("�ź���", "18765432345"),
				new StudentUserBean("�����", "18765432345"),
				new StudentUserBean("������", "18765432345"),
				new StudentUserBean("�κ���", "18765432345"),
				new StudentUserBean("�ζ���", "18765432345"),
				new StudentUserBean("������", "18765432345"),
				new StudentUserBean("������", "18765432345"),
				new StudentUserBean("������", "18765432345"),
				new StudentUserBean("�ﾯ��", "18765432345"),
				new StudentUserBean("�ž�", "18765432345"),
				new StudentUserBean("���˻�", "18765432345"),
				new StudentUserBean("��ӱ��", "18765432345"),
				new StudentUserBean("��־��", "18765432345"),
				new StudentUserBean("����Ӧ", "18765432345"),
				new StudentUserBean("������", "18765432345"),
				new StudentUserBean("����", "18765432345"),
				new StudentUserBean("����", "18765432345"),
				new StudentUserBean("��ٻ", "18765432345"),
				new StudentUserBean("����÷", "18765432345"),
				new StudentUserBean("������", "18765432345"),
				new StudentUserBean("�ξ�Ӫ", "18765432345"),
				new StudentUserBean("��԰", "18765432345"),
				new StudentUserBean("��", "18765432345") 
				};

		for (int i = 0; i < userinfoArray.length; i++) {

			StudentUserBean su = new StudentUserBean(sname, sphone);
			String st = userinfoArray[i].getUserName();
			String sp = userinfoArray[i].getPhoneNum();
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("s_name", st);
			map.put("s_phone", sp);
			studentList.add(map);
		}

		Arrays.sort(userinfoArray);

		studentUserBeans = Arrays.asList(userinfoArray);
	}

	protected class studentInfoOnItemClickListener implements
			OnItemClickListener {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			// TODO Auto-generated method stub

			Intent it_student_info = new Intent(getActivity(),
					AdvStudentInfoActivity.class);

			int total = position + 1;
			String mString = "������Ϣ" + total;

			for (int i = 0; i <= position; i++) {
				if (position == i) {

					Map map = (Map) studentList.get(i);
					String mstu = (String) map.get("s_name");
					String mpho = (String) map.get("s_phone");
					it_student_info.putExtra("student_name", mstu);
					it_student_info.putExtra("student_phone", mpho);
				}
			}

			startActivity(it_student_info);

		}

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