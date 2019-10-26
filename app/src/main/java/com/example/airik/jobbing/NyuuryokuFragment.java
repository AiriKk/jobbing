package com.example.airik.jobbing;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class NyuuryokuFragment extends Fragment {

    TextView accountV;
    EditText titleV;
    EditText honbunV;
    Button submitButton;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_nyuuryoku, null);

        accountV = view.findViewById(R.id.account);
        titleV = view.findViewById(R.id.title);
        honbunV = view.findViewById(R.id.honbun);
        submitButton = view.findViewById(R.id.toukou);


        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //投稿ボタンを押した時の処理
                String accountData = accountV.getText().toString();
                String titleData = titleV.getText().toString();
                String honbunData = honbunV.getText().toString();

                Article newArticle = new Article(accountData,titleData,honbunData,R.drawable.umi);

                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference articlesRef = database.getReference("articles");
                articlesRef.push().setValue(newArticle);
            }
        });

        return view;

    }
}