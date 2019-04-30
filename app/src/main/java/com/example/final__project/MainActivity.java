package com.example.final__project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button button0;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;
    Button buttonSin;
    Button buttonCos;
    Button buttonTan;
    Button buttonASin;
    Button buttonACos;
    Button buttonATan;
    Button buttonP;
    Button buttonM;
    Button buttonMul;
    Button buttonDiv;
    Button buttonInv;
    Button buttonLog;
    Button buttonLN;
    Button buttonE;
    Button buttonPW;
    Button buttonFac;
    Button buttonPI;
    Button buttonPoint;
    Button buttonSqrt;
    Button buttonRes;
    Button buttonCl;
    Button buttonBack;
    Button buttonOpen;
    Button buttonClose;
    Button buttonMod;
    TextView equations;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button0 = (Button)findViewById(R.id.button0);
        button0.setOnClickListener(this);
        button1 = (Button)findViewById(R.id.button1);
        button1.setOnClickListener(this);
        button2 = (Button)findViewById(R.id.button2);
        button2.setOnClickListener(this);
        button3 = (Button)findViewById(R.id.button3);
        button3.setOnClickListener(this);
        button4 = (Button)findViewById(R.id.button4);
        button4.setOnClickListener(this);
        button5 = (Button)findViewById(R.id.button5);
        button5.setOnClickListener(this);
        button6 = (Button)findViewById(R.id.button6);
        button6.setOnClickListener(this);
        button7 = (Button)findViewById(R.id.button7);
        button7.setOnClickListener(this);
        button8 = (Button)findViewById(R.id.button8);
        button8.setOnClickListener(this);
        button9 = (Button)findViewById(R.id.button9);
        button9.setOnClickListener(this);
        buttonSin = (Button)findViewById(R.id.buttonSin);
        buttonSin.setOnClickListener(this);
        buttonCos = (Button)findViewById(R.id.buttonCos);
        buttonCos.setOnClickListener(this);
        buttonTan = (Button)findViewById(R.id.buttonTan);
        buttonTan.setOnClickListener(this);
        buttonASin = (Button)findViewById(R.id.buttonASin);
        buttonASin.setOnClickListener(this);
        buttonACos = (Button)findViewById(R.id.buttonACos);
        buttonACos.setOnClickListener(this);
        buttonATan = (Button)findViewById(R.id.buttonATan);
        buttonATan.setOnClickListener(this);
        buttonP = (Button)findViewById(R.id.buttonP);
        buttonP.setOnClickListener(this);
        buttonM = (Button)findViewById(R.id.buttonM);
        buttonM.setOnClickListener(this);
        buttonMul = (Button)findViewById(R.id.buttonMul);
        buttonMul.setOnClickListener(this);
        buttonDiv = (Button)findViewById(R.id.buttonDiv);
        buttonDiv.setOnClickListener(this);
        buttonInv = (Button)findViewById(R.id.buttonInv);
        buttonInv.setOnClickListener(this);
        buttonLog = (Button)findViewById(R.id.buttonLog);
        buttonLog.setOnClickListener(this);
        buttonLN = (Button)findViewById(R.id.buttonLN);
        buttonLN.setOnClickListener(this);
        buttonE = (Button)findViewById(R.id.buttonE);
        buttonE.setOnClickListener(this);
        buttonPW = (Button)findViewById(R.id.buttonPW);
        buttonPW.setOnClickListener(this);
        buttonFac  = (Button)findViewById(R.id.buttonFac);
        buttonFac.setOnClickListener(this);
        buttonPI = (Button)findViewById(R.id.buttonPI);
        buttonPI.setOnClickListener(this);
        buttonPoint = (Button)findViewById(R.id.buttonPoint);
        buttonPoint.setOnClickListener(this);
        buttonSqrt = (Button)findViewById(R.id.buttonSqrt);
        buttonSqrt.setOnClickListener(this);
        buttonRes = (Button)findViewById(R.id.buttonRes);
        buttonRes.setOnClickListener(this);
        buttonCl = (Button)findViewById(R.id.buttonCl);
        buttonCl.setOnClickListener(this);
        buttonBack = (Button)findViewById(R.id.buttonBack);
        buttonBack.setOnClickListener(this);
        buttonOpen  = (Button)findViewById(R.id.buttonOpen);
        buttonOpen.setOnClickListener(this);
        buttonClose = (Button)findViewById(R.id.buttonClose);
        buttonClose.setOnClickListener(this);
        buttonMod = (Button)findViewById(R.id.buttonMod);
        buttonMod.setOnClickListener(this);
        equations = (TextView) findViewById(R.id.equations);
        result = (TextView) findViewById(R.id.result);
    }

    boolean check;
    StringBuilder equationString = new StringBuilder();
    StringBuilder resultString = new StringBuilder();
    StringBuilder total = new StringBuilder();

    @Override
    public void onClick(View view) {
        int id = view.getId();
        String[] array = null;
        if (equations.length() > 40) {
            button0.setEnabled(false);
            button1.setEnabled(false);
            button2.setEnabled(false);
            button3.setEnabled(false);
            button4.setEnabled(false);
            button6.setEnabled(false);
            button7.setEnabled(false);
            button8.setEnabled(false);
            button9.setEnabled(false);
            buttonSin.setEnabled(false);
            buttonCos.setEnabled(false);
            buttonTan.setEnabled(false);
            buttonASin.setEnabled(false);
            buttonACos.setEnabled(false);
            buttonATan.setEnabled(false);
            buttonP.setEnabled(false);
            buttonM.setEnabled(false);
            buttonMul.setEnabled(false);
            buttonDiv.setEnabled(false);
            buttonInv.setEnabled(false);
            buttonLog.setEnabled(false);
            buttonLN.setEnabled(false);
            buttonE.setEnabled(false);
            buttonPW.setEnabled(false);
            buttonFac.setEnabled(false);
            buttonPI.setEnabled(false);
            buttonPoint.setEnabled(false);
            buttonSqrt.setEnabled(false);
            buttonRes.setEnabled(false);
            buttonOpen.setEnabled(false);
            buttonClose.setEnabled(false);
            buttonMod.setEnabled(false);
        } else if (equations.length() < 41) {
            button0.setEnabled(true);
            button1.setEnabled(true);
            button2.setEnabled(true);
            button3.setEnabled(true);
            button4.setEnabled(true);
            button6.setEnabled(true);
            button7.setEnabled(true);
            button8.setEnabled(true);
            button9.setEnabled(true);
            buttonSin.setEnabled(true);
            buttonCos.setEnabled(true);
            buttonTan.setEnabled(true);
            buttonASin.setEnabled(true);
            buttonACos.setEnabled(true);
            buttonATan.setEnabled(true);
            buttonP.setEnabled(true);
            buttonM.setEnabled(true);
            buttonMul.setEnabled(true);
            buttonDiv.setEnabled(true);
            buttonInv.setEnabled(true);
            buttonLog.setEnabled(true);
            buttonLN.setEnabled(true);
            buttonE.setEnabled(true);
            buttonPW.setEnabled(true);
            buttonFac.setEnabled(true);
            buttonPI.setEnabled(true);
            buttonPoint.setEnabled(true);
            buttonSqrt.setEnabled(true);
            buttonRes.setEnabled(true);
            buttonOpen.setEnabled(true);
            buttonClose.setEnabled(true);
            buttonMod.setEnabled(true);
        }
        if (check) {
            equationString = new StringBuilder();
            total = new StringBuilder();
            check = false;
            equations.setText(equationString);
        } else {
            if (id == R.id.button0) {
                total.append("0");
                equationString.append("0");
                equations.setText(equationString);
            } else if (id == R.id.button1) {
                total.append("1");
                equationString.append("1");
                equations.setText(equationString);
            } else if (id == R.id.button2) {
                total.append("2");
                equationString.append("2");
                equations.setText(equationString);
            } else if (id == R.id.button3) {
                total.append("3");
                equationString.append("3");
                equations.setText(equationString);
            } else if (id == R.id.button4) {
                total.append("4");
                equationString.append("4");
                equations.setText(equationString);
            } else if (id == R.id.button5) {
                total.append("5");
                equationString.append("5");
                equations.setText(equationString);
            } else if (id == R.id.button6) {
                total.append("6");
                equationString.append("6");
                equations.setText(equationString);
            } else if (id == R.id.button7) {
                total.append("7");
                equationString.append("7");
                equations.setText(equationString);
            } else if (id == R.id.button8) {
                total.append("8");
                equationString.append("8");
                equations.setText(equationString);
            } else if (id == R.id.button9) {
                total.append("9");
                equationString.append("9");
                equations.setText(equationString);
            } else if (id == R.id.buttonPoint) {
                total.append(".");
                equationString.append(".");
                equations.setText(equationString);
            } else if (id == R.id.buttonPI) {
                total.append("π");
                equationString.append("π");
                equations.setText(equationString);
            } else if (id == R.id.buttonP) {
                total.append("+");
                equationString.append("+");
                equations.setText(equationString);
            } else if (id == R.id.buttonM) {
                total.append("-");
                equationString.append("-");
                equations.setText(equationString);
            } else if (id == R.id.buttonMul) {
                total.append("*");
                equationString.append("*");
                equations.setText(equationString);
            } else if (id == R.id.buttonDiv) {
                total.append("/");
                equationString.append("/");
                equations.setText(equationString);
            } else if (id == R.id.buttonPW) {
                total.append("^");
                equationString.append("^(");
                equations.setText(equationString);
            } else if (id == R.id.buttonSqrt) {
                total.append("@");
                equationString.append("√(");
                equations.setText(equationString);
            } else if (id == R.id.buttonLog) {
                total.append("l");
                equationString.append("log(");
                equations.setText(equationString);
            } else if (id == R.id.buttonLN) {
                total.append("n");
                equationString.append("ln(");
                equations.setText(equationString);
            } else if (id == R.id.buttonSin) {
                total.append("s");
                equationString.append("sin(");
                equations.setText(equationString);
            } else if (id == R.id.buttonCos) {
                total.append("c");
                equationString.append("cos(");
                equations.setText(equationString);
            } else if (id == R.id.buttonTan) {
                total.append("t");
                equationString.append("tan(");
                equations.setText(equationString);
            } else if (id == R.id.buttonASin) {
                total.append("z");
                equationString.append("asin(");
                equations.setText(equationString);
            } else if (id == R.id.buttonACos) {
                total.append("x");
                equationString.append("acos(");
                equations.setText(equationString);
            } else if (id == R.id.buttonATan) {
                total.append("v");
                equationString.append("atan(");
                equations.setText(equationString);
            } else if (id == R.id.buttonE) {
                total.append("e");
                equationString.append("e");
                equations.setText(equationString);
            } else if (id == R.id.buttonOpen) {
                total.append("(");
                equationString.append("(");
                equations.setText(equationString);
            } else if (id == R.id.buttonClose) {
                total.append(")");
                equationString.append(")");
                equations.setText(equationString);
            } else if (id == R.id.buttonSqrt) {
                total.append("@");
                equationString.append("√(");
                equations.setText(equationString);
            } else if (id == R.id.buttonRes) {
                showResult(array);
            } else if (id == R.id.buttonInv) {
                if (equationString.length() == 0) {
                    equationString = new StringBuilder();
                }
                equationString = new StringBuilder("1/(" + equationString + ")");
                equations.setText(equationString);
                if (!check) {
                    showResult(array);
                }
                total = new StringBuilder( "1/" + resultString);
                showResult(array);
            } else if (id == R.id.buttonCl) {
                total = new StringBuilder();
                equationString = new StringBuilder();
                resultString = new StringBuilder();
                result.setText(resultString);
                equations.setText(equationString);
            } else if (id == R.id.buttonBack) {
                total = new StringBuilder();
                equationString = new StringBuilder();
                resultString = new StringBuilder();
                result.setText(resultString);
                equations.setText(equationString);
            } else if (id == R.id.buttonMod) {
                equationString.append('%');
                equations.setText(equationString.toString());
                showResult(array);
            }
        }
    }
    public void showResult(String[] array) {
        Calculator calculate = new Calculator();
        if (Calculator.error) {
            IllegalAccessError e = new IllegalAccessError();
            throw(e);
        } else if (total.length() > 0) {
            array = calculate.receive(total.toString());
            array = calculate.stackParen(array);
            resultString = new StringBuilder(calculate.advanced(array));
        }
        result.setText(resultString);
        equationString = new StringBuilder();
        total = new StringBuilder();
        check = true;
    }
}
