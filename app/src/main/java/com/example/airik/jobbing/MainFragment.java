package com.example.airik.jobbing;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainFragment extends Fragment {
    List<Article> mArticles;
    ArticleAdapter mArticleAdapter;
    ListView mListView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_main, null);

        mListView =(ListView)view.findViewById(R.id.listView);
        mArticles = new ArrayList<Article>();

        mArticles.add(new Article(getString(R.string.user1), getString(R.string.naiyou1), getString(R.string.shousai1), R.drawable.star));
        mArticles.add(new Article(getString(R.string.user2), getString(R.string.naiyou2), getString(R.string.shousai2), R.drawable.umi));
//        mArticles.add(new Article(getString(R.string.user3), getString(R.string.naiyou3),R.drawable.ikemen));
//        mArticles.add(new Article(getString(R.string.user1), getString(R.string.naiyou1),R.drawable.star));

        mArticleAdapter = new ArticleAdapter(getContext(),R.layout.article,mArticles);
        mListView.setAdapter(mArticleAdapter);

        //TODO ListViewのOnItemClickListenerを実装！
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String msg = position+1 + "番目の職業がクリックされました";
                Toast.makeText(getContext(), msg, Toast.LENGTH_LONG).show();

                //選択されたデータを取り出す
                Article article = mArticles.get(position);

                //TODO 詳細画面を開く　
                Intent intent = new Intent(getActivity(), ArticleOpenActivity.class);

                intent.putExtra("記事データ", article);

                startActivity(intent);

            }
        });

        return view;
    }
}