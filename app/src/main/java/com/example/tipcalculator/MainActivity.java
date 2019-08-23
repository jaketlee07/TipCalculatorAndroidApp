package com.example.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RatingBar serviceRating = (RatingBar) findViewById(R.id.serviceRating);
        final EditText tipPercent = (EditText) findViewById(R.id.tipPercent);

        serviceRating.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean b)
            {
                tipPercent.setText("" +(int)rating*4);
                Log.i("Testing stars", "Testing stars: " + (int)rating);
            }
        });
    }

    public void calcTip(View v)
    {
        EditText billCost = (EditText) findViewById(R.id.billCost);
        EditText tipPercent = (EditText) findViewById(R.id.tipPercent);
        TextView tip = (TextView) findViewById(R.id.tip);

        int bill = Integer.parseInt(billCost.getText().toString());
        int percent = Integer.parseInt(tipPercent.getText().toString());

        DecimalFormat df = new DecimalFormat("#.00");
        double tipAmount = bill * (percent*.01);
        double billTotal = bill + tipAmount;
        Log.i("Testing calc button", "Testing button");

        tip.setText("TIP: $" + df.format(tipAmount) + "\nTOTAL: $"+ df.format(billTotal));
    }




}
