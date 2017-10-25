package pt.isec.a21230268.rascunhos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import javax.xml.transform.SourceLocator;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onSolido(View view) {
        Intent intent = new Intent(this, SolidoActivity.class);
        startActivity(intent);
    }
}
