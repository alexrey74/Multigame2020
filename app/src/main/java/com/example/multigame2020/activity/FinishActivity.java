package com.example.multigame2020.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.multigame2020.R;
import com.example.multigame2020.utils.ActivityUtils;


public class FinishActivity extends AppCompatActivity {
    public static final String SCORE = "score";
    public static final String NAME = "name";

    public static void NewInstance(Activity activity, String name, int score){
        Intent intent = new Intent(activity, FinishActivity.class);
        intent.putExtra(FinishActivity.SCORE, score);
        intent.putExtra(FinishActivity.NAME,name);

        ActivityUtils.launchActivity(activity, intent, ActivityUtils.TYPE_FADE,false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.finish_activity);

        int score = getIntent().getIntExtra(SCORE, 0);

        TextView txtScore = findViewById(R.id.finish_score);
        txtScore.setText("Score : " + score);

        ((TextView)findViewById(R.id.finish_name)).setText(getIntent().getStringExtra(NAME));
    }
}
