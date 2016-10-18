package com.ccw.qqmusic.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaMetadataRetriever;

/**
 * Created by 蔡灿武 on 2016/10/18 0018.
 */

public class MusicUtil {
    //获取Mp3的专辑图片
    public static Bitmap getThumbnail(String filePath) {
        Bitmap bitmap = null;
        MediaMetadataRetriever retriever = null;
        try {
            retriever = new MediaMetadataRetriever();
            retriever.setDataSource(filePath);
            byte[] bytes = retriever.getEmbeddedPicture();
            if (bytes != null && bytes.length > 0) {
                bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
            }
        } finally {
            if (retriever != null) {
                retriever.release();
            }
        }
        return bitmap;
    }
}