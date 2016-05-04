package com.jspiders.ratingmovie;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by mhs on 5/4/2016.
 */
public class CustomAdapter extends BaseAdapter {

    Context context;
    String[] names;

    CustomAdapter(Context context,String[] names)
    {
        this.context = context;
        this.names = names;
    }


    @Override
    public int getCount() {
        return names.length;
    }

    @Override
    public Object getItem(int position) {
        return names[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.movies_row,parent);
        Viewholder viewholder = new Viewholder();
         viewholder.poster = (ImageView) view.findViewById(R.id.imageViewposter);
        viewholder.title =(TextView) view.findViewById(R.id.textViewtitle);
        viewholder.ratings =(TextView) view.findViewById(R.id.textViewratings);

        viewholder.title.setText("title");
        viewholder.ratings.setText("123");
        return view;
    }

    class Viewholder
    {
        TextView title,ratings;
        ImageView poster;
    }
}
