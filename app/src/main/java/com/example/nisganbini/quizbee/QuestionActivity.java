package com.example.nisganbini.quizbee;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class QuestionActivity extends AppCompatActivity {
    public  static String TAG = QuestionActivity.class.getSimpleName();
    TextView tv;
    Button submitbutton, quitbutton;
    int flag=0;

    RadioGroup radio_g;
    RadioButton rb1,rb2,rb3,rb4;



    String questions[] = {
            "What is the maximum possible length of an identifier?",
            "What will be the output of the following Python statement?",
            "Which of the following is not a keyword?",
            "All keywords in Python are in _________",
            "Which one of these is floor division?",
            " What is the answer to this expression, 22 % 3 is?",
            " Which of the following commands will create a list?",
            " What is the output when we execute list(“hello”)?",
            "Suppose list1 is [3, 5, 25, 1, 3], what is min(list1)?",
            "Suppose list1 is [4, 2, 2, 4, 5, 2, 1, 0], Which of the following is correct syntax for slicing operation?"
    };
    String answers[] = {"main method","<=","this","interface","public","import pkg.*","None of the mentioned","java","equals()","int"};
    String opt[] = {
            "31 characters","63 characters","79 characters","none of the mentioned",
            "a","bc","bca","abc",
            "eval","assert","nonlocal","pass",
            "Lowercase","Uppercase","Capitalized","none of the mentioned",
            "/","//","%","None of the mentioned",
            "7","1","0","5",
            "list1 = list()"," list1 = []","list1 = list([1, 2, 3])","All of the mentioned",
            " [‘h’, ‘e’, ‘l’, ‘l’, ‘o’]"," [‘hello’]","[‘llo’]","[‘olleh’]",
            "3","5","25","1",
            "print(list1[0])","print(list1[:2])","print(list1[:-2])","All of the mentioned"
    };

    public static int marks=0,correct=0,wrong=0,counter=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG,"Question Display Activity created");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        final TextView  textView1= (TextView) findViewById(R.id.textView);

        final TextView score = (TextView)findViewById(R.id.textView4);
        TextView textView=(TextView)findViewById(R.id.DispName);
        Intent intent = getIntent();
        String name= intent.getStringExtra("myname");


        if (name.trim().equals(""))
            textView.setText("Hello User");
        else
            textView.setText("Hello " + name);


        submitbutton=(Button)findViewById(R.id.button3);
        quitbutton=(Button)findViewById(R.id.buttonquit);
        tv=(TextView) findViewById(R.id.tvque);

        radio_g=(RadioGroup)findViewById(R.id.answersgrp);
        rb1=(RadioButton)findViewById(R.id.radioButton);
        rb2=(RadioButton)findViewById(R.id.radioButton2);
        rb3=(RadioButton)findViewById(R.id.radioButton3);
        rb4=(RadioButton)findViewById(R.id.radioButton4);
        tv.setText(questions[flag]);
        rb1.setText(opt[0]);
        rb2.setText(opt[1]);
        rb3.setText(opt[2]);
        rb4.setText(opt[3]);
        submitbutton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Log.w(TAG,"Sub,it button clicked");

                if(radio_g.getCheckedRadioButtonId()==-1)
                {
                    Toast.makeText(getApplicationContext(), "Please select one choice", Toast.LENGTH_SHORT).show();
                    return;
                }
                RadioButton uans = (RadioButton) findViewById(radio_g.getCheckedRadioButtonId());
                String ansText = uans.getText().toString();

                if(ansText.equals(answers[flag])) {
                    correct++;
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                }
                else {
                    wrong++;
                    Toast.makeText(getApplicationContext(), "Wrong", Toast.LENGTH_SHORT).show();
                }

                flag++;

                if (score != null)
                    score.setText(""+correct);

                if(flag<questions.length)
                {
                    tv.setText(questions[flag]);
                    rb1.setText(opt[flag*4]);
                    rb2.setText(opt[flag*4 +1]);
                    rb3.setText(opt[flag*4 +2]);
                    rb4.setText(opt[flag*4 +3]);
                }
                else
                {
                    marks=correct;
                    Intent in = new Intent(getApplicationContext(),ResultActivity.class);
                    startActivity(in);

                }
                radio_g.clearCheck();
            }
        });

        quitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e(TAG,"Exiting button clicked");
                Intent intent=new Intent(getApplicationContext(),ResultActivity.class);
                startActivity(intent);
            }
        });

    }

}