package com.example.android.takehomelesson06_stephaniey;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.text.NumberFormat;

public class PaymentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        Intent intent = getIntent();

        setTitle("Your Receipt");

        float amt = intent.getFloatExtra(Keys.AMT_KEY, 0f);
        float tax = intent.getFloatExtra(Keys.TAX_KEY, 0f);
        float tip = intent.getFloatExtra(Keys.TIP_KEY, 0f);

        float total = amt + (amt * tax) + (amt * tip);

        displayPaymentInfo(amt, tax, tip, total);

    }

    private void displayPaymentInfo(float amt, float tax, float tip, float total) {

        NumberFormat dollarFmt = NumberFormat.getInstance();
        dollarFmt.setMinimumFractionDigits(2);
        dollarFmt.setMaximumFractionDigits(2);
        NumberFormat percentFmt = NumberFormat.getInstance();
        percentFmt.setMinimumFractionDigits(1);
        percentFmt.setMaximumFractionDigits(2);

        String paymentText = "Total: " + dollarFmt.format(amt)
                + "\nSales Tax: " + percentFmt.format(tax * 100)
                + "\nTip: " + percentFmt.format(tip * 100)
                + "\nGrand Total: " + dollarFmt.format(total);

        TextView paymentDisplay = (TextView) findViewById(R.id.payment_display);
        paymentDisplay.setText(paymentText);
    }
}
