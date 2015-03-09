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
import android.widget.TextView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class LoginActivity extends Activity {

	private Button sign;
	
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);// 生命周期方法
		requestWindowFeature(Window.FEATURE_NO_TITLE);// 去掉标题栏
		super.setContentView(R.layout.activity_login);
		
		this.sign = (Button)super.findViewById(R.id.sign);
		this.sign.setOnClickListener(new LoginSetOnClickListenerImpl());
		

	}
	
	private class LoginSetOnClickListenerImpl implements OnClickListener{

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Intent it = new Intent(LoginActivity.this,SignActivity.class);
			
			LoginActivity.this.startActivity(it);
		}
		
	}
	

}