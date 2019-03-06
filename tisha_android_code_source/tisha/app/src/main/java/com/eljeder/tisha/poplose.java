package com.eljeder.tisha;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;

public   class poplose  extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.poplose);


        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);


        int width = dm.widthPixels;
        int height =dm.heightPixels;
        getWindow().setLayout((int)(width*.9),(int)(height*.9));
        getWindow().setBackgroundDrawableResource(R.drawable.trp);

    }



    public void retu (View view) {

        Intent retunrsing=new Intent(this, com.eljeder.tisha.singleplayerlevelthemcpu.class);
        startActivity( retunrsing);

        MainActivity.fa.finish();
    }
}

