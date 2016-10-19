package com.ccw.qqmusic.localMusic.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ccw.qqmusic.R;
import com.ccw.qqmusic.showMusic.model.bean.MusicBean;

import java.util.List;

/**
 * Created by 蔡灿武 on 2016/10/18 0018.
 */

public class LocalMusicLvAdapter extends BaseAdapter {
    private List<MusicBean> list;
    private Context context;
    private LayoutInflater inflater;

    public LocalMusicLvAdapter(List<MusicBean> list, Context context) {
        this.list = list;
        this.context = context;
        inflater= LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView==null){
            convertView=inflater.inflate(R.layout.localmusic_lv_item,parent,false);
            holder=new ViewHolder();
            holder.musicName= ((TextView) convertView.findViewById(R.id.music_name));
            holder.artist= (TextView) convertView.findViewById(R.id.artist);
            convertView.setTag(holder);
        }else {
            holder= (ViewHolder) convertView.getTag();
        }
        MusicBean bean = list.get(position);
        holder.musicName.setText(bean.getSongName());
        holder.artist.setText(bean.getSingerName());
        return convertView;
    }
    class ViewHolder{
        TextView musicName,artist;
    }
}
