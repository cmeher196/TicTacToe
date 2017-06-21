package com.something.chandra.tictactoe;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {



    Vibrator vib;
    TextView tv3;
    Button b[][]=new Button[3][3];
    int c[][] = new int[3][3];

    static boolean bool =false;
    static int counter;

    public void buttonEnabled() {  //To Disable Buttons after the game gets over...
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (b[i][j].isEnabled()) {
                    b[i][j].setVisibility(View.INVISIBLE);
                }
            }
        }
        tv3.setVisibility(View.INVISIBLE);
    }


    public void alertForX()  //to set Alert dialog box for the X player
    {

        AlertDialog.Builder b =new AlertDialog.Builder(this);
        TextView title = new TextView(this);
        title.setTextColor(ContextCompat.getColor(this, android.R.color.holo_blue_dark));
        title.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        title.setTypeface(Typeface.DEFAULT_BOLD);
        title.setText("CONGRATULATIONS");
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        lp.setMargins(0, 20, 0, 0);
        title.setPadding(0,30,0,0);
        title.setLayoutParams(lp);
        title.setGravity(Gravity.CENTER);
        b.setCustomTitle(title);
        b.setMessage("PLAYER 'X' WINS");
        b.setIcon(R.drawable.medal);
        b.setNegativeButton("Cancel",null);
        b.setCancelable(false);
        AlertDialog d=b.create();
        d.show();
    }



    public void alertForO()    //to set Alert dialog box for the O player
    {

      AlertDialog.Builder b =new AlertDialog.Builder(this);
        TextView title = new TextView(this);
        title.setTextColor(ContextCompat.getColor(this, android.R.color.holo_blue_dark));
        title.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        title.setTypeface(Typeface.DEFAULT_BOLD);
        title.setText("CONGRATULATIONS");
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        lp.setMargins(0, 20, 0, 0);
        title.setPadding(0,30,0,0);
        title.setLayoutParams(lp);
        title.setGravity(Gravity.CENTER);
        b.setCustomTitle(title);
        b.setMessage("PLAYER 'O' WINS");
        b.setIcon(R.drawable.medal);
        b.setNegativeButton("Cancel",null);
        b.setCancelable(false);
        AlertDialog d=b.create();
        d.show();
    }

    public void alertForDraw()   //to set Alert dialog box for draw...
    {
        tv3.setVisibility(View.INVISIBLE);

        AlertDialog.Builder b =new AlertDialog.Builder(this);
        TextView title = new TextView(this);
        title.setTextColor(ContextCompat.getColor(this, android.R.color.holo_blue_dark));
        title.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        title.setTypeface(Typeface.DEFAULT_BOLD);
        title.setText("DRAW");
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        lp.setMargins(0, 20, 0, 0);
        title.setPadding(0,30,0,0);
        title.setLayoutParams(lp);
        title.setGravity(Gravity.CENTER);
        b.setCustomTitle(title);
        b.setMessage("NO ONE WINS...");
        b.setIcon(R.drawable.medal);
        b.setNegativeButton("Cancel",null);
        b.setCancelable(false);
        AlertDialog d=b.create();
        d.show();

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        b[0][0]=(Button)findViewById(R.id.b1);
        b[0][1]=(Button)findViewById(R.id.b2);
        b[0][2]=(Button)findViewById(R.id.b3);
        b[1][0]=(Button)findViewById(R.id.b4);
        b[1][1]=(Button)findViewById(R.id.b5);
        b[1][2]=(Button)findViewById(R.id.b6);
        b[2][0]=(Button)findViewById(R.id.b7);
        b[2][1]=(Button)findViewById(R.id.b8);
        b[2][2]=(Button)findViewById(R.id.b9);
        tv3=(TextView)findViewById(R.id.tv3);
        counter=0;


        //to set Vibration...
        String vib_ser_name = Context.VIBRATOR_SERVICE;
        vib=(Vibrator)getSystemService(vib_ser_name);


        for (int i=0;i<3;i++)  //assigning the counter c =0 initially.....
        {
            for (int j=0;j<3;j++)
            {
                c[i][j]=2;
            }
        }



        b[0][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bool == false) {
                    b[0][0].setBackgroundResource(R.drawable.x1x);
                    bool = true;
                    counter+=1;
                    b[0][0].setEnabled(false);
                    vib.vibrate(150);
                    c[0][0] = 1;
                    tv3.setText("O's turn");


                }
                else {
                    b[0][0].setBackgroundResource(R.drawable.wodoo);
                    bool = false;
                    counter+=1;
                    b[0][0].setEnabled(false);
                    vib.vibrate(150);
                    tv3.setText("X's turn");
                    c[0][0] = 0;

                }

                if((c[0][0]==1 &&c[0][1]==1 && c[0][2]==1)|| (c[1][0]==1 &&c[1][1]==1 && c[1][2]==1)|| (c[2][0]==1 &&c[2][1]==1 && c[2][2]==1)|| (c[0][0]==1 &&c[1][0]==1 && c[2][0]==1)|| (c[0][1]==1 &&c[1][1]==1 && c[2][1]==1)|| (c[0][2]==1 &&c[1][2]==1 && c[2][2]==1)|| (c[0][2]==1 &&c[1][1]==1 && c[2][0]==1)|| (c[0][0]==1 &&c[1][1]==1 && c[2][2]==1))
                {
                    buttonEnabled();
                    alertForX();
                }

              else  if((c[0][0]==0 &&c[0][1]==0 && c[0][2]==0)|| (c[1][0]==0 &&c[1][1]==0 && c[1][2]==0)|| (c[2][0]==0 &&c[2][1]==0 && c[2][2]==0)|| (c[0][0]==0 &&c[1][0]==0 && c[2][0]==0)|| (c[0][1]==0 &&c[1][1]==0 && c[2][1]==0)|| (c[0][2]==0 &&c[1][2]==0 && c[2][2]==0)|| (c[0][2]==0 &&c[1][1]==0 && c[2][0]==0)|| (c[0][0]==0 &&c[1][1]==0 && c[2][2]==0))
                {
                    buttonEnabled();
                   alertForO();
                }
              else  if (counter==9)
                {

                    alertForDraw();
                }
            }


        });

        b[0][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bool==false)
                {
                    b[0][1].setBackgroundResource(R.drawable.x1x);
                    bool=true;
                    b[0][1].setEnabled(false);
                    vib.vibrate(150);
                    c[0][1]=1;
                    counter+=1;
                    tv3.setText("O's turn");

                }
                else{

                    b[0][1].setBackgroundResource(R.drawable.wodoo);
                    bool=false;
                    b[0][1].setEnabled(false);
                    vib.vibrate(150);
                    c[0][1]=0;
                    counter+=1;
                    tv3.setText("X's turn");

                }
                if((c[0][0]==1 &&c[0][1]==1 && c[0][2]==1)|| (c[1][0]==1 && c[1][1]==1 && c[1][2]==1)|| (c[2][0]==1 && c[2][1]==1 && c[2][2]==1)|| (c[0][0]==1 &&c[1][0]==1 && c[2][0]==1)|| (c[0][1]==1 &&c[1][1]==1 && c[2][1]==1)|| (c[0][2]==1 &&c[1][2]==1 && c[2][2]==1)|| (c[0][2]==1 &&c[1][1]==1 && c[2][0]==1)|| (c[0][0]==1 &&c[1][1]==1 && c[2][2]==1))
                {
                    buttonEnabled();
                   alertForX();
                }

               else if((c[0][0]==0 &&c[0][1]==0 && c[0][2]==0)|| (c[1][0]==0 &&c[1][1]==0 && c[1][2]==0)|| (c[2][0]==0 &&c[2][1]==0 && c[2][2]==0)|| (c[0][0]==0 &&c[1][0]==0 && c[2][0]==0)|| (c[0][1]==0 &&c[1][1]==0 && c[2][1]==0)|| (c[0][2]==0 &&c[1][2]==0 && c[2][2]==0)|| (c[0][2]==0 &&c[1][1]==0 && c[2][0]==0)|| (c[0][0]==0 &&c[1][1]==0 && c[2][2]==0))
                {
                    buttonEnabled();
                  alertForO();
                }
              else  if (counter==9)
                {
                    alertForDraw();
                }
                }

        });

        b[0][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bool==false)
                {
                    b[0][2].setBackgroundResource(R.drawable.x1x);
                    bool=true;
                    b[0][2].setEnabled(false);
                    vib.vibrate(150);
                    c[0][2]=1;
                    counter+=1;
                    tv3.setText("O's turn");

                }
                else{
                    b[0][2].setBackgroundResource(R.drawable.wodoo);
                    bool=false;
                    b[0][2].setEnabled(false);
                    vib.vibrate(150);
                    c[0][2]=0;
                    counter+=1;
                    tv3.setText("X's turn");

                }
                if((c[0][0]==1 &&c[0][1]==1 && c[0][2]==1)|| (c[1][0]==1 &&c[1][1]==1 && c[1][2]==1)|| (c[2][0]==1 &&c[2][1]==1 && c[2][2]==1)|| (c[0][0]==1 &&c[1][0]==1 && c[2][0]==1)|| (c[0][1]==1 &&c[1][1]==1 && c[2][1]==1)|| (c[0][2]==1 &&c[1][2]==1 && c[2][2]==1)|| (c[0][2]==1 &&c[1][1]==1 && c[2][0]==1)|| (c[0][0]==1 &&c[1][1]==1 && c[2][2]==1))
                {
                    buttonEnabled();
                  alertForX();
                }
               else if((c[0][0]==0 &&c[0][1]==0 && c[0][2]==0)|| (c[1][0]==0 &&c[1][1]==0 && c[1][2]==0)|| (c[2][0]==0 &&c[2][1]==0 && c[2][2]==0)|| (c[0][0]==0 &&c[1][0]==0 && c[2][0]==0)|| (c[0][1]==0 &&c[1][1]==0 && c[2][1]==0)|| (c[0][2]==0 &&c[1][2]==0 && c[2][2]==0)|| (c[0][2]==0 &&c[1][1]==0 && c[2][0]==0)|| (c[0][0]==0 &&c[1][1]==0 && c[2][2]==0))
                {
                    buttonEnabled();
                     alertForO();
                }
              else  if (counter==9)
                {
                    alertForDraw();
                }
                }

        });

        b[1][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
            if (bool == false) {
                b[1][0].setBackgroundResource(R.drawable.x1x);
                bool = true;
                b[1][0].setEnabled(false);
                vib.vibrate(150);
                c[1][0] = 1;
                tv3.setText("O's turn");
                counter+= 1;
            }
            else {
                b[1][0].setBackgroundResource(R.drawable.wodoo);
                bool = false;
                b[1][0].setEnabled(false);
                vib.vibrate(150);
                c[1][0] = 0;
                counter+= 1;
                tv3.setText("X's turn");
            }

            if ((c[0][0] == 1 && c[0][1] == 1 && c[0][2] == 1) || (c[1][0] == 1 && c[1][1] == 1 && c[1][2] == 1) || (c[2][0] == 1 && c[2][1] == 1 && c[2][2] == 1) || (c[0][0] == 1 && c[1][0] == 1 && c[2][0] == 1) || (c[0][1] == 1 && c[1][1] == 1 && c[2][1] == 1) || (c[0][2] == 1 && c[1][2] == 1 && c[2][2] == 1) || (c[0][2] == 1 && c[1][1] == 1 && c[2][0] == 1) || (c[0][0] == 1 && c[1][1] == 1 && c[2][2] == 1))
            {
                buttonEnabled();
               alertForX();
            }

              else  if((c[0][0]==0 &&c[0][1]==0 && c[0][2]==0)|| (c[1][0]==0 &&c[1][1]==0 && c[1][2]==0)|| (c[2][0]==0 &&c[2][1]==0 && c[2][2]==0)|| (c[0][0]==0 &&c[1][0]==0 && c[2][0]==0)|| (c[0][1]==0 &&c[1][1]==0 && c[2][1]==0)|| (c[0][2]==0 &&c[1][2]==0 && c[2][2]==0)|| (c[0][2]==0 &&c[1][1]==0 && c[2][0]==0)|| (c[0][0]==0 &&c[1][1]==0 && c[2][2]==0))
            {
                buttonEnabled();
                alertForO();
            }
          else  if (counter == 9) {
                alertForDraw();
            }
            }
        });

        b[1][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bool==false)
                {
                    b[1][1].setBackgroundResource(R.drawable.x1x);

                    bool=true;
                    b[1][1].setEnabled(false);
                    vib.vibrate(150);
                    c[1][1]=1;
                    counter+=1;
                    tv3.setText("O's turn");
                }
                else{
                    b[1][1].setBackgroundResource(R.drawable.wodoo);
                    bool=false;
                    b[1][1].setEnabled(false);
                    vib.vibrate(150);
                    c[1][1]=0;
                    counter+=1;
                    tv3.setText("X's turn");
                }

                if((c[0][0]==1 &&c[0][1]==1 && c[0][2]==1)|| (c[1][0]==1 &&c[1][1]==1 && c[1][2]==1)|| (c[2][0]==1 &&c[2][1]==1 && c[2][2]==1)|| (c[0][0]==1 &&c[1][0]==1 && c[2][0]==1)|| (c[0][1]==1 &&c[1][1]==1 && c[2][1]==1)|| (c[0][2]==1 &&c[1][2]==1 && c[2][2]==1)|| (c[0][2]==1 &&c[1][1]==1 && c[2][0]==1)|| (c[0][0]==1 &&c[1][1]==1 && c[2][2]==1))
                {
                    buttonEnabled();
                  alertForX();
                }
               else if((c[0][0]==0 &&c[0][1]==0 && c[0][2]==0)|| (c[1][0]==0 &&c[1][1]==0 && c[1][2]==0)|| (c[2][0]==0 &&c[2][1]==0 && c[2][2]==0)|| (c[0][0]==0 &&c[1][0]==0 && c[2][0]==0)|| (c[0][1]==0 &&c[1][1]==0 && c[2][1]==0)|| (c[0][2]==0 &&c[1][2]==0 && c[2][2]==0)|| (c[0][2]==0 &&c[1][1]==0 && c[2][0]==0)|| (c[0][0]==0 &&c[1][1]==0 && c[2][2]==0))
                {
                    buttonEnabled();
                 alertForO();
                }
              else  if (counter==9)
                {
                    alertForDraw();
                }
                }

        });

        b[1][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bool==false)
                {
                    b[1][2].setBackgroundResource(R.drawable.x1x);
                    bool=true;
                    b[1][2].setEnabled(false);
                    vib.vibrate(150);
                    c[1][2]=1;
                    counter+=1;
                    tv3.setText("O's turn");
                }
                else{
                    b[1][2].setBackgroundResource(R.drawable.wodoo);
                    bool=false;
                    b[1][2].setEnabled(false);
                    vib.vibrate(150);
                    c[1][2]=0;
                    counter+=1;
                    tv3.setText("X's turn");
                }
                if((c[0][0]==1 &&c[0][1]==1 && c[0][2]==1)|| (c[1][0]==1 &&c[1][1]==1 && c[1][2]==1)|| (c[2][0]==1 &&c[2][1]==1 && c[2][2]==1)|| (c[0][0]==1 &&c[1][0]==1 && c[2][0]==1)|| (c[0][1]==1 &&c[1][1]==1 && c[2][1]==1)|| (c[0][2]==1 &&c[1][2]==1 && c[2][2]==1)|| (c[0][2]==1 &&c[1][1]==1 && c[2][0]==1)|| (c[0][0]==1 &&c[1][1]==1 && c[2][2]==1))
                {
                    buttonEnabled();
                  alertForX();
                }
              else  if((c[0][0]==0 &&c[0][1]==0 && c[0][2]==0)|| (c[1][0]==0 &&c[1][1]==0 && c[1][2]==0)|| (c[2][0]==0 &&c[2][1]==0 && c[2][2]==0)|| (c[0][0]==0 &&c[1][0]==0 && c[2][0]==0)|| (c[0][1]==0 &&c[1][1]==0 && c[2][1]==0)|| (c[0][2]==0 &&c[1][2]==0 && c[2][2]==0)|| (c[0][2]==0 &&c[1][1]==0 && c[2][0]==0)|| (c[0][0]==0 &&c[1][1]==0 && c[2][2]==0))
                {
                    buttonEnabled();
                  alertForO();
                }
              else  if (counter==9)
                {
                    alertForDraw();
                }
                }
       //     }
        });

        b[2][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bool==false) {
                    b[2][0].setBackgroundResource(R.drawable.x1x);
                    bool = true;
                    b[2][0].setEnabled(false);
                    vib.vibrate(150);
                    c[2][0] = 1;
                    tv3.setText("O's turn");
                    counter+=1;
                }
                else
                {
                    b[2][0].setBackgroundResource(R.drawable.wodoo);
                    bool=false;
                    b[2][0].setEnabled(false);
                    vib.vibrate(150);
                    c[2][0]=0;
                    counter+=1;
                    tv3.setText("X's turn");
                }
                if((c[0][0]==1 &&c[0][1]==1 && c[0][2]==1)|| (c[1][0]==1 &&c[1][1]==1 && c[1][2]==1)|| (c[2][0]==1 &&c[2][1]==1 && c[2][2]==1)|| (c[0][0]==1 &&c[1][0]==1 && c[2][0]==1)|| (c[0][1]==1 &&c[1][1]==1 && c[2][1]==1)|| (c[0][2]==1 &&c[1][2]==1 && c[2][2]==1)|| (c[0][2]==1 &&c[1][1]==1 && c[2][0]==1)|| (c[0][0]==1 &&c[1][1]==1 && c[2][2]==1))
                {
                    buttonEnabled();
                   alertForX();
                }
                else if((c[0][0]==0 &&c[0][1]==0 && c[0][2]==0)|| (c[1][0]==0 &&c[1][1]==0 && c[1][2]==0)|| (c[2][0]==0 &&c[2][1]==0 && c[2][2]==0)|| (c[0][0]==0 &&c[1][0]==0 && c[2][0]==0)|| (c[0][1]==0 &&c[1][1]==0 && c[2][1]==0)|| (c[0][2]==0 &&c[1][2]==0 && c[2][2]==0)|| (c[0][2]==0 &&c[1][1]==0 && c[2][0]==0)|| (c[0][0]==0 &&c[1][1]==0 && c[2][2]==0))
                {
                    buttonEnabled();
                alertForO();
                }
               else if (counter==9)
                {
                    alertForDraw();
                }
                }
         //   }
        });

        b[2][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bool==false)
                {
                    b[2][1].setBackgroundResource(R.drawable.x1x);
                    bool=true;
                    b[2][1].setEnabled(false);
                    vib.vibrate(150);
                    c[2][1]=1;
                    counter+=1;
                    tv3.setText("O's turn");
                }
                else{
                    b[2][1].setBackgroundResource(R.drawable.wodoo);
                    bool=false;
                    b[2][1].setEnabled(false);
                    vib.vibrate(150);
                    c[2][1]=0;
                    counter+=1;
                    tv3.setText("X's turn");
                }
                if((c[0][0]==1 &&c[0][1]==1 && c[0][2]==1)|| (c[1][0]==1 &&c[1][1]==1 && c[1][2]==1)|| (c[2][0]==1 &&c[2][1]==1 && c[2][2]==1)|| (c[0][0]==1 &&c[1][0]==1 && c[2][0]==1)|| (c[0][1]==1 &&c[1][1]==1 && c[2][1]==1)|| (c[0][2]==1 &&c[1][2]==1 && c[2][2]==1)|| (c[0][2]==1 &&c[1][1]==1 && c[2][0]==1)|| (c[0][0]==1 &&c[1][1]==1 && c[2][2]==1))
                {
                    buttonEnabled();
                  alertForX();
                }
              else  if((c[0][0]==0 &&c[0][1]==0 && c[0][2]==0)|| (c[1][0]==0 &&c[1][1]==0 && c[1][2]==0)|| (c[2][0]==0 &&c[2][1]==0 && c[2][2]==0)|| (c[0][0]==0 &&c[1][0]==0 && c[2][0]==0)|| (c[0][1]==0 &&c[1][1]==0 && c[2][1]==0)|| (c[0][2]==0 &&c[1][2]==0 && c[2][2]==0)|| (c[0][2]==0 &&c[1][1]==0 && c[2][0]==0)|| (c[0][0]==0 &&c[1][1]==0 && c[2][2]==0))
                {
                    buttonEnabled();
                  alertForO();
                }
              else  if (counter==9)
                {
                    alertForDraw();
                }
                }
      //      }
        });

        b[2][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bool==false)
                {
                    b[2][2].setBackgroundResource(R.drawable.x1x);
                    bool=true;
                    b[2][2].setEnabled(false);
                    vib.vibrate(150);
                    c[2][2]=1;
                    counter+=1;
                    tv3.setText("O's turn");

                }
                else{
                    b[2][2].setBackgroundResource(R.drawable.wodoo);
                    bool=false;
                    b[2][2].setEnabled(false);
                    vib.vibrate(150);
                    c[2][2]=0;
                    counter+=1;
                    tv3.setText("X's turn");
                }
                if((c[0][0]==1 &&c[0][1]==1 && c[0][2]==1)|| (c[1][0]==1 &&c[1][1]==1 && c[1][2]==1)|| (c[2][0]==1 &&c[2][1]==1 && c[2][2]==1)|| (c[0][0]==1 &&c[1][0]==1 && c[2][0]==1)|| (c[0][1]==1 &&c[1][1]==1 && c[2][1]==1)|| (c[0][2]==1 &&c[1][2]==1 && c[2][2]==1)|| (c[0][2]==1 &&c[1][1]==1 && c[2][0]==1)|| (c[0][0]==1 &&c[1][1]==1 && c[2][2]==1))
                {
                    buttonEnabled();
                  alertForX();
                }
              else  if((c[0][0]==0 &&c[0][1]==0 && c[0][2]==0)|| (c[1][0]==0 &&c[1][1]==0 && c[1][2]==0)|| (c[2][0]==0 &&c[2][1]==0 && c[2][2]==0)|| (c[0][0]==0 &&c[1][0]==0 && c[2][0]==0)|| (c[0][1]==0 &&c[1][1]==0 && c[2][1]==0)|| (c[0][2]==0 &&c[1][2]==0 && c[2][2]==0)|| (c[0][2]==0 &&c[1][1]==0 && c[2][0]==0)|| (c[0][0]==0 &&c[1][1]==0 && c[2][2]==0))
                {
                    buttonEnabled();
                  alertForO();
                }
               else if (counter==9)
                {
                    alertForDraw();
                }
                }
        });

    }

    public boolean onCreateOptionsMenu(Menu menu) { //for on Screen Menu...
        MenuInflater mi = getMenuInflater();
        mi.inflate(R.menu.mainactivitymenu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {//for menu options...

        int mid = item.getItemId();
        if(mid==R.id.home)
        {
            Intent info = new Intent(this,HomePage.class);
            startActivity(info);
            finish();
        }
        if(mid == R.id.about){
            Intent info = new Intent(this,AboutUs.class);
            startActivity(info);
        }
        if(mid == R.id.help){
            Intent info = new Intent(this,HowToPlay.class);
            startActivity(info);
        }
        if (mid == R.id.exit)
        {
            AlertDialog.Builder b= new AlertDialog.Builder(MainActivity.this);
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

        if (mid == R.id.reset){
            Intent info = new Intent(MainActivity.this,MainActivity.class);
            startActivity(info);
            finish();
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onDestroy() {
        bool=false;
        counter=0;
        super.onDestroy();
    }

  }

