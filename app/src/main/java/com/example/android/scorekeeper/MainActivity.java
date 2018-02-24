package com.example.android.scorekeeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int scoreA = 0;
    int scoreB = 0;
    int cornersA = 0;
    int cornersB = 0;
    int foulsA = 0;
    int foulsB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayForTeamA(scoreA);
        displayForTeamB(scoreB);
        displayStatsA(prepareStatsMessage(cornersA,foulsA));
        displayStatsB(prepareStatsMessage(cornersB,foulsB));
    }

    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    public void displayStatsA(String stats) {
        TextView statsView = (TextView) findViewById(R.id.stats_a);
        statsView.setText(stats);
    }

    public void displayStatsB(String stats) {
        TextView statsView = (TextView) findViewById(R.id.stats_b);
        statsView.setText(stats);
    }

    public void countCornersA(View v){
        cornersA += 1;
        String stats = prepareStatsMessage(cornersA, foulsA);
        displayStatsA(stats);
    }

    public void countFoulsA(View v){
        foulsA += 1;
        String stats = prepareStatsMessage(cornersA, foulsA);
        displayStatsA(stats);
    }

    public void countCornersB(View v){
        cornersB += 1;
        String stats = prepareStatsMessage(cornersB, foulsB);
        displayStatsB(stats);
    }

    public void countFoulsB(View v){
        foulsB += 1;
        String stats = prepareStatsMessage(cornersB, foulsB);
        displayStatsB(stats);
    }

    public void countGoalA(View v) {
        scoreA += 1;
        displayForTeamA(scoreA);
    }

    public void countGoalB(View v) {
        scoreB += 1;
        displayForTeamB(scoreB);
    }

    private String prepareStatsMessage(int corner, int foul) {
        String stats = getString(R.string.stats, corner, foul);
        return  stats;
    }

    public void reset(View v) {
        scoreA = 0;
        scoreB = 0;
        cornersA = 0;
        cornersB = 0;
        foulsA = 0;
        foulsB = 0;
        displayForTeamA(scoreA);
        displayForTeamB(scoreB);
        displayStatsA(prepareStatsMessage(cornersA,foulsA));
        displayStatsB(prepareStatsMessage(cornersB,foulsB));
    }
}
