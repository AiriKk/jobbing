package com.example.airik.jobbing;

import java.io.Serializable;

public class Article implements Serializable {
    public String username;
    public String naiyou;
    public String shousai;

    public int icon;

    public boolean isFavorite = false; //お気に入りにされているかどうか

    public Article(String username,  String naiyou,String shousai,int icon) {

        this.username = username;
        this.naiyou = naiyou;
        this.shousai = shousai;
        this.icon = icon;


    }
}