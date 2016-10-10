package com.example.anish.youtubechannel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.anish.youtubechannel.Adapters.RecyclerAdapter;
import com.example.anish.youtubechannel.Adapters.YouTubeRecylerAdapter;
import com.example.anish.youtubechannel.Model.Item;
import com.example.anish.youtubechannel.Model.YouTubeResponse;
import com.example.anish.youtubechannel.Rest.ApiClient;
import com.example.anish.youtubechannel.Rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

   private final static String API_KEY = KeyClass.KEY;
    /* private final static String channelId = KeyClass.KEY;
    private final static String part = "snippet,id";
    private final static String order = "date";
    private final static String maxresult = "50";
*/

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);




/*       *//* final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.movies_recycler_view);
        recyclerView.setAdapter(adapter);
       *//* //to use RecycleView, you need a layout manager. default is LinearLayoutManager

       *//* YouTubeRecylerAdapter adapter=new YouTubeRecylerAdapter(MainActivity.this);
        recyclerView.setAdapter(adapter);*//*
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        //ApiInterface apiService =ApiClient.getClient().create(ApiInterface.class);
        Call<YouTubeResponse> call = apiService.getChannelResult();//API_KEY,channelId,part,order,maxresult

        call.enqueue(new Callback<YouTubeResponse>() {
            @Override
            public void onResponse(Call<YouTubeResponse> call, Response<YouTubeResponse> response) {
                List<Item> items = response.body().getItems();

                final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list);
                recyclerView.setHasFixedSize(true);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
                linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                recyclerView.setLayoutManager(linearLayoutManager);
                recyclerView.setAdapter(new YouTubeRecylerAdapter(items, R.layout.youtuberow, getApplicationContext()));
            }

            @Override
            public void onFailure(Call<YouTubeResponse> call, Throwable t) {

            }
        });
    }
}*/


        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        //ApiInterface apiService =ApiClient.getClient().create(ApiInterface.class);
        Call<YouTubeResponse> call = apiService.getChannelResult(API_KEY);
        call.enqueue(new Callback<YouTubeResponse>() {
            @Override
            public void onResponse(Call<YouTubeResponse> call, Response<YouTubeResponse> response) {
                //int statusCode = response.code();
                List<Item> items =(List<Item>)response.body().getItems();
                Log.d(TAG, "onResponse: "+items.size());
                recyclerView.setAdapter(new YouTubeRecylerAdapter(items, R.layout.youtuberow, getApplicationContext()));
            }

            @Override
            public void onFailure(Call<YouTubeResponse> call, Throwable t) {
                // Log error here since request failed
                Log.d(TAG,"ERRor",t);
            }
        });
    }}
