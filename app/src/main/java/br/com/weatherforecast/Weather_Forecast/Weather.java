package br.com.weatherforecast.Weather_Forecast;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class Weather {

     public final String dayOfWeek;
     public final String minTemp;
     public final String maxTemp;
     public final String humidity;
     public final String description;
     public final String iconURL;



     public Weather (long timeStamp, double minTemp,
                     double maxTemp,double humidity,String description,String iconName){


         NumberFormat numberFormat = NumberFormat.getNumberInstance();
         numberFormat.setMaximumFractionDigits(0);
         NumberFormat percentFormat = NumberFormat.getPercentInstance();


         this.minTemp = numberFormat.format(minTemp);
         this.maxTemp = numberFormat.format(maxTemp);
         this.humidity = percentFormat.format(humidity / 100.0);
         this.description = description;
         this.iconURL = "http://openweathermap.org/img/w/" + iconName + ".png";
         this.dayOfWeek = converter(timeStamp);

     }

     public String converter (long timeStamp){

         Calendar calendar = Calendar.getInstance();
         calendar.setTimeInMillis(timeStamp * 1000);
         TimeZone tz = TimeZone.getDefault();
         calendar.add(Calendar.MILLISECOND, tz.getOffset(calendar.getTimeInMillis()));
         SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
         return sdf.format(calendar.getTime());

     }

}
