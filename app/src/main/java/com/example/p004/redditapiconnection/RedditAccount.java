package com.example.p004.redditapiconnection;

/**
 * Created by P004 on 3/9/2018.
 */

public class RedditAccount extends RedditObject {
    public String Username;
    public String Link;
    public RedditAccount(String Uname){
        Username = Uname;
        Link = "http://www.reddit.com/u/"+Uname;
    }
}
