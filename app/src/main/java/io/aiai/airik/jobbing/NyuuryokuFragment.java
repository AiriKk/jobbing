package io.aiai.airik.jobbing;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class NyuuryokuFragment extends Fragment {

    TextView accountV;
    EditText titleV;
    EditText honbunV;
    Button submitButton;
    SharedPreferences pref;
    int age;
    ImageView ageV;



    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(io.aiai.airik.jobbing.R.layout.fragment_nyuuryoku, null);

        accountV = view.findViewById(io.aiai.airik.jobbing.R.id.account);
        titleV = view.findViewById(io.aiai.airik.jobbing.R.id.title);
        honbunV = view.findViewById(io.aiai.airik.jobbing.R.id.honbun);
        submitButton = view.findViewById(io.aiai.airik.jobbing.R.id.toukou);
        ageV = view.findViewById(io.aiai.airik.jobbing.R.id.pochi2);


        pref = getContext().getSharedPreferences("設定したもの", Context.MODE_PRIVATE);
        accountV = view.findViewById(io.aiai.airik.jobbing.R.id.account);
        String name = pref.getString("name", "No Name");
        accountV.setText(name);

        age = pref.getInt("age",0);


        if (age == 0) {
            ageV.getDrawable().setTint(ContextCompat.getColor(getContext(), io.aiai.airik.jobbing.R.color.colorStudent));
        } else {
            ageV.getDrawable().setTint(ContextCompat.getColor(getContext(), io.aiai.airik.jobbing.R.color.colorAdult));
        }


        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //投稿ボタンを押した時の処理
                String accountData = accountV.getText().toString();
                String titleData = titleV.getText().toString();
                String honbunData = honbunV.getText().toString();

                Article newArticle = new Article(accountData,titleData,honbunData, io.aiai.airik.jobbing.R.drawable.umi,age);

                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference articlesRef = database.getReference("articles");
                articlesRef.push().setValue(newArticle);


//                FragmentManager fragmentManager = getFragmentManager();
//                if (fragmentManager != null) {
//                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//
//                    // BackStackを設定
//                    fragmentTransaction.addToBackStack(null);
//
//                    fragmentTransaction.replace(R.id.container, ProfileFragment.newInstance());
//                    fragmentTransaction.commit();
//
//                }
                Toast.makeText(getContext(),"投稿が完了しました", Toast.LENGTH_LONG).show();
            }
        });

        return view;

    }
}