package com.example.airik.jobbing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Article> mArticles;
    ArticleAdapter mArticleAdapter;
    ListView mListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView =(ListView)findViewById(R.id.listView);
        mArticles = new ArrayList<Article>();

        mArticles.add(new Article(getString(R.string.user1), getString(R.string.naiyou1)));
        mArticles.add(new Article(getString(R.string.user2), getString(R.string.naiyou2)));
        mArticles.add(new Article(getString(R.string.user1), getString(R.string.naiyou1)));
        mArticles.add(new Article(getString(R.string.user1), getString(R.string.naiyou1)));

        mArticleAdapter = new ArticleAdapter(this,R.layout.article,mArticles);
        mListView.setAdapter(mArticleAdapter);

    }
}
