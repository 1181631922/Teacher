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

	int[] images = null;// ͼƬ��ԴID
	String[] titles = null;// ����

	ArrayList<ImageView> imageSource = null;// ͼƬ��Դ
	ArrayList<View> dots = null;// ��
	TextView title = null;
	ViewPager viewPager;// ������ʾͼƬ
	MyPagerAdapter adapter;// viewPager��������
	private int currPage = 0;// ��ǰ��ʾ��ҳ
	private int oldPage = 0;// ��һ����ʾ��ҳ
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
		titles = new String[] { "ʯ��ׯѧԺ��ҳ", "�����ѧԺ", "����ѧԺ", "��ʷ�Ļ�ѧԺ", "����ѧԺ" };
		// ��Ҫ��ʾ��ͼƬ�ŵ�list������
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

						Toast.makeText(getActivity(), "ʯ��ׯѧԺ��ҳ", 1000).show();
					}
					if (j == 1) {
						Uri uri = Uri.parse("http://jsj.sjzc.edu.cn/");
						Intent it = new Intent(Intent.ACTION_VIEW, uri);
						startActivity(it);

						Toast.makeText(getActivity(), "�����ѧԺ", 1000).show();
					}
					if (j == 2) {
						Uri uri = Uri.parse("http://hgxy.sjzc.edu.cn/");
						Intent it = new Intent(Intent.ACTION_VIEW, uri);
						startActivity(it);

						Toast.makeText(getActivity(), "����ѧԺ", 1000).show();
					}
					if (j == 3) {
						Uri uri = Uri.parse("http://210.31.249.13/lsx/");
						Intent it = new Intent(Intent.ACTION_VIEW, uri);
						startActivity(it);

						Toast.makeText(getActivity(), "��ʷ�Ļ�ѧԺ", 1000).show();
					}
					if (j == 4) {
						Uri uri = Uri.parse("http://210.31.249.13/shuxue/");
						Intent it = new Intent(Intent.ACTION_VIEW, uri);
						startActivity(it);

						Toast.makeText(getActivity(), "����ѧԺ", 1000).show();
					}

					// Toast.makeText(getActivity(), "���ǵ�" + j + "��ͼƬ",
					// 1000).show();

				}
			});

		}

		// ��ȡ��ʾ�ĵ㣨�������·��ĵ㣬��ʾ��ǰ�ǵڼ��ţ�
		dots = new ArrayList<View>();
		dots.add(getActivity().findViewById(R.id.dot1));
		dots.add(getActivity().findViewById(R.id.dot2));
		dots.add(getActivity().findViewById(R.id.dot3));
		dots.add(getActivity().findViewById(R.id.dot4));
		dots.add(getActivity().findViewById(R.id.dot5));

		// ͼƬ�ı���
		title = (TextView) getActivity().findViewById(R.id.title);
		title.setText(titles[0]);

		// ��ʾͼƬ��VIew
		viewPager = (ViewPager) getActivity().findViewById(R.id.vp);
		// ΪviewPager����������
		adapter = new MyPagerAdapter();
		viewPager.setAdapter(adapter);
		// ΪviewPager��Ӽ��������ü��������ڵ�ͼƬ�任ʱ������͵�Ҳ���ű仯
		MyPageChangeListener listener = new MyPageChangeListener();
		viewPager.setOnPageChangeListener(listener);

		// ������ʱ����ÿ��2���Զ�������һ�ţ�ͨ�������߳�ʵ�֣�����Timer���ƣ���ʹ��Timer���棩
		ScheduledExecutorService scheduled = Executors
				.newSingleThreadScheduledExecutor();
		// ����һ���̣߳����߳�����֪ͨUI�̱߳任ͼƬ
		ViewPagerTask pagerTask = new ViewPagerTask();
		scheduled.scheduleAtFixedRate(pagerTask, 6, 6, TimeUnit.SECONDS);
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onViewCreated(view, savedInstanceState);
	}

	// ViewPagerÿ�ν�����������ͼƬ�������ڷ�ֹ�����ڴ������
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
			// �жϽ�Ҫ��ʾ��ͼƬ�Ƿ��������ʾ��ͼƬ��ͬһ��
			// arg0Ϊ��ǰ��ʾ��ͼƬ��arg1�ǽ�Ҫ��ʾ��ͼƬ
			System.out.println("isViewFromObject");
			return arg0 == arg1;
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			System.out.println("destroyItem==" + position);
			// ���ٸ�ͼƬ
			container.removeView(imageSource.get(position));
		}

		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			// ��ʼ����Ҫ��ʾ��ͼƬ������ͼƬ���뵽container�У���viewPager��
			container.addView(imageSource.get(position));
			System.out.println("instantiateItem===" + position + "===="
					+ container.getChildCount());
			return imageSource.get(position);
		}
	}

	// ����ViewPager�ı仯
	private class MyPageChangeListener implements OnPageChangeListener {
		@Override
		public void onPageScrollStateChanged(int arg0) {

		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {

		}

		@Override
		public void onPageSelected(final int position) {
			// ����ʾ��ͼƬ�����仯֮��
			// ���ñ���
			title.setText(titles[position]);
			// �ı���״̬
			dots.get(position).setBackgroundResource(R.drawable.dot_focused);
			dots.get(oldPage).setBackgroundResource(R.drawable.dot_normal);
			// ��¼��ҳ��

			oldPage = position;
			currPage = position;
		}
	}

	private class ViewPagerTask implements Runnable {
		@Override
		public void run() {
			// �ı䵱ǰҳ���ֵ
			currPage = (currPage + 1) % images.length;
			// ������Ϣ��UI�߳�
			handler.sendEmptyMessage(0);
		}
	}

	private Handler handler = new Handler() {
		public void handleMessage(Message msg) {
			// ���յ���Ϣ�󣬸���ҳ��
			viewPager.setCurrentItem(currPage);
		};
	};
}
