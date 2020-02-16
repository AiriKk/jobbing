package io.aiai.airik.jobbing;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

public class TopActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, BottomNavigationView.OnNavigationItemSelectedListener{

    SharedPreferences pref;
    TextView name;
    TextView prof;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(io.aiai.airik.jobbing.R.layout.activity_top);
        Toolbar toolbar = (Toolbar) findViewById(io.aiai.airik.jobbing.R.id.toolbar);
        setSupportActionBar(toolbar);

        //下のオプション
        BottomNavigationView navigationView = (BottomNavigationView) findViewById(io.aiai.airik.jobbing.R.id.bottom_nav_view);
        navigationView.setOnNavigationItemSelectedListener(this);
        navigationView.getMenu().findItem(io.aiai.airik.jobbing.R.id.nav_main).setChecked(true);
        //初期設定
        fragmentTransaction(new MainFragment());

        // headerに名前とprofを表示
        pref =getSharedPreferences("設定したもの", Context.MODE_PRIVATE);
    }

    private void fragmentTransaction(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(io.aiai.airik.jobbing.R.id.container,fragment).commit();
    }

    //端末の戻るボタンを押した時
    @Override
    public void onBackPressed() {
        //左上のメニューを閉じる
        DrawerLayout drawer = (DrawerLayout) findViewById(io.aiai.airik.jobbing.R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case  io.aiai.airik.jobbing.R.id.nav_main:
                //　遷移
                fragmentTransaction(new MainFragment());
                return true;
            case io.aiai.airik.jobbing.R.id.nav_profile:
                fragmentTransaction(new ProfileFragment());
                return true;
            case io.aiai.airik.jobbing.R.id.nav_nyuuryoku:
                fragmentTransaction(new NyuuryokuFragment());
                return true;
        }
        return false;
    }
}
