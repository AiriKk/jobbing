package io.aiai.airik.jobbing;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ArticleOpenActivity extends AppCompatActivity {

    TextView kijinonakami;
    TextView usermei;
    TextView jobname;
    ImageView nenrei;
    SharedPreferences pref;
    int setage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(io.aiai.airik.jobbing.R.layout.activity_article_open);


        kijinonakami = (TextView)findViewById(io.aiai.airik.jobbing.R.id.kijinonakami);
        usermei = (TextView)findViewById(io.aiai.airik.jobbing.R.id.usermei);
        jobname = (TextView)findViewById(io.aiai.airik.jobbing.R.id.title);
        nenrei = (ImageView)findViewById(io.aiai.airik.jobbing.R.id.nenrei);

        pref = getSharedPreferences("設定したもの", Context.MODE_PRIVATE);
        String name = pref.getString("name", "No Name");
        setage = pref.getInt("age",0);


        if (setage == 0) {
            nenrei.getDrawable().setTint(ContextCompat.getColor(this, io.aiai.airik.jobbing.R.color.colorStudent));
        } else {
            nenrei.getDrawable().setTint(ContextCompat.getColor(this, io.aiai.airik.jobbing.R.color.colorAdult));
        }


        Intent intent = getIntent();
        Article article = (Article) intent.getSerializableExtra("記事データ");

        kijinonakami.setText(article.honbun);
        usermei.setText(article.username);
        jobname.setText(article.title);
    }

    //TODO コメント機能の追加　
    //TODO 好きな記事をアカウントに保存できるように　
    // TODO プロファイルのデータを変更を可能に　
    //TODO プロファイルの写真を変更を可能に　
    //TODO 検索機能を付け足す　
    //TODO 記事表示時にユーザーネームの表示
}
