package com.eljeder.tisha;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import static com.eljeder.tisha.twoplayerscreen2.player1icon;
import static com.eljeder.tisha.twoplayerscreen2.player2icon;
import static com.eljeder.tisha.twoplayerscreen2.playfirsth;


public class chosecarrotowplayer extends AppCompatActivity {

    public static int kk1=0;
    public static int kk2=0;
    public int playfirstowplayer;

    public int player1iconn;
    public  int player2iconn;
    public static int[] listTowPlayer;
    private AdView mAdView,   adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.carrochoose);


        // private AdView mAdView,   adView;
        MobileAds.initialize(this,"ca-app-pub-1350123755884874~6965127510");


        adView = new AdView(chosecarrotowplayer.this);
        adView.setAdSize(AdSize.SMART_BANNER);

        adView.setAdUnitId( "ca-app-pub-3940256099942544/6300978111");
        RelativeLayout layout = (RelativeLayout) findViewById(R.id.lchoose);
        layout.addView(adView);
// Initiate a generic request.
        AdRequest adRequest = new AdRequest.Builder().build();
// Load the adView with the ad request.
        adView.loadAd(adRequest);
        layout.bringToFront();

        intiaTowPlayer();

        ImageButton btnew=(ImageButton) findViewById(R.id.imageButton6new);
        Animation anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);


        btnew.setAnimation(anim);
        anim.start();






}







    public void intiaTowPlayer() {
        ImageButton carro1 = (ImageButton) findViewById(R.id.carrochos1);
        ImageButton carro2 = (ImageButton) findViewById(R.id.carrochos2);
        ImageButton carro3 = (ImageButton) findViewById(R.id.carrochos3);
        ImageButton carro4 = (ImageButton) findViewById(R.id.carrochos4);
        ImageButton carro5 = (ImageButton) findViewById(R.id.carrochos5);
        ImageButton carro6 = (ImageButton) findViewById(R.id.carrochos6);
        ImageButton carro7 = (ImageButton) findViewById(R.id.carrochos7);
        ImageButton carro8 = (ImageButton) findViewById(R.id.carrochos8);
        ImageButton carro9 = (ImageButton) findViewById(R.id.carrochos9);
        ImageButton playbt=(ImageButton) findViewById(R.id.playbtnchosecarro);
        playbt.setVisibility(View.INVISIBLE);
        playfirstowplayer = playfirsth;
        player1iconn = player1icon;

        player2iconn = player2icon;
        kk1 = 0;kk2=0;
        listTowPlayer = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};

    }

    public void btnew(View view) {
        ImageButton carro1=(ImageButton) findViewById(R.id.carrochos1);
        ImageButton carro2=(ImageButton) findViewById(R.id.carrochos2);
        ImageButton carro3=(ImageButton) findViewById(R.id.carrochos3);
        ImageButton carro4=(ImageButton) findViewById(R.id.carrochos4);
        ImageButton carro5=(ImageButton) findViewById(R.id.carrochos5);
        ImageButton carro6=(ImageButton) findViewById(R.id.carrochos6);
        ImageButton carro7=(ImageButton) findViewById(R.id.carrochos7);
        ImageButton carro8=(ImageButton) findViewById(R.id.carrochos8);
        ImageButton carro9=(ImageButton) findViewById(R.id.carrochos9);
        listTowPlayer =new int[]{0,0,0,0,0,0,0,0,0};
        kk1=0;kk2=0;
        ImageButton playbt=(ImageButton) findViewById(R.id.playbtnchosecarro);
        playbt.setVisibility(View.INVISIBLE);
        carro1.setBackgroundResource(R.drawable.trp);
        carro2.setBackgroundResource(R.drawable.trp);
        carro3.setBackgroundResource(R.drawable.trp);
        carro4.setBackgroundResource(R.drawable.trp);
        carro5.setBackgroundResource(R.drawable.trp);
        carro6.setBackgroundResource(R.drawable.trp);
        carro7.setBackgroundResource(R.drawable.trp);
        carro8.setBackgroundResource(R.drawable.trp);
        carro9.setBackgroundResource(R.drawable.trp); }

    public void carochoosebtcpu(View view) {

int casevideas=0;


        for(int j=0;j<9;j++){ if (listTowPlayer[j] ==0 ) { casevideas++; }


        if(casevideas==3){
            Intent mainactivity=new Intent(this,MainActivitytwop.class);
            startActivity(mainactivity);this.finish();} }





    }













    public void carrochose1(View view) {
        ImageButton carro1=(ImageButton) findViewById(R.id.carrochos1);

        if(playfirstowplayer==2 && kk2 <3 &&  kk1==0 && listTowPlayer[0]==0 ){
            listTowPlayer[0]=2;
            int v=1;
if(listTowPlayer[0]==listTowPlayer[1] && listTowPlayer[0]==listTowPlayer[2]){ listTowPlayer[0]=0; v=0;}
if(listTowPlayer[0]==2 && listTowPlayer[3]==2 && listTowPlayer[6]==2){v=0; listTowPlayer[0]=0;}


            if(v==1){
            if( player2iconn==1){carro1.setBackgroundResource(R.drawable.bananered);}
            if(player2iconn==2){carro1.setBackgroundResource(R.drawable.korafootred);}
            if( player2iconn==3){carro1.setBackgroundResource(R.drawable.minion2red2);}
            kk2++;    }}

        if(playfirstowplayer==1 && kk1 <3 && kk2==0  && listTowPlayer[0]==0 ){
            listTowPlayer[0]=1;
            int v=1;
            if(listTowPlayer[0]==listTowPlayer[1] && listTowPlayer[0]==listTowPlayer[2]){ listTowPlayer[0]=0; v=0;}
            if(listTowPlayer[0]==1 && listTowPlayer[3]==1 && listTowPlayer[6]==1){v=0; listTowPlayer[0]=0;}


            if(v==1){
            if( player1iconn==1){carro1.setBackgroundResource(R.drawable.fraisered);}
            if( player1iconn==2){carro1.setBackgroundResource(R.drawable.korabasketred);}
            if( player1iconn==3){carro1.setBackgroundResource(R.drawable.mininred1);}
            kk1++;}
        }
        if(kk1==3 && kk2 <3 && listTowPlayer[0]==0 ){

            listTowPlayer[0]=2;
            int v=1;
            if(listTowPlayer[0]==listTowPlayer[1] && listTowPlayer[0]==listTowPlayer[2]){ listTowPlayer[0]=0; v=0;}
            if(listTowPlayer[0]==2 && listTowPlayer[3]==2 && listTowPlayer[6]==2){v=0; listTowPlayer[0]=0;}


            if(v==1){
            if( player2iconn==1){carro1.setBackgroundResource(R.drawable.bananered);}
            if(player2iconn==2){carro1.setBackgroundResource(R.drawable.korafootred);}
            if( player2iconn==3){carro1.setBackgroundResource(R.drawable.minion2red2);}
            kk2++;} }


            if(kk2==3 && kk1<3 && listTowPlayer[0]==0){
            listTowPlayer[0]=1;
                int v=1;
                if(listTowPlayer[0]==listTowPlayer[1] && listTowPlayer[0]==listTowPlayer[2]){ listTowPlayer[0]=0; v=0;}
                if(listTowPlayer[0]==1 && listTowPlayer[3]==1 && listTowPlayer[6]==1){v=0; listTowPlayer[0]=0;}

if(v==1){
                if( player1iconn==1){carro1.setBackgroundResource(R.drawable.fraisered);}
                if( player1iconn==2){carro1.setBackgroundResource(R.drawable.korabasketred);}
                if( player1iconn==3){carro1.setBackgroundResource(R.drawable.mininred1);}
                kk1++; }


            }int casevide=0;  for(int j=0;j<9;j++){ if (listTowPlayer[j] ==0 ) { casevide++; }}


            if(casevide==3){
                ImageButton playbt=(ImageButton) findViewById(R.id.playbtnchosecarro);
                playbt.setVisibility(View. VISIBLE);ImageButton btplayy=(ImageButton) findViewById(R.id.playbtnchosecarro);
                Animation anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);
                btplayy.setAnimation(anim);
                anim.start();
            }

        }

    public void carrochose2(View view) {
        ImageButton carro2=(ImageButton) findViewById(R.id.carrochos2);
        if(playfirstowplayer==2 && kk2 <3 &&  kk1==0 && listTowPlayer[1]==0 ){
            listTowPlayer[1]=2;

            int v=1;
            if(listTowPlayer[1]==2 && listTowPlayer[0]==2 && listTowPlayer[2]==2){v=0; listTowPlayer[0]=0;}
            if(listTowPlayer[1]==2 && listTowPlayer[4]==2 && listTowPlayer[7]==2){v=0; listTowPlayer[0]=0;}


            if(v==1){
            if( player2iconn==1){carro2.setBackgroundResource(R.drawable.bananered);}
            if(player2iconn==2){carro2.setBackgroundResource(R.drawable.korafootred);}
            if( player2iconn==3){carro2.setBackgroundResource(R.drawable.minion2red2);}
            kk2++;} }

        if(playfirstowplayer==1 && kk1 <3 && kk2==0 && listTowPlayer[1]==0 ){
            listTowPlayer[1]=1;
            int v=1;
            if(listTowPlayer[1]==1 && listTowPlayer[0]==1 && listTowPlayer[2]==1){v=0; listTowPlayer[0]=0;}
            if(listTowPlayer[1]==1 && listTowPlayer[4]==1 && listTowPlayer[7]==1){v=0; listTowPlayer[0]=0;}


            if(v==1){
            if( player1iconn==1){carro2.setBackgroundResource(R.drawable.fraisered);}
            if( player1iconn==2){carro2.setBackgroundResource(R.drawable.korabasketred);}
            if(player1iconn==3){carro2.setBackgroundResource(R.drawable.mininred1);}
            kk1++;} }


        if(kk1==3 && kk2 <3 && listTowPlayer[1]==0){
            listTowPlayer[1]=2;
            int v=1;
            if(listTowPlayer[1]==2 && listTowPlayer[0]==2 && listTowPlayer[2]==2){v=0; listTowPlayer[0]=0;}
            if(listTowPlayer[1]==2 && listTowPlayer[4]==2 && listTowPlayer[7]==2){v=0; listTowPlayer[0]=0;}


            if(v==1){
            if( player2iconn==1){carro2.setBackgroundResource(R.drawable.bananered);}
            if(player2iconn==2){carro2.setBackgroundResource(R.drawable.korafootred);}
            if( player2iconn==3){carro2.setBackgroundResource(R.drawable.minion2red2);}
            kk2++;} }


        if(kk2==3 && kk1<3 && listTowPlayer[1]==0){
            listTowPlayer[1]=1;
            int v=1;
            if(listTowPlayer[1]==1 && listTowPlayer[0]==1 && listTowPlayer[2]==1){v=0; listTowPlayer[0]=0;}
            if(listTowPlayer[1]==1 && listTowPlayer[4]==1 && listTowPlayer[7]==1){v=0; listTowPlayer[0]=0;}


            if(v==1){
            if( player1iconn==1){carro2.setBackgroundResource(R.drawable.fraisered);}
            if( player1iconn==2){carro2.setBackgroundResource(R.drawable.korabasketred);}
            if(player1iconn==3){carro2.setBackgroundResource(R.drawable.mininred1);}
            kk1++; }


        }

        int casevide=0;  for(int j=0;j<9;j++){ if (listTowPlayer[j] ==0 ) { casevide++; }}


        if(casevide==3){
            ImageButton playbt=(ImageButton) findViewById(R.id.playbtnchosecarro);
            playbt.setVisibility(View. VISIBLE);ImageButton btplayy=(ImageButton) findViewById(R.id.playbtnchosecarro);
            Animation anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);
            btplayy.setAnimation(anim);
            anim.start();
        }

    }

    public void carrochose3(View view) {

        ImageButton carro3=(ImageButton) findViewById(R.id.carrochos3);
        if(playfirstowplayer==2 && kk2 <3 &&  kk1==0 && listTowPlayer[2]==0){
            listTowPlayer[2]=2;

            int v=1;
            if(listTowPlayer[2]==2 && listTowPlayer[1]==2 && listTowPlayer[0]==2){v=0; listTowPlayer[2]=0;}
            if(listTowPlayer[2]==2 && listTowPlayer[5]==2 && listTowPlayer[8]==2){v=0; listTowPlayer[2]=0;}


            if(v==1){
            if( player2iconn==1){carro3.setBackgroundResource(R.drawable.bananered);}
            if(player2iconn==2){carro3.setBackgroundResource(R.drawable.korafootred);}
            if( player2iconn==3){carro3.setBackgroundResource(R.drawable.minion2red2);}
            kk2++;} }
        if(playfirstowplayer==1 && kk1 <3 && kk2==0 && listTowPlayer[2]==0 ){
            listTowPlayer[2]=1;
            int v=1;
            if(listTowPlayer[2]==1 && listTowPlayer[1]==1 && listTowPlayer[0]==1){v=0; listTowPlayer[2]=0;}
            if(listTowPlayer[2]==1 && listTowPlayer[5]==1 && listTowPlayer[8]==1){v=0; listTowPlayer[2]=0;}


            if(v==1){
            if( player1iconn==1){carro3.setBackgroundResource(R.drawable.fraisered);}
            if( player1iconn==2){carro3.setBackgroundResource(R.drawable.korabasketred);}
            if(player1iconn==3){carro3.setBackgroundResource(R.drawable.mininred1);}
            kk1++;} }
        if(kk1==3 && kk2 <3 && listTowPlayer[2]==0 ){
            listTowPlayer[2]=2;
            int v=1;
            if(listTowPlayer[2]==2 && listTowPlayer[1]==2 && listTowPlayer[0]==2){v=0; listTowPlayer[2]=0;}
            if(listTowPlayer[2]==2 && listTowPlayer[5]==2 && listTowPlayer[8]==2){v=0; listTowPlayer[2]=0;}


            if(v==1){
            if( player2iconn==1){carro3.setBackgroundResource(R.drawable.bananered);}
            if(player2iconn==2){carro3.setBackgroundResource(R.drawable.korafootred);}
            if( player2iconn==3){carro3.setBackgroundResource(R.drawable.minion2red2);}
            kk2++;} }
        if(kk2==3 && kk1<3 && listTowPlayer[2]==0){
            listTowPlayer[2]=1;
            int v=1;
            if(listTowPlayer[2]==1 && listTowPlayer[1]==1 && listTowPlayer[0]==1){v=0; listTowPlayer[2]=0;}
            if(listTowPlayer[2]==1 && listTowPlayer[5]==1 && listTowPlayer[8]==1){v=0; listTowPlayer[2]=0;}


            if(v==1){
            if( player1iconn==1){carro3.setBackgroundResource(R.drawable.fraisered);}
            if( player1iconn==2){carro3.setBackgroundResource(R.drawable.korabasketred);}
            if(player1iconn==3){carro3.setBackgroundResource(R.drawable.mininred1);}
            kk1++;}}

        int casevide=0;  for(int j=0;j<9;j++){ if (listTowPlayer[j] ==0 ) { casevide++; }}


        if(casevide==3){
            ImageButton playbt=(ImageButton) findViewById(R.id.playbtnchosecarro);
            playbt.setVisibility(View. VISIBLE);ImageButton btplayy=(ImageButton) findViewById(R.id.playbtnchosecarro);
            Animation anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);
            btplayy.setAnimation(anim);
            anim.start();
        }
    }

    public void carrochose4(View view) {
        ImageButton carro4=(ImageButton) findViewById(R.id.carrochos4);
        if(playfirstowplayer==2 && kk2 <3 &&  kk1==0 &&listTowPlayer[3]==0){
            listTowPlayer[3]=2;
            int v=1;
            if(listTowPlayer[3]==2 && listTowPlayer[6]==2 && listTowPlayer[0]==2){v=0; listTowPlayer[3]=0;}
            if(listTowPlayer[4]==2 && listTowPlayer[3]==2 && listTowPlayer[5]==2){v=0; listTowPlayer[3]=0;}


            if(v==1){
            if( player2iconn==1){carro4.setBackgroundResource(R.drawable.bananered);}
            if(player2iconn==2){carro4.setBackgroundResource(R.drawable.korafootred);}
            if( player2iconn==3){carro4.setBackgroundResource(R.drawable.minion2red2);}
            kk2++;}}

        if(playfirstowplayer==1 && kk1 <3 && kk2==0 && listTowPlayer[3]==0){
            listTowPlayer[3]=1;
            int v=1;
            if(listTowPlayer[3]==1 && listTowPlayer[6]==1 && listTowPlayer[0]==1){v=0; listTowPlayer[3]=0;}
            if(listTowPlayer[4]==1 && listTowPlayer[3]==1 && listTowPlayer[5]==1){v=0; listTowPlayer[3]=0;}


            if(v==1){
            if( player1iconn==1){carro4.setBackgroundResource(R.drawable.fraisered);}
            if( player1iconn==2){carro4.setBackgroundResource(R.drawable.korabasketred);}
            if(player1iconn==3){carro4.setBackgroundResource(R.drawable.mininred1);}
            kk1++;}
        }
        if(kk1==3 && kk2 <3 && listTowPlayer[3]==0 ){
            listTowPlayer[3]=2;
            int v=1;
            if(listTowPlayer[3]==2 && listTowPlayer[6]==2 && listTowPlayer[0]==2){v=0; listTowPlayer[3]=0;}
            if(listTowPlayer[4]==2 && listTowPlayer[3]==2 && listTowPlayer[5]==2){v=0; listTowPlayer[3]=0;}


            if(v==1){
            if( player2iconn==1){carro4.setBackgroundResource(R.drawable.bananered);}
            if(player2iconn==2){carro4.setBackgroundResource(R.drawable.korafootred);}
            if( player2iconn==3){carro4.setBackgroundResource(R.drawable.minion2red2);}
            kk2++;}}


        if(kk2==3 && kk1<3 && listTowPlayer[3]==0){
            listTowPlayer[3]=1;
            int v=1;
            if(listTowPlayer[3]==1 && listTowPlayer[6]==1 && listTowPlayer[0]==1){v=0; listTowPlayer[3]=0;}
            if(listTowPlayer[4]==1 && listTowPlayer[3]==1 && listTowPlayer[5]==1){v=0; listTowPlayer[3]=0;}


            if(v==1){
            if( player1iconn==1){carro4.setBackgroundResource(R.drawable.fraisered);}
            if( player1iconn==2){carro4.setBackgroundResource(R.drawable.korabasketred);}
            if(player1iconn==3){carro4.setBackgroundResource(R.drawable.mininred1);}
            kk1++; }


        }int casevide=0;  for(int j=0;j<9;j++){ if (listTowPlayer[j] ==0 ) { casevide++; }}


        if(casevide==3){
            ImageButton playbt=(ImageButton) findViewById(R.id.playbtnchosecarro);
            playbt.setVisibility(View. VISIBLE);ImageButton btplayy=(ImageButton) findViewById(R.id.playbtnchosecarro);
            Animation anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);
            btplayy.setAnimation(anim);
            anim.start();
        }
    }

    public void carrochose5(View view) {

        ImageButton carro5=(ImageButton) findViewById(R.id.carrochos5);
        if(playfirstowplayer==2 && kk2 <3 &&  kk1==0 && listTowPlayer[4]==0 ){
            listTowPlayer[4]=2;
            int v=1;
            if(listTowPlayer[4]==2 && listTowPlayer[1]==2 && listTowPlayer[7]==2){v=0; listTowPlayer[4]=0;}
            if(listTowPlayer[4]==2 && listTowPlayer[3]==2 && listTowPlayer[5]==2){v=0; listTowPlayer[4]=0;}


            if(v==1){
            if( player2iconn==1){carro5.setBackgroundResource(R.drawable.bananered);}
            if(player2iconn==2){carro5.setBackgroundResource(R.drawable.korafootred);}
            if( player2iconn==3){carro5.setBackgroundResource(R.drawable.minion2red2);}
            kk2++;} }

        if(playfirstowplayer==1 && kk1 <3 && kk2==0 && listTowPlayer[4]==0 ){
            listTowPlayer[4]=1;
            int v=1;
            if(listTowPlayer[4]==1 && listTowPlayer[1]==1 && listTowPlayer[7]==1){v=0; listTowPlayer[4]=0;}
            if(listTowPlayer[4]==1 && listTowPlayer[3]==1 && listTowPlayer[5]==1){v=0; listTowPlayer[4]=0;}


            if(v==1){
            if( player1iconn==1){carro5.setBackgroundResource(R.drawable.fraisered);}
            if( player1iconn==2){carro5.setBackgroundResource(R.drawable.korabasketred);}
            if(player1iconn==3){carro5.setBackgroundResource(R.drawable.mininred1);}
            kk1++;}
        }
        if(kk1==3 && kk2 <3 && listTowPlayer[4]==0 ){
            listTowPlayer[4]=2;
            int v=1;
            if(listTowPlayer[4]==2 && listTowPlayer[1]==2 && listTowPlayer[7]==2){v=0; listTowPlayer[4]=0;}
            if(listTowPlayer[4]==2 && listTowPlayer[3]==2 && listTowPlayer[5]==2){v=0; listTowPlayer[4]=0;}


            if(v==1){
            if( player2iconn==1){carro5.setBackgroundResource(R.drawable.bananered);}
            if(player2iconn==2){carro5.setBackgroundResource(R.drawable.korafootred);}
            if( player2iconn==3){carro5.setBackgroundResource(R.drawable.minion2red2);}
            kk2++;}}


        if(kk2==3 && kk1<3 && listTowPlayer[4]==0){
            listTowPlayer[4]=1;
            int v=1;
            if(listTowPlayer[4]==1 && listTowPlayer[1]==1 && listTowPlayer[7]==1){v=0; listTowPlayer[4]=0;}
            if(listTowPlayer[4]==1 && listTowPlayer[3]==1 && listTowPlayer[5]==1){v=0; listTowPlayer[4]=0;}


            if(v==1){
            if( player1iconn==1){carro5.setBackgroundResource(R.drawable.fraisered);}
            if( player1iconn==2){carro5.setBackgroundResource(R.drawable.korabasketred);}
            if(player1iconn==3){carro5.setBackgroundResource(R.drawable.mininred1);}
            kk1++;}


        }int casevide=0;  for(int j=0;j<9;j++){ if (listTowPlayer[j] ==0 ) { casevide++; }}


        if(casevide==3){
            ImageButton playbt=(ImageButton) findViewById(R.id.playbtnchosecarro);
            playbt.setVisibility(View. VISIBLE);ImageButton btplayy=(ImageButton) findViewById(R.id.playbtnchosecarro);
            Animation anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);
            btplayy.setAnimation(anim);
            anim.start();
        }
    }

    public void carrochose6(View view) {
        ImageButton carro6=(ImageButton) findViewById(R.id.carrochos6);
        if(playfirstowplayer==2 && kk2 <3 &&  kk1==0 && listTowPlayer[5]==0){
            listTowPlayer[5]=2;
            int v=1;
            if(listTowPlayer[5]==2 && listTowPlayer[2]==2 && listTowPlayer[8]==2){v=0; listTowPlayer[5]=0;}
            if(listTowPlayer[5]==2 && listTowPlayer[3]==2 && listTowPlayer[4]==2){v=0; listTowPlayer[5]=0;}
            if(v==1){
            if( player2iconn==1){carro6.setBackgroundResource(R.drawable.bananered);}
            if(player2iconn==2){carro6.setBackgroundResource(R.drawable.korafootred);}
            if( player2iconn==3){carro6.setBackgroundResource(R.drawable.minion2red2);}
            kk2++;}}

        if(playfirstowplayer==1 && kk1 <3 && kk2==0 && listTowPlayer[5]==0 ){
            listTowPlayer[5]=1;
            int v=1;
            if(listTowPlayer[5]==1 && listTowPlayer[2]==1 && listTowPlayer[8]==1){v=0; listTowPlayer[5]=0;}
            if(listTowPlayer[5]==1 && listTowPlayer[3]==1 && listTowPlayer[4]==1){v=0; listTowPlayer[5]=0;}
            if(v==1){
            if( player1iconn==1){carro6.setBackgroundResource(R.drawable.fraisered);}
            if( player1iconn==2){carro6.setBackgroundResource(R.drawable.korabasketred);}
            if(player1iconn==3){carro6.setBackgroundResource(R.drawable.mininred1);}
            kk1++;}
        }
        if(kk1==3 && kk2 <3 && listTowPlayer[5]==0){
            listTowPlayer[5]=2;
            int v=1;
            if(listTowPlayer[5]==2 && listTowPlayer[2]==2 && listTowPlayer[8]==2){v=0; listTowPlayer[5]=0;}
            if(listTowPlayer[5]==2 && listTowPlayer[3]==2 && listTowPlayer[4]==2){v=0; listTowPlayer[5]=0;}
            if(v==1){
            if( player2iconn==1){carro6.setBackgroundResource(R.drawable.bananered);}
            if(player2iconn==2){carro6.setBackgroundResource(R.drawable.korafootred);}
            if( player2iconn==3){carro6.setBackgroundResource(R.drawable.minion2red2);}
            kk2++;}}


        if(kk2==3 && kk1<3 && listTowPlayer[5]==0){
            listTowPlayer[5]=1;
            int v=1;
            if(listTowPlayer[5]==1 && listTowPlayer[2]==1 && listTowPlayer[8]==1){v=0; listTowPlayer[5]=0;}
            if(listTowPlayer[5]==1 && listTowPlayer[3]==1 && listTowPlayer[4]==1){v=0; listTowPlayer[5]=0;}
            if(v==1){
            if( player1iconn==1){carro6.setBackgroundResource(R.drawable.fraisered);}
            if( player1iconn==2){carro6.setBackgroundResource(R.drawable.korabasketred);}
            if(player1iconn==3){carro6.setBackgroundResource(R.drawable.mininred1);}
            kk1++;}


        }int casevide=0;  for(int j=0;j<9;j++){ if (listTowPlayer[j] ==0 ) { casevide++; }}


        if(casevide==3){
            ImageButton playbt=(ImageButton) findViewById(R.id.playbtnchosecarro);
            playbt.setVisibility(View. VISIBLE);ImageButton btplayy=(ImageButton) findViewById(R.id.playbtnchosecarro);
            Animation anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);
            btplayy.setAnimation(anim);
            anim.start();
        }
    }

    public void carrochose7(View view) {
        ImageButton carro7=(ImageButton) findViewById(R.id.carrochos7);
        if(playfirstowplayer==2 && kk2 <3 &&  kk1==0 && listTowPlayer[6]==0 ){
            listTowPlayer[6]=2;
            int v=1;
            if(listTowPlayer[6]==2 && listTowPlayer[7]==2 && listTowPlayer[8]==2){v=0; listTowPlayer[6]=0;}
            if(listTowPlayer[0]==2 && listTowPlayer[6]==2 && listTowPlayer[3]==2){v=0; listTowPlayer[6]=0;}


            if(v==1){
            if( player2iconn==1){carro7.setBackgroundResource(R.drawable.bananered);}
            if(player2iconn==2){carro7.setBackgroundResource(R.drawable.korafootred);}
            if( player2iconn==3){carro7.setBackgroundResource(R.drawable.minion2red2);}
            kk2++;}}

        if(playfirstowplayer==1 && kk1 <3 && kk2==0 && listTowPlayer[6]==0){
            listTowPlayer[6]=1;
            int v=1;
            if(listTowPlayer[6]==1 && listTowPlayer[7]==1 && listTowPlayer[8]==1){v=0; listTowPlayer[6]=0;}
            if(listTowPlayer[0]==1 && listTowPlayer[6]==1 && listTowPlayer[3]==1){v=0; listTowPlayer[6]=0;}


            if(v==1){
            if( player1iconn==1){carro7.setBackgroundResource(R.drawable.fraisered);}
            if( player1iconn==2){carro7.setBackgroundResource(R.drawable.korabasketred);}
            if(player1iconn==3){carro7.setBackgroundResource(R.drawable.mininred1);}
            kk1++;}
        }
        if(kk1==3 && kk2 <3  && listTowPlayer[6]==0){listTowPlayer[6]=2;
            int v=1;
            if(listTowPlayer[6]==2 && listTowPlayer[7]==2 && listTowPlayer[8]==2){v=0; listTowPlayer[6]=0;}
            if(listTowPlayer[0]==2 && listTowPlayer[6]==2 && listTowPlayer[3]==2){v=0; listTowPlayer[6]=0;}


            if(v==1){
            if( player2iconn==1){carro7.setBackgroundResource(R.drawable.bananered);}
            if(player2iconn==2){carro7.setBackgroundResource(R.drawable.korafootred);}
            if( player2iconn==3){carro7.setBackgroundResource(R.drawable.minion2red2);}
            kk2++;}}


        if(kk2==3 && kk1<3 && listTowPlayer[6]==0){ listTowPlayer[6]=1;
            int v=1;
            if(listTowPlayer[6]==1 && listTowPlayer[7]==1 && listTowPlayer[8]==1){v=0; listTowPlayer[6]=0;}
            if(listTowPlayer[0]==1 && listTowPlayer[6]==1 && listTowPlayer[3]==1){v=0; listTowPlayer[6]=0;}


            if(v==1){
            if( player1iconn==1){carro7.setBackgroundResource(R.drawable.fraisered);}
            if( player1iconn==2){carro7.setBackgroundResource(R.drawable.korabasketred);}
            if(player1iconn==3){carro7.setBackgroundResource(R.drawable.mininred1);}
            kk1++;}


        }int casevide=0;  for(int j=0;j<9;j++){ if (listTowPlayer[j] ==0 ) { casevide++; }}


        if(casevide==3){
            ImageButton playbt=(ImageButton) findViewById(R.id.playbtnchosecarro);
            playbt.setVisibility(View. VISIBLE);ImageButton btplayy=(ImageButton) findViewById(R.id.playbtnchosecarro);
            Animation anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);
            btplayy.setAnimation(anim);
            anim.start();
        }
    }

    public void carrochose8(View view) {
        ImageButton carro8=(ImageButton) findViewById(R.id.carrochos8);
        if(playfirstowplayer==2 && kk2 <3 &&  kk1==0 && listTowPlayer[7]==0 ){
            listTowPlayer[7]=2;
            int v=1;
            if(listTowPlayer[7]==2 && listTowPlayer[1]==2 && listTowPlayer[4]==2){v=0; listTowPlayer[7]=0;}
            if(listTowPlayer[7]==2 && listTowPlayer[6]==2 && listTowPlayer[8]==2){v=0; listTowPlayer[7]=0;}


            if(v==1){
            if( player2iconn==1){carro8.setBackgroundResource(R.drawable.bananered);}
            if(player2iconn==2){carro8.setBackgroundResource(R.drawable.korafootred);}
            if( player2iconn==3){carro8.setBackgroundResource(R.drawable.minion2red2);}
            kk2++;}}

        if(playfirstowplayer==1 && kk1 <3 && kk2==0 && listTowPlayer[7]==0 ){
            listTowPlayer[7]=1;
            int v=1;
            if(listTowPlayer[7]==1 && listTowPlayer[1]==1 && listTowPlayer[4]==1){v=0; listTowPlayer[7]=0;}
            if(listTowPlayer[7]==1 && listTowPlayer[6]==1 && listTowPlayer[8]==1){v=0; listTowPlayer[7]=0;}


            if(v==1){
            if( player1iconn==1){carro8.setBackgroundResource(R.drawable.fraisered);}
            if( player1iconn==2){carro8.setBackgroundResource(R.drawable.korabasketred);}
            if(player1iconn==3){carro8.setBackgroundResource(R.drawable.mininred1);}
            kk1++;}
        }
        if(kk1==3 && kk2 <3 && listTowPlayer[7]==0 ){
            listTowPlayer[7]=2;
            int v=1;
            if(listTowPlayer[7]==2 && listTowPlayer[1]==2 && listTowPlayer[4]==2){v=0; listTowPlayer[7]=0;}
            if(listTowPlayer[7]==2 && listTowPlayer[6]==2 && listTowPlayer[8]==2){v=0; listTowPlayer[7]=0;}


            if(v==1){
            if( player2iconn==1){carro8.setBackgroundResource(R.drawable.bananered);}
            if(player2iconn==2){carro8.setBackgroundResource(R.drawable.korafootred);}
            if( player2iconn==3){carro8.setBackgroundResource(R.drawable.minion2red2);}
            kk2++;}}


        if(kk2==3 && kk1<3 && listTowPlayer[7]==0){ listTowPlayer[7]=1;
            int v=1;
            if(listTowPlayer[7]==1 && listTowPlayer[1]==1 && listTowPlayer[4]==1){v=0; listTowPlayer[7]=0;}
            if(listTowPlayer[7]==1 && listTowPlayer[6]==1 && listTowPlayer[8]==1){v=0; listTowPlayer[7]=0;}


            if(v==1){
            if( player1iconn==1){carro8.setBackgroundResource(R.drawable.fraisered);}
            if( player1iconn==2){carro8.setBackgroundResource(R.drawable.korabasketred);}
            if(player1iconn==3){carro8.setBackgroundResource(R.drawable.mininred1);}
            kk1++;}


        }
        int casevide=0;  for(int j=0;j<9;j++){ if (listTowPlayer[j] ==0 ) { casevide++; }}


        if(casevide==3){
            ImageButton playbt=(ImageButton) findViewById(R.id.playbtnchosecarro);
            playbt.setVisibility(View.VISIBLE);ImageButton btplayy=(ImageButton) findViewById(R.id.playbtnchosecarro);
            Animation anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);
            btplayy.setAnimation(anim);
            anim.start();
        }
    }

    public void carrochse9(View view) {
        ImageButton carro9=(ImageButton) findViewById(R.id.carrochos9);
        if(playfirstowplayer==2 && kk2 <3 &&  kk1==0 && listTowPlayer[8]==0){
            listTowPlayer[8]=2;
            int v=1;
            if(listTowPlayer[8]==2 && listTowPlayer[4]==2 && listTowPlayer[2]==2){v=0; listTowPlayer[8]=0;}
            if(listTowPlayer[8]==2 && listTowPlayer[7]==2 && listTowPlayer[6]==2){v=0; listTowPlayer[8]=0;}


            if(v==1){
            if( player2iconn==1){carro9.setBackgroundResource(R.drawable.bananered);}
            if(player2iconn==2){carro9.setBackgroundResource(R.drawable.korafootred);}
            if( player2iconn==3){carro9.setBackgroundResource(R.drawable.minion2red2);}
            kk2++;}}

        if(playfirstowplayer==1 && kk1 <3 && kk2==0 && listTowPlayer[8]==0 ){
            listTowPlayer[8]=1;
            int v=1;
            if(listTowPlayer[8]==1 && listTowPlayer[5]==1 && listTowPlayer[2]==1){v=0; listTowPlayer[8]=0;}
            if(listTowPlayer[8]==1 && listTowPlayer[7]==1 && listTowPlayer[6]==1){v=0; listTowPlayer[8]=0;}


            if(v==1){
            if( player1iconn==1){carro9.setBackgroundResource(R.drawable.fraisered);}
            if( player1iconn==2){carro9.setBackgroundResource(R.drawable.korabasketred);}
            if(player1iconn==3){carro9.setBackgroundResource(R.drawable.mininred1);}
            kk1++;}
        }
        if(kk1==3 && kk2 <3 && listTowPlayer[8]==0 ){
            listTowPlayer[8]=2;
            int v=1;
            if(listTowPlayer[8]==2 && listTowPlayer[5]==2 && listTowPlayer[2]==2){v=0; listTowPlayer[8]=0;}
            if(listTowPlayer[8]==2 && listTowPlayer[7]==2 && listTowPlayer[6]==2){v=0; listTowPlayer[8]=0;}


            if(v==1){
            if( player2iconn==1){carro9.setBackgroundResource(R.drawable.bananered);}
            if(player2iconn==2){carro9.setBackgroundResource(R.drawable.korafootred);}
            if( player2iconn==3){carro9.setBackgroundResource(R.drawable.minion2red2);}
            kk2++;}}


        if(kk2==3 && kk1<3 && listTowPlayer[8]==0){
            listTowPlayer[8]=1;
            int v=1;
            if(listTowPlayer[8]==1 && listTowPlayer[4]==1 && listTowPlayer[2]==1){v=0; listTowPlayer[8]=0;}
            if(listTowPlayer[8]==1 && listTowPlayer[7]==1 && listTowPlayer[6]==1){v=0; listTowPlayer[8]=0;}


            if(v==1){
            if( player1iconn==1){carro9.setBackgroundResource(R.drawable.fraisered);}
            if( player1iconn==2){carro9.setBackgroundResource(R.drawable.korabasketred);}
            if(player1iconn==3){carro9.setBackgroundResource(R.drawable.mininred1);}
            kk1++;}


        }int casevide=0;  for(int j=0;j<9;j++){ if (listTowPlayer[j] ==0 ) { casevide++; }}


        if(casevide==3){
            ImageButton playbt=(ImageButton) findViewById(R.id.playbtnchosecarro);
            playbt.setVisibility(View.VISIBLE);ImageButton btplayy=(ImageButton) findViewById(R.id.playbtnchosecarro);
            Animation anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);
            btplayy.setAnimation(anim);
            anim.start();
        }
    }

}
