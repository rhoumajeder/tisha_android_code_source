package com.eljeder.tisha;


import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import static android.media.MediaPlayer.create;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class LayouttwelcomActivity extends AppCompatActivity {


    public CheckBox chek;
    private AdView mAdView,   adView;
    MediaPlayer   mMediaPlayer;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layoutwelcom);

  MobileAds.initialize(this,"ca-app-pub-1350123755884874~6965127510");


        adView = new AdView(LayouttwelcomActivity.this);
        adView.setAdSize(AdSize.SMART_BANNER);

        adView.setAdUnitId( "ca-app-pub-3940256099942544/6300978111");
        RelativeLayout  layout = (RelativeLayout) findViewById(R.id.yy);
        layout.addView(adView);
// Initiate a generic request.
        AdRequest adRequest = new AdRequest.Builder().build();
// Load the adView with the ad request.
        adView.loadAd(adRequest);
        layout.bringToFront();








     mMediaPlayer=MediaPlayer.create(LayouttwelcomActivity.this, R.raw.reaming);
        mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mMediaPlayer.setLooping(true);
        mMediaPlayer.start();

        chek=( CheckBox) findViewById(R.id.checkBox);

        chek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(chek.isChecked()){
                    mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                    mMediaPlayer.setLooping(true);
                    mMediaPlayer.start();




                }
                if(!chek.isChecked()){

                    mMediaPlayer.stop();
                    mMediaPlayer=MediaPlayer.create(LayouttwelcomActivity.this, R.raw.reaming);


                }

            }
        });


























        ImageButton singleplayer = (ImageButton) findViewById(R.id.imageButton1) ;
        ImageButton twoplayerr = (ImageButton) findViewById(R.id.imageButton2) ;
        ImageButton howtoplay = (ImageButton) findViewById(R.id.imageButton3) ;
        ImageButton contact = (ImageButton) findViewById(R.id.imageButton4) ;

       Animation anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fadein);
       singleplayer.setAnimation(anim);
       twoplayerr.setAnimation(anim);
       howtoplay.setAnimation(anim);
       contact.setAnimation(anim);
       anim.start();
        Animation anim1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);
        singleplayer.setAnimation(anim1);
        twoplayerr.setAnimation(anim1);
        howtoplay.setAnimation(anim1);
        contact.setAnimation(anim1);
        anim1.start();







    }

    public void puton(){





    }

    public void putoff(){







    }




    public void cheklis()
    {



    }

    public void welcombtsingleplayer(View view) {

        Intent singleplayerlevelthemcpu=new Intent(this,singleplayerlevelthemcpu.class);
startActivity(singleplayerlevelthemcpu);

    }

    public void welcombttowplayer(View view) {
        Intent  twoplayerscreen2=new Intent(this, com.eljeder.tisha.twoplayerscreen2.class);
startActivity(twoplayerscreen2);

    }

    public void welcomehowtoplay(View view) {


    }

    public void welcomecontact(View view) {
        Intent  contact=new Intent(this, com.eljeder.tisha.contactactivity.class);
        startActivity(contact);


    }



}
