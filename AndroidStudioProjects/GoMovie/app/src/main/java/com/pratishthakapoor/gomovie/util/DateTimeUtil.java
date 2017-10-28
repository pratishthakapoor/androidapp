package com.pratishthakapoor.gomovie.util;

import com.ocpsoft.pretty.time.PrettyTime;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by tanmayvijayvargiya on 15/01/17.
 */
public class DateTimeUtil {

    static PrettyTime prettyTime = new PrettyTime();

    public static String getReadableTimeFromISOstring(String isoTimeString){

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSS");
        Date parsedDate = null;

        try {
            parsedDate = dateFormat.parse(isoTimeString);
        } catch (ParseException e) {
            e.printStackTrace();
            return "";
        }

        return convertDateToReadableTime(parsedDate);
    }

    private static String convertDateToReadableTime(Date targetDate){
        return prettyTime.format(targetDate);
    }
}
