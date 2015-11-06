package com.example.epds_new;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.graphics.Movie;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;


public class CustomListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Models> movieItems;
   
 
    public CustomListAdapter(Activity activity, List<Models> movieItems) {
        this.activity = activity;
        this.movieItems = movieItems;
    }
 
    @Override
    public int getCount() {
        return movieItems.size();
    }
 
    @Override
    public Object getItem(int location) {
        return movieItems.get(location);
    }
 
    @Override
    public long getItemId(int position) {
        return position;
    }
 
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
 
        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.list_row, null);
 
        
        TextView title = (TextView) convertView.findViewById(R.id.title);
    
       
 
        // getting movie data for the row
        Models m = movieItems.get(position);
 
        ImageView image = (ImageView)convertView.findViewById(R.id.thumbnail);
        // thumbnail image
      
    image.setImageResource(R.drawable.icon_inspector);
         
        // title
        title.setText(m.getTitle());
      
         
        // rating
    
 
        return convertView;
    }
 
}

