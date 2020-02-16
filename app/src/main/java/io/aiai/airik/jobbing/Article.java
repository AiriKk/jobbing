package io.aiai.airik.jobbing;

import java.io.Serializable;

public class Article implements Serializable {
    public String username;
    public String title;
    public String honbun;
    public int ageA;

    public int icon = io.aiai.airik.jobbing.R.drawable.hito;

    public boolean isFavorite = false; //お気に入りにされているかどうか

    public Article(){

    }

//    public Article(String username,  String title,String honbun,Int ageA) {
//
//        this.username = username; //usernameは自動で記事に登録されるように設定する！！
//        this.title = title;
//        this.honbun = honbun;
//        this.ageA = ageA;
//
//
//    }

    public Article(String username,  String title,String honbun,int icon,int ageA) {

        this.username = username;
        this.title = title;
        this.honbun = honbun;
        this.icon = icon;
        this.ageA= ageA;


    }
}