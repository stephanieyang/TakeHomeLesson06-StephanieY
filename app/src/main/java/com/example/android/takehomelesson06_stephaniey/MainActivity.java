package com.example.android.takehomelesson06_stephaniey;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calculatePayment(View view) {
        EditText mainAmtText = (EditText) findViewById(R.id.amt_main);
        EditText taxAmtText = (EditText) findViewById(R.id.amt_tax);
        EditText tipAmtText = (EditText) findViewById(R.id.amt_tip);

        launchPaymentActivity(Float.parseFloat(mainAmtText.getText().toString()),
                Float.parseFloat(taxAmtText.getText().toString()),
                Float.parseFloat(tipAmtText.getText().toString()));
    }

    private void launchPaymentActivity(float amt, float tax, float tip) {
        Intent intent = new Intent(this, PaymentActivity.class);
        intent.putExtra(Keys.AMT_KEY, amt);
        intent.putExtra(Keys.TAX_KEY, tax);
        intent.putExtra(Keys.TIP_KEY, tip);
        startActivity(intent);

    }
}
