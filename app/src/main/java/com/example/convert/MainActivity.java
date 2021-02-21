package com.example.convert;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    RadioGroup converter;
    Button converterbtn;
    RadioButton r1;
    RadioButton r2;
    EditText txtSrc;
    TextView txtOut;
    double res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        converter= findViewById(R.id.converter);
        converterbtn=findViewById(R.id.converterbtn);
        r1=findViewById(R.id.radioButton1);
        r2=findViewById(R.id.radioButton2);
       txtSrc=findViewById(R.id.montant);
       txtOut=findViewById(R.id.valeur);
        converterbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int checkedid = converter.getCheckedRadioButtonId();
                if(checkedid == -1){
                    Message.message(getApplicationContext(),"Please select a money Converter");

                }else {
                    fctConverter(v);
                }

            }
        });
        converter.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                findRadioButton(checkedId );
            }
        });
    }


    private void findRadioButton(int checkedid) {
        switch (checkedid){
            case R.id.radioButton1:
                Message.message(getApplicationContext(),"Dinar To Euro");
                break;
            case  R.id.radioButton2:
                Message.message(getApplicationContext(),"Euro To Dinar");
                break;
        }
    }
    public void fctConverter(View v){
        if(r1.isChecked()){
            res=Float.parseFloat(txtSrc.getText().toString())/3.4;
            txtOut.setText(res+" Euro");
        }else if(r2.isChecked()){
            res=Float.parseFloat(txtSrc.getText().toString())*3.4;
            txtOut.setText(res+" Dinars");
        }
    }
}