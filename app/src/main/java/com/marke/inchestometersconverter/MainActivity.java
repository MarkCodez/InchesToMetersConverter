package com.marke.inchestometersconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText inchesText;
    private Button convertButton;
    private TextView metersResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // link views by id
        findViews();
        // convert when button is clicked
        conversionAction();
    }

    private void findViews() {
        inchesText = findViewById(R.id.edit_text_inches);
        convertButton = findViewById(R.id.button_convert);
        metersResult = findViewById(R.id.text_view_result);
    }

    private void conversionAction() {
        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // retaining information entered into text box
                String inchesT = inchesText.getText().toString();

                if (inchesT.isEmpty()) {
                    // prompt user to enter value in inches field
                    Toast.makeText(MainActivity.this, "Inches field is empty. Try again...", Toast.LENGTH_SHORT).show();
                    conversionAction();
                } else {
                    // convert inches to meters
                    int inches = Integer.parseInt(inchesT);
                    double meters = inches / (39.37);

                    // display using correct formatting
                    DecimalFormat threeDecimals = new DecimalFormat("0.000");
                    String metersTextResult = threeDecimals.format(meters);

                    metersResult.setText(metersTextResult + " meters!");
                }
            }
        });
    }

}