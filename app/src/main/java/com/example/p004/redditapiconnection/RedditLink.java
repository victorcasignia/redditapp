package com.example.p004.redditapiconnection;

import org.json.JSONObject;

/**
 * Created by P004 on 3/9/2018.
 */

public class RedditLink extends RedditObject {
    public Boolean isSelf;

    public Boolean getSelf() {
        return isSelf;
    }

    public void setSelf(Boolean self) {
        isSelf = self;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getPermalink() {
        return Permalink;
    }

    public void setPermalink(String permalink) {
        Permalink = permalink;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public RedditAccount getPoster() {
        return Poster;
    }

    public void setPoster(RedditAccount poster) {
        Poster = poster;
    }

    public String getPreview() {
        return Preview;
    }

    public void setPreview(String preview) {
        Preview = preview;
    }

    public int getScore() {
        return Score;
    }

    public void setScore(int score) {
        Score = score;
    }

    public String getDomain() {
        return Domain;
    }

    public void setDomain(String domain) {
        Domain = domain;
    }

    public Boolean getSpoiler() {
        return isSpoiler;
    }

    public void setSpoiler(Boolean spoiler) {
        isSpoiler = spoiler;
    }

    public String getCreatedUTC() {
        return CreatedUTC;
    }

    public void setCreatedUTC(String createdUTC) {
        CreatedUTC = createdUTC;
    }

    public String getThumbnail() {
        return Thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        Thumbnail = thumbnail;
    }

    private String Title;
    private String Permalink;
    private String URL;
    private RedditAccount Poster;
    private String Preview;
    private int Score;
    private String Domain;
    private Boolean isSpoiler;
    private String CreatedUTC;


    private String Thumbnail;
    public RedditLink(){
    }
}
