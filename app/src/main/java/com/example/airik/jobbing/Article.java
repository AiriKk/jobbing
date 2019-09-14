package com.example.airik.jobbing;

import java.io.Serializable;

public class Article implements Serializable {
    public String username;
    public String title;
    public String honbun;

    public int icon;

    public boolean isFavorite = false; //お気に入りにされているかどうか

    public Article(String username,  String title,String honbun,int icon) {

        this.username = username;
        this.title = title;
        this.honbun = honbun;
        this.icon = icon;


    }
}