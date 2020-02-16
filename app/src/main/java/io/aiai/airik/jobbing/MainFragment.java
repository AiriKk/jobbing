package io.aiai.airik.jobbing;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

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
        View view = inflater.inflate(io.aiai.airik.jobbing.R.layout.fragment_main, null);

        mListView =(ListView)view.findViewById(io.aiai.airik.jobbing.R.id.listView);
        mArticles = new ArrayList<Article>();

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference articleRef = database.getReference("articles");

        articleRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot){
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    Article article = dataSnapshot.getValue(Article.class);
                    mArticles.add(article);
                }
                mArticleAdapter.notifyDataSetChanged();
            }
            @Override
            public void onCancelled(DatabaseError error){
                Log.w("Firebase","Failed to read value",error.toException());
            }
        });

        mArticleAdapter = new ArticleAdapter(getContext(), io.aiai.airik.jobbing.R.layout.article,mArticles);
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

    private void lordArticle(){
//        SharedPreferences pref= getActivity().getSharedPreferences("記事倉庫",getContext().MODE_PRIVATE);
//       Article[] articles = pref.get("articles",null);

    }
}