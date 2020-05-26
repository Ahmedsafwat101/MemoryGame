package com.example.memorygame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView timerTxtView,questionTxtView;
    TextView txtbut1, txtbut2,txtbut3,txtbut4;
    Button playAgain,Exit,scoreView;
    ImageButton but1,but2,but3,but4;
    ImageView questinimageView,timerimageView;
    CountDownTimer myTimer;
    int correctAnswerpostion;
    ArrayList<Integer>Answers= new ArrayList<>();
    int incorrectAnswer;
    int correctAnswer;
    int Score=0;
    int numberofQes=0;
    public void componentsGone(int var)
    {
        if(var==1) {
            // Game Controller
            playAgain = (Button) findViewById(R.id.butplayagain);
            playAgain.setVisibility(View.VISIBLE);
            Exit = (Button) findViewById(R.id.butexit);
            Exit.setVisibility(View.VISIBLE);
            scoreView = (Button) findViewById(R.id.scorebut);
            scoreView.setVisibility(View.VISIBLE);
            scoreView.setText(Integer.toString(Score)+"/"+Integer.toString(numberofQes)+"        Your Score");

            txtbut1 = (TextView) findViewById(R.id.textViewbut1);
            txtbut2 = (TextView) findViewById(R.id.textViewbut2);
            txtbut3 = (TextView) findViewById(R.id.textViewbut3);
            txtbut4 = (TextView) findViewById(R.id.textViewbut4);
            timerTxtView = (TextView) findViewById(R.id.textViewtimer);
            questionTxtView = (TextView) findViewById(R.id.textViewquestion);

            txtbut1.setVisibility(View.INVISIBLE);
            txtbut2.setVisibility(View.INVISIBLE);
            txtbut3.setVisibility(View.INVISIBLE);
            txtbut4.setVisibility(View.INVISIBLE);
            timerTxtView.setVisibility(View.INVISIBLE);
            questionTxtView.setVisibility(View.INVISIBLE);


            but1 = (ImageButton) findViewById(R.id.imageButton);
            but2 = (ImageButton) findViewById(R.id.imageButton2);
            but3 = (ImageButton) findViewById(R.id.imageButton3);
            but4 = (ImageButton) findViewById(R.id.imageButton4);

            but1.setVisibility(View.INVISIBLE);
            but2.setVisibility(View.INVISIBLE);
            but3.setVisibility(View.INVISIBLE);
            but4.setVisibility(View.INVISIBLE);

            questinimageView = (ImageView) findViewById(R.id.imageView);
            timerimageView = (ImageView) findViewById(R.id.imageView2);

            questinimageView.setVisibility(View.INVISIBLE);
            timerimageView.setVisibility(View.INVISIBLE);
        }
        else if (var==0)
        {
            // Game Controller
            playAgain = (Button) findViewById(R.id.butplayagain);
            playAgain.setVisibility(View.INVISIBLE);
            Exit = (Button) findViewById(R.id.butexit);
            Exit.setVisibility(View.INVISIBLE);
            scoreView = (Button) findViewById(R.id.scorebut);
            scoreView.setVisibility(View.INVISIBLE);

            txtbut1 = (TextView) findViewById(R.id.textViewbut1);
            txtbut2 = (TextView) findViewById(R.id.textViewbut2);
            txtbut3 = (TextView) findViewById(R.id.textViewbut3);
            txtbut4 = (TextView) findViewById(R.id.textViewbut4);
            timerTxtView = (TextView) findViewById(R.id.textViewtimer);
            questionTxtView = (TextView) findViewById(R.id.textViewquestion);

            txtbut1.setVisibility(View.VISIBLE);
            txtbut2.setVisibility(View.VISIBLE);
            txtbut3.setVisibility(View.VISIBLE);
            txtbut4.setVisibility(View.VISIBLE);
            timerTxtView.setVisibility(View.VISIBLE);
            questionTxtView.setVisibility(View.VISIBLE);


            but1 = (ImageButton) findViewById(R.id.imageButton);
            but2 = (ImageButton) findViewById(R.id.imageButton2);
            but3 = (ImageButton) findViewById(R.id.imageButton3);
            but4 = (ImageButton) findViewById(R.id.imageButton4);

            but1.setVisibility(View.VISIBLE);
            but2.setVisibility(View.VISIBLE);
            but3.setVisibility(View.VISIBLE);
            but4.setVisibility(View.VISIBLE);

            questinimageView = (ImageView) findViewById(R.id.imageView);
            timerimageView = (ImageView) findViewById(R.id.imageView2);

            questinimageView.setVisibility(View.VISIBLE);
            timerimageView.setVisibility(View.VISIBLE);
        }
    }
    public void playAgain(View view)
    {

        componentsGone(0);
        animation(-1000,1000);
        myTimer.start();
        generateQuestion();
        Score=0;
        numberofQes=0;
    }
    public void Exit(View view)
    {
        Intent i = new Intent(this, Main2Activity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        i.putExtra("Exit",true);
        startActivity(i);
    }
    public void generateQuestion()
    {
;
        Random rand= new Random();
        int num1=rand.nextInt(21); //btw 0 and 20
        int num2= rand.nextInt(21);//btw 0 and 20
        correctAnswer=num1+num2;
        String Sum= Integer.toString(num1)+" + "+Integer.toString(num2);
        TextView SumtxtView= (TextView) findViewById(R.id.textViewquestion);
        SumtxtView.setText(Sum);
        correctAnswerpostion= rand.nextInt(4); //btw 0 and 3
        Answers.clear();
        for(int i=0;i<4;i++)
        {
            if(i==correctAnswerpostion)
            {
                Answers.add(correctAnswer);
            }
            else
            {
                incorrectAnswer=rand.nextInt(41);
                while (incorrectAnswer==correctAnswer|| Answers.indexOf(incorrectAnswer)!=-1) {
                    incorrectAnswer = rand.nextInt(41);
                }
                Answers.add(incorrectAnswer);
            }
        }

        txtbut1.setText((Integer.toString(Answers.get(0))));
        txtbut2.setText((Integer.toString(Answers.get(1))));
        txtbut3.setText((Integer.toString(Answers.get(2))));
        txtbut4.setText((Integer.toString(Answers.get(3))));
    }
    public void buttClicked(View view)
    {
        final ImageView image= (ImageView) view;
        String tag= (String) view.getTag();
        //Log.i("Butt clicked", (String) view.getTag());
         image.setImageResource(R.drawable.para_normalsira);
         if(view.getTag().toString().equals(Integer.toString(correctAnswerpostion+1)))
         {
             Log.i("as", "correct ");
             //image.setImageResource(R.drawable.para_normalsira);
             Score++;
         }
         else
         {
             Log.i("msg", "wrong ");
         }
         generateQuestion();
         numberofQes++;
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                image.setImageResource(R.drawable.para_barajsira);
            }
        }, 300);

    }
    public  void animation(int var1,int var2)
    {
        playAgain = (Button) findViewById(R.id.butplayagain);
        Exit = (Button) findViewById(R.id.butexit);
        scoreView = (Button) findViewById(R.id.scorebut);

        scoreView.animate().translationYBy(var1).setDuration(var2);
        Exit.animate().translationYBy(var1).setDuration(var2*4);
        playAgain.animate().translationYBy(var1).setDuration(var2*2);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtbut1= (TextView)findViewById(R.id.textViewbut1);
        txtbut2= (TextView)findViewById(R.id.textViewbut2);
        txtbut3= (TextView)findViewById(R.id.textViewbut3);
        txtbut4= (TextView)findViewById(R.id.textViewbut4);


        animation(-1000,100);
        generateQuestion();


        myTimer= new CountDownTimer(30000,1000)
        {
            @Override
            public void onTick(long millisUntilFinished) {
                timerTxtView= (TextView)findViewById(R.id.textViewtimer);
                timerTxtView.setText(Integer.toString((int)millisUntilFinished/1000));
                //Log.i("seconds", Integer.toString((int)millisUntilFinished/1000));
            }

            @Override
            public void onFinish() {
                animation(1000,1000);
                componentsGone(1);
            }
        }.start();
    }
}
