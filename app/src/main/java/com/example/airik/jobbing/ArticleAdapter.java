package com.example.airik.jobbing;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import java.util.List;

public class ArticleAdapter extends ArrayAdapter<Article> {

    List<Article> mArticles;

    public ArticleAdapter(Context context, int resourceId, List<Article> objects){
        super(context, resourceId, objects);

        mArticles = objects;
    }

    @Override
    public int getCount() {
        return mArticles.size();
    }

    @Override
    public Article getItem(int position) {
        return mArticles.get(position);
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent){
        final ViewHolder viewHolder;
        if (convertView == null){
            //articleレイアウト複製
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.article, null);
            //viewHolderを用意
            viewHolder = new ViewHolder(convertView);
            //viewHolderをViewにタグ付け
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        //記事のデータをレイアウトにセットしていく
        final Article item=getItem(position);

        if(item !=null){
            //set data
            viewHolder.usernameT.setText(item.username);
            viewHolder.naiyouT.setText(item.naiyou);
        }

        return convertView;
    }

    public static class ViewHolder{

        TextView usernameT;
        TextView naiyouT;

        public ViewHolder(View view){

            usernameT = (TextView)view.findViewById(R.id.username);
            naiyouT = (TextView)view.findViewById(R.id.naiyou);
        }

    }

}