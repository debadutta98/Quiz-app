package com.quizeapp.quize;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    Button True_button;
    Button False_button;
    TextView t;
    TextView t1;
    TextView t3;
    ProgressBar p;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        True_button =(Button) findViewById(R.id.button);
        False_button=(Button) findViewById(R.id.button2);
        int arr[]={
                R.string.textview,
                R.string.q2,
                R.string.q3,
                R.string.q4,
                R.string.q5,
                R.string.q6,
                R.string.q7,
                R.string.q8,
                R.string.q9,
                R.string.q10
            };
        boolean ans[]={false,false,false,false,false,true,false,true,true,true};
        t=(TextView)findViewById(R.id.textView3);
        t1=(TextView)findViewById(R.id.textView4);
        t3=(TextView)findViewById(R.id.textView5);
        p=(ProgressBar)findViewById(R.id.progressBar);
        p.getProgressDrawable().setColorFilter(
                Color.YELLOW, android.graphics.PorterDuff.Mode.SRC_IN);
        final TrueFalse ob[]=new TrueFalse[10];
        for(int i=0;i<10;i++)
        {
            ob[i]=new TrueFalse(arr[i],ans[i]);
        }
        final int[] count = {0};
        final int[] c = {0};

        True_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(ob[count[0]].value==true)
                {
                    Toast massage=Toast.makeText(getApplicationContext(),"Right Answer",Toast.LENGTH_SHORT);
                    massage.show();
                    int t2=count[0]+1;
                    if(t2==10)
                    {
                        showme(c[0]);
                    }
                    if(t2<10){
                        t.setText(ob[t2].question_ID);
                         t1.setText("Q:"+(t2+1) +"/10");}
                    c[0]++;
                    t3.setText("Score:"+c[0]+"/10");
                    p.incrementProgressBy(10);
                }
                else
                {
                    Toast massage=Toast.makeText(getApplicationContext(),"Wrong Answer",Toast.LENGTH_SHORT);
                    massage.show();
                    int t2=count[0]+1;
                    if(t2==10)
                    {
                        showme(c[0]);
                    }
                    if(t2<10){
                        t.setText(ob[t2].question_ID);
                        t1.setText("Q:"+(t2+1)+"/10");}
                    t3.setText("Score:"+c[0]+"/10");
                }
                count[0]++;
            }
        });
        False_button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                if(ob[count[0]].value==false)
                {
                    Toast massage = Toast.makeText(getApplicationContext(), "Right Answer", Toast.LENGTH_SHORT);
                    massage.show();
                    int t2=count[0]+1;
                    if(t2==10)
                    {
                        showme(c[0]);
                    }
                    if(t2<10){
                        t.setText(ob[t2].question_ID);
                        t1.setText("Q:"+(t2+1)+"/10");}

                    c[0]++;
                    t3.setText("Score:"+c[0]+"/10");
                    p.incrementProgressBy(10);
                }
                else
                {
                    Toast massage=Toast.makeText(getApplicationContext(),"Wrong Answer",Toast.LENGTH_SHORT);
                    massage.show();
                    int t2=count[0]+1;
                    if(t2==10)
                    {
                        showme(c[0]);
                    }
                    if(t2<10){
                        t.setText(ob[t2].question_ID);
                        t1.setText("Q:"+(t2+1)+"/10");}
                    t3.setText("Score:"+c[0]+"/10");
                }
                count[0]++;
            }
        });

    }
    public void showme(int c)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Final Score");
        builder.setCancelable(false);
        builder.setMessage("Your score is score "+c+"/"+10);
        builder.setPositiveButton("Close", new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int id) {
            finish();
        }
    });
        builder.show();
    }
}