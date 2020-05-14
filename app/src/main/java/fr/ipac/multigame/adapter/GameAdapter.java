package fr.ipac.multigame.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import fr.ipac.multigame.model.Game;

import fr.ipac.multigame.R;

import java.util.ArrayList;

public class GameAdapter extends RecyclerView.Adapter<GameAdapter.ViewHolder> {
    private Fragment setting;
    private ArrayList<Game> games;

    public GameAdapter(Fragment fragment, ArrayList<Game> games){
        this.games = games;
        this.setting = fragment;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i){
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.show_settings_row, viewGroup, false);
        return new GameAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position){
        final Game game = games.get(position);
        viewHolder.name.setText(game.getName());
        viewHolder.score.setText(String.valueOf(game.getScore()));
    }

    public int getItemCount() { return games.size(); }
    class ViewHolder extends RecyclerView.ViewHolder{
        private TextView name;
        private TextView score;

        ViewHolder(View itemView){
            super(itemView);
            name = itemView.findViewById(R.id.gameSetting);
            score = itemView.findViewById(R.id.bestScore);
        }
    }
}
