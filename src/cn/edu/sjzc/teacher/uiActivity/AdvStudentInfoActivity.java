package cn.edu.sjzc.teacher.uiActivity;

import cn.edu.sjzc.teacher.R;
import android.R.layout;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class AdvStudentInfoActivity extends BaseActivity implements OnClickListener {

	private ImageButton studentinfo_back;
	private TextView student_info_name, student_info_phone;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);// 生命周期方法
		requestWindowFeature(Window.FEATURE_NO_TITLE);// 去掉标题栏
		super.setContentView(R.layout.activity_adv_student_info);

		init();

		initData();

	}

	private void initData() {

		Intent it = this.getIntent();

		String student_name = it.getStringExtra("student_name");
		String student_phone = it.getStringExtra("student_phone");

		this.student_info_name.setText(student_name);

		this.student_info_phone.setText(student_phone);
	}

	private void init() {
		ImageButton changepassword_back = (ImageButton) this
				.findViewById(R.id.studentinfo_back);
		changepassword_back.setOnClickListener(this);

		this.student_info_name = (TextView) super
				.findViewById(R.id.student_info_name);

		this.student_info_phone = (TextView) super
				.findViewById(R.id.student_info_phone);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

		switch (v.getId()) {
		case R.id.studentinfo_back:

			AdvStudentInfoActivity.this.finish();

			break;

		default:
			break;
		}

	}

}