package com.example.mygallery.Modal;

public class Photo {

    private String id;
    private String owner;
    private String secret;
    private String server;
    private Integer farm;
    private String title;
    private Integer ispublic;
    private Integer isfriend;
    private Integer isfamily;
    private String url_s;
    private Integer height_s;
    private Integer width_s;

    public Photo(String id, String owner, String secret, String server, Integer farm, String title,
                 Integer ispublic, Integer isfriend, Integer isfamily, String url_s, Integer height_s, Integer width_s) {
        this.id = id;
        this.owner = owner;
        this.secret = secret;
        this.server = server;
        this.farm = farm;
        this.title = title;
        this.ispublic = ispublic;
        this.isfriend = isfriend;
        this.isfamily = isfamily;
        this.url_s = url_s;
        this.height_s = height_s;
        this.width_s = width_s;
    }

    public String getUrl_s() {
        return url_s;
    }

    public Integer getHeight_s() {
        return height_s;
    }

    public Integer getWidth_s() {
        return width_s;
    }
}
