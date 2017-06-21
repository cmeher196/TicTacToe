package com.something.chandra.tictactoe;


import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class HomePage extends AppCompatActivity {


    Button play,exit,how,about;
    InterstitialAd mInterstitialAd;

   /* private void initializeCalldorado() {
        Calldorado.startCalldorado(this);
    }*/

    private void showInterstitial() {
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mInterstitialAd = new InterstitialAd(this);
        // set the ad unit ID
        mInterstitialAd.setAdUnitId("ca-app-pub-7158819369536945/6997398913");
        AdRequest adRequest1 = new AdRequest.Builder()
                .build();
        // Load ads into Interstitial Ads
        mInterstitialAd.loadAd(adRequest1);
        mInterstitialAd.setAdListener(new AdListener() {
            public void onAdLoaded() {
                showInterstitial();
            }
        });

    //    initializeCalldorado();

        setContentView(R.layout.activity_home_page);
        play=(Button)findViewById(R.id.b1);
        exit=(Button)findViewById(R.id.b3);
        how=(Button)findViewById(R.id.b2);
        about=(Button)findViewById(R.id.b4);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent info =new Intent(HomePage.this,MainActivity.class);
                startActivity(info);
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder b= new AlertDialog.Builder(HomePage.this);
                b.setTitle("EXIT");
                b.setMessage("Do you want to Exit");
                b.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finishAffinity();
                    }
                });
                b.setNegativeButton("No",null);
                b.setCancelable(false);
                AlertDialog db = b.create();
                db.show();
            }
        });

        how.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent info =new Intent(HomePage.this,HowToPlay.class);
                startActivity(info);
            }
        });


        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent info =new Intent(HomePage.this,AboutUs.class);
                startActivity(info);
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) { //for on Screen Menu...
        MenuInflater mi = getMenuInflater();
        mi.inflate(R.menu.mymenuoption,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {//for menu options...

        int mid = item.getItemId();
        if(mid==R.id.home)
        {
            Intent info = new Intent(this,HomePage.class);
            startActivity(info);
        //    finish();
        }
        if(mid == R.id.about){
            Intent info = new Intent(this,AboutUs.class);
            startActivity(info);
         //   finish();
        }
        if(mid == R.id.help){
            Intent info = new Intent(this,HowToPlay.class);
            startActivity(info);
          //  finish();
        }
        if (mid == R.id.exit)
        {
            AlertDialog.Builder b= new AlertDialog.Builder(HomePage.this);
            b.setTitle("EXIT");
            b.setMessage("Do you want to Exit");
            b.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finishAffinity();
                }
            });
            b.setNegativeButton("No",null);
            b.setCancelable(false);
            AlertDialog db = b.create();
            db.show();
        }
        return super.onOptionsItemSelected(item);
    }
}
