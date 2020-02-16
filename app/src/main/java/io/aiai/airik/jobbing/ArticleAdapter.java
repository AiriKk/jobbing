package io.aiai.airik.jobbing;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
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
            convertView = LayoutInflater.from(getContext()).inflate(io.aiai.airik.jobbing.R.layout.article, null);
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
            viewHolder.naiyouT.setText(item.title);
            viewHolder.iconIT.setImageResource(io.aiai.airik.jobbing.R.drawable.hito);
            viewHolder.heart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(item.isFavorite == false) {
                        viewHolder.heart.getDrawable().setTint(ContextCompat.getColor(getContext(), io.aiai.airik.jobbing.R.color.colorIsFavorite));
                        item.isFavorite = true;
                    }
                    else{

                        viewHolder.heart.getDrawable().setTint(ContextCompat.getColor(getContext(), io.aiai.airik.jobbing.R.color.colorIsNotFavorite));
                        item.isFavorite = false;
                    }
                }
            });

            if (item.ageA == 0) {
                viewHolder.dott.getDrawable().setTint(ContextCompat.getColor(getContext(), io.aiai.airik.jobbing.R.color.colorStudent));
            } else {
                viewHolder.dott.getDrawable().setTint(ContextCompat.getColor(getContext(), io.aiai.airik.jobbing.R.color.colorAdult));
            }
        }

        return convertView;
    }

    public static class ViewHolder{

        TextView usernameT;
        TextView naiyouT;
        ImageView iconIT;
        public ImageView heart;
        public ImageView dott;

        public ViewHolder(View view){

            usernameT = (TextView)view.findViewById(io.aiai.airik.jobbing.R.id.username);
            naiyouT = (TextView)view.findViewById(io.aiai.airik.jobbing.R.id.naiyou);
            iconIT = (ImageView)view.findViewById(io.aiai.airik.jobbing.R.id.icon);
            heart = (ImageView)view.findViewById(io.aiai.airik.jobbing.R.id.Heart);
            dott = (ImageView)view.findViewById(io.aiai.airik.jobbing.R.id.dot);
        }

    }

}