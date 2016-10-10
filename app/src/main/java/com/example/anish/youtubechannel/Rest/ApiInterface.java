package com.example.anish.youtubechannel.Rest;

import com.example.anish.youtubechannel.Model.YouTubeResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by ANISH on 09-10-2016.
 */
public interface ApiInterface
{
    @GET("search?&channelId=UC6ZkHcW5QQubZ-Q6XYINE3Q&part=snippet,id&order=date&maxResults=50")
    Call<YouTubeResponse> getChannelResult(@Query("key") String key);//key=AIzaSyAKY_5SRDhyy0CiYCwdIASimezW0CNt2HA
}

//@Query("key") String key,@Query("channelId") String channelId,@Query("part") String part,@Query("order") String order,@Query("maxResults") String maxResults
