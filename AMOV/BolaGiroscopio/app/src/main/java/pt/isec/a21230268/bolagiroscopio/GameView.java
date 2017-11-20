package pt.isec.a21230268.bolagiroscopio;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class GameView extends View {

    Paint paint;
    Position posx, posy;


    public GameView(Context context, Position posx, Position posy) {
        super(context);
        this.posx = posx;
        this.posy = posy;

        paint = new Paint(Paint.DITHER_FLAG);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.rgb(0x36,0x2c,0x1d));
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        posx.actLimites(0, w);
        posy.actLimites(0, h);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(100, 100, 50, paint);
    }
}
