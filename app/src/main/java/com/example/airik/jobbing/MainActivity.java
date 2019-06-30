package com.example.airik.jobbing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

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

        mArticles.add(new Article(getString(R.string.user1), getString(R.string.naiyou1), getString(R.string.shousai1), R.drawable.star));
        mArticles.add(new Article(getString(R.string.user2), getString(R.string.naiyou2), getString(R.string.shousai2), R.drawable.umi));
//        mArticles.add(new Article(getString(R.string.user3), getString(R.string.naiyou3),R.drawable.ikemen));
//        mArticles.add(new Article(getString(R.string.user1), getString(R.string.naiyou1),R.drawable.star));

        mArticleAdapter = new ArticleAdapter(this,R.layout.article,mArticles);
        mListView.setAdapter(mArticleAdapter);

        //TODO ListViewのOnItemClickListenerを実装！
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String msg = position+1 + "番目の職業がクリックされました";
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();

                //選択されたデータを取り出す
                Article article = mArticles.get(position);

                //TODO 詳細画面を開く　
                Intent intent = new Intent(MainActivity.this, ArticleOpenActivity.class);

                intent.putExtra("記事データ", article);

                startActivity(intent);

            }
        });


    }
}