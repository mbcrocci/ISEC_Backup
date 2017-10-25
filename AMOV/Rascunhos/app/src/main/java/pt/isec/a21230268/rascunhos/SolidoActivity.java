package pt.isec.a21230268.rascunhos;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.SeekBar;

public class SolidoActivity extends Activity {

    SeekBar sbRed, sbGreen, sbBlue;
    FrameLayout frPreview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solido);

        sbRed     = findViewById(R.id.sbRed);
        sbGreen   = findViewById(R.id.sbGreen);
        sbBlue    = findViewById(R.id.sbBlue);
        frPreview = findViewById(R.id.frPreview);

        sbRed.setMax(255);   sbRed.setProgress(255);
        sbGreen.setMax(255); sbGreen.setProgress(255);
        sbBlue.setMax(255);  sbBlue.setProgress(255);

        sbRed.setOnSeekBarChangeListener(procSeekBar);
        sbGreen.setOnSeekBarChangeListener(procSeekBar);
        sbBlue.setOnSeekBarChangeListener(procSeekBar);

    }

    SeekBar.OnSeekBarChangeListener procSeekBar = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            int color = Color.rgb(
                    sbRed.getProgress(),
                    sbGreen.getProgress(),
                    sbBlue.getProgress()
            );
            frPreview.setBackgroundColor(color);
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mi = getMenuInflater();
        mi.inflate(R.menu.menu_criar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menuCriar) {
            Intent intent = new Intent(this, DesenhoActivity.class);

            String strTitulo = ((EditText) findViewById(R.id.edTitulo)).getText().toString();
            if (strTitulo == null || strTitulo.length()<1) {
                ((EditText) findViewById(R.id.edTitulo)).requestFocus();
            }
            int color = Color.rgb(
                    sbRed.getProgress(),
                    sbGreen.getProgress(),
                    sbBlue.getProgress()
            );

            intent.putExtra("Titulo", strTitulo);
            intent.putExtra("Cor", color);

            startActivity(intent);
            finish();

            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
