package cn.edu.sjzc.teacher.uiActivity;

import cn.edu.sjzc.teacher.R;
import cn.edu.sjzc.teacher.uiFragment.PersonalCenter;
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

public class PerPersonalInfoActivity extends Activity implements
		OnClickListener {

	private ImageButton personalinfo_back;
	private Button personalinfo_but;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);// 生命周期方法
		requestWindowFeature(Window.FEATURE_NO_TITLE);// 去掉标题栏
		super.setContentView(R.layout.activity_per_personalinfo);

		init();
	}

	private void init() {
		ImageButton personalinfo_back = (ImageButton) this
				.findViewById(R.id.personalinfo_back);
		personalinfo_back.setOnClickListener(this);

		Button personalinfo_but = (Button) this
				.findViewById(R.id.personalinfo_but);
		personalinfo_but.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.personalinfo_back:

			PerPersonalInfoActivity.this.finish();

			break;

		case R.id.personalinfo_but:

			Intent it_personalinfo = new Intent(PerPersonalInfoActivity.this, PerChangeInfoActivity.class);
			PerPersonalInfoActivity.this.startActivity(it_personalinfo);

			break;

		default:
			break;
		}

	}

}