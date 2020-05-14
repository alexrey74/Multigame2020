package com.example.multigame2020.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.FrameLayout;

import com.example.multigame2020.R;

public class DragnDropFragment extends Fragment {
    final static int UP_LEFT = 0;
    final static int UP_RIGHT = 1;
    final static int CENTER_LEFT = 2;
    final static int CENTER_RIGHT = 3;
    final static int DOWN_LEFT = 4;
    final static int DOWN_RIGHT = 5;
    private int score = -1;
    private TextView scoreTv;
    private int dragZone = 0;
    private FrameLayout circle;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_drag_n_drop, container, false);
        scoreTv = view.findViewById(R.id.drag_score);
        circle = view.findViewById(R.id.drag_target);

        circle.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    ClipData data = ClipData.newPlainText("", "");
                    View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
                    view.startDrag(data, shadowBuilder, view, 0);
                    //    view.setVisibility(View.INVISIBLE);
                    return true;
                }
                return false;
            }
        });
        topLeft.setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View v, DragEvent event) {
                if (event.getAction() == DragEvent.ACTION_DROP && dragZone == UP_LEFT) {
                    setAction();
                }
                return false;
            }
        });

        setAction();
        return view;
    }



    private void setAction() {
        score++;
        scoreTv.setText(getString(R.string.score, score));
        if (Math.random() < 0.16) {
            dragZone = UP_LEFT;
            circle.getBackground().setColorFilter(getResources().getColor(R.color.colorGreen), PorterDuff.Mode.SRC_OVER);
        } else if (Math.random() < 0.32) {
            dragZone = UP_RIGHT;
            circle.getBackground().setColorFilter(getResources().getColor(R.color.colorGreen), PorterDuff.Mode.SRC_OVER);
        } else if (Math.random() < 0.48) {
            dragZone = CENTER_LEFT;
            circle.getBackground().setColorFilter(getResources().getColor(R.color.colorGreen), PorterDuff.Mode.SRC_OVER);
        } else if (Math.random() < 0.64) {
            dragZone = CENTER_RIGHT;
            circle.getBackground().setColorFilter(getResources().getColor(R.color.colorGreen), PorterDuff.Mode.SRC_OVER);
        } else if (Math.random() < 0.80) {
            dragZone = DOWN_LEFT;
            circle.getBackground().setColorFilter(getResources().getColor(R.color.colorGreen), PorterDuff.Mode.SRC_OVER);
        } else {
            dragZone = DOWN_RIGHT;
            circle.getBackground().setColorFilter(getResources().getColor(R.color.colorGreen), PorterDuff.Mode.SRC_OVER);
        }
    }
}
