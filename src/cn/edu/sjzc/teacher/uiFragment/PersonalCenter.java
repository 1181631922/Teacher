package cn.edu.sjzc.teacher.uiFragment;

import cn.edu.sjzc.teacher.R;
import cn.edu.sjzc.teacher.uiActivity.LoginActivity;
import cn.edu.sjzc.teacher.uiActivity.PerChangeInfoActivity;
import cn.edu.sjzc.teacher.uiActivity.PerChangePasswordActivity;
import cn.edu.sjzc.teacher.uiActivity.PerPersonalInfoActivity;
import cn.edu.sjzc.teacher.uiActivity.PerScheduleActivity;
import cn.edu.sjzc.teacher.uiActivity.TeacherRankingActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class PersonalCenter extends BaseFragment implements OnClickListener {
	
	public static BaseFragment newInstance(int index) {
		BaseFragment fragment = new PersonalCenter();
		Bundle args = new Bundle();
		args.putInt("index", index);
		fragment.setArguments(args);
		fragment.setIndex(index);
		return fragment;
	}

	private Button user_but, per_person_but, per_password_but,
			per_schedule_but;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		return inflater.inflate(R.layout.fragment_personalcenter, container, false);

	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

		init();

	}

	public void init() {
		Button user_but = (Button) getActivity().findViewById(R.id.user_but);
		user_but.setOnClickListener(this);

		Button per_person_but = (Button) getActivity().findViewById(
				R.id.per_person_but);
		per_person_but.setOnClickListener(this);

		Button per_password_but = (Button) getActivity().findViewById(
				R.id.per_password_but);
		per_password_but.setOnClickListener(this);

		Button per_schedule_but = (Button) getActivity().findViewById(
				R.id.per_schedule_but);
		per_schedule_but.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

		switch (v.getId()) {
		case R.id.user_but:
			Intent it_user = new Intent(getActivity(), PerChangeInfoActivity.class);
			PersonalCenter.this.startActivity(it_user);
			break;
		case R.id.per_person_but:
			Intent it_person = new Intent(getActivity(), PerPersonalInfoActivity.class);
			PersonalCenter.this.startActivity(it_person);
			break;

		case R.id.per_password_but:
			Intent it_password = new Intent(getActivity(), PerChangePasswordActivity.class);
			PersonalCenter.this.startActivity(it_password);
			break;

		case R.id.per_schedule_but:
			Intent it_schedule = new Intent(getActivity(), PerScheduleActivity.class);
			PersonalCenter.this.startActivity(it_schedule);
			break;

		default:
			break;
		}

	}

}