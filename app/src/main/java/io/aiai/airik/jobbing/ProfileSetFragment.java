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
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;


public class ProfileSetFragment extends Fragment {
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Button Kanryou;
    EditText nameSetting;
    EditText profileSetting;
    Spinner spinner;
    String spinnerItems[] = {"学生", "社会人"};
    ImageView pochi;
    int setage;


    static ProfileSetFragment newInstance() {
        //呼ばれたものを渡す(返事する)
        return new ProfileSetFragment();
    }

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(io.aiai.airik.jobbing.R.layout.fragment_profile_set, null);

        pref = getContext().getSharedPreferences("設定したもの", Context.MODE_PRIVATE);
        editor = pref.edit();
        Kanryou = view.findViewById(io.aiai.airik.jobbing.R.id.set);
        nameSetting = view.findViewById(io.aiai.airik.jobbing.R.id.nameSetting);
        profileSetting = view.findViewById(io.aiai.airik.jobbing.R.id.profileSetting);
        pochi = view.findViewById(io.aiai.airik.jobbing.R.id.pochi);

        spinner = view.findViewById(io.aiai.airik.jobbing.R.id.spinner);
        spinner.setFocusable(false);
        setage = pref.getInt("age",0);
        spinner.setSelection(setage);

        // https://stackoverflow.com/questions/5787809/get-spinner-selected-items-text
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            // *********
            // Spinner の要素が選択された時に実行される処理
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (!spinner.isFocusable()) {
                    if (setage == 0) {
                        pochi.getDrawable().setTint(ContextCompat.getColor(getContext(), io.aiai.airik.jobbing.R.color.colorStudent));
                    } else {
                        pochi.getDrawable().setTint(ContextCompat.getColor(getContext(), io.aiai.airik.jobbing.R.color.colorAdult));
                    }
                    spinner.setFocusable(true);
                    return;
                }
                if (i == 0) {
                    pochi.getDrawable().setTint(ContextCompat.getColor(getContext(), io.aiai.airik.jobbing.R.color.colorStudent));
                } else {
                    pochi.getDrawable().setTint(ContextCompat.getColor(getContext(), io.aiai.airik.jobbing.R.color.colorAdult));
                }
                setage = i;
                Toast.makeText(getActivity(), "使用を変更しました", Toast.LENGTH_SHORT).show();
            }

            // *********

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        String name = pref.getString("name","");
        String profile = pref.getString("profile", "");


        nameSetting.setText(name);
        profileSetting.setText(profile);

        Kanryou.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String newname = nameSetting.getText().toString();
                String newprofile = profileSetting.getText().toString();

                editor.putString("name", newname);
                editor.putString("profile", newprofile);
                editor.putInt("age",setage);
                editor.commit();


                FragmentManager fragmentManager = getFragmentManager();
                if (fragmentManager != null) {
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                    // BackStackを設定
                    fragmentTransaction.addToBackStack(null);

                    fragmentTransaction.replace(io.aiai.airik.jobbing.R.id.container, ProfileFragment.newInstance());
                    fragmentTransaction.commit();

                }

            }
        });
        return view;
    }
}
