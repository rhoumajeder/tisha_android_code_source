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

import java.util.Random;

import static com.eljeder.tisha.singleplayerlevelthemcpu.cpuicon;
import static com.eljeder.tisha.singleplayerlevelthemcpu.humanicon;
import static com.eljeder.tisha.singleplayerlevelthemcpu.playfirst;

public class choosecarro extends AppCompatActivity {
public static int k=0;
public int playfirstt;

public int hicon;
public  int cpuiconn;
public static int[] list; // list choose


    private AdView mAdView,   adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.carrochoose);

       // private AdView mAdView,   adView;
        MobileAds.initialize(this,"ca-app-pub-1350123755884874~6965127510");


        adView = new AdView(choosecarro.this);
        adView.setAdSize(AdSize.SMART_BANNER);

        adView.setAdUnitId( "ca-app-pub-3940256099942544/6300978111");
        RelativeLayout layout = (RelativeLayout) findViewById(R.id.lchoose);
        layout.addView(adView);
// Initiate a generic request.
        AdRequest adRequest = new AdRequest.Builder().build();
// Load the adView with the ad request.
        adView.loadAd(adRequest);
        layout.bringToFront();



















        ImageButton newbt=(ImageButton) findViewById(R.id.imageButton6new);
        Animation anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);
        newbt.setAnimation(anim);
        anim.start();
        // playbtnchosecarro


 intia();

    }
public void intia(){
     ImageButton carro1=(ImageButton) findViewById(R.id.carrochos1);
     ImageButton carro2=(ImageButton) findViewById(R.id.carrochos2);
     ImageButton carro3=(ImageButton) findViewById(R.id.carrochos3);
    ImageButton carro4=(ImageButton) findViewById(R.id.carrochos4);
    ImageButton carro5=(ImageButton) findViewById(R.id.carrochos5);
    ImageButton carro6=(ImageButton) findViewById(R.id.carrochos6);
    ImageButton carro7=(ImageButton) findViewById(R.id.carrochos7);
   ImageButton carro8=(ImageButton) findViewById(R.id.carrochos8);
    ImageButton carro9=(ImageButton) findViewById(R.id.carrochos9);

        hicon=humanicon;
        playfirstt=playfirst;
        cpuiconn=cpuicon;


      k=0;
        list =new int[]{0,0,0,0,0,0,0,0,0};
        if(playfirst==1){cpuplacecouenpremier();

            if(list[0]==1){
                if(  cpuiconn==1){carro1.setBackgroundResource(R.drawable.fraisered);}
                if( cpuiconn==2){carro1.setBackgroundResource(R.drawable.korabasketred);}
                if( cpuiconn==3){carro1.setBackgroundResource(R.drawable.minion2red2);}
            }

           if(list[1]==1){
               if(  cpuiconn==1){carro2.setBackgroundResource(R.drawable.fraisered);}
               if( cpuiconn==2){carro2.setBackgroundResource(R.drawable.korabasketred);}
               if( cpuiconn==3){carro2.setBackgroundResource(R.drawable.minion2red2);}}


           if(list[2]==1){

               if(  cpuiconn==1){carro3.setBackgroundResource(R.drawable.fraisered);}
               if( cpuiconn==2){carro3.setBackgroundResource(R.drawable.korabasketred);}
               if( cpuiconn==3){carro3.setBackgroundResource(R.drawable.minion2red2);}}


            if(list[3]==1){

                if(  cpuiconn==1){carro4.setBackgroundResource(R.drawable.fraisered);}
                if( cpuiconn==2){carro4.setBackgroundResource(R.drawable.korabasketred);}
                if( cpuiconn==3){carro4.setBackgroundResource(R.drawable.minion2red2);}}

            if(list[4]==1){

                if(  cpuiconn==1){carro5.setBackgroundResource(R.drawable.fraisered);}
                if( cpuiconn==2){carro5.setBackgroundResource(R.drawable.korabasketred);}
                if( cpuiconn==3){carro5.setBackgroundResource(R.drawable.minion2red2);}
            }

            if(list[5]==1){

                if(  cpuiconn==1){carro6.setBackgroundResource(R.drawable.fraisered);}
                if( cpuiconn==2){carro6.setBackgroundResource(R.drawable.korabasketred);}
                if( cpuiconn==3){carro6.setBackgroundResource(R.drawable.minion2red2);}}

            if(list[6]==1){

                if(  cpuiconn==1){carro7.setBackgroundResource(R.drawable.fraisered);}
                if( cpuiconn==2){carro7.setBackgroundResource(R.drawable.korabasketred);}
                if( cpuiconn==3){carro7.setBackgroundResource(R.drawable.minion2red2);}}

            if(list[7]==1){

                if(  cpuiconn==1){carro8.setBackgroundResource(R.drawable.fraisered);}
                if( cpuiconn==2){carro8.setBackgroundResource(R.drawable.korabasketred);}
                if( cpuiconn==3){carro8.setBackgroundResource(R.drawable.minion2red2);}}

            if(list[8]==1){

                if(  cpuiconn==1){carro9.setBackgroundResource(R.drawable.fraisered);}
                if( cpuiconn==2){carro9.setBackgroundResource(R.drawable.korabasketred);}
                if( cpuiconn==3){carro9.setBackgroundResource(R.drawable.minion2red2);}
            }

        }
}

public void cpuplacecouenpremier(){
    int index;

    Random random = new Random();
    index  = random.nextInt(18);
    if(index==0){ list[0]=1; list[4]=1; list[8]=1; }
    if(index==1){ list[6]=1; list[4]=1; list[2]=1; }
    if(index==2){ list[1]=1; list[6]=1; list[8]=1; }
    if(index==3){ list[0]=1; list[7]=1; list[2]=1; }
    if(index==4){ list[0]=1; list[6]=1; list[5]=1; }

    if(index==5){ list[2]=1; list[8]=1; list[3]=1; }
    if(index==6){ list[3]=1; list[4]=1; list[2]=1; }
    if(index==7){ list[3]=1; list[4]=1; list[8]=1; }
    if(index==8){ list[7]=1; list[4]=1; list[2]=1; }
    if(index==9){ list[7]=1; list[4]=1; list[0]=1; }


    if(index==10){ list[7]=1; list[8]=1; list[0]=1; }
    if(index==11){ list[6]=1; list[7]=1; list[2]=1; }
    if(index==12){ list[6]=1; list[3]=1; list[2]=1; }
    if(index==13){ list[0]=1; list[3]=1; list[8]=1; }
    if(index==14){ list[0]=1; list[1]=1; list[8]=1; }

    if(index==15){ list[6]=1; list[1]=1; list[2]=1; }
    if(index==16){ list[6]=1; list[2]=1; list[5]=1; }
    if(index==17){ list[5]=1; list[8]=1; list[0]=1; }

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
        list =new int[]{0,0,0,0,0,0,0,0,0};
        k=0;
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
        carro9.setBackgroundResource(R.drawable.trp);
        if(playfirst==1){intia();}


    }

    public void carochoosebtcpu(View view) {
        int ucpu=0;
        int uhu=0;
    if(playfirst==1){

    for(int i=0;i<9;i++){
        if(list[i] != 0){ ucpu++; }

    }}
        if(playfirst==2){

            for(int i=0;i<9;i++){
                if(list[i] != 0){uhu++; }

            }}
    if(uhu==3){
        Intent mainactivity=new Intent(this,MainActivity.class);
        startActivity(mainactivity);this.finish();}
        if(ucpu==6){
            Intent mainactivity=new Intent(this,MainActivity.class);
            startActivity(mainactivity);
     this.finish();
    }
    }




    public void carrochose1(View view) {
        ImageButton carro1=(ImageButton) findViewById(R.id.carrochos1);

        if(k<3 && list[0] != 1){
            list[0]=2;
            int v=1;
            if(list[0]==2 && list[1]==2 && list[2]==2){v=0; list[0]=0;}
            if(list[0]==2 && list[3]==2 && list[6]==2){v=0; list[0]=0;}


                if(v==1){
            if( hicon==1){carro1.setBackgroundResource(R.drawable.bananered);}
            if( hicon==2){carro1.setBackgroundResource(R.drawable.korafootred);}
            if( hicon==3){carro1.setBackgroundResource(R.drawable.minion2red2);}
            k++; }ImageButton playbt=(ImageButton) findViewById(R.id.playbtnchosecarro);
            if(k==3){ playbt.setVisibility(View.VISIBLE);ImageButton playbtted=(ImageButton) findViewById(R.id.playbtnchosecarro);
                Animation anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);


                playbtted.setAnimation(anim);
                anim.start(); }


        }
    }

    public void carrochose2(View view) {

        ImageButton carro2=(ImageButton) findViewById(R.id.carrochos2);

        if(k<3 && list[1] != 1){
            list[1]=2;
            int v=1;
            if(list[1]==2 && list[0]==2 && list[2]==2){v=0; list[0]=0;}
            if(list[1]==2 && list[4]==2 && list[7]==2){v=0; list[0]=0;}


            if(v==1){
            if( hicon==1){carro2.setBackgroundResource(R.drawable.bananered);}
            if( hicon==2){carro2.setBackgroundResource(R.drawable.korafootred);}
            if( hicon==3){carro2.setBackgroundResource(R.drawable.minion2red2);}
            k++;}
        }ImageButton playbt=(ImageButton) findViewById(R.id.playbtnchosecarro);
        if(k==3){ playbt.setVisibility(View.VISIBLE); ImageButton playbtted=(ImageButton) findViewById(R.id.playbtnchosecarro);
            Animation anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);


            playbtted.setAnimation(anim);
            anim.start();}



        }


    public void carrochose3(View view) {

        ImageButton carro3=(ImageButton) findViewById(R.id.carrochos3);

        if(k<3 && list[2] != 1){
            list[2]=2;
            int v=1;
            if(list[2]==2 && list[1]==2 && list[0]==2){v=0; list[2]=0;}
            if(list[2]==2 && list[5]==2 && list[8]==2){v=0; list[2]=0;}


            if(v==1){
            if( hicon==1){carro3.setBackgroundResource(R.drawable.bananered);}
            if( hicon==2){carro3.setBackgroundResource(R.drawable.korafootred);}
            if( hicon==3){carro3.setBackgroundResource(R.drawable.minion2red2);}
            k++;}
        } ImageButton playbt=(ImageButton) findViewById(R.id.playbtnchosecarro);
        if(k==3){ playbt.setVisibility(View.VISIBLE);ImageButton playbtted=(ImageButton) findViewById(R.id.playbtnchosecarro);
            Animation anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);


            playbtted.setAnimation(anim);
            anim.start(); }

    }

    public void carrochose4(View view) {

        ImageButton carro4=(ImageButton) findViewById(R.id.carrochos4);

        if(k<3 && list[3] != 1){
            list[3]=2;
            int v=1;
            if(list[3]==2 && list[6]==2 && list[0]==2){v=0; list[3]=0;}
            if(list[4]==2 && list[3]==2 && list[5]==2){v=0; list[3]=0;}


            if(v==1){
            if( hicon==1){carro4.setBackgroundResource(R.drawable.bananered);}
            if( hicon==2){carro4.setBackgroundResource(R.drawable.korafootred);}
            if( hicon==3){carro4.setBackgroundResource(R.drawable.minion2red2);}
            k++;}
        } ImageButton playbt=(ImageButton) findViewById(R.id.playbtnchosecarro);
        if(k==3){ playbt.setVisibility(View.VISIBLE);ImageButton playbtted=(ImageButton) findViewById(R.id.playbtnchosecarro);
            Animation anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);


            playbtted.setAnimation(anim);
            anim.start(); }
    }

    public void carrochose5(View view) {

        ImageButton carro5=(ImageButton) findViewById(R.id.carrochos5);

        if(k<3 && list[4] != 1){
            list[4]=2;
            int v=1;
            if(list[4]==2 && list[1]==2 && list[7]==2){v=0; list[4]=0;}
            if(list[4]==2 && list[3]==2 && list[5]==2){v=0; list[4]=0;}


            if(v==1){
            if( hicon==1){carro5.setBackgroundResource(R.drawable.bananered);}
            if( hicon==2){carro5.setBackgroundResource(R.drawable.korafootred);}
            if( hicon==3){carro5.setBackgroundResource(R.drawable.minion2red2);}
            k++;}
        }ImageButton playbt=(ImageButton) findViewById(R.id.playbtnchosecarro);
        if(k==3){ playbt.setVisibility(View.VISIBLE);ImageButton playbtted=(ImageButton) findViewById(R.id.playbtnchosecarro);
            Animation anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);


            playbtted.setAnimation(anim);
            anim.start(); }
    }

    public void carrochose6(View view) {

        ImageButton carro6=(ImageButton) findViewById(R.id.carrochos6);

        if(k<3 && list[5] != 1){
            list[5]=2;
            int v=1;
            if(list[5]==2 && list[2]==2 && list[8]==2){v=0; list[5]=0;}
            if(list[5]==2 && list[3]==2 && list[4]==2){v=0; list[5]=0;}


            if(v==1){
            if( hicon==1){carro6.setBackgroundResource(R.drawable.bananered);}
            if( hicon==2){carro6.setBackgroundResource(R.drawable.korafootred);}
            if( hicon==3){carro6.setBackgroundResource(R.drawable.minion2red2);}
            k++;}
        } ImageButton playbt=(ImageButton) findViewById(R.id.playbtnchosecarro);
        if(k==3){ playbt.setVisibility(View.VISIBLE); ImageButton playbtted=(ImageButton) findViewById(R.id.playbtnchosecarro);
            Animation anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);


            playbtted.setAnimation(anim);
            anim.start();}
    }

    public void carrochose7(View view) {

        ImageButton carro7=(ImageButton) findViewById(R.id.carrochos7);

        if(k<3 && list[6] != 1){
            list[6]=2;

            int v=1;
            if(list[6]==2 && list[7]==2 && list[8]==2){v=0; list[6]=0;}
            if(list[0]==2 && list[6]==2 && list[3]==2){v=0; list[6]=0;}


            if(v==1){
            if( hicon==1){carro7.setBackgroundResource(R.drawable.bananered);}
            if( hicon==2){carro7.setBackgroundResource(R.drawable.korafootred);}
            if( hicon==3){carro7.setBackgroundResource(R.drawable.minion2red2);}
            k++;}
        } ImageButton playbt=(ImageButton) findViewById(R.id.playbtnchosecarro);
        if(k==3){ playbt.setVisibility(View.VISIBLE);ImageButton playbtted=(ImageButton) findViewById(R.id.playbtnchosecarro);
            Animation anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);


            playbtted.setAnimation(anim);
            anim.start(); }
    }

    public void carrochose8(View view) {

        ImageButton carro8=(ImageButton) findViewById(R.id.carrochos8);

        if(k<3 && list[7] != 1){
            list[7]=2;
            int v=1;
            if(list[7]==2 && list[1]==2 && list[4]==2){v=0; list[7]=0;}
            if(list[7]==2 && list[6]==2 && list[8]==2){v=0; list[7]=0;}


            if(v==1){
            if( hicon==1){carro8.setBackgroundResource(R.drawable.bananered);}
            if( hicon==2){carro8.setBackgroundResource(R.drawable.korafootred);}
            if( hicon==3){carro8.setBackgroundResource(R.drawable.minion2red2);}
            k++;}
        } ImageButton playbt=(ImageButton) findViewById(R.id.playbtnchosecarro);
        if(k==3){ playbt.setVisibility(View.VISIBLE);ImageButton playbtted=(ImageButton) findViewById(R.id.playbtnchosecarro);
            Animation anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);


            playbtted.setAnimation(anim);
            anim.start(); }
    }

    public void carrochse9(View view) {

        ImageButton carro9=(ImageButton) findViewById(R.id.carrochos9);
        if(k<3 && list[8] != 1){
            list[8]=2;
            int v=1;
            if(list[8]==2 && list[5]==2 && list[2]==2){v=0; list[8]=0;}
            if(list[8]==2 && list[7]==2 && list[6]==2){v=0; list[8]=0;}


            if(v==1){
            if( hicon==1){carro9.setBackgroundResource(R.drawable.bananered);}
            if( hicon==2){carro9.setBackgroundResource(R.drawable.korafootred);}
            if( hicon==3){carro9.setBackgroundResource(R.drawable.minion2red2);}
            k++;}
        } ImageButton playbt=(ImageButton) findViewById(R.id.playbtnchosecarro);
        if(k==3){ playbt.setVisibility(View.VISIBLE);ImageButton playbtted=(ImageButton) findViewById(R.id.playbtnchosecarro);
            Animation anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);


            playbtted.setAnimation(anim);
            anim.start(); }
    }

}

