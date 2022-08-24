//Stuart Lees
// S1821982

package org.stuart.gcu.leesstuartmpdresit;

public class Weather
{
    private String title;
    private String description;
    private String language;
    private String pubDate;
    private String geo_rss;
    private String max_temp;
    private String min_temp;
    private String wind_dir;
    private String wind_speed;
    private String sunset;
    private String weather;
    private String image;
    private String pressure;
    private boolean check;

    public Weather()
    {
        title = "";
        description = "";
        language = "";
        pubDate = "";
        geo_rss = "";
        max_temp= "";
        min_temp= "";
        wind_dir= "";
        wind_speed= "";
        sunset= "";

    }

    public Weather(String title, String description, String language, String pubDate, String geo_rss, String max_temp, String min_temp, String wind_dir, String wind_speed, String sunset)
    {
        title = title;
        description = description;
        language = language;
        pubDate = pubDate;
        geo_rss = geo_rss;
        max_temp= max_temp;
        min_temp= min_temp;
        wind_dir= wind_dir;
        wind_speed= wind_speed;
        sunset= sunset;
    }

    public String getTitle()
    {
        return title;
    }
    public void setTitle(String title) {this.title = title;}

    public Boolean getCheck() {return check;}
    public void setCheck(Boolean inc){this.check = check;}

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getLanguage() { return language; }
    public void setLanguage(String language) { this.language = language; }

    public String getPubDate() { return pubDate; }
    public void setPubDate(String pubDate) { this.pubDate = pubDate; }

    public String getGeo_rss() { return geo_rss; }
    public void setGeo_rss(String geo_rss) { this.geo_rss = geo_rss; }

    public String getMax_temp() { return max_temp; }
    public void setMax_temp(String max_temp) { this.max_temp = max_temp; }

    public String getMin_temp() { return min_temp; }
    public void setMin_temp(String min_temp) { this.min_temp = min_temp; }

    public String getWind_dir() { return wind_dir; }
    public void setWind_dir(String win_dir) { this.wind_dir = win_dir; }

    public String getWind_speed() { return wind_speed; }
    public void setWind_speed(String wind_speed) { this.wind_speed = wind_speed; }

    public String getSunset() { return sunset; }
    public void setSunset(String sunset) { this.sunset = sunset; }

    public String getPressure() { return pressure; }
    public void setPressure(String pressure) { this.pressure = pressure; }

    public String getImage() { return image; }


    @Override
    public String toString() {
        return "Weather :: Title=" + this.title + " Description=" + this.description +
                " Language=" + this.language + " Date=" + this.pubDate + "Sunset=" + this.sunset;
    }


    private String getImage(String d){
        String image = "";
        //String weather = String.format();

        if (weather == "clear"){
            image = "day_clear";
        } else if (weather == "Light Rain") {
            image = "rain";
        } else if (weather == "Windy") {
            image = "wind";
        } else if (weather == "Cloudy") {
            image = "overcast";
        } else {
            image = "day_clear";
        }
        return image+".png";
    }
}

// End of class
