package com.pratishthakapoor.gomovie.util;

/**
 * Created by tanmayvijayvargiya on 15/01/17.
 */
public class FeedObjectUtil {
    private static int youtubeVideoIdLength = 11;

    public static boolean isValidYoutubeId(String id){
        if(id != null){
            if(id.length() == 11){
                return true;
            }
        }
        return false;
    }

    public static boolean isValidPicture(String url) {
        if (url != null) {
            if (url.endsWith(".jpg") || url.endsWith(".jpeg") || url.endsWith(".png")) {
                return true;
            }
        }
        return false;
    }

    public static String getThumbnailUrlFromId(String id){
        return "https://img.youtube.com/vi/"+id+"/mqdefault.jpg";
    }

    public static String getStringFromVerb(String verb){
        return getStringFromVerb(verb, "a");
    }
    public static String getStringFromVerb(String verb , String count){
        String result = "";
        if(verb.equals("post")){
            result =  "posted " + count + " ";
        }
        if(verb.equals("WANT_WATCH")){
            result =  "wants to watch " + count + " ";
        }
        if(verb.equals("review")){
            result = "did " + count + " movie ";
        }
        else
            result =  " " + verb + " ";

        if(count != "a"){
            result += "movies";
        }
        return result;
    }

}
