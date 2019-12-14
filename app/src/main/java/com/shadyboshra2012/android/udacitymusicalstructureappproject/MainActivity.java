package com.shadyboshra2012.android.udacitymusicalstructureappproject;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize new ArrayList for songs.
        ArrayList<Song> songs = new ArrayList<>();
        // Array of Songs' names.
        String[] songsName = new String[]{"LoveGame", "Time What Is Time", "Halo", "I Miss You", "Let It Be",
                "Where Are You", "Sirens Call", "Fallin", "Black Velvet", "Believer"};
        // Array of Songs' artist names.
        String[] songsArtists = new String[]{"Lady Gaga", "Blind Guardian", "Beyoncé", "blink-182", "Ambelique",
                "Eric Martin", "Cats on Trees", "Alicia Keys", "Alannah Myles", "Imagine Dragons"};

        // Loop to initialize new song
        // And add it to Songs array list.
        for(int id = 0 ; id < 10; id++){
            String name = songsName[id];
            String artistName = songsArtists[id];
            String image = name.toLowerCase().replaceAll(" ", "_");
            Song song = new Song(id, name, artistName,image);
            songs.add(song);
        }

        // Initialize adapter for songs.
        SongsAdapter songsAdapter = new SongsAdapter(this, songs);

        // Initialize songs list view and link it with adapter.
        ListView songsListView = findViewById(R.id.songs_list_view);
        songsListView.setAdapter(songsAdapter);
    }
}
