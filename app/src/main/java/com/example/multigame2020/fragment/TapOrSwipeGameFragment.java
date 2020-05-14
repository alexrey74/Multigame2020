package com.example.multigame2020.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.multigame2020.R;
import com.example.multigame2020.activity.FinishActivity;
import com.example.multigame2020.activity.MainActivity;
import com.example.multigame2020.utils.ActivityUtils;

import java.util.Timer;
import java.util.TimerTask;

public class TapOrSwipeGameFragment extends Fragment {
    final static int TIME_BEFORE_FIRST_EXECUTION = 0;
    final static int DELAY_BETWEEN_TRIGGER = 1000;
    private int COUNTER = 20;
    private boolean IS_LONG = false;

    private int score = 0;


    private TextView txtCounter;
    private LinearLayout tapContainer;
    private TextView txtTap;
    private TextView txtScore;

    Timer timer = new Timer();


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fast_tap_game, container, false);
        txtCounter = view.findViewById(R.id.remaining_time);

        final Handler handler = new Handler();

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    public void run() {
                        if (COUNTER > 0){
                            COUNTER--;
                            txtCounter.setText(getString(R.string.remaining_time, COUNTER));
                        } else {
                            FinishActivity.NewInstance(getActivity(), getString(R.string.fastTap_name), score);

                            timer.cancel();
                            getFragmentManager().popBackStack();
                        }
                    }
                });
            }
        };
        timer.schedule(timerTask, TIME_BEFORE_FIRST_EXECUTION, DELAY_BETWEEN_TRIGGER);

        tapContainer = view.findViewById(R.id.containerTapClick);
        txtTap = view.findViewById(R.id.txt_tap);
        txtScore = view.findViewById(R.id.txt_score);

        tapContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!IS_LONG){
                    score++;
                    setTypeTap();
                }
            }
        });

        tapContainer.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if(IS_LONG){
                    score++;
                    setTypeTap();
                }
                return true;
            }
        });
        return view;
    }



    public void setTypeTap(){
        txtScore.setText(getString(R.string.score, score));
         if(Math.random() > 0.5){
             IS_LONG = true;
             txtTap.setText(getString(R.string.long_tap));
         } else {
             IS_LONG = false;
             txtTap.setText(getString(R.string.simple_tap));
         }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        timer.cancel();
    }
}