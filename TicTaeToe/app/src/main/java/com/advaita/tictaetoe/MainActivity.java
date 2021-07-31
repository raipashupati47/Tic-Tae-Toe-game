package com.advaita.tictaetoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
boolean gameactive=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
//    0-X;
//    1-O;
    int activeplayer=0;
    int [] gameState = {2,2,2,2,2,2,2,2,2};
    int [][] winpositions={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{1,4,8},{2,4,6}};

    public void tap(View view){
        ImageView img=(ImageView) view;
        int tappedImage= Integer.parseInt(img.getTag().toString());
        if(!gameactive){
            gamereset(view);
        }
        if(gameState[tappedImage]==2 && gameactive ) {
            gameState[tappedImage] = activeplayer;
            img.setTranslationY(-1000f);
            if (activeplayer == 0) {
                img.setImageResource(R.drawable.x);
                activeplayer = 1;
                TextView status = findViewById(R.id.status);
                status.setText("O's turn - Tap to play");
            } else {
                img.setImageResource(R.drawable.o);
                activeplayer = 0;
                TextView status = findViewById(R.id.status);
                status.setText("X's turn - Tap to play");
            }
            img.animate().translationYBy(1000f).setDuration(300);
        }

    for(int[] winposition: winpositions) {
        if ((gameState[winposition[0]] == gameState[winposition[1]]) && (gameState[winposition[1]] == gameState[winposition[2]]) && gameState[winposition[0]] != 2) {
            String str;

            if (gameState[winposition[0]] == 0) {
                str = "X has won";
            } else {
                str = "O has won";
            }
            TextView status = findViewById(R.id.status);
            status.setText(str);
            gameactive=false;

        }
    }
    }
    public void gamereset(View view){
        gameactive=true;
        activeplayer=0;
        for(int i=0;i<gameState.length;i++){
            gameState[i]=2;
        }
        ( (ImageView) findViewById(R.id.imageView0)).setImageResource(0);
        ( (ImageView) findViewById(R.id.imageView1)).setImageResource(0);
        ( (ImageView) findViewById(R.id.imageView2)).setImageResource(0);
        ( (ImageView) findViewById(R.id.imageView3)).setImageResource(0);
        ( (ImageView) findViewById(R.id.imageView4)).setImageResource(0);
        ( (ImageView) findViewById(R.id.imageView5)).setImageResource(0);
        ( (ImageView) findViewById(R.id.imageView6)).setImageResource(0);
        ( (ImageView) findViewById(R.id.imageView7)).setImageResource(0);
        ( (ImageView) findViewById(R.id.imageView8)).setImageResource(0);


    }


}