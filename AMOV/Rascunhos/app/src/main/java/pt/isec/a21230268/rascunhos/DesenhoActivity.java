package pt.isec.a21230268.rascunhos;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

import java.util.ArrayList;

public class DesenhoActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desenho);

        Intent intent = getIntent();

        String strTitulo = intent.getStringExtra("Titulo");
        if (strTitulo==null)
            strTitulo = "(sem nome)";

        int color = intent.getIntExtra("Cor", Color.WHITE);

        FrameLayout fr = findViewById(R.id.frDesenho);
        //fr.setBackgroundColor(color);

        AreaDesenho ad = new AreaDesenho(this, color);
        fr.addView(ad);

        getActionBar().setTitle(strTitulo);
    }
}
class Ponto {
    float x, y;

    public Ponto(float x, float y) {
        this.x = x;
        this.y = y;
    }
}

class AreaDesenho extends View implements GestureDetector.OnGestureListener {
    int corFundo;
    GestureDetector gestureDetector;
    ArrayList<Ponto> tabPontos;

    public AreaDesenho(Context context, int cor) {
        super(context);
        this.corFundo = cor;
        tabPontos = new ArrayList<>();

        setBackgroundColor(cor);
        gestureDetector = new GestureDetector(context, this);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (gestureDetector.onTouchEvent(event))
            return true;

        return super.onTouchEvent(event);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (tabPontos.size() < 2)
            return;

        Paint paint = new Paint(Paint.DITHER_FLAG);

        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(5);
        paint.setStyle(Paint.Style.FILL);

        float x, y, lastx=tabPontos.get(0).x, lasty=tabPontos.get(0).y;
        for (int i = 1; i < tabPontos.size(); i++) {
            x = tabPontos.get(i).x;
            y = tabPontos.get(i).y;

            canvas.drawLine(lastx, lasty, x, y, paint);

            lastx = x;
            lasty = y;
        }


        canvas.drawLine(100, 100, 200, 200, paint);
    }

    @Override
    public boolean onDown(MotionEvent e) {
        tabPontos.add(new Ponto(e.getX(0), e.getY(0)));
        return true;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        tabPontos.add(new Ponto(e2.getX(0), e2.getY(0)));

        invalidate();

        return true;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        return false;
    }
}
