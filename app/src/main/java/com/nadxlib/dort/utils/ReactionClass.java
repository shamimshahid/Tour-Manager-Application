package com.nadxlib.dort.utils;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;


import com.github.pgreze.reactions.ReactionPopup;
import com.github.pgreze.reactions.ReactionsConfig;
import com.github.pgreze.reactions.ReactionsConfigBuilder;
import com.nadxlib.dort.R;

public class ReactionClass extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reaction);

        ReactionsConfig config = new ReactionsConfigBuilder(getApplicationContext())
                .withReactions(new int[]{
                        R.drawable.ic_fb_like,
                        R.drawable.ic_fb_love,
                        R.drawable.ic_fb_laugh,
                        R.drawable.ic_fb_wow,
                        R.drawable.ic_fb_sad,
                        R.drawable.ic_fb_angry
                })
                .build();

        ReactionPopup popup = new ReactionPopup(getApplicationContext(), config, (position) -> {

            return true; // true is closing popup, false is requesting a new selection
        });




        Button react = findViewById(R.id.react);
        ImageView imageView = findViewById(R.id.like);
        imageView.setOnTouchListener(popup);
        popup.setReactionSelectedListener((position) -> {
            Log.i("Reactions", "Selection position=" + position);
            if(position == 1){
                imageView.setImageResource(R.drawable.ic_fb_love);
            }
            return position != 3;
        });

    }
}