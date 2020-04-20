package com.example.aniket.brainteaser;

import android.os.CountDownTimer;
import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button goButton , button1 , button2 , button3 , button4 , playAgainButton;
    TextView scoreTextView , timerTextView , sumTextView , resultTextView;
    CountDownTimer countDownTimer;
    ArrayList<Integer> answers = new ArrayList<Integer>();
    int locationOfCorrectAnswer;
    int score = 0;
    int numberOfQuestions;


//    public int generateRandomNumber()
//    {
//        Random r = new Random();
//        int a = r.nextInt(50-0) + 0;
//        return a;
//    }

    public void startGame(View view)
    {
        score = 0;
        numberOfQuestions = 0;
        locationOfCorrectAnswer = 0;
        scoreTextView.setText(Integer.toString(score) + "/" + Integer.toString(numberOfQuestions));
        goButton.setVisibility(View.INVISIBLE);
        button1.setVisibility(View.VISIBLE);
        button2.setVisibility(View.VISIBLE);
        button3.setVisibility(View.VISIBLE);
        button4.setVisibility(View.VISIBLE);
        scoreTextView.setVisibility(View.VISIBLE);
        sumTextView.setVisibility(View.VISIBLE);
        timerTextView.setVisibility(View.VISIBLE);
        playAgainButton.setVisibility(View.VISIBLE);
        newQuestion();
    }

    public void checkAnswer(View view)
    {
        numberOfQuestions++;
        if(Integer.toString(locationOfCorrectAnswer + 1).equals(view.getTag().toString()))
        {
            Log.i("Correct" , "You got it!");
            resultTextView.setText("Correct!");
            resultTextView.setVisibility(View.VISIBLE);
            score++;
        }
        else
        {
            Log.i("Incorrect" , ":/");
            resultTextView.setText("Wrong :(");
            resultTextView.setVisibility(View.VISIBLE);
        }
        scoreTextView.setText(Integer.toString(score) + "/" + Integer.toString(numberOfQuestions));
        countDownTimer.cancel();
        newQuestion();
    }

    public void updateTimer(int seconds)
    {
        timerTextView.setText(Integer.toString(seconds));
    }

    public void newQuestion()
    {
        if(numberOfQuestions == 20)
        {
            resultTextView.setVisibility(View.VISIBLE);
            resultTextView.setText("Done");
            button1.setVisibility(View.INVISIBLE);
            button2.setVisibility(View.INVISIBLE);
            button3.setVisibility(View.INVISIBLE);
            button4.setVisibility(View.INVISIBLE);
            scoreTextView.setVisibility(View.INVISIBLE);
            timerTextView.setVisibility(View.INVISIBLE);
            sumTextView.setVisibility(View.INVISIBLE);

        }
        else
        {
            resultTextView.setVisibility(View.INVISIBLE);
            Random rand = new Random();
            int a = rand.nextInt(50);
            int b = rand.nextInt(50);
            sumTextView.setText(Integer.toString(a) + "+" + Integer.toString(b));
            locationOfCorrectAnswer = rand.nextInt(4);
            answers.clear();
            for (int j=0;j<4;j++)
            {
                if(j == locationOfCorrectAnswer)
                    answers.add(a + b);
                else {
                    int wrongAnswer = rand.nextInt(99);
                    while(wrongAnswer == a+b)
                    {
                        wrongAnswer = rand.nextInt(99);
                    }
                    answers.add(wrongAnswer);

                }
            }
            button1.setText(Integer.toString(answers.get(0)));
            button2.setText(Integer.toString(answers.get(1)));
            button3.setText(Integer.toString(answers.get(2)));
            button4.setText(Integer.toString(answers.get(3)));
            countDownTimer = new CountDownTimer(15000 + 100 , 1000) {
                @Override
                public void onTick(long l) {
                    updateTimer((int)l/1000);
                }

                @Override
                public void onFinish() {
                    numberOfQuestions++;
                    scoreTextView.setText(Integer.toString(score) + "/" + Integer.toString(numberOfQuestions));
                    newQuestion();

                }
            }.start();
        }

    }

    public void playAgain(View view)
    {
        goButton.setVisibility(View.VISIBLE);
        button1.setVisibility(View.INVISIBLE);
        button2.setVisibility(View.INVISIBLE);
        button3.setVisibility(View.INVISIBLE);
        button4.setVisibility(View.INVISIBLE);
        scoreTextView.setVisibility(View.INVISIBLE);
        sumTextView.setVisibility(View.INVISIBLE);
        timerTextView.setVisibility(View.INVISIBLE);
        resultTextView.setVisibility(View.INVISIBLE);
        playAgainButton.setVisibility(View.INVISIBLE);
        countDownTimer.cancel();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        goButton = findViewById(R.id.goButton);
        goButton.setVisibility(View.VISIBLE);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        playAgainButton = findViewById(R.id.playAgainButton);
        scoreTextView = findViewById(R.id.scoreTextView);
        sumTextView = findViewById(R.id.sumTextView);
        timerTextView = findViewById(R.id.timerTextView);
        resultTextView = findViewById(R.id.resultTextView);
        button1.setVisibility(View.INVISIBLE);
        button2.setVisibility(View.INVISIBLE);
        button3.setVisibility(View.INVISIBLE);
        button4.setVisibility(View.INVISIBLE);
        scoreTextView.setVisibility(View.INVISIBLE);
        sumTextView.setVisibility(View.INVISIBLE);
        timerTextView.setVisibility(View.INVISIBLE);
        resultTextView.setVisibility(View.INVISIBLE);
        playAgainButton.setVisibility(View.INVISIBLE);


    }
}
