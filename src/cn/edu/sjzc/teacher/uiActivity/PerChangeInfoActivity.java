package cn.edu.sjzc.teacher.uiActivity;



import cn.edu.sjzc.teacher.R;
import cn.edu.sjzc.teacher.util.PerChangeInfoDialog;
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

public class PerChangeInfoActivity extends Activity implements OnClickListener {

	private ImageButton changeperinfo_back;
	
	private Button changeperinfo_but;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);// 生命周期方法
		requestWindowFeature(Window.FEATURE_NO_TITLE);// 去掉标题栏
		super.setContentView(R.layout.activity_per_changeperinfo);

		init();
	}

	private void init() {
		ImageButton changeperinfo_back = (ImageButton) this
				.findViewById(R.id.changeperinfo_back);
		changeperinfo_back.setOnClickListener(this);

		Button changeperinfo_but = (Button) this
				.findViewById(R.id.changeperinfo_but);
		changeperinfo_but.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

		switch (v.getId()) {
		case R.id.changeperinfo_back:

			PerChangeInfoActivity.this.finish();

			break;
		case R.id.changeperinfo_but:

			PerChangeInfoDialog dialog = new PerChangeInfoDialog(this,
					R.style.mystyle, R.layout.dialog_exit);
			dialog.show();

			break;

		default:
			break;
		}

	}

}