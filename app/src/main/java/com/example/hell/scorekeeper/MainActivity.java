package com.example.hell.scorekeeper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int scoreTeamA;
    private int scoreTeamB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState == null){
            scoreTeamA = 0;
            scoreTeamB = 0;
        }
        setContentView(R.layout.activity_main);
    }
    // Scores
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.txtTeamScoreA);
        scoreView.setText(String.valueOf(score));
    }
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.txtTeamScoreB);
        scoreView.setText(String.valueOf(score));
    }
    // Team Score A
    public void addOnePointA(View v){
        scoreTeamA++;
        displayForTeamA(scoreTeamA);
    }
    // Team Score B
    public void addOnePointB(View v){
        scoreTeamB++;
        displayForTeamB(scoreTeamB);
    }
    // Reset Scores
    public void ResetScore(View v){
        scoreTeamA=0;
        scoreTeamB=0;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("teamAScore",scoreTeamA);
        savedInstanceState.putInt("teamBScore",scoreTeamB);
    }
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        scoreTeamA=savedInstanceState.getInt("teamAScore");
        scoreTeamB=savedInstanceState.getInt("teamBScore");
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
    }
}