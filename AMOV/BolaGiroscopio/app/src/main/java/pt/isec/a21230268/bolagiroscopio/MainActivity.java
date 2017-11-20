package pt.isec.a21230268.bolagiroscopio;

import android.app.Activity;
import android.graphics.Typeface;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.Surface;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements SensorEventListener {

    SensorManager sm;
    Sensor sensor; // acelerometro
    GameView gameView;
    Position posx, posy;
    Display display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WindowManager wm = (WindowManager) getSystemService(WINDOW_SERVICE);
        display = wm.getDefaultDisplay();

        sm = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensor = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        if (sensor == null) {
            Toast.makeText(this, R.string.msgNoAccel, Toast.LENGTH_LONG).show();
            finish();
            return;
        }

        posx = new Position(100, 0, 200, 0);
        posy = new Position(100, 0, 200, 0);

        FrameLayout fr = (FrameLayout) findViewById(R.id.frGameView);
        gameView = new GameView(this, posx, posy);
        fr.addView(gameView);

        TextView tv = (TextView) findViewById(R.id.tvTitulo);
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/Capture_it.ttf");
        tv.setTypeface(font);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (sm != null && sensor != null) {
            sm.registerListener(this, sensor, SensorManager.SENSOR_DELAY_GAME);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (sm != null && sensor != null)
            sm.unregisterListener(this);
    }

    long lasttime = -1;

    @Override
    public void onSensorChanged(SensorEvent event) {
        Log.i("Sensor", "val1 = " + event.values[0] +
                "; val2 = " + event.values[1] +
                "; val3 = " + event.values[2]);

        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            if (lasttime >= 0) {
                float ax = event.values[0];
                float ay = event.values[1];

                switch (display.getRotation()) {
                    case Surface.ROTATION_0:
                        break;

                    case Surface.ROTATION_90:
                        break;

                    case Surface.ROTATION_180:
                        break;

                    case Surface.ROTATION_270:
                        break;
                }

                long dt = event.timestamp - lasttime;

                posx.actualiza(ax, dt);
                posy.actualiza(ay, dt);

                gameView.invalidate();
                lasttime = event.timestamp;
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
