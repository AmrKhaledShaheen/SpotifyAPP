package com.example.signup;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Button;

import java.time.Month;
import java.time.Year;
import java.util.Calendar;
import java.util.Date;

import android.content.Intent;
import android.widget.Toast;


/**
 * The third activity in signup process
 * these tutorial help us to use datapicker
 * https://www.youtube.com/watch?v=hwe1abDO2Ag
 * @version 1.0
 */
public class birthdate extends AppCompatActivity  {
    /**
     * y integer used to check if age is able to use the application or not
     */
    int y=0;

    /**
     * gets called by button next
     * if(y==1)
     * opens next activity
     * @see Gender
     * if(y==0)
     * allows a message to be visible and make button disabled
     * @param view
     */
    public void NexttoGender(View view)
{
    TextView mesg= (TextView)findViewById(R.id.textView6);
    Button buttonNext=(Button)findViewById(R.id.button2);
    Animation animation = AnimationUtils.loadAnimation(this,R.anim.animationscalebutton);
    buttonNext.startAnimation(animation);
    if(y==0)
    {
        mesg.setVisibility(View.VISIBLE);
        buttonNext.setEnabled(false);
    }
    if(y==1)
    {
        Intent intent = new Intent(this, Gender.class);
        startActivity(intent);
    }
}

    /**
     * creates DatePicker to pick date
     * create Calender up to date
     * checks if age is bigger than the minimum or not
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birthdate);
        DatePicker datePicker = (DatePicker) findViewById(R.id.datepicker);
        final Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());

        datePicker.init(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), new DatePicker.OnDateChangedListener() {

            @Override
            public void onDateChanged(DatePicker datePicker, int yearUser, int monthUser, int dayOfMonthUser) {
                Log.d("Date", "Year=" + yearUser + " Month=" + (monthUser + 1) + " day=" + dayOfMonthUser);
               int  yearNumber=calendar.get(Calendar.YEAR);
               int monthNumber=calendar.get(Calendar.MONTH);
               int dayNumber=calendar.get(Calendar.DAY_OF_MONTH);
               int yearResult= yearNumber-yearUser;
               int monthResult=monthNumber-monthUser;
               int dayResult=dayNumber-dayOfMonthUser;
                TextView mesg= (TextView)findViewById(R.id.textView6);
                Button buttonNext=(Button)findViewById(R.id.button2);
               if(yearResult>21)
               {
                   y=1;
                   mesg.setVisibility(View.INVISIBLE);
                   buttonNext.setEnabled(true);
               }
               if(yearResult<21)
               {
                    y=0;
                   mesg.setVisibility(View.VISIBLE);
                   buttonNext.setEnabled(false);
               }
               if(yearResult==21)
                {
                    if(monthResult>0)
                    {
                        y=1;
                        mesg.setVisibility(View.INVISIBLE);
                        buttonNext.setEnabled(true);
                    }
                    if(monthResult<0)
                    {
                        y=0;
                        mesg.setVisibility(View.VISIBLE);
                        buttonNext.setEnabled(false);
                    }
                    if(monthResult==0)
                    {
                        if(dayResult>=0)
                        {
                            y=1;
                            mesg.setVisibility(View.INVISIBLE);
                            buttonNext.setEnabled(true);
                        }
                        if(dayResult<0)
                        {
                            y=0;
                            mesg.setVisibility(View.VISIBLE);
                            buttonNext.setEnabled(false);
                        }

                    }
                }


            }
        });
    }
}