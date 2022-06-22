package com.example.anish.youtubechannel.Adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.anish.youtubechannel.KeyClass;
import com.example.anish.youtubechannel.Model.Id;
import com.example.anish.youtubechannel.Model.Item;
import com.example.anish.youtubechannel.R;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubeStandalonePlayer;
import com.google.android.youtube.player.YouTubeThumbnailLoader;
import com.google.android.youtube.player.YouTubeThumbnailView;

import java.util.List;

/**
 * Created by ANISH on 09-10-2016.
 */
public class YouTubeRecylerAdapter extends RecyclerView.Adapter<YouTubeRecylerAdapter.VideoInfoHolder> {
    private List<Item> items;
    private int rowLayout;
    private Context context;
    Id id;

    public YouTubeRecylerAdapter(List<Item> items, int rowLayout, Context context) {
        this.items = items;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public VideoInfoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.youtuberow, parent, false);
        return new VideoInfoHolder(itemView);
    }
// remove this comment
    @Override
    public void onBindViewHolder(final VideoInfoHolder holder, int position)
    {

        final YouTubeThumbnailLoader.OnThumbnailLoadedListener  onThumbnailLoadedListener = new YouTubeThumbnailLoader.OnThumbnailLoadedListener(){
            @Override
            public void onThumbnailError(YouTubeThumbnailView youTubeThumbnailView, YouTubeThumbnailLoader.ErrorReason errorReason) {

            }

            @Override
            public void onThumbnailLoaded(YouTubeThumbnailView youTubeThumbnailView, String s) {
                youTubeThumbnailView.setVisibility(View.VISIBLE);
                holder.youTubeThumbnailView.setVisibility(View.VISIBLE);
                holder.title.setText("Title");
            }
        };

        holder.youTubeThumbnailView.initialize(KeyClass.KEY, new YouTubeThumbnailView.OnInitializedListener() {
            Id id=new Id();
            @Override
            public void onInitializationSuccess(YouTubeThumbnailView youTubeThumbnailView, YouTubeThumbnailLoader youTubeThumbnailLoader) {

                youTubeThumbnailLoader.setVideo(id.getVideoId());
                youTubeThumbnailLoader.setOnThumbnailLoadedListener(onThumbnailLoadedListener);
                holder.youTubeThumbnailView.setVisibility(View.VISIBLE);
                holder.title.setText("Title");
            }

            @Override
            public void onInitializationFailure(YouTubeThumbnailView youTubeThumbnailView, YouTubeInitializationResult youTubeInitializationResult) {
                //write something for failure
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    public class VideoInfoHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        protected RelativeLayout relativeLayoutOverYouTubeThumbnailView;
        YouTubeThumbnailView youTubeThumbnailView;
        protected CardView playButton;
        TextView title;

        public VideoInfoHolder(View itemView) {
            super(itemView);
            playButton = (CardView) itemView.findViewById(R.id.play_onthis);
            playButton.setOnClickListener(this);
            title = (TextView) itemView.findViewById(R.id.video_title);
            // relativeLayoutOverYouTubeThumbnailView = (RelativeLayout) itemView.findViewById(R.id.youtube_thumbnail);
            youTubeThumbnailView = (YouTubeThumbnailView) itemView.findViewById(R.id.youtube_thumbnail);

        }

        @Override
        public void onClick(View v) {

           /* Intent intent = YouTubeStandalonePlayer.createVideoIntent((Activity) context, KeyClass.KEY, String.valueOf(getLayoutPosition()));//[getLayoutPosition()]
            context.startActivity(intent);*/

            Intent intent= YouTubeStandalonePlayer.createVideoIntent((Activity)context,KeyClass.KEY,id.getVideoId());
            context.startActivity(intent);
        }


    }
}
