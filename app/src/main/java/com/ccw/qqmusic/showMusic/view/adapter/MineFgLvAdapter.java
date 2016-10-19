package com.ccw.qqmusic.showMusic.view.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ccw.qqmusic.R;
import com.ccw.qqmusic.showMusic.model.bean.MusicBean;
import com.ccw.qqmusic.util.MusicUtil;

import java.util.List;

/**
 * Created by 蔡灿武 on 2016/10/17 0017.
 */

public class MineFgLvAdapter extends BaseAdapter {
    private List<MusicBean> list;
    private Context context;
    private LayoutInflater inflater;

    public MineFgLvAdapter(List<MusicBean> list, Context context) {
        this.list = list;
        this.context = context;
        inflater = LayoutInflater.from(context);
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
        ViewHold hold;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.mine_fg_item, parent, false);
            hold = new ViewHold();
            hold.musicName = (TextView) convertView.findViewById(R.id.music_name);
            hold.musicThumbnail = (ImageView) convertView.findViewById(R.id.music_thumbnail);
            convertView.setTag(hold);
        } else {

            hold = (ViewHold) convertView.getTag();
        }
        MusicBean musicBean = list.get(position);
        hold.musicName.setText(musicBean.getSongName());
        Bitmap bitmap = MusicUtil.getThumbnail(musicBean.getUrl());
        if(bitmap!=null){
            hold.musicThumbnail.setImageBitmap(bitmap);
        }else {
            hold.musicThumbnail.setImageResource(R.drawable.default1);
        }

        return convertView;
    }
    class ViewHold {
        TextView musicName;
        ImageView musicThumbnail;
    }
}
