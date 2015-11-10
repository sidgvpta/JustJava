package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */

//Test Comment

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

        EditText name = (EditText) findViewById(R.id.enterName);
        String userName = name.getText().toString();

        displayMessage(createOrderSummary(price, userName));
    }

    private int calculatePrice() {
        int pricePerCoffee = 5;
        int priceWhippedCream = 1;
        int priceChocolate = 2;

        int totalPrice = (pricePerCoffee * quantity);

        if (hasWhippedCream() == true) {
            totalPrice = totalPrice + (priceWhippedCream * quantity);
        }
        if (hasChocolate() == true) {
            totalPrice = totalPrice + (priceChocolate * quantity);
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
        if (quantity == 20) {
            Toast.makeText(this, "Order limit reached", Toast.LENGTH_SHORT).show();
        }
        if (quantity < 20) {
            quantity++;
        }
        displayQuantity(quantity);
    }

    public void decrement(View view) {
        if (quantity > 0) {
            quantity--;
        }
        if (quantity == 0) {
            Toast.makeText(this, "Please select at least one cup of coffee", Toast.LENGTH_SHORT).show();
        }
        displayQuantity(quantity);
    }

    public String createOrderSummary(int price, String name) {
        String summary;
        String ynWhippedCream;
        String ynChocolate;

        if (hasWhippedCream() == true) {
            ynWhippedCream = "yes";
        }
        else {
            ynWhippedCream = "no";
        }

        if (hasChocolate() == true) {
            ynChocolate = "yes";
        }
        else {
            ynChocolate = "no";
        }

        if (quantity > 0) {
            summary = ("Name: " + name);
            summary += ("\nQuantity: " + quantity);
            summary += ("\nWhipped Cream?: " + ynWhippedCream);
            summary += ("\nChocolate?: " + ynChocolate);
            summary += ("\nTotal: $" + price);
            summary += "\nThank You!";
        }
        else {
            summary = ("Name: " + name);
            summary += ("\nQuantity: " + quantity);
            summary += ("\nTotal: $" + price);
        }
        return summary;
    }

    private boolean hasWhippedCream() {
        CheckBox whippedCream = (CheckBox) findViewById(R.id.whippedCream);
        if (whippedCream.isChecked() == true) {
            return true;
        }
        else {
            return false;
        }
    }

    private boolean hasChocolate() {
        CheckBox chocolate = (CheckBox) findViewById(R.id.chocolate);
        if (chocolate.isChecked() == true) {
            return true;
        }
        else {
            return false;
        }
    }

}