//Stuart Lees
// S1821982

package org.stuart.gcu.leesstuartmpdresit;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class WeatherItems extends AppCompatActivity implements View.OnClickListener {
    TextView viewtitle;
    TextView viewtemperature;
    TextView viewwind_dir;
    TextView viewpressure;
    TextView viewsunset;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.campusview);

        Intent intent = getIntent();
        viewtitle = findViewById(R.id.Weather);
        viewtemperature = findViewById(R.id.MinimumTemperature);
        viewwind_dir = findViewById(R.id.WindDirection);
        viewpressure = findViewById(R.id.Pressure);
        viewsunset = findViewById(R.id.Sunset);

         String title = intent.getExtras().getString("title");
        String min_temp = intent.getExtras().getString("min_temp");
        String wind_dir = intent.getExtras().getString("wind_dir");
        String pressure = intent.getExtras().getString("pressure");
        String sunset = intent.getExtras().getString("sunset");




        viewtitle.setText(title);
        viewtemperature.setText(min_temp);
        viewwind_dir.setText(wind_dir);
        viewpressure.setText(pressure);
        viewsunset.setText(sunset);

    }

        public void onClick (View view){
        }
    }



