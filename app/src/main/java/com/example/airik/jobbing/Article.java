package com.example.airik.jobbing;

import java.io.Serializable;

public class Article implements Serializable {
    public String username;
    public String title;
    public String honbun;

    public int icon = R.drawable.umi;

    public boolean isFavorite = false; //お気に入りにされているかどうか

    public Article(){

    }

    public Article(String username,  String title,String honbun) {

        this.username = username; //usernameは自動で記事に登録されるように設定する！！
        this.title = title;
        this.honbun = honbun;


    }

    public Article(String username,  String title,String honbun,int icon) {

        this.username = username;
        this.title = title;
        this.honbun = honbun;
        this.icon = icon;


    }
}