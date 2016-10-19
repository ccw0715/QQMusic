package com.ccw.qqmusic.showMusic.view;

import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ccw.qqmusic.BaseActivity;
import com.ccw.qqmusic.R;
import com.ccw.qqmusic.showMusic.model.bean.MusicBean;
import com.ccw.qqmusic.showMusic.presenter.ShowPresenter;
import com.ccw.qqmusic.showMusic.view.adapter.VpAdapter;
import com.ccw.qqmusic.showMusic.view.fragment.FindFragment;
import com.ccw.qqmusic.showMusic.view.fragment.MineFragment;
import com.ccw.qqmusic.showMusic.view.fragment.MusicFragment;
import com.ccw.qqmusic.showMusic.view.receiver.Receiver;
import com.ccw.qqmusic.util.MusicUtil;
import com.ccw.qqmusic.util.PlayUtil;

import org.lenve.customshapeimageview.CustomShapeImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements IShowView {

    private ImageView play_or_pause;
    private CustomShapeImageView music_thumbnail;
    private TextView musicName;
    private MusicBean musicBean;
    private ShowPresenter showPresenter=new ShowPresenter(this);
    private Receiver receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        receiver = new Receiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction(PlayUtil.STOPSERVICE_ACTION);
        filter.addAction(PlayUtil.UPDATE_BOTTOM_MUSIC_MSG_ACTION);
        registerReceiver(receiver,filter);
        initView();
        showPresenter.loadData();
    }

    private void initView() {
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        List<Fragment> list = new ArrayList<>();
        list.add(new MineFragment());
        list.add(new MusicFragment());
        list.add(new FindFragment());
        viewPager.setAdapter(new VpAdapter(getSupportFragmentManager(), list));
        music_thumbnail = ((CustomShapeImageView) findViewById(R.id.music_thumbnail));
        musicName = ((TextView) findViewById(R.id.music_name));
        play_or_pause = ((ImageView) findViewById(R.id.play_or_pause));
    }

    @Override
    public void updateMusic(MusicBean bean) {
        this.musicBean = bean;
        musicName.setText(bean.getSongName());
        Bitmap bitmap = MusicUtil.getThumbnail(bean.getUrl());
        if (bitmap != null) {
            music_thumbnail.setImageBitmap(bitmap);
        } else {
            music_thumbnail.setImageResource(R.drawable.default1);
        }
        pauseBtn();
    }

    @Override
    public void updatePauseBtn() {
        pauseBtn();
    }

    private void pauseBtn() {
        if (PlayUtil.CURRENT_STATE == PlayUtil.PLAY){
            play_or_pause.setImageResource(R.drawable.btn_notification_player_stop_pressed);
        }else {
            play_or_pause.setImageResource(R.drawable.btn_notification_player_next_pressed);
        }
    }

    public void play_or_pause(View view) {
        if (PlayUtil.CURRENT_STATE == PlayUtil.STOP) {
            play_or_pause.setImageResource(R.drawable.btn_notification_player_stop_pressed);
            PlayUtil.startService(this, musicBean, PlayUtil.PLAY);
        } else if (PlayUtil.CURRENT_STATE == PlayUtil.PAUSE) {
            play_or_pause.setImageResource(R.drawable.btn_notification_player_stop_pressed);
            PlayUtil.startService(this, musicBean, PlayUtil.PAUSE);
        } else {
            play_or_pause.setImageResource(R.drawable.btn_notification_player_next_pressed);
            PlayUtil.startService(this, musicBean, PlayUtil.PAUSE);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
        showPresenter.saveData(musicBean);
    }
}