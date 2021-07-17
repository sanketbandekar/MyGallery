package com.example.mygallery.Modal;

public class Main {

    private Photos photos;

    private String stat;

    public Main(Photos photos, String stat) {
        this.photos = photos;
        this.stat = stat;
    }

    public Photos getPhotos() {
        return photos;
    }

    public String getStat() {
        return stat;
    }
}
