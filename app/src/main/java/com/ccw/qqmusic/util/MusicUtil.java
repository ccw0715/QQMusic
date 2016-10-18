package com.ccw.qqmusic.util;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaMetadataRetriever;

import com.ccw.qqmusic.R;

/**
 * Created by 蔡灿武 on 2016/10/18 0018.
 */

public class MusicUtil {
    public static final String MUSICBEAN="musicBean";
    //获取Mp3的专辑图片
    public static Bitmap getThumbnail(String filePath) {
        if(filePath == null || "".equals(filePath)){
            return null;
        }
        Bitmap bitmap = null;
        MediaMetadataRetriever retriever = null;
        try {
            retriever = new MediaMetadataRetriever();
            retriever.setDataSource(filePath);
            byte[] bytes = retriever.getEmbeddedPicture();
            if (bytes != null && bytes.length > 0) {
                bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
            }else {
                bitmap = BitmapFactory.decodeResource(Resources.getSystem(), R.drawable.default1);
            }
        } finally {
            if (retriever != null) {
                retriever.release();
            }
        }
        return bitmap;
    }
}

