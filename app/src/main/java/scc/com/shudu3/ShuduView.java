package scc.com.shudu3;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;


public class ShuduView extends View {

    private float width;
    private float height;

    private Game game=new Game();

    public ShuduView(Context context) {
        super(context);
    }
    @Override
    protected void onSizeChanged(int w,int h,int oldw,int oldh){
        this.width=w/9f;
        this.height=h/9f;
        super.onSizeChanged(w,h,oldw,oldh);
    }
    @Override
    protected void onDraw(Canvas canvas){
        Paint backgroundPaint=new Paint();
        backgroundPaint.setColor(getResources().getColor(R.color.shudu_background));
        canvas.drawRect(0,0,getWidth(),getHeight(),backgroundPaint);

        Paint darkPaint= new Paint();
        darkPaint.setStrokeWidth(2);
        darkPaint.setColor(getResources().getColor(R.color.shudu_dark));

        Paint hiltilePaint= new Paint();
        hiltilePaint.setStrokeWidth(2);
        hiltilePaint.setColor(getResources().getColor(R.color.shudu_hitile));

        Paint lightPaint = new Paint();
        lightPaint.setStrokeWidth(2);
        lightPaint.setColor(getResources().getColor(R.color.shudu_light));

        for (int i=0;i<9;i++){

            canvas.drawLine(0,i*height,getWidth(),i*height,lightPaint);
            canvas.drawLine(0,i*height+2,getWidth(),i*height+2,hiltilePaint);
            canvas.drawLine(i*width,0,i*width,getHeight(),lightPaint);
            canvas.drawLine(i*width+2,0,i*width+2,getHeight(),hiltilePaint);
        }
        for (int i=0;i<9;i++) {
            if (i % 3 != 0) {
                continue;
            }
            canvas.drawLine(0,i*height,getWidth(),i*height,darkPaint);
            canvas.drawLine(0,i*height+2,getWidth(),i*height+2,hiltilePaint);
            canvas.drawLine(i*width,0,i*width,getHeight(),darkPaint);
            canvas.drawLine(i*width+2,0,i*width+2,getHeight(),hiltilePaint);
        }
        Paint numberPaint = new Paint();
        numberPaint.setColor(Color.BLACK);
        numberPaint.setStyle(Paint.Style.STROKE);
        numberPaint.setTextSize(0.75f*height);
        numberPaint.setTextAlign(Paint.Align.CENTER);

        Paint.FontMetrics fm= numberPaint.getFontMetrics();
        float x=width/2;
        float y=height/2-(fm.ascent+fm.descent)/2;
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                canvas.drawText(game.getTitleString(i,j),i*width+x,j*height+y,numberPaint);
            }
        }
        super.onDraw(canvas);
}

}
