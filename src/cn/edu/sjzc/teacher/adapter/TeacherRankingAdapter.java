package cn.edu.sjzc.teacher.adapter;

import java.util.List;

import cn.edu.sjzc.teacher.R;
import cn.edu.sjzc.teacher.bean.TeacherRankingBean;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class TeacherRankingAdapter extends BaseAdapter {
	Context context;
	LayoutInflater layoutInflater;
	private List<TeacherRankingBean> data;
	int markcolorCount=0;

	public TeacherRankingAdapter(Context context) {
		this.context = context;
		layoutInflater = LayoutInflater.from(context);
	}

	public void setData(List<TeacherRankingBean> data) {
		this.data = data;
		this.notifyDataSetChanged();
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return data.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return data.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		MyView myView;
		if (convertView == null) {
			myView = new MyView();
			convertView = layoutInflater.inflate(R.layout.item_listview_teacher_rankding, null);
			myView.tv = (TextView) convertView.findViewById(R.id.textview);
			myView.textview_values = (TextView) convertView
					.findViewById(R.id.textview_values);
			myView.values_btn = (Button) convertView
					.findViewById(R.id.values_btn);
			myView.point_img = (ImageView) convertView
					.findViewById(R.id.point_img);
			convertView.setTag(myView);
		} else {
			myView = (MyView) convertView.getTag();
		}

		
		myView.tv.setText(data.get(position).getKnowledgename());
		myView.values_btn.setBackgroundResource(color[position % 5]);
		myView.point_img.setBackgroundResource(pointimg[position % 5]);

		myView.textview_values.setText(data.get(position).getPencent()+"%");
		setHeight(myView.values_btn, data.get(position).getPencent()+150);
		return convertView;
	}
	private int pointimg[] = { R.drawable.point_img1, R.drawable.point_img2,
			R.drawable.point_img3, R.drawable.point_img4, R.drawable.point_img5 };
	private int color[] = { R.color.color1, R.color.color2,R.color.color3, R.color.color4,
			R.color.color5 };
	public class MyView {
		TextView textview_values, tv;

		Button values_btn;
		ImageView point_img;

	}

	public void setHeight(Button btn ,int heightvalues) {
		RelativeLayout.LayoutParams p = (android.widget.RelativeLayout.LayoutParams) btn
				.getLayoutParams();
	
		p.height = heightvalues;
	
		btn.setLayoutParams(p);
	

	}

}
