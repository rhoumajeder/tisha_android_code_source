package com.eljeder.tisha;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;

public   class gameovertow  extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gameovertwolayout);


        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);


        int width = dm.widthPixels;
        int height =dm.heightPixels;
        getWindow().setLayout((int)(width*.9),(int)(height*.9));
        getWindow().setBackgroundDrawableResource(R.drawable.trp);

    }



    public void returntowpp(View view) {

        Intent retuntwop=new Intent(this, com.eljeder.tisha.twoplayerscreen2.class);
        startActivity(retuntwop);

    }
}

