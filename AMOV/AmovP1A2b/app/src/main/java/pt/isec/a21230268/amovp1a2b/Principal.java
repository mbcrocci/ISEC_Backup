package pt.isec.a21230268.amovp1a2b;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by m0nk1w1 on 10/10/2017.
 */

public class Principal extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Log.i("AmovP1A2b","Principal::onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.principal_activity);
    }
}
