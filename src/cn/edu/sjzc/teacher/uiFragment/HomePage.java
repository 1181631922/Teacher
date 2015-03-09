package cn.edu.sjzc.teacher.uiFragment;

import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import cn.edu.sjzc.teacher.R;
import cn.edu.sjzc.teacher.uiActivity.HomeExchangeActivity;
import cn.edu.sjzc.teacher.uiActivity.HomeInfoActivity;
import cn.edu.sjzc.teacher.uiActivity.HomeNewsActivity;
import cn.edu.sjzc.teacher.uiActivity.LoginActivity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class HomePage extends Fragment {
	
	private LinearLayout home_news,home_info,home_exchange;

	int[] images = null;// 图片资源ID
	String[] titles = null;// 标题

	ArrayList<ImageView> imageSource = null;// 图片资源
	ArrayList<View> dots = null;// 点
	TextView title = null;
	ViewPager viewPager;// 用于显示图片
	MyPagerAdapter adapter;// viewPager的适配器
	private int currPage = 0;// 当前显示的页
	private int oldPage = 0;// 上一次显示的页
	View dot1;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		LayoutInflater myInflater = (LayoutInflater) getActivity()
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		View view = myInflater.inflate(R.layout.fragment_homepage, container, false);

		return view;

	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		init_viewpager();
		init_view();
		

	}
	
	public void init_view(){
		View dot1 = (View) getActivity().findViewById(R.id.dot1);
		dot1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent it = new Intent(getActivity(), LoginActivity.class);
				HomePage.this.startActivity(it);
			}
		});
		
		LinearLayout home_news = (LinearLayout) getActivity().findViewById(R.id.home_news);
		home_news.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent it = new Intent(getActivity(), HomeNewsActivity.class);
				HomePage.this.startActivity(it);
			}
		});
		
		LinearLayout home_info = (LinearLayout) getActivity().findViewById(R.id.home_info);
		home_info.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent it = new Intent(getActivity(), HomeInfoActivity.class);
				HomePage.this.startActivity(it);
			}
		});
		
		LinearLayout home_exchange = (LinearLayout) getActivity().findViewById(R.id.home_exchange);
		home_exchange.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent it = new Intent(getActivity(), HomeExchangeActivity.class);
				HomePage.this.startActivity(it);
			}
		});
		
		
	}
	
	

	public void init_viewpager() {
		images = new int[] { R.drawable.sjzc, R.drawable.computer,
				R.drawable.c, R.drawable.d, R.drawable.e };
		titles = new String[] { "石家庄学院首页", "计算机学院", "化工学院", "历史文化学院", "数信学院" };
		// 将要显示的图片放到list集合中
		imageSource = new ArrayList<ImageView>();
		for (int i = 0; i < images.length; i++) {
			ImageView image = new ImageView(getActivity());
			image.setBackgroundResource(images[i]);
			imageSource.add(image);

			final int j = i;
			image.setOnClickListener(new View.OnClickListener() {

				public void onClick(View v) {

					if (j == 0) {

						Uri uri = Uri.parse("http://www.sjzc.edu.cn/");
						Intent it = new Intent(Intent.ACTION_VIEW, uri);
						startActivity(it);

						Toast.makeText(getActivity(), "石家庄学院首页", 1000).show();
					}
					if (j == 1) {
						Uri uri = Uri.parse("http://jsj.sjzc.edu.cn/");
						Intent it = new Intent(Intent.ACTION_VIEW, uri);
						startActivity(it);

						Toast.makeText(getActivity(), "计算机学院", 1000).show();
					}
					if (j == 2) {
						Uri uri = Uri.parse("http://hgxy.sjzc.edu.cn/");
						Intent it = new Intent(Intent.ACTION_VIEW, uri);
						startActivity(it);

						Toast.makeText(getActivity(), "化工学院", 1000).show();
					}
					if (j == 3) {
						Uri uri = Uri.parse("http://210.31.249.13/lsx/");
						Intent it = new Intent(Intent.ACTION_VIEW, uri);
						startActivity(it);

						Toast.makeText(getActivity(), "历史文化学院", 1000).show();
					}
					if (j == 4) {
						Uri uri = Uri.parse("http://210.31.249.13/shuxue/");
						Intent it = new Intent(Intent.ACTION_VIEW, uri);
						startActivity(it);

						Toast.makeText(getActivity(), "数信学院", 1000).show();
					}

					// Toast.makeText(getActivity(), "这是第" + j + "张图片",
					// 1000).show();

				}
			});

		}

		// 获取显示的点（即文字下方的点，表示当前是第几张）
		dots = new ArrayList<View>();
		dots.add(getActivity().findViewById(R.id.dot1));
		dots.add(getActivity().findViewById(R.id.dot2));
		dots.add(getActivity().findViewById(R.id.dot3));
		dots.add(getActivity().findViewById(R.id.dot4));
		dots.add(getActivity().findViewById(R.id.dot5));

		// 图片的标题
		title = (TextView) getActivity().findViewById(R.id.title);
		title.setText(titles[0]);

		// 显示图片的VIew
		viewPager = (ViewPager) getActivity().findViewById(R.id.vp);
		// 为viewPager设置适配器
		adapter = new MyPagerAdapter();
		viewPager.setAdapter(adapter);
		// 为viewPager添加监听器，该监听器用于当图片变换时，标题和点也跟着变化
		MyPageChangeListener listener = new MyPageChangeListener();
		viewPager.setOnPageChangeListener(listener);

		// 开启定时器，每隔2秒自动播放下一张（通过调用线程实现）（与Timer类似，可使用Timer代替）
		ScheduledExecutorService scheduled = Executors
				.newSingleThreadScheduledExecutor();
		// 设置一个线程，该线程用于通知UI线程变换图片
		ViewPagerTask pagerTask = new ViewPagerTask();
		scheduled.scheduleAtFixedRate(pagerTask, 6, 6, TimeUnit.SECONDS);
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onViewCreated(view, savedInstanceState);
	}

	// ViewPager每次仅最多加载三张图片（有利于防止发送内存溢出）
	private class MyPagerAdapter extends PagerAdapter {
		@Override
		public int getCount() {
			System.out.println("getCount");
			return images.length;
		}

		@Override
		public Object instantiateItem(View container, int position) {
			// TODO Auto-generated method stub
			View view = dots.get(position);
			view.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent it = new Intent(getActivity(), LoginActivity.class);
					HomePage.this.startActivity(it);
				}
			});
			ViewPager viewPager = (ViewPager) container;
			viewPager.addView(view);
			return dots.get(position);
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			// 判断将要显示的图片是否和现在显示的图片是同一个
			// arg0为当前显示的图片，arg1是将要显示的图片
			System.out.println("isViewFromObject");
			return arg0 == arg1;
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			System.out.println("destroyItem==" + position);
			// 销毁该图片
			container.removeView(imageSource.get(position));
		}

		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			// 初始化将要显示的图片，将该图片加入到container中，即viewPager中
			container.addView(imageSource.get(position));
			System.out.println("instantiateItem===" + position + "===="
					+ container.getChildCount());
			return imageSource.get(position);
		}
	}

	// 监听ViewPager的变化
	private class MyPageChangeListener implements OnPageChangeListener {
		@Override
		public void onPageScrollStateChanged(int arg0) {

		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {

		}

		@Override
		public void onPageSelected(final int position) {
			// 当显示的图片发生变化之后
			// 设置标题
			title.setText(titles[position]);
			// 改变点的状态
			dots.get(position).setBackgroundResource(R.drawable.dot_focused);
			dots.get(oldPage).setBackgroundResource(R.drawable.dot_normal);
			// 记录的页面

			oldPage = position;
			currPage = position;
		}
	}

	private class ViewPagerTask implements Runnable {
		@Override
		public void run() {
			// 改变当前页面的值
			currPage = (currPage + 1) % images.length;
			// 发送消息给UI线程
			handler.sendEmptyMessage(0);
		}
	}

	private Handler handler = new Handler() {
		public void handleMessage(Message msg) {
			// 接收到消息后，更新页面
			viewPager.setCurrentItem(currPage);
		};
	};
}
