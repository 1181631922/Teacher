package cn.edu.sjzc.teacher.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class PillarView extends View {

	private Paint paint;
	private Chart chart;
	int left = 85;

	public PillarView(Context context) {
		super(context);
		init();

	}

	public PillarView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();

	}

	public void init() {
		paint = new Paint();
		paint.setColor(Color.BLUE);
		chart = new Chart();

		paint.setAntiAlias(true);
	}

	@Override
	protected void onDraw(Canvas canvas) {
	
		//drawChart(canvas);

		 canvas.drawRect(120, 170, 90, 400, paint);
		//this.postInvalidate();
	}

	public void drawChart(Canvas canvas) {
		

		 canvas.drawRect(20, 170, 90, 130, paint);

		
		//canvas.drawText(2 + "(Íò)", 10,50, paint);
		this.postInvalidate();


	}

	class Chart {
		private int bottom = 1000;

		public void drawSelf(Canvas canvas, Paint paint, float left, float top) {
			
		}
	}

}
