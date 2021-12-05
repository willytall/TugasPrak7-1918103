package com.example.tugasprak7_1918103;


import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Jadwal> Jadwal;
    public CustomListAdapter(Activity activity, List<Jadwal> Jadwal) {
        this.activity = activity;
        this.Jadwal = Jadwal;
    }
    @Override
    public int getCount() {
        return Jadwal.size();
    }
    @Override
    public Object getItem(int location) {
        return Jadwal.get(location);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup
            parent) {
        if (inflater == null)
            inflater = (LayoutInflater) activity

                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.custom_list,
                    null);
        TextView nama = (TextView)
                convertView.findViewById(R.id.text_Jadwal_SepakBola);
        TextView kelas = (TextView)
                convertView.findViewById(R.id.text_Tim);
        ImageView imageView = (ImageView)
                convertView.findViewById(R.id.iconid);
        Jadwal  m = Jadwal.get(position);
        nama.setText("Jadwal : "+ m.get_jadwal());
        kelas.setText("TIM : "+ m.get_tim());
        return convertView;
    }
}
