package com.ccw.qqmusic.playMusic.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.ccw.qqmusic.R;
import com.ccw.qqmusic.databinding.ActivityPlayerBinding;
import com.ccw.qqmusic.playMusic.presenter.PlayerPresenter;
import com.ccw.qqmusic.util.PlayUtil;

public class PlayerActivity extends AppCompatActivity implements IPlayerView {
    private PlayerPresenter playerPresenter = new PlayerPresenter(this);
    private ImageView play_or_pause;
    private TextView currentTime;
    private TextView totalTime;
    private SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityPlayerBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_player);
        binding.setMusic(PlayUtil.currentMusic);
        initView();
        playerPresenter.start();
    }

    private void initView() {
        LinearLayout leftMenu = (LinearLayout) findViewById(R.id.left_menu);
        leftMenu.getLayoutParams().width = getResources().getDisplayMetrics().widthPixels;
        leftMenu.requestLayout();
        LinearLayout rightMenu = (LinearLayout) findViewById(R.id.right_menu);
        rightMenu.getLayoutParams().width = getResources().getDisplayMetrics().widthPixels;
        rightMenu.requestLayout();
        play_or_pause = ((ImageView) findViewById(R.id.play_or_pause));
        currentTime = ((TextView) findViewById(R.id.current_time));
        totalTime = ((TextView) findViewById(R.id.total_time));
        seekBar = ((SeekBar) findViewById(R.id.seekBar));
    }

    @Override
    public void updatePlayerControl() {
        if (PlayUtil.CURRENT_STATE == PlayUtil.PLAY) {
            play_or_pause.setImageResource(R.drawable.btn_notification_player_stop_pressed);
        } else {
            play_or_pause.setImageResource(R.drawable.ring_btnplay);
        }
    }

    public void playOrPause(View view) {
        if (PlayUtil.CURRENT_STATE == PlayUtil.STOP) {
            play_or_pause.setImageResource(R.drawable.btn_notification_player_stop_pressed);
            PlayUtil.startService(this, PlayUtil.currentMusic, PlayUtil.PLAY);
        } else if (PlayUtil.CURRENT_STATE == PlayUtil.PAUSE) {
            play_or_pause.setImageResource(R.drawable.btn_notification_player_stop_pressed);
            PlayUtil.startService(this, PlayUtil.currentMusic, PlayUtil.PAUSE);
        } else {
            play_or_pause.setImageResource(R.drawable.ring_btnplay);
            PlayUtil.startService(this, PlayUtil.currentMusic, PlayUtil.PAUSE);
        }
    }

    public void preBtn(View view) {
        if (PlayUtil.CURRENT_POSION > 0) {
            PlayUtil.CURRENT_POSION = PlayUtil.CURRENT_POSION -1;
            PlayUtil.currentMusic = PlayUtil.current_play_list.get(PlayUtil.CURRENT_POSION);
            PlayUtil.startService(this,PlayUtil.currentMusic,PlayUtil.PLAY);
            PlayUtil.currentMusic.setSongName(PlayUtil.currentMusic.getSongName());
        }
    }

    public void nextBtn(View view) {
        if(PlayUtil.CURRENT_POSION<PlayUtil.current_play_list.size()-1){
            PlayUtil.CURRENT_POSION = PlayUtil.CURRENT_POSION+1;
            PlayUtil.currentMusic = PlayUtil.current_play_list.get(PlayUtil.CURRENT_POSION);
            PlayUtil.startService(this,PlayUtil.currentMusic,PlayUtil.PLAY);
//            PlayUtil.currentMusic.setSongName(PlayUtil.currentMusic.getSongName());
        }
    }
}