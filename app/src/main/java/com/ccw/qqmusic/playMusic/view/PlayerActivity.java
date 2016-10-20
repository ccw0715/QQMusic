package com.ccw.qqmusic.playMusic.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.ccw.qqmusic.R;
import com.ccw.qqmusic.databinding.ActivityPlayerBinding;
import com.ccw.qqmusic.playMusic.presenter.PlayerPresenter;
import com.ccw.qqmusic.util.PlayUtil;

public class PlayerActivity extends AppCompatActivity implements IPlayerView{
    private PlayerPresenter playerPresenter=new PlayerPresenter(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityPlayerBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_player);
        binding.setMusic(PlayUtil.currentMusic);
        initView();
        playerPresenter.start();
    }
    private void initView() {
//        findViewById(R.id.left_menu)
    }

    @Override
    public void updatePlayerControl() {

    }
}
//    private ImageView playOrPause;
//    private TextView currentTimeTv;
//    private TextView totalTimeTv;
//    private SeekBar seekBar;
//    private PlayerPresenter playerPresenter = new PlayerPresenter(this);

//    private void initView() {
//        LinearLayout leftMenu = (LinearLayout) findViewById(R.id.left_menu);
//        leftMenu.getLayoutParams().width = getResources().getDisplayMetrics().widthPixels;
//        leftMenu.requestLayout();
//        LinearLayout rightMenu = (LinearLayout) findViewById(R.id.right_menu);
//        rightMenu.getLayoutParams().width = getResources().getDisplayMetrics().widthPixels;
//        rightMenu.requestLayout();
//        playOrPause = ((ImageView) findViewById(R.id.play_or_pause));
//        currentTimeTv = ((TextView) findViewById(R.id.current_time));
//        totalTimeTv = (TextView) findViewById(R.id.total_time);
//        seekBar = ((SeekBar) findViewById(R.id.seek_bar));
//    }
//
//    @Override
//    public void updatePlayerControl() {
//        if (PlayUtil.CURRENT_STATE == PlayUtil.PLAY) {
//            playOrPause.setImageResource(R.drawable.search_stop_btn);
//        } else {
//            playOrPause.setImageResource(R.drawable.ring_btnplay);
//        }
//    }
//
//    public void playOrPause(View view) {
//        if (PlayUtil.CURRENT_STATE == PlayUtil.STOP) {
//            playOrPause.setImageResource(R.drawable.search_stop_btn);
//            PlayUtil.startService(this, PlayUtil.currentMusic, PlayUtil.PLAY);
//        } else if (PlayUtil.CURRENT_STATE == PlayUtil.PAUSE) {
//            playOrPause.setImageResource(R.drawable.search_stop_btn);
//            PlayUtil.startService(this, PlayUtil.currentMusic, PlayUtil.PAUSE);
//        } else {
//            playOrPause.setImageResource(R.drawable.ring_btnplay);
//            PlayUtil.startService(this, PlayUtil.currentMusic, PlayUtil.PAUSE);
//        }
//    }
//
//    public void preMusic(View view) {
//        if (PlayUtil.CURRENT_POSITION > 0) {
//            PlayUtil.CURRENT_POSITION = PlayUtil.CURRENT_POSITION - 1;
//            PlayUtil.currentMusic = PlayUtil.CURRENT_PLAY_LIST.get(PlayUtil.CURRENT_POSITION);
//            PlayUtil.startService(this, PlayUtil.currentMusic, PlayUtil.PLAY);
//            PlayUtil.currentMusic.setSongname(PlayUtil.currentMusic.getSongname());
//        }
//    }
//
//    public void nextMusic(View view) {
//        if (PlayUtil.CURRENT_POSITION < PlayUtil.CURRENT_PLAY_LIST.size() - 1) {
//            PlayUtil.CURRENT_POSITION = PlayUtil.CURRENT_POSITION + 1;
//            PlayUtil.currentMusic = PlayUtil.CURRENT_PLAY_LIST.get(PlayUtil.CURRENT_POSITION);
//            PlayUtil.startService(this, PlayUtil.currentMusic, PlayUtil.PLAY);
//        }
//    }
//}
