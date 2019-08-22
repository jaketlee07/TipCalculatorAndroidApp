package com.example.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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
        final TextView tip = (TextView) findViewById(R.id.tip);

        serviceRating.setOnClickListener(new View.onClickListener()
        {
            public void onClick(View v)
            {
                tipPercent.setText("" +serviceRating.getRating()*4);
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

        tip.setText("TIP: $" + df.format(tipAmount) + "\nTOTAL: $"+ df.format(billTotal));
    }




}
