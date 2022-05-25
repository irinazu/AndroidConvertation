package com.example.convertation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner=(Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> charSequenceArrayAdapter=ArrayAdapter.createFromResource(this,
                R.array.languages,android.R.layout.simple_spinner_item);
        charSequenceArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(charSequenceArrayAdapter);
        spinner.setOnItemSelectedListener(this);
        RadioGroup radioGroup=(RadioGroup) findViewById(R.id.radioGroup);
        Button button=(Button)findViewById(R.id.button);
        StringBuilder stringBuilder=new StringBuilder();
        EditText edt= (EditText)findViewById(R.id.editText);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

            }
        });

        View.OnClickListener onClickListener=new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stringBuilder.setLength(0);
                stringBuilder.append(edt.getText().toString());

                //ArrayList<TextView> textViewsNum=new ArrayList<>();
                TextView meters=(TextView) findViewById(R.id.textView3);
                TextView kilometers=(TextView) findViewById(R.id.textView5);
                TextView centimeters=(TextView) findViewById(R.id.textView7);
                TextView feet=(TextView) findViewById(R.id.textView9);
                TextView miles=(TextView) findViewById(R.id.textView11);
                TextView inches=(TextView) findViewById(R.id.textView13);
                //Double result;

                Integer checkedRadioButtonId = radioGroup.getCheckedRadioButtonId();
                if(stringBuilder.length()!=0){
                    Double num=Double.parseDouble(stringBuilder.toString());
                    switch (checkedRadioButtonId){
                        case R.id.radioButton1:
                           meters.setText(stringBuilder.toString());
                           kilometers.setText(String.valueOf(num*0.001));
                           centimeters.setText(String.valueOf(num*100));
                           feet.setText(String.valueOf(num*3.3));
                           miles.setText(String.valueOf(num*0.00062));
                           inches.setText(String.valueOf(num*39));
                            break;
                        case R.id.radioButton2:
                            meters.setText(String.valueOf(num*1000));
                            kilometers.setText(stringBuilder.toString());
                            centimeters.setText(String.valueOf(num*100000));
                            feet.setText(String.valueOf(num*3281));
                            miles.setText(String.valueOf(num*0.62));
                            inches.setText(String.valueOf(num*39370));
                            break;
                        case R.id.radioButton3:
                            meters.setText(String.valueOf(num*0.01));
                            kilometers.setText(String.valueOf(num*0.001));
                            centimeters.setText(stringBuilder.toString());
                            feet.setText(String.valueOf(num*0.033));
                            miles.setText(String.valueOf(num/160934));
                            inches.setText(String.valueOf(num*0.393));
                            break;
                        case R.id.radioButton4:
                            meters.setText(String.valueOf(num*0.3048));
                            kilometers.setText(String.valueOf(num*0.0003048));
                            centimeters.setText(String.valueOf(num*30.48));
                            feet.setText(stringBuilder.toString());
                            miles.setText(String.valueOf(num*0.00018));
                            inches.setText(String.valueOf(num*12));
                            break;
                        case R.id.radioButton5:
                            meters.setText(String.valueOf(num*1609));
                            kilometers.setText(String.valueOf(num*1.6));
                            centimeters.setText(String.valueOf(num*160934.4));
                            feet.setText(String.valueOf(num*5280));
                            miles.setText(stringBuilder.toString());
                            inches.setText(String.valueOf(num*63360));
                            break;
                        case R.id.radioButton6:
                            meters.setText(String.valueOf(num*0.0254));
                            kilometers.setText(String.valueOf(num/39370));
                            centimeters.setText(String.valueOf(num*2.54));
                            feet.setText(String.valueOf(num*0.083));
                            miles.setText(String.valueOf(num/63360));
                            inches.setText(stringBuilder.toString());
                            break;

                    }
                }

            }
        };
        button.setOnClickListener(onClickListener);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String s=adapterView.getItemAtPosition(i).toString();
        ArrayList<TextView> textViews=new ArrayList<>();
        textViews.add((TextView) findViewById(R.id.textView1));
        textViews.add((TextView) findViewById(R.id.textView2));
        textViews.add((TextView) findViewById(R.id.textView4));
        textViews.add((TextView) findViewById(R.id.textView6));
        textViews.add((TextView) findViewById(R.id.textView8));
        textViews.add((TextView) findViewById(R.id.textView10));
        textViews.add((TextView) findViewById(R.id.textView12));

        ArrayList<RadioButton> radioButtons=new ArrayList<>();
        radioButtons.add((RadioButton) findViewById(R.id.radioButton1));
        radioButtons.add((RadioButton) findViewById(R.id.radioButton2));
        radioButtons.add((RadioButton) findViewById(R.id.radioButton3));
        radioButtons.add((RadioButton) findViewById(R.id.radioButton4));
        radioButtons.add((RadioButton) findViewById(R.id.radioButton5));
        radioButtons.add((RadioButton) findViewById(R.id.radioButton6));
        onChanceLanguage(s,textViews,radioButtons);

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        ArrayList<TextView> textViews=new ArrayList<>();
        textViews.add((TextView) findViewById(R.id.textView1));
        textViews.add((TextView) findViewById(R.id.textView2));
        textViews.add((TextView) findViewById(R.id.textView4));
        textViews.add((TextView) findViewById(R.id.textView6));
        textViews.add((TextView) findViewById(R.id.textView8));
        textViews.add((TextView) findViewById(R.id.textView10));
        textViews.add((TextView) findViewById(R.id.textView12));

        ArrayList<RadioButton> radioButtons=new ArrayList<>();
        radioButtons.add((RadioButton) findViewById(R.id.radioButton1));
        radioButtons.add((RadioButton) findViewById(R.id.radioButton2));
        radioButtons.add((RadioButton) findViewById(R.id.radioButton3));
        radioButtons.add((RadioButton) findViewById(R.id.radioButton4));
        radioButtons.add((RadioButton) findViewById(R.id.radioButton5));
        radioButtons.add((RadioButton) findViewById(R.id.radioButton6));
        onNotChanceLanguage(textViews,radioButtons);
    }
    public void onNotChanceLanguage( List<TextView> textViews,List<RadioButton> radioButtons) {
        String[] ru=getResources().getStringArray(R.array.Ru);
        for(int i=0;i<textViews.size();i++){
            textViews.get(i).setText(ru[i]);
        }
        int j=1;
        for(int i=0;i<radioButtons.size();i++){
            radioButtons.get(i).setText(ru[j]);
            ++j;
        }
    }
    public void onChanceLanguage(String text, List<TextView> textViews,List<RadioButton> radioButtons){


        if(text.equals("English")){
            String[] en=getResources().getStringArray(R.array.En);

            for(int i=0;i<textViews.size();i++){
                textViews.get(i).setText(en[i]);
            }
            int j=1;
            for(int i=0;i<radioButtons.size();i++){
                radioButtons.get(i).setText(en[j]);
                ++j;
            }
        }else {
            String[] ru=getResources().getStringArray(R.array.Ru);
            for(int i=0;i<textViews.size();i++){
                textViews.get(i).setText(ru[i]);
            }
            int j=1;
            for(int i=0;i<radioButtons.size();i++){
                radioButtons.get(i).setText(ru[j]);
                ++j;
            }
        }
    }


}