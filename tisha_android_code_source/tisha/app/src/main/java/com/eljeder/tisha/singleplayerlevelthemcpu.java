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

public class singleplayerlevelthemcpu extends AppCompatActivity {

    public static int diffi;  // diffe 2 very easy , 3 easy , 5  hard
    public static int playfirst; // playfirst =1 , cpu joue , playfirst 2 ;human joue
    public static int cpuicon;
    public static int humanicon;

  //cpu   // fraise 1  basket  2   minioncpu  3

   //human  //   banane 1  kora 2  minionhuman 3


    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layoutsingleplayer1);



        MobileAds.initialize(this,
                "ca-app-pub-3940256099942544~3347511713");



        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());



















        ImageButton playbt=(ImageButton) findViewById(R.id.imageButtonsingleplayer);

        Animation anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fadein);
     playbt.setAnimation(anim);
        anim.start();
        Animation animm = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);
        playbt.setAnimation(animm);
        animm.start();

    }
    public void onDestroy() {
        super.onDestroy();
        Runtime.getRuntime().gc();
    }
    public void singleplayer1bt(View view) {
        diff();
        playfirst();
        themecpu();
        humantheme();
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        }
        Intent choosecarro=new Intent(this,choosecarro.class);


        startActivity(choosecarro);
    }

public  void diff(){
    RadioButton level1=(RadioButton) findViewById(R.id.radioButtonlevel1);
    RadioButton level2=(RadioButton) findViewById(R.id.radioButtonlevel2);
    RadioButton level3=(RadioButton) findViewById(R.id.radioButtonlevel3);

    if(level1.isChecked()){ diffi=2; }
    if(level2.isChecked()){ diffi=3; }
    if(level3.isChecked()){ diffi=5; }


    Bundle difiib=new Bundle();
    difiib.putInt("diffi",diffi);
    Intent choosecarro=new Intent(this, com.eljeder.tisha.choosecarro.class);
    choosecarro.putExtras(difiib);


}

public void playfirst(){
    RadioButton human=(RadioButton) findViewById(R.id.radioButtonhumanjoue1);
    RadioButton cpu=(RadioButton) findViewById(R.id.radioButtoncpujoue1);

    if(cpu.isChecked()){playfirst=1;}
    if(human.isChecked()){playfirst=2;}

   // Bundle playfirstb=new Bundle();
     //playfirstb.putInt("playfirst",playfirst);
 //   Intent choosecarro=new Intent(this, com.davenotdavid.samplepuzzle.choosecarro.class);
 //   choosecarro.putExtras(playfirstb);


}



public void themecpu(){
    RadioButton cpufraise=(RadioButton) findViewById(R.id.cpufraise);
    RadioButton cpubasket=(RadioButton) findViewById(R.id.cpubasket);
    RadioButton cpuminion=(RadioButton) findViewById(R.id.cpuminion);

    if(cpufraise.isChecked()){cpuicon=1;}
    if(cpubasket.isChecked()){cpuicon=2;}
    if(cpuminion.isChecked()){cpuicon=3;}



   //  Intent choosecarro=new Intent(this, com.davenotdavid.samplepuzzle.choosecarro.class);
   //  choosecarro.putExtras(cpuiconb);

    Bundle cpuiconb=new Bundle();
    cpuiconb.putInt("cpuicon",cpuicon);
    Intent intenac=new Intent(this, com.eljeder.tisha.MainActivity.class);
  intenac.putExtras(cpuiconb);


}

public void humantheme(){


    RadioButton humankora=(RadioButton) findViewById(R.id.humankora);
    RadioButton humanminion=(RadioButton) findViewById(R.id.humanminion);
    RadioButton humanbanane=(RadioButton) findViewById(R.id.humanbanane);

    if(humanbanane.isChecked()){humanicon=1;}
    if(humankora.isChecked()){humanicon=2;}
    if(humanminion.isChecked()){humanicon=3;}


    Bundle humaniconb=new Bundle();
    humaniconb.putInt("humanicon",humanicon);
    Intent intentac=new Intent(this, com.eljeder.tisha.choosecarro.class);
    intentac.putExtras(humaniconb);


}


}
