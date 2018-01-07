package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private final String StOry = "StOry";
    private final String TOp = "TOp_bUttOn";
    private final String BOttOM = "BOttOM_bUttOn";
    private final String retrieveInDex = "retrieveInDex";
    private final int GAME_OVER = 4;
    private String StOry2;
    private String StOry3;
    private String StOry4;
    private String StOry5;
    private String StOry6;
    private String Ans1_1;
    private String Ans1_2;
    private String Ans2_1;
    private String Ans2_2;
    private String Ans3_1;
    private String Ans3_2;
    private int StOry_InDex;
    private TextView textView;
    private Button TopButton;
    private Button BottoMBUtton;
    public MainActivity(){
        StOry_InDex = 1;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StOry2 = getString(R.string.T2_Story);
        StOry3 = getString(R.string.T3_Story);
        StOry4 = getString(R.string.T4_End);
        StOry5 = getString(R.string.T5_End);
        StOry6 = getString(R.string.T6_End);
        Ans1_1 = getString(R.string.T1_Ans1);
        Ans1_2 = getString(R.string.T1_Ans2);
        Ans2_1 = getString(R.string.T2_Ans1);
        Ans2_2 = getString(R.string.T2_Ans2);
        Ans3_1 = getString(R.string.T3_Ans1);
        Ans3_2 = getString(R.string.T3_Ans2);
        textView = (TextView) findViewById(R.id.storyTextView);
        TopButton = (Button) findViewById(R.id.buttonTop);
        BottoMBUtton = (Button) findViewById(R.id.buttonBottom);
        TopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TopButton.getText() == Ans1_1 || TopButton.getText() == Ans2_1){
                    StOry_InDex = 3;
                    T3_Story();
                }
                else{
                    StOry_InDex = GAME_OVER;
                    UpDAteStory(StOry6);
                    TopButton.setVisibility(View.INVISIBLE);
                    BottoMBUtton.setVisibility(View.INVISIBLE);
                }
            }
        });
        BottoMBUtton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(BottoMBUtton.getText() == Ans1_2){
                    StOry_InDex = 2;
                    UpDAteStory(StOry2);
                    setTopButton(Ans2_1);
                    setBottoMBUtton(Ans2_2);
                }
                else if(BottoMBUtton.getText() == Ans2_2){
                    StOry_InDex = GAME_OVER;
                    UpDAteStory(StOry4);
                    TopButton.setVisibility(View.INVISIBLE);
                    BottoMBUtton.setVisibility(View.INVISIBLE);
                }
                else{
                    StOry_InDex = GAME_OVER;
                    UpDAteStory(StOry5);
                    TopButton.setVisibility(View.INVISIBLE);
                    BottoMBUtton.setVisibility(View.INVISIBLE);
                }
            }
        });
        if(savedInstanceState != null){
            StOry_InDex = savedInstanceState.getInt(retrieveInDex);
            UpDAteStory(savedInstanceState.getString(StOry));
            if(StOry_InDex != GAME_OVER) {
                setTopButton(savedInstanceState.getString(TOp));
                setBottoMBUtton(savedInstanceState.getString(BOttOM));
            }
            else {
                TopButton.setVisibility(View.INVISIBLE);
                BottoMBUtton.setVisibility(View.INVISIBLE);
            }
        }
    }
    private void UpDAteStory(String text){
        textView.setText(text);
    }
    private void setTopButton(String text){
        TopButton.setText(text);
    }
    private void setBottoMBUtton(String text){
        BottoMBUtton.setText(text);
    }
    private void T3_Story(){
        UpDAteStory(StOry3);
        setTopButton(Ans3_1);
        setBottoMBUtton(Ans3_2);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putString(StOry, textView.getText().toString());
        outState.putInt(retrieveInDex, StOry_InDex);
        if(StOry_InDex != GAME_OVER) {
            outState.putString(TOp, TopButton.getText().toString());
            outState.putString(BOttOM, BottoMBUtton.getText().toString());
        }
    }
}

