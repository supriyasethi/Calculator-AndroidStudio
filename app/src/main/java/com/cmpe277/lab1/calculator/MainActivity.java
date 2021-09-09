package com.cmpe277.lab1.calculator;

import androidx.appcompat.app.AppCompatActivity;
import org.mariuszgromada.math.mxparser.*;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int calTxt1;
    int calTxt2;
    String callText="";
    String viewText = "";
    int finalCalI = 0;
    double finalCalD = 0;
    String splitTxt[];
    TextView txtView;
    TextView txtView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtView = findViewById(R.id.calText);
        txtView1 = findViewById(R.id.results);
    }

    public void updateText(String addText) {
        if(txtView.getText().toString().equals("EnterNum")) {
            txtView.setText(addText);
        } else {
            String oldstr = txtView.getText().toString();
            txtView.setText(oldstr + addText);
        }
    }

    public void clickButton(View view) {

        switch (view.getId()) {
            case (R.id.buttonClear): {
                txtView.setText("");
                txtView1.setText("");
                break;
            }
            case (R.id.button1): {
                updateText("1");
                break;
            }
            case (R.id.button2): {
                updateText("2");
                break;
            }
            case (R.id.button3): {
                updateText("3");
                break;
            }
            case (R.id.button4): {
                updateText("4");
                break;
            }
            case (R.id.button5): {
                updateText("5");
                break;
            }
            case (R.id.button6): {
                updateText("6");
                break;
            }
            case (R.id.button7): {
                updateText("7");
                break;
            }
            case (R.id.button8): {
                updateText("8");
                break;
            }
            case (R.id.button9): {
                updateText("9");
                break;
            }
            case (R.id.button0): {
                updateText("0");
                break;
            }
            case (R.id.buttonAdd): {
                updateText("+");
                break;
            }
            case (R.id.buttonDecimal): {
                updateText(".");
                break;
            }
            case (R.id.buttonSubtract): {
                updateText("-");
                break;
            }
            case (R.id.buttonMultiply): {
                updateText("×");
                break;
            }
            case (R.id.buttonDivide): {
                updateText("÷");
                break;
            }
            case (R.id.buttonBack): {
                String str =  txtView.getText().toString();
                int len = txtView.getText().toString().length();
                String subStr = str.substring(0, len-1);
                txtView.setText(subStr);
                break;
            }
            case (R.id.buttonBracket): {
                if(txtView.getText().toString().contains("(")) {
                    updateText(")");
                } else updateText("(");
                break;
            }
            case (R.id.buttonSign): {
                if(txtView.getText().toString().contains("+")) {
                    int len = txtView.getText().toString().length();
                    txtView.setText("-" + (txtView.getText().toString()).substring(1,len));
                } else if(txtView.getText().toString().contains("-")){
                    int len = txtView.getText().toString().length();
                    txtView.setText("+" + (txtView.getText().toString()).substring(1,len));
                } else {
                    int len = txtView.getText().toString().length();
                    txtView.setText("-" + (txtView.getText().toString()).substring(0,len));
                }
                break;
            }
            case (R.id.buttonEqual): {
                String userExp = txtView.getText().toString();
                userExp = userExp.replaceAll("÷", "/");
                userExp = userExp.replaceAll("×","*");
                Expression exp = new Expression(userExp);
                String result = String.valueOf(exp.calculate());
                txtView1.setText(result);
                break;
            }
        }

    }


}