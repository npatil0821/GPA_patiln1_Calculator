package edu.montclair.gpa_patiln1_calculator;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView gpa; //used to output gpa
    Button button; //used to take user input for submission
    EditText grade1, grade2, grade3, grade4, grade5; //used to hold values for grades

    //toast parameters
    Context context;
    int duration = Toast.LENGTH_SHORT;
    CharSequence err_msg = "Five grades must be entered.";
    //outputs toast informing user fields are empty
    Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //gets access to necessary views
        button=(Button)findViewById(R.id.button);
        grade1 = (EditText)findViewById(R.id.grade1);
        grade2 = (EditText)findViewById(R.id.grade2);
        grade3 = (EditText)findViewById(R.id.grade3);
        grade4 = (EditText)findViewById(R.id.grade4);
        grade5 = (EditText)findViewById(R.id.grade5);
        gpa = (TextView)findViewById(R.id.gpa);

        //checks if text in first input has been changed
        grade1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            //changes button text to "compute gpa" if "clear"
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (button.getText().toString() == "Clear")
                    button.setText("Compute GPA");
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        //checks if text in second input has been changed
        grade2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            //changes button text to "compute gpa" if "clear"
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (button.getText().toString() == "Clear")
                    button.setText("Compute GPA");
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        //checks if text in third input has been changed
        grade3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            //changes button text to "compute gpa" if "clear"
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (button.getText().toString() == "Clear")
                    button.setText("Compute GPA");
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        //checks if text in fourth input has been changed
        grade4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            //changes button text to "compute gpa" if "clear"
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (button.getText().toString() == "Clear")
                    button.setText("Compute GPA");
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        //checks if text in fifth input has been changed
        grade5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            //changes button text to "compute gpa" if "clear"
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (button.getText().toString() == "Clear")
                    button.setText("Compute GPA");
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        //waits for button to be pressed
        button.setOnClickListener(new View.OnClickListener() {

            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            public void onClick(View view) {
                //checks if any fields are empty
                if (grade1.getText().toString().isEmpty() || grade2.getText().toString().isEmpty() || grade3.getText().toString().isEmpty() || grade4.getText().toString().isEmpty() || grade5.getText().toString().isEmpty()) {
                    context = getApplicationContext();
                    err_msg = "Five grades must be entered.";

                    //outputs toast informing user fields are empty
                    toast = Toast.makeText(context, err_msg, duration);
                    toast.show();

                    //changes the color of input fields if they were left blank
                    if (grade1.getText().toString().isEmpty()) {
                        grade1.setBackgroundTintList(context.getResources().getColorStateList(R.color.red));
                    }

                    if (grade2.getText().toString().isEmpty()) {
                        grade2.setBackgroundTintList(context.getResources().getColorStateList(R.color.red));
                    }

                    if (grade3.getText().toString().isEmpty()) {
                        grade3.setBackgroundTintList(context.getResources().getColorStateList(R.color.red));
                    }

                    if (grade4.getText().toString().isEmpty()) {
                        grade4.setBackgroundTintList(context.getResources().getColorStateList(R.color.red));
                    }

                    if (grade5.getText().toString().isEmpty()) {
                        grade5.setBackgroundTintList(context.getResources().getColorStateList(R.color.red));
                    }

                    return;
                }

                //calculates gpa if not already calculated
                else if (button.getText().toString() != "Clear") {
                    context = getApplicationContext();

                    //changes color of inputs back to black
                    grade1.setBackgroundTintList(context.getResources().getColorStateList(R.color.black));
                    grade2.setBackgroundTintList(context.getResources().getColorStateList(R.color.black));
                    grade3.setBackgroundTintList(context.getResources().getColorStateList(R.color.black));
                    grade4.setBackgroundTintList(context.getResources().getColorStateList(R.color.black));
                    grade5.setBackgroundTintList(context.getResources().getColorStateList(R.color.black));
                    calc_gpa();

                    //changes text on button to allow user to clear inputs
                    button.setText("Clear");
                }

                else {
                    //clears all inputs
                    grade1.setText("");
                    grade2.setText("");
                    grade3.setText("");
                    grade4.setText("");
                    grade5.setText("");

                    //changes text on button to allow user to calculate gpa
                    button.setText("Compute GPA");
                }
            }
        });
    }

    //calculates gpa and outputs it to gpa view
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void calc_gpa() {
        double avg, g1, g2, g3, g4, g5; //used to hold all grades and their average
        boolean isInv = false;

        //takes input from all grade input fields
        g1 = Double.parseDouble(grade1.getText().toString());
        g2 = Double.parseDouble(grade2.getText().toString());
        g3 = Double.parseDouble(grade3.getText().toString());
        g4 = Double.parseDouble(grade4.getText().toString());
        g5 = Double.parseDouble(grade5.getText().toString());

        //checks if any grades are above 100 or below 0
        if (g1 < 0 || g1 > 100) {
            grade1.setBackgroundTintList(context.getResources().getColorStateList(R.color.red));
            isInv = true;
        }

        if (g2 < 0 || g2 > 100) {
            grade2.setBackgroundTintList(context.getResources().getColorStateList(R.color.red));
            isInv = true;
        }

        if (g3 < 0 || g3 > 100) {
            grade3.setBackgroundTintList(context.getResources().getColorStateList(R.color.red));
            isInv = true;
        }

        if (g4 < 0 || g4 > 100) {
            grade4.setBackgroundTintList(context.getResources().getColorStateList(R.color.red));
            isInv = true;
        }

        if (g5 < 0 || g5 > 100) {
            grade5.setBackgroundTintList(context.getResources().getColorStateList(R.color.red));
            isInv = true;
        }

        //outputs toast to tell user an input is invalid
        if (isInv) {
            context = getApplicationContext();
            err_msg = "Invalid input.";
            toast = Toast.makeText(context, err_msg, duration);
            toast.show();

            return;
        }
        //calculates average
        avg = (g1 + g2 + g3 + g4 + g5) / 5;

        //outputs average to gpa view
        gpa.setText(Double.toString(avg));

        //changes gpa color to red if 60 or below
        if (avg <= 60)
            gpa.setTextColor(context.getResources().getColorStateList(R.color.red));

        //changes gpa color to yellow if between 60 and 80
        else if (avg > 60 && avg <= 79) {
            gpa.setTextColor(context.getResources().getColorStateList(R.color.yellow));
        }

        //changes gpa color to green if 80 or above
        else
            gpa.setTextColor(context.getResources().getColorStateList(R.color.green));
    }
}