package com.eljeder.tisha;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
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

import static com.eljeder.tisha.twoplayerscreen2.player1icon;
import static com.eljeder.tisha.twoplayerscreen2.player2icon;
import java.util.ArrayList;


;
import static com.eljeder.tisha.chosecarrotowplayer.listTowPlayer;
import static java.lang.Math.abs;

public class MainActivitytwop extends AppCompatActivity {
    // 2  asweed , 1 orange
// 2 facile  3 te8elbe , 5 me te8elbech


    public  static  int h1;
    public  static  int h2;
    private static GestureDetectGridViewtow mGridView;
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
    private static Context bContext;
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

    private AdView mAdView,   adView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.boardgametowpla);


        MobileAds.initialize(this,"ca-app-pub-1350123755884874~6965127510");


        adView = new AdView(MainActivitytwop.this);
        adView.setAdSize(AdSize.SMART_BANNER);

        adView.setAdUnitId( "ca-app-pub-3940256099942544/6300978111");
        RelativeLayout layout = (RelativeLayout) findViewById(R.id.mainpub2);
        layout.addView(adView);
// Initiate a generic request.
        AdRequest adRequest = new AdRequest.Builder().build();
// Load the adView with the ad request.
        adView.loadAd(adRequest);
        layout.bringToFront();











        bContext=this;

        init(getApplicationContext());
        setDimensions();
        btprogon();

    }
    public   void btprogon(){
        ImageButton btprog = (ImageButton) findViewById(R.id.probtt);
        ImageButton bb;

        bb =btprog;

    }

    private void init(Context context) {



        mGridView = (GestureDetectGridViewtow) findViewById(R.id.gridtow);
        mGridView.setBackgroundResource(R.drawable.boardtictac1);
        mGridView.setNumColumns(COLUMNS);
        libre = new int[]{1,2, 1, 0, 0, 0, 2, 1, 2};


        libre=listTowPlayer;


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
                if( player1icon==1){buttons.get(i).setBackgroundResource(R.drawable.fraisered);}
                if( player1icon==2){buttons.get(i).setBackgroundResource(R.drawable.korabasketred);}
                if(player1icon==3){buttons.get(i).setBackgroundResource(R.drawable.mininred1);}}

            else  if (libre[i]==2){
                if( player2icon==1){buttons.get(i).setBackgroundResource(R.drawable.bananered);}
                if( player2icon==2){buttons.get(i).setBackgroundResource(R.drawable.korafootred);}
                if( player2icon==3){buttons.get(i).setBackgroundResource(R.drawable.minion2red2);}
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




        final  Animation anim = AnimationUtils.loadAnimation(context , R.anim.rotate);

        anim.start();





        final int [][] jeu; jeu=makejeufromlibre();
        affichequigagne(jeu,context);





    } // swap between tow button (image )
    public static void   btprogon(ImageButton imagebutton){
        //     ImageButton btprog ;
        // btprog = (ImageButton) findViewById(R.id.probtt);
        imagebutton.setVisibility(View.VISIBLE);
        imagebutton.setRotation(135);

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


                Intent gameo=new Intent(bContext, gameovertow.class);
                bContext.startActivity(gameo);
            }
            if (jeu[i][0] ==2 && jeu[i][1] ==2 && jeu[i][2] ==2 ) {
                Intent gameo=new Intent(bContext, gameovertow.class);
                bContext.startActivity(gameo);
            }}

        for(int i=0;i<3;i++) {
            if (jeu[0][i] ==1 && jeu[1][i] ==1 && jeu[2][i] ==1) {
                Intent gameo=new Intent(bContext, gameovertow.class);
                bContext.startActivity(gameo);
            }
            if (jeu[0][i] ==2 && jeu[1][i] ==2 && jeu[2][i] ==2 ) {
                Intent gameo=new Intent(bContext, gameovertow.class);
                bContext.startActivity(gameo);
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




}

