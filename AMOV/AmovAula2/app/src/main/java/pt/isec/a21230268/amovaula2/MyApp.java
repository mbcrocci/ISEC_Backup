package pt.isec.a21230268.amovaula2;

import android.app.Application;
import android.content.res.Configuration;
import android.util.Log;

/**
 * Created by m0nk1w1 on 10/10/2017.
 */

public class MyApp extends Application {
    @Override
    public void onCreate() {
        Log.i("AmovP1A2", "MyApp:onCreate");
        super.onCreate();
    }

    @Override
    public void onLowMemory() {
        Log.i("AmovP1A2", "onLowMemory");
        super.onLowMemory();
    }

    @Override
    public void onTrimMemory(int level) {
        Log.i("AmovP1A2", "onTrimMemory");
        super.onTrimMemory(level);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        Log.i("AmovP1A2", "onConfigurationChanged");
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onTerminate() {
        Log.i("AmovP1A2", "onTerminate");
        super.onTerminate();
    }
}
