package com.eljeder.tisha;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;


public class contactactivity extends AppCompatActivity {
    private AdView mAdView,   adView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_activity);





        // private AdView mAdView,   adView;
        MobileAds.initialize(this,"ca-app-pub-1350123755884874~6965127510");


        adView = new AdView(contactactivity.this);
        adView.setAdSize(AdSize.SMART_BANNER);

        adView.setAdUnitId( "ca-app-pub-3940256099942544/6300978111");
        RelativeLayout layout = (RelativeLayout) findViewById(R.id.conn);
        layout.addView(adView);
// Initiate a generic request.
        AdRequest adRequest = new AdRequest.Builder().build();
// Load the adView with the ad request.
        adView.loadAd(adRequest);
        layout.bringToFront();

    }
}
