//Stuart Lees
// S1821982

package org.stuart.gcu.leesstuartmpdresit;

import android.util.Log;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.StringReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;


public class PullParser {
    private static final String TAG = "ParseIncidents";
    private ArrayList<Weather> applications;

    public PullParser() {
        this.applications = new ArrayList<>();
    }



    public ArrayList<Weather> getApplications() {
        return applications;
    }

    public boolean parseData(String xmlData) {
        boolean status = true;
        Weather currentWeather = null;
        boolean inEntry = false;
        String textValue = "";
        Log.d(TAG, "Starting to parse the XML Data: " + xmlData);

        try {
                Log.d(TAG, "Parse Debug 1");
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser xpp = factory.newPullParser();
            xpp.setInput(new StringReader(xmlData));
            int eventType = xpp.getEventType();
//            eventType = xpp.next();
//
            Log.d(TAG, "Parse Debug 2: Before first item");

            while(eventType != XmlPullParser.END_DOCUMENT) {
                String tagName = xpp.getName();
                switch (eventType) {
                    case XmlPullParser.START_TAG:
                        if("item".equalsIgnoreCase(tagName)) {
                            inEntry = true;
                            currentWeather = new Weather();
                        }
                        break;

                    case XmlPullParser.TEXT:
                        textValue = xpp.getText();
                        break;

                    case XmlPullParser.END_TAG:
                        if(inEntry) {
                            if("item".equalsIgnoreCase(tagName)) {
                                applications.add(currentWeather);
                                inEntry = false;
                            }else if("title".equalsIgnoreCase(tagName)) {
                                currentWeather.setTitle(textValue);
                            }else if("description".equalsIgnoreCase(tagName)) {
                                Log.d("MyTag", "Unedited Description "+textValue);
                                currentWeather.setMax_temp(textValue);
                                if (textValue.contains("Maximum Temperature:")) {
                                    String[] parts = textValue.split(",");

                                    String min_temp = currentWeather.getMin_temp();
                                    String wind_dir = currentWeather.getWind_dir();
                                    String pressure = currentWeather.getPressure();
                                    String sunset = currentWeather.getSunset();


                                    currentWeather.setMin_temp(min_temp);
                                    currentWeather.setWind_dir(wind_dir);
                                    currentWeather.setPressure(pressure);
                                    currentWeather.setSunset(sunset);
                                    currentWeather.setCheck(false);
                                } else {currentWeather.setCheck(true);}
                            }else if("pubDate".equalsIgnoreCase(tagName)) {
                                currentWeather.setPubDate(textValue);
                            }
                        }
                        break;
                    default:
                }
                eventType = xpp.next();

            }
            Log.d("ParseIncidents", "Finished Parsing items");
            for (Weather app: applications) {
            }

        } catch(Exception e) {
            status = false;
            e.printStackTrace();
        }
        return status;
    }

    private Date[] Date(String[] parts){
        Date FormatDate = null;

        try{
            String Date = parts[0].substring(0);
            //Formats the Date
            SimpleDateFormat sdf = new SimpleDateFormat(" d MMMMM yyyy - HH:mm", Locale.ENGLISH);
            Date sd = sdf.parse(Date);
            sdf.applyPattern("dd/MM/yy HH:mm");
            String theDate = sdf.format(sd);
            FormatDate = sdf.parse(theDate);
        } catch (ParseException e){
            e.printStackTrace();
        }
        return new Date[]{FormatDate};
    };

}