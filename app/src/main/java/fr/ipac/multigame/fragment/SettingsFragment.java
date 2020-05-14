package fr.ipac.multigame.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import fr.ipac.multigame.R;
import fr.ipac.multigame.adapter.GameAdapter;
import fr.ipac.multigame.model.Game;

public class SettingsFragment extends Fragment {
    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings, container, false);
        recyclerView = view.findViewById(R.id.displayScores);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        ArrayList<Game> games = new ArrayList<>();
        games.add(new Game(String.valueOf(R.string.swipe_name), 0));
        games.add(new Game(String.valueOf(R.string.drag_n_drop_name), 0));
        games.add(new Game(String.valueOf(R.string.fast_tap_name), 0));
        games.add(new Game(String.valueOf(R.string.ipac_game), 0));

        recyclerView.setAdapter(new GameAdapter(this, games));

        return view;
    }
}
