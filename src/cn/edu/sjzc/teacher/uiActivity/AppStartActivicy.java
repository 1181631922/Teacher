package cn.edu.sjzc.teacher.uiActivity;

import java.util.Timer;
import java.util.TimerTask;






import cn.edu.sjzc.teacher.R;
import cn.edu.sjzc.teacher.uiFragment.MainTabActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;

public class AppStartActivicy extends BaseActivity {
	Thread thread;
	protected void onCreate(Bundle savedInstanceState) {
		  super.onCreate(savedInstanceState);
		  this.requestWindowFeature(Window.FEATURE_NO_TITLE); //去掉标题栏
		      setContentView(R.layout.activity_appstart); // 绑定布局文件
		      
		      new Handler().postDelayed(new Runnable(){
		  		@Override
		  		public void run(){
		  			Intent intent = new Intent (AppStartActivicy.this,MainTabActivity.class);			
		  			startActivity(intent);			
		  			AppStartActivicy.this.finish();
		  		}
		  	}, 4000);     
		       
		      
		     }



}
