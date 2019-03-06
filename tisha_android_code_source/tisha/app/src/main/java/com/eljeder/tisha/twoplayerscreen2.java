package com.eljeder.tisha;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.RadioButton;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class twoplayerscreen2 extends AppCompatActivity {
    public static int playfirsth;
    public static int player1icon;
    public static int player2icon;
public static  int blokiafromtowplayeractivity;
    public static  int permisstomovefromtwoplayscreen;

    private InterstitialAd mInterstitialAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.twoplayerscreendeux);




        MobileAds.initialize(this,
                "ca-app-pub-3940256099942544~3347511713");



        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());



















        ImageButton playbt=(ImageButton) findViewById(R.id.imageButton12);

        ImageButton bbplay=(ImageButton) findViewById(R.id.imageButtonsingleplayer);
        Animation anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);


        bbplay.setAnimation(anim);
        anim.start();

    }
    public void onDestroy() {
        super.onDestroy();
        Runtime.getRuntime().gc();
    }


    public void playfirsth(){
        RadioButton player1=(RadioButton) findViewById(R.id.radioplayer1);
        RadioButton player2=(RadioButton) findViewById(R.id.radioplayer2);


        if(player1.isChecked()){playfirsth=1;}
        if(player2.isChecked()){playfirsth=2;} }


    public void player1them(){
        RadioButton cpufrais=(RadioButton) findViewById(R.id.cpufrais);
        RadioButton cpubaske=(RadioButton) findViewById(R.id.cpubaske);
        RadioButton cpuminio=(RadioButton) findViewById(R.id.cpuminio);

        if(cpufrais.isChecked()){player1icon=1;}
        if(cpubaske.isChecked()){player1icon=2;}
        if(cpuminio.isChecked()){player1icon=3;}}


    public void player2them(){


        RadioButton humankora=(RadioButton) findViewById(R.id.humankor);
        RadioButton humanminion=(RadioButton) findViewById(R.id.humanminio);
        RadioButton humanbanane=(RadioButton) findViewById(R.id.humanbanan);

        if(humanbanane.isChecked()){player2icon=1;}
        if(humankora.isChecked()){player2icon=2;}
        if(humanminion.isChecked()){player2icon=3;} }



    public void btplaytwoplayer(View view) {

      playfirsth();
       player1them();
        player2them();
        blokiafromtowplayeractivity=1;
        permisstomovefromtwoplayscreen=1;
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        }
        Intent choosecarrotwoplayer=new Intent(this,chosecarrotowplayer.class);


        startActivity(choosecarrotwoplayer);



    }
}
