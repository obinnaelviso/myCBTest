package com.joytekmotion.mycbtest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class GridAdapter extends BaseAdapter {
    private int btnIcon[];
    private Context context;
    private LayoutInflater inflater;

    public GridAdapter(Context context, int btnIcon[]) {
        this.context = context;
        this.btnIcon = btnIcon;
    }


    @Override
    public int getCount() {
        return btnIcon.length;
    }

    @Override
    public Object getItem(int position) {
        return btnIcon[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View gridView = convertView;

        if(convertView == null) {
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            gridView = inflater.inflate(R.layout.sub_layout, null);
        }

        ImageView icon = (ImageView) gridView.findViewById(R.id.btnIcon);

        icon.setImageResource(btnIcon[position]);

        return gridView;
    }
}
