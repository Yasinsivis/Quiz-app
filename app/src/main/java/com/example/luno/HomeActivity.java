package com.example.luno;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


public class HomeActivity extends AppCompatActivity {
    Button btnDOG;
    Button btnCAT;
    Button btnBUG;
    Button btnDUCK;
    Button btnTIGER;
    Button btnLION;
    Button btnDOLPHIN;
    Button btnWOLF;
    Button btnSQUIRREL;
    Button btnTURTLE;
    Button btnBIRD;
    Button btnPARROT;
    Button btnPIG;
    Button btnBULL;
    Button btnBEAR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);

        //tanımlar
        btnDOG=findViewById(R.id.DOG);
        btnCAT=findViewById(R.id.CAT);
        btnBEAR=findViewById(R.id.BEAR);
        btnBUG=findViewById(R.id.BUG);
        btnDUCK=findViewById(R.id.DUCK);
        btnLION=findViewById(R.id.LION);
        btnTIGER=findViewById(R.id.TIGER);
        btnWOLF=findViewById(R.id.WOLF);
        btnDOLPHIN=findViewById(R.id.DOLPHIN);
        btnPARROT=findViewById(R.id.PARROT);
        btnBIRD=findViewById(R.id.BIRD);
        btnPIG=findViewById(R.id.PIG);
        btnSQUIRREL=findViewById(R.id.SQUIRREL);
        btnTURTLE=findViewById(R.id.TURTLE);
        btnBULL=findViewById(R.id.BULL);

        //tags
        btnDOG.setTag(0);
        btnCAT.setTag(1);
        btnDUCK.setTag(2);
        btnBUG.setTag(3);
        btnBIRD.setTag(4);
        btnTURTLE.setTag(5);
        btnPARROT.setTag(6);
        btnSQUIRREL.setTag(7);
        btnBULL.setTag(8);
        btnPIG.setTag(9);
        btnTIGER.setTag(10);
        btnLION.setTag(11);
        btnDOLPHIN.setTag(12);
        btnWOLF.setTag(13);
        btnBEAR.setTag(14);
    }
    public void PlayBTN (View view){

        int testId=(int) view.getTag();
        Intent intent = new Intent(HomeActivity.this, QuestionActivity.class);
        intent.putExtra("Index", testId);
        startActivity(intent);
      
    }
    public void Settings (View view){
        Intent settingsIntent = new Intent(HomeActivity.this , SettingsActivity.class);
        startActivity(settingsIntent);
    }
    public void Score(View view){
        Intent ScoreIntent = new Intent(HomeActivity.this, ScoreActivity.class);
        startActivity(ScoreIntent);
    }

    public void Profile(View view){
        showProfileDialog();
    }
    private void showProfileDialog() {
        ProfileDialogFragment dialogFragment = new ProfileDialogFragment();
        dialogFragment.show(getSupportFragmentManager(), "ProfileDialogFragment");
    }
}
