package com.example.epds_new;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class InspectorCustomAdapter extends BaseAdapter {
	 private Activity activity;
	    private LayoutInflater inflater;
	    private List<InspectorModels> inspectorItems;
	     public InspectorCustomAdapter(Activity activity, List<InspectorModels> inspectorItems) {
			// TODO Auto-generated constructor stub
	    	 this.activity = activity;
	         this.inspectorItems = inspectorItems;
		}
	   
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return inspectorItems.size();
	}

	@Override
	public Object getItem(int location) {
		// TODO Auto-generated method stub
		return inspectorItems.get(location);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.list_row, null);
        TextView title = (TextView) convertView.findViewById(R.id.title);
        InspectorModels m = inspectorItems.get(position);
        ImageView image = (ImageView)convertView.findViewById(R.id.thumbnail);
        image.setImageResource(R.drawable.icon_inspector);
        title.setText(m.getTitle());
		return convertView;
	}

}
