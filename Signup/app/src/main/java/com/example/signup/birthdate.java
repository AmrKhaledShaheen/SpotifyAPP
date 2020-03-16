package com.example.signup;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Button;
import java.util.Calendar;
import android.content.Intent;

public class birthdate extends AppCompatActivity  {
//    Button bNext3;
//
//    private static final String TAG = "birthdate";
//
//    private TextView mDisplayDate;
//
//    private DatePickerDialog.OnDateSetListener mDateSetListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birthdate);
//        mDisplayDate = (TextView) findViewById(R.id.textView2);
//        bNext3 = (Button) findViewById(R.id.button2);
//        bNext3.setOnClickListener((View.OnClickListener) this);
//
//        mDisplayDate.setOnClickListener((View.OnClickListener) this);
//
//        Calendar cal = Calendar.getInstance();
//        int year = cal.get(Calendar.YEAR);
//        int month = cal.get(Calendar.MONTH);
//        int day = cal.get(Calendar.DAY_OF_MONTH);
//
//        DatePickerDialog dialog = new DatePickerDialog(
//                birthdate.this,
//                android.R.style.Widget_DeviceDefault_ActionBar_Solid,
//                mDateSetListener,
//                year, month, day);
//                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//                dialog.show();

//        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
//            @Override
//            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
//                month = month + 1;
//                Log.d(TAG, "onDateSet: mm/dd/yyy: " + month + "/" + day + "/" + year);
//
//                String date = month + "/" + day + "/" + year;
//                mDisplayDate.setText(date);
//            }
//        };

    }
}