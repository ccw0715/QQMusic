package com.ccw.qqmusic.showMusic.view.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * Created by 蔡灿武 on 2016/10/17 0017.
 */

public class MineFgLvAdapter extends BaseAdapter{
    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
//    private List<MusicBean> list;
//    private Context context;
//    private LayoutInflater inflater;
//
//    public MineFgLvAdapter(List<MusicBean> list, Context context) {
//        this.list = list;
//        this.context = context;
//        inflater = LayoutInflater.from(context);
//    }
//
//    @Override
//    public int getCount() {
//        return list.size();
//    }
//
//    @Override
//    public Object getItem(int position) {
//        return list.get(position);
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return position;
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        ViewHolder holder;
//        if (convertView == null) {
//            convertView = inflater.inflate(R.layout.mine_fg_lv_item, parent, false);
//            holder = new ViewHolder();
//            holder.musicName = (TextView) convertView.findViewById(R.id.music_name);
//            holder.musicThumbnail = (ImageView) convertView.findViewById(R.id.music_thumbnail);
//            convertView.setTag(holder);
//        }else{
//            holder = (ViewHolder) convertView.getTag();
//        }
//        MusicBean musicBean = list.get(position);
//        holder.musicName.setText(musicBean.getMusicName());
//        holder.musicThumbnail.setImageBitmap(MusicUtil.getThumbnail(musicBean.getMusicPath()));
//        return convertView;
//    }
//    class ViewHolder{
//        TextView musicName;
//        ImageView musicThumbnail;
//    }
}
