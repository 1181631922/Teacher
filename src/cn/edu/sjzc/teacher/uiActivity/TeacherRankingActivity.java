package cn.edu.sjzc.teacher.uiActivity;

import java.util.ArrayList;
import java.util.List;

import cn.edu.sjzc.teacher.R;
import cn.edu.sjzc.teacher.adapter.TeacherRankingAdapter;
import cn.edu.sjzc.teacher.bean.TeacherRankingBean;
import cn.edu.sjzc.teacher.view.HorizontalListView;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;
import android.widget.ListView;

public class TeacherRankingActivity extends Activity {
	Context context;
	private HorizontalListView mListView;
	private TeacherRankingAdapter teacherRankingAdapter;
	private List<TeacherRankingBean> data;
	private String knowledgename[] = { "老师1", "老师2", "老师3", "老师14",
			"老师15", "老师16", "老师7", "老师18", "老师19" ,"老师10"};
	private int pencent[] = { 13, 56, 78, 35, 57, 78, 45, 26, 44 ,69};


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);// 去掉标题栏
		setContentView(R.layout.activity_teacher_ranking);
		context = TeacherRankingActivity.this;
		viewInit();

	}

	public void viewInit() {
		mListView = (HorizontalListView) findViewById(R.id.listview);
		teacherRankingAdapter = new TeacherRankingAdapter(context);
		data = new ArrayList<TeacherRankingBean>();

		for (int i = 0; i < knowledgename.length; i++) {
			TeacherRankingBean teacherRankingBean = new TeacherRankingBean();
			teacherRankingBean.setKnowledgename(knowledgename[i]);
			teacherRankingBean.setPencent(pencent[i]);
		
			data.add(teacherRankingBean);

		}
		teacherRankingAdapter.setData(data);
		mListView.setAdapter(teacherRankingAdapter);

	}

}
