package com.example.airik.jobbing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ArticleOpenActivity extends AppCompatActivity {

    TextView kijinonakami;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_open);


        kijinonakami = (TextView)findViewById(R.id.kijinonakami);


        Intent intent = getIntent();
        Article article = (Article) intent.getSerializableExtra("記事データ");

        kijinonakami.setText(article.honbun);
    }

    //TODO コメント機能の追加　
    //TODO 好きな記事をアカウントに保存できるように　
    // TODO プロファイルのデータを変更を可能に　
    //TODO プロファイルの写真を変更を可能に　
    //TODO 検索機能を付け足す　
    //TODO 記事表示時にユーザーネームの表示
    //TODO 検索機能をつける
}
