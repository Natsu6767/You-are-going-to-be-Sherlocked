package com.mdg_recruitment.mohit.sherlock;


public class Config {

    // Google Console APIs developer key
    public static final String DEVELOPER_KEY = "AIzaSyDgYHGl9THR-doFpplz4Wou5JLomteAm90";
    //YouTube video id
    public static  String YOUTUBE_VIDEO_CODE = new String();

    // Sets YouTube video id
    public static void videoIdSet(){

         switch (MainActivity.SEASON){

             case "Season 1" :
                 switch (MainActivity.EPISODE){
                     case "Episode 1" : YOUTUBE_VIDEO_CODE = "MiglWGPP0nA"; break;
                     case "Episode 2" : YOUTUBE_VIDEO_CODE = "y_GGbRkqqFg"; break;
                     case "Episode 3" : YOUTUBE_VIDEO_CODE = "AviDWKhmVdU"; break;
                 }
                 break;
             case "Season 2" :
                 switch (MainActivity.EPISODE){
                     case "Episode 1" : YOUTUBE_VIDEO_CODE = "JE4wTmbyV8g"; break;
                     case "Episode 2" : YOUTUBE_VIDEO_CODE = "bm78r2innnE"; break;
                     case "Episode 3" : YOUTUBE_VIDEO_CODE = "wVoo9RqrHtw"; break;
                 }
                 break;
             case "Season 3" :
                 switch (MainActivity.EPISODE){
                     case "Episode 1" : YOUTUBE_VIDEO_CODE = "O7cKIjNIPoY"; break;
                     case "Episode 2" : YOUTUBE_VIDEO_CODE = "N-lMgIg2p1c"; break;
                     case "Episode 3" : YOUTUBE_VIDEO_CODE = "LI7T69cA3Kg"; break;
                 }
                 break;
         }


    }
}
