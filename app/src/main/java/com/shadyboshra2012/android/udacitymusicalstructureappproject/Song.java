package com.shadyboshra2012.android.udacitymusicalstructureappproject;

 class Song {
    private int id;
    private String name;
    private String artistName;
    private String image;

    Song() {
    }

    Song(int id, String name, String artistName, String image) {
        this.id = id;
        this.name = name;
        this.artistName = artistName;
        this.image = image;
    }

    int getId() {
        return id;
    }

    String getName() {
        return name;
    }

    String getArtistName() {
        return artistName;
    }

    String getImage() {
        return image;
    }
}
