package com.example.multigame2020.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.multigame2020.R;
import com.example.multigame2020.utils.ActivityUtils;

public class TapOrSwipeFragment extends Fragment {
    private TextView start;
    private RelativeLayout fastTapContainer;
    public static String IS_TAP = "IS_TAP";

    public static TapOrSwipeFragment newInstance(boolean isTap){
        TapOrSwipeFragment fragment = new TapOrSwipeFragment();
        Bundle bundle = new Bundle();
        bundle.putBoolean(IS_TAP, isTap);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fast_tap, container, false);
        start = view.findViewById(R.id.fastTap_start);
        fastTapContainer = view.findViewById(R.id.fastTapContainer);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityUtils.addFragmentToActivity(TapOrSwipeFragment.this, new TapOrSwipeGameFragment(), fastTapContainer.getId());
                //lancer fragment jeu
            }
        });

        return view;
    }
}
