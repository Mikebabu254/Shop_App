package com.example.assignment3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button processLoan;
    EditText amountApplied;
    TextView interest, payableAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        processLoan = findViewById(R.id.processLoanBtn);
        processLoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    CalculateInterest();
                    AmountPayable();
                }catch (Exception e){
                    Toast.makeText(MainActivity.this, "input a value", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    public void CalculateInterest(){

        amountApplied = findViewById(R.id.amountApplied);
        interest = findViewById(R.id.interestPayed);


        String amount = amountApplied.getText().toString();
        float principle = Float.parseFloat(amount);


        float i = (principle * 0.30F * 2)/100 ;
        interest.setText("interest is ksh " + i);
    }

    public void AmountPayable(){
        payableAmount = findViewById(R.id.paybleAmount);
        amountApplied = findViewById(R.id.amountApplied);
        interest = findViewById(R.id.interestPayed);

        String amount = amountApplied.getText().toString();
        float principle = Float.parseFloat(amount);
        //float principle = Float.parseFloat(amount);

        float i = (principle * 0.30F * 2 )/100 ;

        float a = principle + i;
        payableAmount.setText("payable amount is ksh "+ a );
    }
}