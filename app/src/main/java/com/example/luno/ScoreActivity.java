package com.example.luno;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


import java.util.List;

public class ScoreActivity extends AppCompatActivity {
    TextView topPlayer1, topPlayer2, topPlayer3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_score);

        topPlayer1 = findViewById(R.id.topPlayer1);
        topPlayer2 = findViewById(R.id.topPlayer2);
        topPlayer3 = findViewById(R.id.topPlayer3);

        ProcessResult result = APP.Database.getTopThreePlayers();


        List<Player> topPlayers = APP.TopPlayersList;

        if (topPlayers.size() > 0) {
            topPlayer1.setText(topPlayers.get(0).getName() + " - " + topPlayers.get(0).getScore());
        }
        if (topPlayers.size() > 1) {
            topPlayer2.setText(topPlayers.get(1).getName() + " - " + topPlayers.get(1).getScore());
        }
        if (topPlayers.size() > 2) {
            topPlayer3.setText(topPlayers.get(2).getName() + " - " + topPlayers.get(2).getScore());
        }


    }
    public void Back(View view){
        Intent BackIntent = new Intent(ScoreActivity.this,HomeActivity.class);
        startActivity(BackIntent);
    }
}