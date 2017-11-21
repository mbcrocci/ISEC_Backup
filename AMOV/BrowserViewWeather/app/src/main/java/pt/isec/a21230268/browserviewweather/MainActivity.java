package pt.isec.a21230268.browserviewweather;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends Activity {

    TextView texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        texto = (TextView) findViewById(R.id.texto);
        DownloadTask downloadTask= new DownloadTask(texto);
        ConnectivityManager connMgr= (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo= connMgr.getActiveNetworkInfo();
        if(networkInfo!= null&& networkInfo.isConnected()) {
            downloadTask.execute("api.openweathermap.org/data/2.5/weather?id=2740637&appid=8e37dc880b0bad592c4f30a27f3b4df9");
        } else {
            texto.setText("No network connectionavailable.");
        }
    }
}

class DownloadTask extends AsyncTask<String, Void, String> {
        TextView texto;
        public DownloadTask(TextView texto) {
            this.texto= texto;
        }

        @Override
        protected String doInBackground(String... params) {
            String resultado = "(erro)";

            try{
                resultado = getData(params[0]);
            } catch(Exception e) {
                e.printStackTrace();
            }
            return resultado;
        }

        @Override
        protected void onPostExecute(String resultado) {
            try {
                JSONObject obj = new JSONObject(resultado);
                JSONObject cityobj = obj.getJSONObject("city");
                JSONObject coord = cityobj.getJSONObject("coord");
                texto.setText("Lat = " + coord.getDouble("lat") +
                            "; Lon = " + coord.getDouble("long")
                );

            } catch (Exception e) {
                e.printStackTrace();
                texto.setText(resultado);
            }
        }

        String getData(String endereco) {
            StringBuilder resp = new StringBuilder();
            try {
                URL url= new URL(endereco);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setReadTimeout(10000 /* milisegundos*/);
                conn.setConnectTimeout(15000 /* milisegundos*/);
                conn.setRequestMethod("GET");
                conn.setDoInput(true);
                conn.connect();
                int codigo= conn.getResponseCode();
                if (codigo== 200) {
                    InputStream is = conn.getInputStream();
                    BufferedReader br = new BufferedReader(new InputStreamReader(is));
                    String line;
                    while ( (line = br.readLine()) != null )
                        resp.append(line + "\n");
                } else {
                    resp.append("Erroa acederàpágina: "+codigo);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return resp.toString();
        }

}
