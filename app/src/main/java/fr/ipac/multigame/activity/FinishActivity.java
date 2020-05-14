package fr.ipac.multigame.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import fr.ipac.multigame.R;
import fr.ipac.multigame.manager.ProfileManager;
import fr.ipac.multigame.model.Game;
import fr.ipac.multigame.model.Player;
import fr.ipac.multigame.utils.ActivityUtils;


public class FinishActivity extends AppCompatActivity {


    public static final String SCORE = "score";
    public static final String NAME = "name";

    public static void newInstance(Activity activity, String name, int score) {
        Intent intent = new Intent(activity, FinishActivity.class);

        intent.putExtra(FinishActivity.NAME, name);
        intent.putExtra(FinishActivity.SCORE, score);

        ActivityUtils.launchActivity(activity, intent, ActivityUtils.TYPE_FADE, false);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.finish_activity);

        String nameOfGame = getIntent().getStringExtra(NAME);
        int scoreOfGame = getIntent().getIntExtra(SCORE, 0);

        Player player = ProfileManager.getInstance().getPlayer();

        ArrayList<Game> playerGame = new ArrayList<>();
        try {
            player.getScores().isEmpty();
        } catch (NullPointerException e){
            player.setScores(playerGame);
            playerGame.add(new Game(getString(R.string.fast_tap_name), 0));
            playerGame.add(new Game(getString(R.string.drag_n_drop_name), 0));
            playerGame.add(new Game(getString(R.string.ipac_game), 0));
            playerGame.add(new Game(getString(R.string.swipe_name), 0));
        }
        if(playerGame.isEmpty()){
            playerGame.add(new Game(getString(R.string.fast_tap_name), 0));
            playerGame.add(new Game(getString(R.string.drag_n_drop_name), 0));
            playerGame.add(new Game(getString(R.string.ipac_game), 0));
            playerGame.add(new Game(getString(R.string.swipe_name), 0));
        } else {
            Integer i = playerGame.indexOf(new Game(FinishActivity.NAME, scoreOfGame));
            if(playerGame.get(i).getScore() < scoreOfGame){
                playerGame.set(i, new Game(FinishActivity.NAME, scoreOfGame));
            }
        }

        TextView name = findViewById(R.id.finish_name);
        TextView score = findViewById(R.id.finish_score);

        name.setText(nameOfGame);
        score.setText(String.valueOf(scoreOfGame));

        findViewById(R.id.finish_menu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        findViewById(R.id.finish_exit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity();
            }
        });
    }

}
