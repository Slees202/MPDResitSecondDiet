//Stuart Lees
// S1821982

package org.stuart.gcu.leesstuartmpdresit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ViewFlipper;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements OnClickListener
{

    private TextView WeatherElement;
    private TextView rawDataDisplay;
    private Button startButton, GlasButton, LondButton, NYButton, OmanButton, MauriButton, BanglaButton;;
    private String result = "";
    private String url1="";
    // Traffic Scotland Planned Roadworks XML link
    private String urlSource="https://weather-broker-cdn.api.bbci.co.uk/en/forecast/rss/3day/2643123";

    private Button btn;
    private Button btnForward;
    private Button btnBack;
    private TextView picNumbDisplay;
    private ViewFlipper flip;
    private int picCount;

    private String URLGlas = "https://weather-broker-cdn.api.bbci.co.uk/en/forecast/rss/3day/2648579";
    private String URLLond = "https://weather-broker-cdn.api.bbci.co.uk/en/forecast/rss/3day/2643743";
    private String URLNY = "https://weather-broker-cdn.api.bbci.co.uk/en/forecast/rss/3day/5128581";
    private String URLOman = "https://weather-broker-cdn.api.bbci.co.uk/en/forecast/rss/3day/287286";
    private String URLMauritius = "https://weather-broker-cdn.api.bbci.co.uk/en/forecast/rss/3day/934154";
    private String URLBangla = "https://weather-broker-cdn.api.bbci.co.uk/en/forecast/rss/3day/1185241";



    private String WeatherGlas[] = {};
    private String WeatherLond[] = {};
    private String WeatherNY[] = {};
    private String WeatherOman[] = {};
    private String WeatherMauri[] = {};
    private String WeatherBangla[] = {};
    private ArrayList<Weather> ItemGlas;
    private ArrayList<Weather> ItemLond;
    private ArrayList<Weather> ItemNY;
    private ArrayList<Weather> ItemOman;
    private ArrayList<Weather> ItemMauri;
    private ArrayList<Weather> ItemBangla;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("MyTag","in onCreate");
        // Set up the raw links to the graphical components
        rawDataDisplay = (TextView)findViewById(R.id.rawDataDisplay);
        startButton = (Button)findViewById(R.id.startButton);
        startButton.setOnClickListener(this);
        Log.e("MyTag","after startButton");

        GlasButton = (Button)findViewById(R.id.GlasButton);
        GlasButton.setOnClickListener(this);
        LondButton = (Button)findViewById(R.id.LondButton);
        LondButton.setOnClickListener(this);
        NYButton = (Button)findViewById(R.id.NYButton);
        NYButton.setOnClickListener(this);
        OmanButton = (Button)findViewById(R.id.OmanButton);
        OmanButton.setOnClickListener(this);
        MauriButton = (Button)findViewById(R.id.MauriButton);
        MauriButton.setOnClickListener(this);
        BanglaButton = (Button)findViewById(R.id.BanglaButton);
        BanglaButton.setOnClickListener(this);

        btnForward=(Button)findViewById(R.id.btnForward);
        btnBack=(Button)findViewById(R.id.btnBack);
        picNumbDisplay = findViewById(R.id.picNumbDisplay);
        btnForward.setOnClickListener(this);
        btnBack.setOnClickListener(this);
        flip=(ViewFlipper)findViewById(R.id.flip);

        flip.setInAnimation(this,android.R.anim.fade_in);

        flip.setOutAnimation(this, android.R.anim.fade_out);

        picCount = 1;

        Log.e("MyTag",picCount + "");
        picNumbDisplay.setText("Picture Count " + picCount + " of 5");


    }

    public void startProgress(String url, String location) {
        String[] urlAndLocation = {url, location};
        new Task().execute(urlAndLocation);
    }


    @Override
    public void onClick(View v) {
        String location;
        Log.e("MyTag", "in onClick");
        Log.e("MyTag", "after startProgress");


            if (v == btnForward)
            {
                flip.showNext();
                if (picCount == 5)
                    picCount = 1;
                else
                    picCount = picCount + 1;

                Log.e("MyTag",picCount + "");
                picNumbDisplay.setText("Picture Count " + picCount + " of 5");
            }
            else
            {
                flip.showPrevious();
                if (picCount == 1)
                    picCount = 5;
                else
                    picCount = picCount - 1;

                Log.e("MyTag",picCount + "");
                picNumbDisplay.setText("Picture Count " + picCount + " of 5");
            }




        switch (v.getId()) {

            case R.id.GlasButton:
                location = "Glasgow";
                Log.d("MyTag", "Location Is " + location);
                WeatherElement.setText("Glasgow Weather");
                if (WeatherGlas.length != 0) {
                    Log.e("MyTag", "Weather Unavailable");
                } else {
                    startProgress(URLGlas, location);
                }
                break;

            case R.id.LondButton:
                location = "Glasgow";
                Log.d("MyTag", "Location Is " + location);
                WeatherElement.setText("London Weather");
                if (WeatherLond.length != 0) {
                    Log.e("MyTag", "Weather Unavailable");
                } else {
                    startProgress(URLLond, location);
                }
                break;

            case R.id.NYButton:
                location = "New York";
                Log.d("MyTag", "Location Is " + location);
                WeatherElement.setText("New York Weather");
                if (WeatherNY.length != 0) {
                    Log.e("MyTag", "Weather Unavailable");
                } else {
                    startProgress(URLNY, location);
                }
                break;

            case R.id.OmanButton:
                Button:
                location = "Oman";
                Log.d("MyTag", "Location Is " + location);
                WeatherElement.setText("Omani Weather");
                if (WeatherOman.length != 0) {
                    Log.e("MyTag", "Weather Unavailable");
                } else {
                    startProgress(URLOman, location);
                }
                break;

            case R.id.MauriButton:
                location = "Mauritius";
                Log.d("MyTag", "Location Is " + location);
                WeatherElement.setText("Mauritius Weather");
                if (WeatherMauri.length != 0) {
                    Log.e("MyTag", "Weather Unavailable");
                } else {
                    startProgress(URLMauritius, location);
                }
                break;

            case R.id.BanglaButton:
                location = "Bangladesh";
                Log.d("MyTag", "Location Is " + location);
                WeatherElement.setText("Bangladesh Weather");
                if (WeatherBangla.length != 0) {
                    Log.e("MyTag", "Weather Unavailable");
                } else {
                    startProgress(URLBangla, location);
                }
                break;


        }
    }

    public ArrayList handleResult(String data){
        PullParser p = new PullParser();
        p.parse(data);
        return p.getApplications();
    }

    // Need separate thread to access the internet resource over network
    // Other neater solutions should be adopted in later iterations.
    private class Task extends AsyncTask<String[], Void, ArrayList<Weather>> {

        String tType;

        @Override
        public ArrayList<Weather> doInBackground(String[]... params) {
            tType = params[0][1];

            Log.d("MyTag","In background, params: "+ params[0][0]+ tType);
            return getData(params[0][0]); }

        private ArrayList<Weather> getData(String url)
        {
            URL url1;
            URLConnection yc;
            BufferedReader in = null;
            String inputLine = "";

            try{
                result = "";
                url1 = new URL(url);
                yc = url1.openConnection();
                in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
                Log.d("MyTag","Retrieving data from:  " + url);

                while ((inputLine = in.readLine()) != null){
                    result = result + inputLine;
                }
                Log.i("MyTag", "Successful. Result: " + result);
                in.close();
            }
            catch (IOException ae)
            {
                Log.e("MyTag", "Error: IOException");
            }

            // Once XML data is collected it is then parsed

            ArrayList<Weather> items= handleResult(result);
            Log.d("MyTag", "Total items parsed: "+ items.size());

            String titles[];
            int i = 0;
            titles = new String [items.size()];
            for (Weather o : items){
                titles[i] = o.getTitle();
                i++; }

            if (items.size() == 0) {
                Weather neu = new Weather();
                neu.setTitle("No Incidents Found");
                items.add(neu); }

            switch(tType) {
                case "WeatherGlas":
                    Log.d("MyTag", "Weather " + items);
                    WeatherGlas = titles;
                    ItemGlas = items;
                    break;


                case "WeatherLond":
                    Log.d("MyTag", "Weather " + items);
                    WeatherLond = titles;
                    ItemLond = items;
                    break;

                case "WeatherNY":
                    Log.d("MyTag", "Weather " + items);
                    WeatherNY = titles;
                    ItemNY = items;
                    break;

                case "WeatherOman":
                    Log.d("MyTag", "Weather " + items);
                    WeatherOman = titles;
                    ItemOman = items;
                    break;

                case "WeatherMauri":
                    Log.d("MyTag", "Weather " + items);
                    WeatherMauri = titles;
                    ItemMauri = items;
                    break;

                case "WeatherBangla":
                    Log.d("MyTag", "Weather " + items);
                    WeatherBangla = titles;
                    ItemBangla = items;
                    break;
            }

                return items;

        }
    }
}