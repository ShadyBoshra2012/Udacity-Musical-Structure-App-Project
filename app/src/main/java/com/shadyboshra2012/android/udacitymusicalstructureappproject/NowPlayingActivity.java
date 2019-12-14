package com.shadyboshra2012.android.udacitymusicalstructureappproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class NowPlayingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_plaing);

        // Back button
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);

        // Array of Songs' names.
        String[] songsName = new String[]{"LoveGame", "Time What Is Time", "Halo", "I Miss You", "Let It Be",
                "Where Are You", "Sirens Call", "Fallin", "Black Velvet", "Believer"};
        // Array of Songs' artist names.
        String[] songsArtists = new String[]{"Lady Gaga", "Blind Guardian", "Beyoncé", "blink-182", "Ambelique",
                "Eric Martin", "Cats on Trees", "Alicia Keys", "Alannah Myles", "Imagine Dragons"};

        // Retrieve song id which it have been sent from previous activity.
        int songID = getIntent().getIntExtra("songID", 0);
        Song selectedSong = new Song();

        // Loop to initialize new song
        // And add it to Songs array list.
        // And select the song which has same id.
        for (int id = 0; id < 10; id++) {
            String name = songsName[id];
            String artistName = songsArtists[id];
            String image = name.toLowerCase().replaceAll(" ", "_");
            Song song = new Song(id, name, artistName, image);

            if (id == songID) {
                selectedSong = song;
                break;
            }
        }

        // Initialize variables for changing image, song name and song artist name.
        ImageView songImageView = findViewById(R.id.song_image_view);
        int resourceId = getResources().getIdentifier(selectedSong.getImage(), "drawable",
                "com.shadyboshra2012.android.udacitymusicalstructureappproject");
        songImageView.setImageResource(resourceId);
        TextView songNameTextView = findViewById(R.id.song_name_text);
        songNameTextView.setText(selectedSong.getName());
        TextView songArtistNameTextView = findViewById(R.id.song_artist_name_text);
        songArtistNameTextView.setText(selectedSong.getArtistName());
    }

    public boolean onOptionsItemSelected(MenuItem item){
        finish();
        return true;
    }
}
