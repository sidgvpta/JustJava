package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends ActionBarActivity {

    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        /**int pricePerCoffee = 5;*/
        int price = calculatePrice();
        displayMessage(createOrderSummary(price));
    }

    private int calculatePrice() {
        int pricePerCoffee = 5;
        int priceOfWhippedCream = 1;
        int totalPrice = (pricePerCoffee * quantity);
        if (isChecked() == true) {
            totalPrice = totalPrice + (priceOfWhippedCream * quantity);
        }
        return totalPrice;
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

    public void increment(View view) {
        quantity++;
        displayQuantity(quantity);
    }

    public void decrement(View view) {
        if (quantity > 0) {
            quantity--;
        }
        displayQuantity(quantity);
    }

    public String createOrderSummary(int price) {
        String summary;
        String whippedCream;

        if (isChecked() == true) {
            whippedCream = "yes";
        }
        else {
            whippedCream = "no";
        }

        if (quantity > 0) {
            summary = ("Name: Sid Gupta" + "\nQuantity: " + quantity + "\nWhipped Cream?: " + whippedCream + "\nTotal: $" + price + "\nThank You!");
        }
        else {
            summary = ("Name: Sid Gupta" + "\nQuantity: " + quantity + "\nTotal: $" + price);
        }
        return summary;
    }

    private boolean isChecked() {
        CheckBox whippedCream = (CheckBox) findViewById(R.id.toppingsCheckBox);
        if (whippedCream.isChecked() == true) {
            return true;
        }
        else {
            return false;
        }
    }

}