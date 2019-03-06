package com.eljeder.tisha;

import android.os.Vibrator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.ArrayList;
import java.util.Random;

import static com.eljeder.tisha.choosecarro.list;
import static com.eljeder.tisha.singleplayerlevelthemcpu.cpuicon;
import static com.eljeder.tisha.singleplayerlevelthemcpu.diffi;
import static com.eljeder.tisha.singleplayerlevelthemcpu.humanicon;

import static com.eljeder.tisha.singleplayerlevelthemcpu.playfirst;
import static com.eljeder.tisha.twoplayerscreen2.blokiafromtowplayeractivity;
import static com.eljeder.tisha.twoplayerscreen2.permisstomovefromtwoplayscreen;
import static java.lang.Math.abs;

public class MainActivity extends AppCompatActivity {
    // 2  asweed , 1 orange
// 2 facile  3 te8elbe , 5 me te8elbech
    public static Activity fa;

    public  static  int h1;
    public  static  int h2;
    private static GestureDetectGridView mGridView;
    public  static  int diff; //   2 very easy  3-easy   ---5hard
    private static final int COLUMNS = 3;
    private static final int DIMENSIONS = COLUMNS * COLUMNS;
    public static  int u=0;
    public static  int uu=0;
    static ArrayList<Button> buttons = new ArrayList<>();
    private static int mColumnWidth, mColumnHeight;
    public static String h;
    public static String hh;
    public static final String up = "up";
    public static final String down = "down";
    public static final String left = "left";
    public static final String right = "right";
    int currentPosition, swap ;
    private static int [] tileList;
    private  static  int[] libre = new int[9] ;
    private  static  int[]  libreblok =new int[9];
    private  static int[][]  jeu = new int[3][3];
    private static int[] turn= new int[2];
    private static int[] coupblok2= new int[2];
    private static int[] coupblok1= new int[2];

    private  static  boolean role;

    private  static int[] coujoue1 =new int  [4];
    private  static  int[] coujoue2 =new int [4];

    private static int play1=0;
    private static int play2=0;
    public static int hc;
public static int cc;
public static int playfirstt;
public static int permetjouer;
// bloké move tile
    // bloké ia jouer
    public static int iablok;
    public static int permtomov;
static  ImageButton nn;
static     Vibrator vvv;
public static int gagne=7;

    private static Context mContext;
    private static Context bContext;
    private AdView mAdView,   adView;
  //  Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.boardgame);


fa=this;

        // private AdView mAdView,   adView;
        MobileAds.initialize(this,"ca-app-pub-1350123755884874~6965127510");


        adView = new AdView(MainActivity.this);
        adView.setAdSize(AdSize.SMART_BANNER);

        adView.setAdUnitId( "ca-app-pub-3940256099942544/6300978111");
        RelativeLayout layout = (RelativeLayout) findViewById(R.id.mainpub);
        layout.addView(adView);
// Initiate a generic request.
        AdRequest adRequest = new AdRequest.Builder().build();
// Load the adView with the ad request.
        adView.loadAd(adRequest);
        layout.bringToFront();










        mContext = this;
bContext=this;

        init(getApplicationContext());
      setDimensions();
      btprogon();


    }
public   void btprogon(){
    ImageButton btprog = (ImageButton) findViewById(R.id.probtt);
    Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        ImageButton bb;
    Vibrator vv;

        bb =btprog;
        nn=bb;
        vvv=v;

}



public   void gagnee(){
    if(gagne==1){
        Intent popgagnee=new Intent(this,popgagne.class);
        startActivity(popgagnee);}

}



    private void init(Context context) {
iablok=blokiafromtowplayeractivity;
permtomov=permisstomovefromtwoplayscreen;
     //   Bundle cpuiconb=getIntent().getExtras();
     //   Bundle humaniconb=getIntent().getExtras();
       //  humanicon=humaniconb.getInt("humanicon");

  //      cpuicon=cpuiconb.getInt("cpuicon");
playfirstt=playfirst;
hc=humanicon;
cc=cpuicon;
diff=diffi;

        mGridView = (GestureDetectGridView) findViewById(R.id.grid);
        mGridView.setBackgroundResource(R.drawable.boardtictac1);
        mGridView.setNumColumns(COLUMNS);
        libre = new int[]{1,2, 1, 0, 0, 0, 2, 1, 2};
        if(playfirstt==2){  lirelibre(); }
        if(playfirst==1){
            libre=list;
            permetjouer=1;
}


        list =new int[]{0,0,0,0,0,0,0,0,0};
        jeu =new int[][]{{1,2, 0}, {2, 1, 2},{ 0, 0, 1}};
        coujoue1=new int[]{771,771,771,771};
        coujoue2=new int[]{772,772,772,772};
        libreblok =new int[]{0,0,0,0,0,0,0,0,0};
        turn= new int[]{1, 0};
        coupblok2=new int[]{222,222};
        coupblok1=new int[]{111,111};

        tileList = new int[DIMENSIONS];
        for (int i = 0; i < DIMENSIONS; i++) {
            tileList[i] =i;
        }
        Button button;  // array of button
        // make variable for button
        for (int i =0 ; i<9 ;i++){
            button = new Button(context);
            buttons.add(button);
        }}


    public static int convertDpToPixels(float dp, Context context){
        Resources resources = context.getResources();


        return (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                dp,
                resources.getDisplayMetrics()
        );
    }
    private void setDimensions() {
        ViewTreeObserver vto = mGridView.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {



                mGridView.getViewTreeObserver().removeOnGlobalLayoutListener(this);


                ViewGroup.LayoutParams layoutParams = mGridView.getLayoutParams();
                layoutParams.height=convertDpToPixels(350,  getApplicationContext()); //this is in pixels
                mGridView.setLayoutParams(layoutParams);


                int displayWidth = mGridView.getMeasuredWidth();   // 3ordd
                int displayHeight = mGridView.getMeasuredHeight(); // toullll
                h1=mGridView.getMeasuredHeight();


                int statusbarHeight = getStatusBarHeight(getApplicationContext()); // toul fougani
                int requiredHeight = displayHeight - statusbarHeight; //toull li lezem

                mColumnWidth = displayWidth / COLUMNS;  // il 3ord 3lé thléthé
                mColumnHeight = requiredHeight / COLUMNS; // toull 3lé thléthé

                display(getApplicationContext());
                int [][] jeu; jeu=makejeufromlibre();
                if(permetjouer==1) {
                    IA_jOUER(jeu, getApplicationContext(), diff);
                    permetjouer=0;
                }
            }
        });
    }
    private int getStatusBarHeight(Context context) {
        int result = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen",
                "android");

        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }

        return result;
    }
    private static   void display(Context context) { // show image sous forme buttons in grid
        String s;

        s=String.valueOf(h1);

        for (int i = 0; i <9 ; i++) {

            if ( libre[i]==0) {buttons.get(i).setBackgroundResource(R.drawable.trp);}
            else if (libre[i]==1){   buttons.get(i).setActivated(false);
                buttons.get(i).setEnabled(false);
                if( cc==1){buttons.get(i).setBackgroundResource(R.drawable.fraisered);}
                if( cc==2){buttons.get(i).setBackgroundResource(R.drawable.korabasketred);}
                if(cc==3){buttons.get(i).setBackgroundResource(R.drawable.mininred1);}}

            else  if (libre[i]==2){
                if( hc==1){buttons.get(i).setBackgroundResource(R.drawable.bananered);}
                if( hc==2){buttons.get(i).setBackgroundResource(R.drawable.korafootred);}
                if( hc==3){buttons.get(i).setBackgroundResource(R.drawable.minion2red2);}
                }}

        /// to put the buttons (array)  in the correct place in grid  (( adapter ))
        mGridView.setAdapter(new CustomAdapter(buttons, mColumnWidth, mColumnHeight));

    } //// show image sous forme buttons in grid


    private static void animm(  Context context , int c ) {

        Animation anim = AnimationUtils.loadAnimation(context , R.anim.fly_in_from_center);
        buttons.get(c).setAnimation(anim);
        anim.start();

    }
    private static void animmup(  Context context , int c ) {

        Animation anim = AnimationUtils.loadAnimation(context , R.anim.slide_up);
        buttons.get(c).setAnimation(anim);
        // buttons.get(c).setRotation(135);
        anim.start();


    }



    public static void moveTiles(Context context, String direction, int position) {

        if(position == coupblok2[0] && direction == hh){
            Toast.makeText(context, "repeated  move 2", Toast.LENGTH_SHORT).show();
        }
        if(position == coupblok1[0] && direction == h){
            Toast.makeText(context, "repeated  move 1 ", Toast.LENGTH_SHORT).show();
        }




        if (libre[position] != 0 ){ if( position != coupblok2[0] || direction != hh ) {

            if( position != coupblok1[0] || direction != h ) {


            // Upper-left-corner tile
            if (position == 0  ) { // case Numero 0

                if (direction.equals(right)  && libre[1]==0 )  // case Numero 1 doit vide
                {   swap(context, position, 1); //libresip(position,position+1);

                }

                else if (direction.equals(down) &&  libre[3] ==0 ) // case numero 3 doit vide
                { swap(context, position, COLUMNS);
                    //libresip(position,position+COLUMNS);
                    animm(context , position);
                    animmup(context , 3 );}


                else Toast.makeText(context, "Invalid move", Toast.LENGTH_SHORT).show();

                // Upper-center tiles
            } else if (position ==1) {
                if (direction.equals(left) && libre[0]==0) {
                    swap(context, position, -1); //libresip(position, position-1);
                }
                else if (direction.equals(down) && libre[4]==0 ) {
                    swap(context, position, COLUMNS); // libresip(position,position+COLUMNS);
                }
                else if (direction.equals(right) && libre[2]==0 ){
                    swap(context, position, 1); //libresip(position,position+1);
                }
                else Toast.makeText(context, "Invalid move", Toast.LENGTH_SHORT).show();

                // Upper-right-corner tile
            } else if (position == 2) {
                if (direction.equals(left) && libre[1]==0) {
                    swap(context, position, -1); // libresip(position,position-1);
                }
                else if (direction.equals(down) && libre[5]==0){
                    swap(context, position, COLUMNS);// libresip(position,position+3);
                }
                else Toast.makeText(context, "Invalid move", Toast.LENGTH_SHORT).show();

                // Left-side tiles
            } else if (position ==3) {
                if (direction.equals(up)  && libre[0]==0) {
                    swap(context, position, -COLUMNS);// libresip(position,position-3);
                }
                else if (direction.equals(right) && libre[4]==0) {
                    swap(context, position, 1); //libresip(position,position+1);
                }
                else if (direction.equals(down) && libre[6]==0){
                    swap(context, position, COLUMNS); //libresip(position,position+3);
                }
                else Toast.makeText(context, "Invalid move", Toast.LENGTH_SHORT).show();

                // Right-side AND bottom-right-corner tiles
            } else if (position == 4) {
                if (direction.equals(up) && libre[1]==0) {
                    swap(context, position, -COLUMNS); //libresip(position,position-3);
                }
                else if (direction.equals(left) && libre[3]==0) {
                    swap(context, position, -1); //libresip(position,position-1);
                }
                else if (direction.equals(right) && libre[5]==0) {
                    swap(context, position, 1); //libresip(position,position+1);
                }
                else if (direction.equals(down) && libre[7]==0) {
                    swap(context, position, COLUMNS);// libresip(position,position+3);

                    // Tolerates only the right-side tiles to swap downwards as opposed to the bottom-
                    // right-corner tile.

                } else Toast.makeText(context, "Invalid move", Toast.LENGTH_SHORT).show();

                // Bottom-left corner tile
            } else if (position == 5) {
                if (direction.equals(up) && libre[2]==0) {
                    swap(context, position, -COLUMNS); //libresip(position,position-3);
                }
                else if (direction.equals(left) && libre [4]==0) {
                    swap(context, position, -1);//libresip(position,position-1);
                }
                else if (direction.equals(down) && libre [8]==0) {
                    swap(context, position, COLUMNS);//libresip(position,position+3);
                }
                else Toast.makeText(context, "Invalid move", Toast.LENGTH_SHORT).show();

                // Bottom-center tiles
            } else if (position ==6) {
                if (direction.equals(up) && libre[3]==0){
                    swap(context, position, -COLUMNS); //libresip(position,position-3);
                }

                else if (direction.equals(right) && libre[7]==0 ) {
                    swap(context, position, 1);//libresip(position,position+1);
                }
                else Toast.makeText(context, "Invalid move", Toast.LENGTH_SHORT).show();

                // Center tiles
            }
            else if (position ==7) {
                if (direction.equals(up) && libre[4]==0){
                    swap(context, position, -COLUMNS); //libresip(position,position-3);
                }

                else if (direction.equals(right) && libre[8]==0 ) {
                    swap(context, position, 1);//libresip(position,position+1);
                }
                else if (direction.equals(left) && libre[6]==0 ) {
                    swap(context, position, -1);//libresip(position,position-1);
                }
                else Toast.makeText(context, "Invalid move", Toast.LENGTH_SHORT).show();

                // Center tiles
            }
            else if (position ==8) {
                if (direction.equals(up) && libre[5]==0){
                    swap(context, position, -COLUMNS);// libresip(position,position-3);
                }


                else if (direction.equals(left) && libre[7]==0 ) {
                    swap(context, position, -1);  //libresip(position,position-1);
                }
                else Toast.makeText(context, "Invalid move", Toast.LENGTH_SHORT).show();

                // Center tiles
            }




        }}}}
    // bouger les images



    private static void swap(final Context context, int currentPosition, int swap) {
       if(libre[currentPosition]==2){
           if( uu==2 && coujoue2[0] != currentPosition+swap ){ uu=0;  coupblok2[0]=222; coupblok2[1]=222 ; }
           int t=0;
           int dd2;
           coujoue2[uu]=currentPosition;coujoue2[uu+1]=currentPosition+swap;
           uu=2;

 if(coujoue2[0]==coujoue2[3] && coujoue2[1]==coujoue2[2]){ coupblok2[0]=coujoue2[0];
                                                             coupblok2[1]=coujoue2[1] ;
                                                             dd2= coupblok2[1]-coupblok2[0];
                                                          hh=tosting(dd2); } }


        if(libre[currentPosition]==1){
            if( u==2 && coujoue1[0] != currentPosition+swap ){ u=0;  coupblok1[0]=222; coupblok1[1]=222 ; }
            int t=0;
            int dd2;
            coujoue1[u]=currentPosition;coujoue1[u+1]=currentPosition+swap;
            u=2;

            if(coujoue1[0]==coujoue1[3] && coujoue1[1]==coujoue1[2]){ coupblok1[0]=coujoue1[0];
                coupblok1[1]=coujoue1[1] ;
                dd2= coupblok1[1]-coupblok1[0];
                h=tosting(dd2); } }

        int newPosition = libre[currentPosition + swap];
        libre[currentPosition + swap] = libre[currentPosition];
        libre[currentPosition] = newPosition;
        display(context);
     //   bprogon(context );


nn.setVisibility(View.VISIBLE);
      final  Animation anim = AnimationUtils.loadAnimation(context , R.anim.rotate);
       nn.setAnimation(anim);
        anim.start();





         final int [][] jeu; jeu=makejeufromlibre();
        affichequigagne(jeu,context);
      //  try {Thread.sleep(2000);} catch (InterruptedException e) {e.printStackTrace();}

         Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
               // anim.cancel();
                nn.setVisibility(View.INVISIBLE);

                IA_jOUER(jeu , context,diff);
                // Do something after 5s = 5000ms
              //  ProgressBar p=(ProgressBar) fi
            }
        }, 1800); gagne =0;


    } // swap between tow button (image )
    public static void   btprogon(ImageButton imagebutton){
    //     ImageButton btprog ;
   // btprog = (ImageButton) findViewById(R.id.probtt);
        imagebutton.setVisibility(View.VISIBLE);
       imagebutton.setRotation(135);

    }

    public  static  void IA_jOUER(int[][] jeu , Context context, int profondeur) {

        int tmp;

        int max = -10000;
        int x1=88;
        int [][] coupos1;int index,position,y1,x2,y2;String s;
        int max1=0,may1=0,max2=0,may2=0;
        coupos1 = couppossible1(jeu);



        int comp=0;int n;
        n=coupos1.length;Random random = new Random();
        // index  = random.nextInt(n);s=String.valueOf(comp);


        for(index=0;index<n;index++){
            x1=coupos1[index][0];y1=coupos1[index][1];x2=coupos1[index][2];y2=coupos1[index][3];
            FaireJouerJeu(jeu,x1,y1,x2,y2);
            tmp = Min(jeu,profondeur-1);
            if(tmp >= max || ( (tmp == max) && (random.nextInt()%2 == 0) ))
            {
                max = tmp;
                max1 = x1;
                may1 = y1;
                max2= x2;
                may2= y2;
            }
            AnulFaireJouer(jeu,x1,y1,x2,y2);

        }
        FaireJouerJeu(jeu,max1,may1,max2,may2);



        libre= makelibrefromjeu();
        affichequigagne(jeu,context);
        display(context);
    }
    public  static  int Min(int[][] jeu,int profondeur) {
        int x1,y1,x2,y2;
        if(profondeur == 0 || gagnant(jeu)!=0) {return eval(jeu);}
        int min = 10000;int index;
        int tmp;int [][] coupos1;
        Random random = new Random();
        coupos1 = couppossible2(jeu);
        for(index=0;index<coupos1.length;index++){
            x1=coupos1[index][0];y1=coupos1[index][1];x2=coupos1[index][2];y2=coupos1[index][3];
            FaireJouerJeu2(jeu,x1,y1,x2,y2);
            tmp = Max(jeu,profondeur-1);
            if(tmp <= min  || ( (tmp == min) && (random.nextInt()%2 == 0) )) {min = tmp;}
            AnulFaireJouer2(jeu,x1,y1,x2,y2);}
        return  min;

    }
    public  static  int Max(int[][] jeu, int profondeur ) {
        int x1,y1,x2,y2;
        if(profondeur == 0 || gagnant(jeu)!=0)  {return eval(jeu);}

        int max = -10000;int index;
        int tmp;int [][] coupos1;
        coupos1 = couppossible1(jeu);
        for(index=0;index<coupos1.length;index++){
            x1=coupos1[index][0];y1=coupos1[index][1];x2=coupos1[index][2];y2=coupos1[index][3];
            FaireJouerJeu(jeu,x1,y1,x2,y2);
            tmp = Min(jeu,profondeur-1);
            if(tmp >=max) {max = tmp;}
            AnulFaireJouer(jeu,x1,y1,x2,y2);}
        return  max;

    }


    public  static int[][]    case0(int[][] jeu ){
        int i,j;


        int [][]   case0 = {{0,0},{0,0},{0,0}};
        int   k=0;
        for ( i=0; i<3;i++) {
            for (j=0;j<3;j++){
                if (jeu [i][j]==0){
                    case0[k][0]=i;
                    case0[k][1]=j;
                    k++;   }}}

        return case0;         }
    public  static int[][] case1(int[][] jeu ) {
        int i,j;

        int [][]   case1 = {{0,0},{0,0},{0,0}};
        int   k=0;
        for ( i=0; i<3;i++) {
            for (j=0;j<3;j++){
                if (jeu [i][j]==1){
                    case1[k][0]=i;
                    case1[k][1]=j;
                    k++;   }}}

        return case1;         }
    public  static int[][] case2(int [][] jeu ) {
        int i,j;

        int [][]   case2 = {{0,0},{0,0},{0,0}};
        int   k=0;
        for ( i=0; i<3;i++) {
            for (j=0;j<3;j++){
                if (jeu [i][j]==2){
                    case2[k][0]=i;
                    case2[k][1]=j;
                    k++;   }}}

        return case2;         }
    private static  String tosting(int j){
        String s="dd";
        if (j== 1){ s=right; }
        if (j== -1){s=left ; }
        if (j== 3){ s=down; }
        if (j== -3){s=up ; }
        return s;

    }



    public  static int [] makelibrefromjeu(){

        libre[0]=jeu[0][0];
        libre[1]=jeu[0][1];
        libre[2]=jeu[0][2];
        libre[3]=jeu[1][0];
        libre[4]=jeu[1][1];
        libre[5]=jeu[1][2];
        libre[6]=jeu[2][0];
        libre[7]=jeu[2][1];
        libre[8]=jeu[2][2];

        return libre;
    }
    public  static  int[][] makejeufromlibre(){
        jeu[0][0]=libre[0];
        jeu[0][1]=libre[1];
        jeu[0][2]=libre[2];
        jeu[1][0]=libre[3];
        jeu[1][1]=libre[4];
        jeu[1][2]=libre[5];
        jeu[2][0]=libre[6];
        jeu[2][1]=libre[7];
        jeu[2][2]=libre[8];

        return jeu;
    }
    public  static  void FaireJouerJeu(int[][] jeu, int x1,int y1 ,int x2,int y2 ){
        jeu[x1][y1]=0;jeu[x2][y2]=1;}
    public  static  void FaireJouerJeu2(int[][] jeu, int x1,int y1 ,int x2,int y2 ){
        jeu[x1][y1]=0;jeu[x2][y2]=2;}
    public  static  void AnulFaireJouer(int[][] jeu, int x1,int y1 ,int x2,int y2 ) {
        jeu[x1][y1]=1;jeu[x2][y2]=0;
    }
    public  static  void AnulFaireJouer2(int[][] jeu, int x1,int y1 ,int x2,int y2 ) {
        jeu[x1][y1]=2;jeu[x2][y2]=0;
    }

    public static  int[][] couppossible1(int[][] jeu) {
        int [][] coupos1,listcasevide, listecase1,coupos ; coupos1 = new int[11][4];
        for (int i=0;i<11;i++){for(int j=0;j<4;j++){coupos1[i][j]=88;}}
        listecase1=case1(jeu);
        listcasevide=case0(jeu);
        int comp=0;
        int q=0;
        for (int  r=0;r<3;r++){
            for (int i=0; i<3;i++) {
                if (listecase1[r][0] == listcasevide[i][0]) { // vérifie si ligne commun
                    if (abs(listecase1[r][1] - listcasevide[i][1]) == 1 ) {
                        coupos1[q][0] = listecase1[r][0];
                        coupos1[q][1] = listecase1[r][1];
                        coupos1[q][2] = listcasevide[i][0];
                        coupos1[q][3] = listcasevide[i][1];
                        q++;}}
                if (listecase1[r][1] == listcasevide[i][1]) { // vérifie si colonne commun
                    if (abs(listecase1[r][0] -listcasevide[i][0]) == 1) {
                        coupos1[q][0] = listecase1[r][0];
                        coupos1[q][1] = listecase1[r][1];
                        coupos1[q][2] = listcasevide[i][0];
                        coupos1[q][3] = listcasevide[i][1];
                        q++;
                    }



                }}


        }  for(int i=0;i<11;i++){if(coupos1[i][0]!=88){comp++;}}
        coupos = new int[comp][4];
        for(int i=0;i<comp;i++){ for(int j=0;j<4;j++){
            coupos[i][j]=coupos1[i][j];
        }

        }

        return coupos;}
    public static  int[][] couppossible2(int[][] jeu) {
        int [][] coupos1,listcasevide, listecase1,coupos ; coupos1 = new int[11][4];
        for (int i=0;i<11;i++){for(int j=0;j<4;j++){coupos1[i][j]=88;}}
        listecase1=case2(jeu);
        listcasevide=case0(jeu);
        int comp=0;
        int q=0;
        for (int  r=0;r<3;r++){
            for (int i=0; i<3;i++) {
                if (listecase1[r][0] == listcasevide[i][0]) { // vérifie si ligne commun
                    if (abs(listecase1[r][1] - listcasevide[i][1]) == 1 ) {
                        coupos1[q][0] = listecase1[r][0];
                        coupos1[q][1] = listecase1[r][1];
                        coupos1[q][2] = listcasevide[i][0];
                        coupos1[q][3] = listcasevide[i][1];
                        q++;}}
                if (listecase1[r][1] == listcasevide[i][1]) { // vérifie si colonne commun
                    if (abs(listecase1[r][0] -listcasevide[i][0]) == 1) {
                        coupos1[q][0] = listecase1[r][0];
                        coupos1[q][1] = listecase1[r][1];
                        coupos1[q][2] = listcasevide[i][0];
                        coupos1[q][3] = listcasevide[i][1];
                        q++;
                    }



                }}


        }  for(int i=0;i<11;i++){if(coupos1[i][0]!=88){comp++;}}
        coupos = new int[comp][4];
        for(int i=0;i<comp;i++){ for(int j=0;j<4;j++){
            coupos[i][j]=coupos1[i][j];
        }

        }

        return coupos;}

    public static void affichequigagne(int[][] jeu, Context context){
        for(int i=0;i<3;i++) {
            if (jeu[i][0] ==1 && jeu[i][1] ==1 && jeu[i][2] ==1) {

               gagne=1;
                Intent popgagnee=new Intent(mContext, popgagne.class);

                mContext.startActivity(popgagnee);
                vvv.vibrate(800);
                break;



            }
            if (jeu[i][0] ==2 && jeu[i][1] ==2 && jeu[i][2] ==2 ) {
                gagne=2;
                Intent poplosee=new Intent(bContext, poplose.class);
                vvv.vibrate(800);
                bContext.startActivity(poplosee);
                break;


            }}

        for(int i=0;i<3;i++) {
            if (jeu[0][i] ==1 && jeu[1][i] ==1 && jeu[2][i] ==1) {
                gagne=1;
                Intent popgagnee=new Intent(mContext, popgagne.class);
                vvv.vibrate(800);
                mContext.startActivity(popgagnee);
                break;

            }
            if (jeu[0][i] ==2 && jeu[1][i] ==2 && jeu[2][i] ==2 ) {
                gagne=2;

                Intent poplose=new Intent(bContext, poplose.class);
                vvv.vibrate(800);
                bContext.startActivity(poplose);
                break;
            }}

    }
    public static  int gagnant(int[][] jeu ) {
        for(int i=0;i<3;i++) {
            if (jeu[i][0] ==1 && jeu[i][1] ==1 && jeu[i][2] ==1) {return 1;}
            if (jeu[i][0] ==2 && jeu[i][1] ==2 && jeu[i][2] ==2 ) {return 2;}}

        for(int i=0;i<3;i++) {
            if (jeu[0][i] ==1 && jeu[1][i] ==1 && jeu[2][i] ==1) {return 1;}
            if (jeu[0][i] ==2 && jeu[1][i] ==2 && jeu[2][i] ==2 ) {return 2;}}
        return 0; }
    public static int eval(int [][] jeu)   {

        int vainqueur=0;
        if( (vainqueur = gagnant(jeu)) != 0)
        {if( vainqueur == 1 ) {return 10000  ;}
        else if( vainqueur == 2 ) {return -10000 ;}
        }

        return 0;



    }

    public static void lirelibre(){
int  t=0;
int [] listvid;
listvid=new int[]{0,0,0,0,0,0};
     libre=list;
     if(libre[6]==2 && libre[4]==2 && libre[2]==2){
         int index,index1;
         Random random = new Random();
          index  = random.nextInt(2);
          if(index==0){
              libre[5]=1;libre[0]=1;
              index1=random.nextInt(4);
              if(index1==0){libre[1]=1;}
              if(index1==1){libre[3]=1;}
              if(index1==2){libre[7]=1;}
              if(index1==3){libre[8]=1;}
          }
         if(index==1){
             libre[1]=1;libre[5]=1;
              index1=random.nextInt(4);
              if(index1==0){libre[7]=1;}
              if(index1==1){libre[3]=1;}
              if(index1==2){libre[8]=1;}
              if(index1==3){libre[0]=1;}
         }}





     else if(libre[8]==2 && libre[4]==2 && libre[0]==2){
         int index,index1;
         Random random = new Random();
         index  = random.nextInt(2);
         if(index==0){
             libre[1]=1;libre[3]=1;
             index1=random.nextInt(3);

             if(index1==0){libre[5]=1;}
             if(index1==1){libre[7]=1;}
             if(index1==2){libre[8]=1;}
         }
         if(index==1){
             libre[5]=1;libre[7]=1;
             index1=random.nextInt(3);
             if(index1==0){libre[1]=1;}

             if(index1==1){libre[3]=1;}
             if(index1==2){libre[6]=1;}
         }





        }







      else if(libre[6]==2 && libre[8]==2 && libre[1]==2){

            int index,index1;
            Random random = new Random();
            index  = random.nextInt(2);
            if(index==0){
                libre[0]=1;libre[4]=1;
                index1=random.nextInt(4);
                if(index1==0){libre[3]=1;}
                if(index1==1){libre[2]=1;}
                if(index1==2){libre[5]=1;}
                if(index1==3){libre[7]=1;}
            }
            if(index==1){
                libre[5]=1;libre[4]=1;
                index1=random.nextInt(3);
                if(index1==0){libre[0]=1;}
                if(index1==1){libre[2]=1;}
                if(index1==2){libre[7]=1;}

            }}









       else if(libre[0]==2 && libre[2]==2 && libre[7]==2){
         int index,index1;
         Random random = new Random();
         index  = random.nextInt(2);
         if(index==0){
             libre[3]=1;libre[1]=1;
             index1=random.nextInt(4);
             if(index1==0){libre[4]=1;}
             if(index1==1){libre[5]=1;}
             if(index1==2){libre[8]=1;}
             if(index1==3){libre[6]=1;}
         }
         if(index==1){
             libre[6]=1;libre[5]=1;
             index1=random.nextInt(4);
             if(index1==0){libre[1]=1;}
             if(index1==1){libre[8]=1;}
             if(index1==2){libre[3]=1;}
             if(index1==3){libre[4]=1;}
         }



     }





        else if(libre[0]==2 && libre[6]==2 && libre[5]==2){
         int index,index1;
         Random random = new Random();
         index  = random.nextInt(2);
         if(index==0){
             libre[4]=1;libre[2]=1;
             index1=random.nextInt(4);
             if(index1==0){libre[8]=1;}
             if(index1==1){libre[3]=1;}
             if(index1==2){libre[7]=1;}
             if(index1==3){libre[1]=1;}
         }
         if(index==1){
             libre[3]=1;libre[1]=1;
             index1=random.nextInt(4);
             if(index1==0){libre[2]=1;}
             if(index1==1){libre[8]=1;}
             if(index1==2){libre[4]=1;}
             if(index1==3){libre[7]=1;}
         }








     }





         else if(libre[2]==2 && libre[8]==2 && libre[3]==2){
         int index,index1;
         Random random = new Random();
         index  = random.nextInt(2);
         if(index==0){
             libre[5]=1;libre[7]=1;
             index1=random.nextInt(4);
             if(index1==0){libre[0]=1;}
             if(index1==1){libre[1]=1;}
             if(index1==2){libre[4]=1;}
             if(index1==3){libre[6]=1;}
         }
         if(index==1){
             libre[0]=1;libre[4]=1;
             index1=random.nextInt(4);
             if(index1==0){libre[5]=1;}
             if(index1==1){libre[7]=1;}
             if(index1==2){libre[6]=1;}
             if(index1==3){libre[1]=1;}
         }




        }






          else if(libre[6]==2 && libre[4]==2 && libre[8]==2){

         int index,index1;
         Random random = new Random();
         index  = random.nextInt(2);
         if(index==0){
             libre[7]=1;libre[5]=1;
             index1=random.nextInt(4);
             if(index1==0){libre[0]=1;}
             if(index1==1){libre[1]=1;}
             if(index1==2){libre[2]=1;}
             if(index1==3){libre[3]=1;}
         }
         if(index==1){
             libre[7]=1;libre[3]=1;
             index1=random.nextInt(4);
             if(index1==0){libre[0]=1;}
             if(index1==1){libre[1]=1;}
             if(index1==2){libre[2]=1;}
             if(index1==3){libre[5]=1;}
         }


        }







      else if(libre[0]==2 && libre[4]==2 && libre[2]==2){

         int index,index1;
         Random random = new Random();
         index  = random.nextInt(2);
         if(index==0){
             libre[1]=1;libre[5]=1;
             index1=random.nextInt(4);
             if(index1==0){libre[8]=1;}
             if(index1==1){libre[6]=1;}
             if(index1==2){libre[7]=1;}
             if(index1==3){libre[3]=1;}
         }
         if(index==1){
             libre[1]=1;libre[3]=1;
             index1=random.nextInt(4);
             if(index1==0){libre[5]=1;}
             if(index1==1){libre[8]=1;}
             if(index1==2){libre[7]=1;}
             if(index1==3){libre[6]=1;}
         }

        }






       else if(libre[0]==2 && libre[4]==2 && libre[6]==2){

         int index,index1;
         Random random = new Random();
         index  = random.nextInt(2);
         if(index==0){
             libre[3]=1;libre[1]=1;
             index1=random.nextInt(4);
             if(index1==0){libre[2]=1;}
             if(index1==1){libre[5]=1;}
             if(index1==2){libre[7]=1;}
             if(index1==3){libre[8]=1;}
         }
         if(index==1){
             libre[3]=1;libre[7]=1;
             index1=random.nextInt(4);
             if(index1==0){libre[1]=1;}
             if(index1==1){libre[2]=1;}
             if(index1==2){libre[5]=1;}
             if(index1==3){libre[8]=1;}
         }





     }




        else if(libre[2]==2 && libre[4]==2 && libre[8]==2){
         int index,index1;
         Random random = new Random();
         index  = random.nextInt(2);
         if(index==0){
             libre[5]=1;libre[1]=1;
             index1=random.nextInt(4);
             if(index1==0){libre[0]=1;}
             if(index1==1){libre[3]=1;}
             if(index1==2){libre[6]=1;}
             if(index1==3){libre[7]=1;}
         }
         if(index==1){
             libre[7]=1;libre[5]=1;
             index1=random.nextInt(4);
             if(index1==0){libre[0]=1;}
             if(index1==1){libre[1]=1;}
             if(index1==2){libre[3]=1;}
             if(index1==3){libre[6]=1;}
         }




        }





         else if(libre[6]==2 && libre[7]==2 && libre[5]==2){

         int index,index1;
         Random random = new Random();
         index  = random.nextInt(2);
         if(index==0){
             libre[8]=1;libre[4]=1;
             index1=random.nextInt(4);
             if(index1==0){libre[3]=1;}
             if(index1==1){libre[0]=1;}
             if(index1==2){libre[1]=1;}
             if(index1==3){libre[2]=1;}
         }
         if(index==1){
             libre[8]=1;libre[3]=1;
             index1=random.nextInt(4);
             if(index1==0){libre[4]=1;}
             if(index1==1){libre[0]=1;}
             if(index1==2){libre[2]=1;}
             if(index1==3){libre[1]=1;}
         }

        }






          else if(libre[3]==2 && libre[4]==2 && libre[8]==2){
         int index,index1;
         Random random = new Random();
         index  = random.nextInt(2);
         if(index==0){
             libre[5]=1;libre[7]=1;
             index1=random.nextInt(4);
             if(index1==0){libre[0]=1;}
             if(index1==1){libre[1]=1;}
             if(index1==2){libre[2]=1;}
             if(index1==3){libre[6]=1;}
         }
         if(index==1){
             libre[5]=1;libre[6]=1;
             index1=random.nextInt(4);
             if(index1==0){libre[7]=1;}
             if(index1==1){libre[0]=1;}
             if(index1==2){libre[1]=1;}
             if(index1==3){libre[2]=1;}
         }




        }





       else if(libre[0]==2 && libre[1]==2 && libre[5]==2){
         int index,index1;
         Random random = new Random();
         index  = random.nextInt(2);
         if(index==0){
             libre[2]=1;libre[4]=1;
             index1=random.nextInt(4);
             if(index1==0){libre[6]=1;}
             if(index1==1){libre[7]=1;}
             if(index1==2){libre[8]=1;}
             if(index1==3){libre[3]=1;}
         }
         if(index==1){
             libre[2]=1;libre[3]=1;
             index1=random.nextInt(4);
             if(index1==0){libre[4]=1;}
             if(index1==1){libre[6]=1;}
             if(index1==2){libre[7]=1;}
             if(index1==3){libre[8]=1;}
         }



        }







        else if(libre[1]==2 && libre[3]==2 && libre[6]==2){

         int index,index1;
         Random random = new Random();
         index  = random.nextInt(2);
         if(index==0){
             libre[0]=1;libre[4]=1;
             index1=random.nextInt(4);
             if(index1==0){libre[2]=1;}
             if(index1==1){libre[5]=1;}
             if(index1==2){libre[8]=1;}
             if(index1==3){libre[7]=1;}
         }
         if(index==1){
             libre[0]=1;libre[7]=1;
             index1=random.nextInt(4);
             if(index1==0){libre[2]=1;}
             if(index1==1){libre[5]=1;}
             if(index1==2){libre[8]=1;}
             if(index1==3){libre[4]=1;}
         }




        }





         else if(libre[2]==2 && libre[4]==2 && libre[7]==2){
         int index,index1;
         Random random = new Random();
         index  = random.nextInt(2);
         if(index==0){
             libre[5]=1;libre[1]=1;
             index1=random.nextInt(4);
             if(index1==0){libre[0]=1;}
             if(index1==1){libre[6]=1;}
             if(index1==2){libre[8]=1;}
             if(index1==3){libre[3]=1;}
         }
         if(index==1){
             libre[8]=1;libre[1]=1;
             index1=random.nextInt(4);
             if(index1==0){libre[5]=1;}
             if(index1==1){libre[0]=1;}
             if(index1==2){libre[3]=1;}
             if(index1==3){libre[6]=1;}
         }

        }





          else if(libre[0]==2 && libre[4]==2 && libre[7]==2){



            int index,index1;
            Random random = new Random();
            index  = random.nextInt(2);
            if(index==0){
                libre[3]=1;libre[1]=1;
                index1=random.nextInt(4);
                if(index1==0){libre[2]=1;}
                if(index1==1){libre[5]=1;}
                if(index1==2){libre[8]=1;}
                if(index1==3){libre[6]=1;}
            }
            if(index==1){
                libre[1]=1;libre[6]=1;
                index1=random.nextInt(4);
                if(index1==0){libre[3]=1;}
                if(index1==1){libre[2]=1;}
                if(index1==2){libre[5]=1;}
                if(index1==3){libre[8]=1;}
            }
        }







       else if(libre[1]==2 && libre[5]==2 && libre[8]==2){


            int index,index1;
            Random random = new Random();
            index  = random.nextInt(2);
            if(index==0){
                libre[2]=1;libre[4]=1;
                index1=random.nextInt(4);
                if(index1==0){libre[0]=1;}
                if(index1==1){libre[3]=1;}
                if(index1==2){libre[6]=1;}
                if(index1==3){libre[7]=1;}
            }
            if(index==1){
                libre[2]=1;libre[7]=1;
                index1=random.nextInt(4);
                if(index1==0){libre[0]=1;}
                if(index1==1){libre[3]=1;}
                if(index1==2){libre[4]=1;}
                if(index1==3){libre[6]=1;}
            }
        }


        else if(libre[0]==2 && libre[7]==2 && libre[8]==2){


            int index,index1;
            Random random = new Random();
            index  = random.nextInt(2);
            if(index==0){
                libre[3]=1;libre[1]=1;
                index1=random.nextInt(4);
                if(index1==0){libre[4]=1;}
                if(index1==1){libre[2]=1;}
                if(index1==2){libre[5]=1;}
                if(index1==3){libre[6]=1;}
            }
            if(index==1){
                libre[6]=1;libre[4]=1;
                index1=random.nextInt(4);
                if(index1==0){libre[1]=1;}
                if(index1==1){libre[2]=1;}
                if(index1==2){libre[3]=1;}
                if(index1==3){libre[5]=1;}
            }
        }




         else if(libre[6]==2 && libre[7]==2 && libre[2]==2){

            int index,index1;
            Random random = new Random();
            index  = random.nextInt(2);
            if(index==0){
                libre[5]=1;libre[4]=1;
                index1=random.nextInt(4);
                if(index1==0){libre[0]=1;}
                if(index1==1){libre[1]=1;}
                if(index1==2){libre[3]=1;}
                if(index1==3){libre[8]=1;}
            }
            if(index==1){
                libre[1]=1;libre[5]=1;
                index1=random.nextInt(4);
                if(index1==0){libre[0]=1;}
                if(index1==1){libre[3]=1;}
                if(index1==2){libre[4]=1;}
                if(index1==3){libre[8]=1;}
            }
        }



          else if(libre[2]==2 && libre[3]==2 && libre[6]==2){
            int index,index1;
            Random random = new Random();
            index  = random.nextInt(2);
            if(index==0){
                libre[5]=1;libre[1]=1;
                index1=random.nextInt(4);
                if(index1==0){libre[4]=1;}
                if(index1==1){libre[0]=1;}
                if(index1==2){libre[7]=1;}
                if(index1==3){libre[8]=1;}
            }
            if(index==1){
                libre[0]=1;libre[4]=1;
                index1=random.nextInt(4);
                if(index1==0){libre[1]=1;}
                if(index1==1){libre[8]=1;}
                if(index1==2){libre[5]=1;}
                if(index1==3){libre[7]=1;}
            }


        }






       else if(libre[0]==2 && libre[3]==2 && libre[8]==2){
            int index,index1;
            Random random = new Random();
            index  = random.nextInt(2);
            if(index==0){
                libre[5]=1;libre[7]=1;
                index1=random.nextInt(4);
                if(index1==0){libre[4]=1;}
                if(index1==1){libre[1]=1;}
                if(index1==2){libre[2]=1;}
                if(index1==3){libre[6]=1;}
            }
            if(index==1){
                libre[7]=1;libre[1]=1;
                index1=random.nextInt(4);
                if(index1==0){libre[2]=1;}
                if(index1==1){libre[4]=1;}
                if(index1==2){libre[5]=1;}
                if(index1==3){libre[6]=1;}
            }



        }




        else if(libre[0]==2 && libre[1]==2 && libre[8]==2){

            int index,index1;
            Random random = new Random();
            index  = random.nextInt(2);
            if(index==0){
                libre[5]=1;libre[7]=1;
                index1=random.nextInt(4);
                if(index1==0){libre[4]=1;}
                if(index1==1){libre[2]=1;}
                if(index1==2){libre[3]=1;}
                if(index1==3){libre[6]=1;}
            }
            if(index==1){
                libre[2]=1;libre[4]=1;
                index1=random.nextInt(4);
                if(index1==0){libre[7]=1;}
                if(index1==1){libre[5]=1;}
                if(index1==2){libre[3]=1;}
                if(index1==3){libre[6]=1;}
            }
        }





         else if(libre[1]==2 && libre[2]==2 && libre[6]==2){
            int index,index1;
            Random random = new Random();
            index  = random.nextInt(2);
            if(index==0){
                libre[3]=1;libre[7]=1;
                index1=random.nextInt(4);
                if(index1==0){libre[4]=1;}
                if(index1==1){libre[0]=1;}
                if(index1==2){libre[8]=1;}
                if(index1==3){libre[5]=1;}
            }
            if(index==1){
                libre[0]=1;libre[4]=1;
                index1=random.nextInt(4);
                if(index1==0){libre[3]=1;}
                if(index1==1){libre[5]=1;}
                if(index1==2){libre[7]=1;}
                if(index1==3){libre[8]=1;}
            }

        }
        else if(libre[2]==2 && libre[5]==2 && libre[6]==2){
            int index,index1;
            Random random = new Random();
            index  = random.nextInt(2);
            if(index==0){
                libre[3]=1;libre[7]=1;
                index1=random.nextInt(4);
                if(index1==0){libre[4]=1;}
                if(index1==1){libre[0]=1;}
                if(index1==2){libre[1]=1;}
                if(index1==3){libre[8]=1;}
            }
            if(index==1){
                libre[7]=1;libre[4]=1;
                index1=random.nextInt(4);
                if(index1==0){libre[0]=1;}
                if(index1==1){libre[1]=1;}
                if(index1==2){libre[3]=1;}
                if(index1==3){libre[8]=1;}
            }

        }
        else if(libre[5]==2 && libre[8]==2 && libre[0]==2){
            int index,index1;
            Random random = new Random();
            index  = random.nextInt(2);
            if(index==0){
                libre[3]=1;libre[1]=1;
                index1=random.nextInt(4);
                if(index1==0){libre[4]=1;}
                if(index1==1){libre[2]=1;}
                if(index1==2){libre[7]=1;}
                if(index1==3){libre[6]=1;}
            }
            if(index==1){
                libre[4]=1;libre[2]=1;
                index1=random.nextInt(4);
                if(index1==0){libre[1]=1;}
                if(index1==1){libre[3]=1;}
                if(index1==2){libre[6]=1;}
                if(index1==3){libre[7]=1;}
            }

        }

     else if(libre[1]==2 && libre[5]==2 && libre[7]==2){
         int index,index1;
         Random random = new Random();
         index  = random.nextInt(2);
         if(index==0){
             libre[4]=1;libre[2]=1;
             index1=random.nextInt(4);
             if(index1==0){libre[3]=1;}
             if(index1==1){libre[0]=1;}
             if(index1==2){libre[6]=1;}
             if(index1==3){libre[8]=1;}
         }
         if(index==1){
             libre[8]=1;libre[4]=1;
             index1=random.nextInt(4);
             if(index1==0){libre[0]=1;}
             if(index1==1){libre[2]=1;}
             if(index1==2){libre[3]=1;}
             if(index1==3){libre[6]=1;}
         }

     }

     else if(libre[1]==2 && libre[3]==2 && libre[7]==2){
         int index,index1;
         Random random = new Random();
         index  = random.nextInt(2);
         if(index==0){
             libre[4]=1;libre[0]=1;
             index1=random.nextInt(4);
             if(index1==0){libre[2]=1;}
             if(index1==1){libre[5]=1;}
             if(index1==2){libre[6]=1;}
             if(index1==3){libre[8]=1;}
         }
         if(index==1){
             libre[6]=1;libre[4]=1;
             index1=random.nextInt(4);
             if(index1==0){libre[0]=1;}
             if(index1==1){libre[2]=1;}
             if(index1==2){libre[5]=1;}
             if(index1==3){libre[8]=1;}
         }

     }


     else if(libre[1]==2 && libre[5]==2 && libre[3]==2){
         int index,index1;
         Random random = new Random();
         index  = random.nextInt(2);
         if(index==0){
             libre[4]=1;libre[0]=1;
             index1=random.nextInt(4);
             if(index1==0){libre[2]=1;}
             if(index1==1){libre[7]=1;}
             if(index1==2){libre[6]=1;}
             if(index1==3){libre[8]=1;}
         }
         if(index==1){
             libre[2]=1;libre[4]=1;
             index1=random.nextInt(4);
             if(index1==0){libre[0]=1;}
             if(index1==1){libre[7]=1;}
             if(index1==2){libre[8]=1;}
             if(index1==3){libre[6]=1;}
         }

     }


     else if(libre[3]==2 && libre[5]==2 && libre[7]==2){
         int index,index1;
         Random random = new Random();
         index  = random.nextInt(2);
         if(index==0){
             libre[4]=1;libre[8]=1;
             index1=random.nextInt(4);
             if(index1==0){libre[1]=1;}
             if(index1==1){libre[0]=1;}
             if(index1==2){libre[6]=1;}
             if(index1==3){libre[2]=1;}
         }
         if(index==1){
             libre[6]=1;libre[4]=1;
             index1=random.nextInt(4);
             if(index1==0){libre[0]=1;}
             if(index1==1){libre[2]=1;}
             if(index1==2){libre[8]=1;}
             if(index1==3){libre[1]=1;}
         }

     }

     else if(libre[6]==2 && libre[4]==2 && libre[5]==2){
         int index,index1;
         Random random = new Random();
         index  = random.nextInt(2);
         if(index==0){
             libre[3]=1;libre[7]=1;
             index1=random.nextInt(4);
             if(index1==0){libre[1]=1;}
             if(index1==1){libre[0]=1;}
             if(index1==2){libre[8]=1;}
             if(index1==3){libre[2]=1;}
         }
         if(index==1){
             libre[3]=1;libre[8]=1;
             index1=random.nextInt(4);
             if(index1==0){libre[0]=1;}
             if(index1==1){libre[2]=1;}
             if(index1==2){libre[7]=1;}
             if(index1==3){libre[1]=1;}
         }

     }
     else if(libre[0]==2 && libre[5]==2 && libre[4]==2){
         int index,index1;
         Random random = new Random();
         index  = random.nextInt(2);
         if(index==0){
             libre[3]=1;libre[1]=1;
             index1=random.nextInt(4);
             if(index1==0){libre[2]=1;}
             if(index1==1){libre[7]=1;}
             if(index1==2){libre[6]=1;}
             if(index1==3){libre[8]=1;}
         }
         if(index==1){
             libre[3]=1;libre[2]=1;
             index1=random.nextInt(4);
             if(index1==0){libre[1]=1;}
             if(index1==1){libre[6]=1;}
             if(index1==2){libre[8]=1;}
             if(index1==3){libre[7]=1;}
         }

     }
     else if(libre[1]==2 && libre[4]==2 && libre[8]==2){
         int index,index1;
         Random random = new Random();
         index  = random.nextInt(2);
         if(index==0){
             libre[5]=1;libre[7]=1;
             index1=random.nextInt(4);
             if(index1==0){libre[2]=1;}
             if(index1==1){libre[0]=1;}
             if(index1==2){libre[6]=1;}
             if(index1==3){libre[3]=1;}
         }
         if(index==1){
             libre[7]=1;libre[2]=1;
             index1=random.nextInt(4);
             if(index1==0){libre[0]=1;}
             if(index1==1){libre[5]=1;}
             if(index1==2){libre[3]=1;}
             if(index1==3){libre[6]=1;}
         }

     }


     else if(libre[1]==2 && libre[4]==2 && libre[6]==2){
         int index,index1;
         Random random = new Random();
         index  = random.nextInt(2);
         if(index==0){
             libre[7]=1;libre[3]=1;
             index1=random.nextInt(4);
             if(index1==0){libre[0]=1;}
             if(index1==1){libre[5]=1;}
             if(index1==2){libre[8]=1;}
             if(index1==3){libre[2]=1;}
         }
         if(index==1){
             libre[7]=1;libre[0]=1;
             index1=random.nextInt(4);
             if(index1==0){libre[3]=1;}
             if(index1==1){libre[2]=1;}
             if(index1==2){libre[5]=1;}
             if(index1==3){libre[8]=1;}
         }

     }







     else  {for(int i=0;i<9;i++){
            if(libre[i]==0){listvid[t]=i; t++;} }
   int index;
         Random random = new Random();
         index  = random.nextInt(8);
         if(index==0){ libre[listvid[2]] =1;libre[listvid[3]] =1; libre[listvid[5]] =1;
         if(libre[0]==libre[1] && libre[0]==libre[2]){ lirelibre();}
             if(libre[0]==libre[3] && libre[0]==libre[6]){libre[listvid[2]]=0; libre[listvid[4]] =1; }
             if(libre[1]==libre[4] && libre[4]==libre[7]){ libre[listvid[2]]=0; libre[listvid[4]] =1;}
             if(libre[2]==libre[5] && libre[5]==libre[8]){ libre[listvid[2]]=0; libre[listvid[4]] =1;}
             if(libre[6]==libre[7] && libre[7]==libre[8]){libre[listvid[2]]=0; libre[listvid[4]] =1;}
             if(libre[3]==libre[4] && libre[4]==libre[5]){libre[listvid[2]]=0; libre[listvid[4]] =1;}



         }
         if(index==1){ libre[listvid[0]] =1;libre[listvid[1]] =1; libre[listvid[4]] =1;
             if(libre[0]==libre[1] && libre[0]==libre[2]){ libre[listvid[0]] =0;libre[listvid[7]] =1;}
             if(libre[0]==libre[3] && libre[0]==libre[6]){ libre[listvid[0]] =0;libre[listvid[7]] =1;}
             if(libre[1]==libre[4] && libre[4]==libre[7]){ libre[listvid[0]] =0;libre[listvid[7]] =1;}
             if(libre[2]==libre[5] && libre[5]==libre[8]){libre[listvid[0]] =0;libre[listvid[7]] =1;}
             if(libre[6]==libre[7] && libre[7]==libre[8]){libre[listvid[0]] =0;libre[listvid[7]] =1;}
             if(libre[3]==libre[4] && libre[4]==libre[5]){libre[listvid[0]] =0;libre[listvid[7]] =1;}}


         if(index==2){ libre[listvid[5]] =1;libre[listvid[0]] =1; libre[listvid[2]] =1;
             if(libre[0]==libre[1] && libre[0]==libre[2]){ libre[listvid[5]] =0; libre[listvid[6]] =1;}
             if(libre[0]==libre[3] && libre[0]==libre[6]){ libre[listvid[5]] =0; libre[listvid[6]] =1;}
             if(libre[1]==libre[4] && libre[4]==libre[7]){ libre[listvid[5]] =0; libre[listvid[6]] =1;}
             if(libre[2]==libre[5] && libre[5]==libre[8]){libre[listvid[5]] =0; libre[listvid[3]] =1;}
             if(libre[6]==libre[7] && libre[7]==libre[8]){ libre[listvid[5]] =0; libre[listvid[6]] =1;}
             if(libre[3]==libre[4] && libre[4]==libre[5]){ libre[listvid[5]] =0; libre[listvid[6]] =1;}}


         if(index==3){ libre[listvid[1]] =1;libre[listvid[5]] =1; libre[listvid[2]] =1;
             if(libre[0]==libre[1] && libre[0]==libre[2]){libre[listvid[0]] =1;libre[listvid[0]] =1;}
             if(libre[0]==libre[3] && libre[0]==libre[6]){libre[listvid[0]] =1;libre[listvid[0]] =1;}
             if(libre[1]==libre[4] && libre[4]==libre[7]){libre[listvid[0]] =1;libre[listvid[0]] =1;}
             if(libre[2]==libre[5] && libre[5]==libre[8]){ libre[listvid[0]] =1;libre[listvid[0]] =1;}
             if(libre[6]==libre[7] && libre[7]==libre[8]){ libre[listvid[0]] =1;libre[listvid[0]] =1;}
             if(libre[3]==libre[4] && libre[4]==libre[5]){ libre[listvid[0]] =1;libre[listvid[0]] =1;}}


         if(index==4){ libre[listvid[2]] =1;libre[listvid[0]] =1; libre[listvid[4]] =1;}
         if(index==5){ libre[listvid[4]] =1;libre[listvid[3]] =1; libre[listvid[5]] =1;
             if(libre[0]==libre[1] && libre[0]==libre[2]){libre[listvid[3]] =0;libre[listvid[0]] =1;}
             if(libre[0]==libre[3] && libre[0]==libre[6]){libre[listvid[3]] =0;libre[listvid[0]] =1;}
             if(libre[1]==libre[4] && libre[4]==libre[7]){ libre[listvid[3]] =0;libre[listvid[0]] =1;}
             if(libre[2]==libre[5] && libre[5]==libre[8]){ libre[listvid[3]] =0;libre[listvid[0]] =1;}
             if(libre[6]==libre[7] && libre[7]==libre[8]){libre[listvid[3]] =0;libre[listvid[0]] =1;}
             if(libre[3]==libre[4] && libre[4]==libre[5]){libre[listvid[3]] =0;libre[listvid[0]] =1;}}


         if(index==6){ libre[listvid[4]] =1;libre[listvid[0]] =1; libre[listvid[1]] =1;
             if(libre[0]==libre[1] && libre[0]==libre[2]){libre[listvid[0]] =0;libre[listvid[5]] =1;}
             if(libre[0]==libre[3] && libre[0]==libre[6]){ libre[listvid[0]] =0;libre[listvid[5]] =1;}
             if(libre[1]==libre[4] && libre[4]==libre[7]){ libre[listvid[0]] =0;libre[listvid[5]] =1;}
             if(libre[2]==libre[5] && libre[5]==libre[8]){libre[listvid[0]] =0;libre[listvid[5]] =1;}
             if(libre[6]==libre[7] && libre[7]==libre[8]){ libre[listvid[0]] =0;libre[listvid[5]] =1;}
             if(libre[3]==libre[4] && libre[4]==libre[5]){ libre[listvid[0]] =0;libre[listvid[5]] =1;}}
         if(index==7){ libre[listvid[5]] =1;libre[listvid[3]] =1; libre[listvid[1]] =1;
             if(libre[0]==libre[1] && libre[0]==libre[2]){libre[listvid[1]] =0;libre[listvid[2]] =1;}
             if(libre[0]==libre[3] && libre[0]==libre[6]){libre[listvid[1]] =0;libre[listvid[2]] =1;}
             if(libre[1]==libre[4] && libre[4]==libre[7]){ libre[listvid[1]] =0;libre[listvid[2]] =1;}
             if(libre[2]==libre[5] && libre[5]==libre[8]){libre[listvid[1]] =0;libre[listvid[2]] =1;}
             if(libre[6]==libre[7] && libre[7]==libre[8]){libre[listvid[1]] =0;libre[listvid[2]] =1;}
             if(libre[3]==libre[4] && libre[4]==libre[5]){ libre[listvid[1]] =0;libre[listvid[2]] =1;}}
     }

















    }


}


