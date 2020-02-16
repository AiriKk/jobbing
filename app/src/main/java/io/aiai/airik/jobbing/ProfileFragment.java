package io.aiai.airik.jobbing;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ProfileFragment extends Fragment {
    ImageView iconset;
    TextView nameset;
    TextView profileset;
    SharedPreferences pref;
    Button change;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    int setage;
    ImageView pochi3;

    static ProfileFragment newInstance(){
        //呼ばれたものを渡す(返事する)
        return new ProfileFragment();
    }


    //レイアウトファイル読み込み
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(io.aiai.airik.jobbing.R.layout.fragment_profile, null);

        pref = getContext().getSharedPreferences("設定したもの", Context.MODE_PRIVATE);
        String name = pref.getString("name", "No Name");
        String profile = pref.getString("profile", "No Profile");
        setage = pref.getInt("age",0);

        // Log.d("age",setage+"");

        pochi3 = view.findViewById(io.aiai.airik.jobbing.R.id.pochi3);

        nameset = view.findViewById(io.aiai.airik.jobbing.R.id.namae);
        profileset = view.findViewById(io.aiai.airik.jobbing.R.id.purofairu);
        change = view.findViewById(io.aiai.airik.jobbing.R.id.change);
        nameset.setText(name);
        profileset.setText(profile);

        if (setage == 0) {
            pochi3.getDrawable().setTint(ContextCompat.getColor(getContext(), io.aiai.airik.jobbing.R.color.colorStudent));
        } else {
            pochi3.getDrawable().setTint(ContextCompat.getColor(getContext(), io.aiai.airik.jobbing.R.color.colorAdult));
        }

        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentManager fragmentManager = getFragmentManager();
                if(fragmentManager != null) {
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                    // BackStackを設定
                    fragmentTransaction.addToBackStack(null);

                    fragmentTransaction.replace(io.aiai.airik.jobbing.R.id.container, ProfileSetFragment.newInstance());
                    fragmentTransaction.commit();
                }
            }

        });
        return view;
    }

}