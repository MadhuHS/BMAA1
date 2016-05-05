package com.jspiders.ratingmovie;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by mhs on 5/4/2016.
 */
public class CustomAdapter extends BaseAdapter {

    Context context;
    String[] names;
    LayoutInflater inflater;
    List<MoviesList.Movies> movies;

    CustomAdapter(Context context,List<MoviesList.Movies> movies)
    {
        this.context = context;
        this.movies = movies;

        inflater =(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }


    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }



    @Override
    public View getView(int position, final View convertView, ViewGroup parent) 
	{
         Holder holder = new Holder();
         View view =  inflater.inflate(R.layout.movies_row,null);
         holder.title =(TextView) view.findViewById(R.id.textViewtitle);
        holder.ratings =(TextView) view.findViewById(R.id.textViewratings);
        holder.poster = (ImageView) view.findViewById(R.id.imageViewposter);

        holder.title.setText(movies.get(position).getTitle());
        holder.ratings.setText(""+movies.get(position).getRatings().getAudience_score());
        Picasso.with(context).load(movies.get(position).getPosters().getThumbnail()).into(holder.poster);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(context,ScrollingActivity.class);
                context.startActivity(intent);
            }
        });
        return view;
    }
    class Holder
    {
        TextView title,ratings;
        ImageView poster;
    }
}
