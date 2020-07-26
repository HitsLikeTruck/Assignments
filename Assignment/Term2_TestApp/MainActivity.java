package com.example.term2_testapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int DoughnutQuantity;
    int FroYoQuantity;
    int Price;

    public EditText name;
    public TextView DoughnutAmount;
    public TextView FroYoAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.Name);
        DoughnutAmount = findViewById(R.id.DoughnutAmount);
        FroYoAmount = findViewById(R.id.FroYoAmount);

        Button submitOrder = findViewById(R.id.SubmitOrder);
        submitOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendEmail();
            }
        });
    }

    public void sendEmail(){
        String clientName = name.getText().toString();

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL," ");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Term2_TestApp order for: " + clientName);
        intent.putExtra(Intent.EXTRA_TEXT, OrderSummary() );

        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent,"Choose an email client"));
    }

    public void DoughnutAmount (int view){}
    public void FroYoAmount (int view){}

    public void DoughnutIncrement (View view){
        DoughnutQuantity+=1;
        DoughnutAmount(DoughnutQuantity);
        displayDoughnutQuantity(DoughnutQuantity);
    }

    public void DoughnutDecrement (View view){
        DoughnutQuantity-=1;
        DoughnutAmount(DoughnutQuantity);

        if(DoughnutQuantity<0){
            DoughnutQuantity=0;
        }
        displayDoughnutQuantity(DoughnutQuantity);
    }

    public void FroYoIncrement(View view){
        FroYoQuantity+=1;
        FroYoAmount(FroYoQuantity);
        displayFroYoQuantity(FroYoQuantity);
    }

    public void FroYoDecrement(View view){
        FroYoQuantity-=1;
        FroYoAmount(FroYoQuantity);
        displayFroYoQuantity(FroYoQuantity);

        if(FroYoQuantity<0){
            FroYoQuantity=0;
        }
        displayFroYoQuantity(FroYoQuantity);
    }

    public void displayDoughnutQuantity(int DoughnutQuantity){
        TextView DoughnutAmountTextView = (TextView) findViewById(R.id.DoughnutAmount);
        DoughnutAmountTextView.setText("" + DoughnutQuantity);
    }
    public void displayFroYoQuantity(int FroYoQuantity){
        TextView FroYoAmountTextView = (TextView) findViewById(R.id.FroYoAmount);
        FroYoAmountTextView.setText("" + FroYoQuantity);
    }

    public int TotalAmount() {
        int DoughnutPrice = DoughnutQuantity * 10;
        int FroyoPrice = FroYoQuantity* 12;

        if(Price == 0){
            Price = DoughnutPrice + FroyoPrice;
            return Price;
        }
        return TotalAmount();
    }

    public String OrderSummary(){
        String clientName = name.getText().toString();

        String message = "Name: " + clientName;
               message += "\nAmount of doughnuts: " + DoughnutQuantity;
               message += "\nAmount of FroYo's: " + FroYoQuantity;
               message += "\nTotal: R" + TotalAmount();
               message += "\nThank you for your purchase!";

        return message;
    }

}
