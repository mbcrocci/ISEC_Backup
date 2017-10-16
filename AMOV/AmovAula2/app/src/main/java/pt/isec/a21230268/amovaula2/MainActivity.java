package pt.isec.a21230268.amovaula2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("AmovP1Aula2", "onCreate");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
