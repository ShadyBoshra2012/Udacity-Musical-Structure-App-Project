package com.shadyboshra2012.android.udacitymusicalstructureappproject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import java.util.ArrayList;

public class SongsAdapter extends ArrayAdapter<Song> {

    private Context mContext;

    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context The current context. Used to inflate the layout file.
     * @param Songs   A List of AndroidFlavor objects to display in a list
     */
    public SongsAdapter(Activity context, ArrayList<Song> Songs) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, Songs);
        mContext = context;
    }



    @Override
    public View getView(final int position, final View convertView, final ViewGroup parent) {
        View listItemView;
        CardView cardView;
        ImageView songImageView;
        TextView songNameTextView;
        TextView songArtistNameTextView;

        listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.song_list_item, parent, false);
        }

        final Song currentSong = getItem(position);

        cardView =  listItemView.findViewById(R.id.card_view);

        songNameTextView = listItemView.findViewById(R.id.song_name_text);
        songNameTextView.setText(currentSong.getName());

        songArtistNameTextView = listItemView.findViewById(R.id.song_artist_name_text);
        songArtistNameTextView.setText(currentSong.getArtistName());

        songImageView =  listItemView.findViewById(R.id.song_image_view);
        int resourceId = mContext.getResources().getIdentifier(currentSong.getImage(), "drawable",
                "com.shadyboshra2012.android.udacitymusicalstructureappproject");
        songImageView.setImageResource(resourceId);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent playMusicIntent = new Intent(mContext, NowPlayingActivity.class);
                playMusicIntent.putExtra("songID", currentSong.getId());
                mContext.startActivity(playMusicIntent);
            }
        });

        return listItemView;
    }
}
