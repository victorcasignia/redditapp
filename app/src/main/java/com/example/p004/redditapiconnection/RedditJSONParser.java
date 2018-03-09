package com.example.p004.redditapiconnection;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by P004 on 3/9/2018.
 */

public class RedditJSONParser {
    public static List<RedditObject> ParseListing(JSONObject Input){
        List<RedditObject> ToReturn = new ArrayList<RedditObject>();

        try{
            String x = Input.getString("kind");
            String DataString = Input.getString("data");
            if(Input.getString("kind")=="Listing"){
                JSONObject Data = new JSONObject(DataString);
                JSONArray Children = Data.getJSONArray("children");
                for(int i=0;i<Children.length();i++){
                    JSONObject Child = Children.getJSONObject(i);
                    /*
                    t1_	Comment
                    t2_	Account
                    t3_	Link
                    t4_	Message
                    t5_	Subreddit
                    t6_	Award
*/
                    JSONObject ChildData = Child.getJSONObject("data");
                    switch(Child.getString("kind")){
                        case "t1":
                            RedditComment rc = new RedditComment();
                            ToReturn.add(rc);
                            break;
                        case "t2":
                            //RedditAccount ra = new RedditAccount();
                            //ToReturn.add(ra);
                            break;
                        case "t3":
                            RedditLink rl = new RedditLink();
                            rl.setCreatedUTC(ChildData.getString("created_utc"));
                            rl.setDomain(ChildData.getString("domain"));
                            rl.setPermalink(ChildData.getString("permalink"));
                            rl.setPoster(new RedditAccount(ChildData.getString("author")));
                            rl.setScore(ChildData.getInt("score"));
                            rl.setSelf(ChildData.getBoolean("is_self"));
                            rl.setSpoiler(ChildData.getBoolean("spoiler"));
                            rl.setThumbnail(ChildData.getString("thumbnail"));
                            rl.setTitle(ChildData.getString("title"));
                            rl.setURL(ChildData.getString("url"));
                            ToReturn.add(rl);
                            break;
                        case "t4":
                            break;
                        case "t5":
                            break;
                        case "t6":
                            break;
                        default:
                            break;

                    }
                }
            }
        }
        catch(JSONException e){

        }
        return ToReturn;
    }
}
