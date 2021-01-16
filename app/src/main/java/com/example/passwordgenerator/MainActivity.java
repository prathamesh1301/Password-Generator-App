package com.example.passwordgenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView name,dob,length,display;
    Button generate,easy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=findViewById(R.id.Name);
        dob=findViewById(R.id.dob);
        length=findViewById(R.id.length);
        display=findViewById(R.id.display);
        generate=findViewById(R.id.strong);
        easy=findViewById(R.id.easy);
        generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pname = name.getText().toString().trim();
                String pdob = dob.getText().toString();
                String symbols = "!@#$<>";
                int len = Integer.parseInt(length.getText().toString());
                char[] password = new char[len];
                Random random = new Random();
                String upper=pname.toUpperCase();
                String lower=pname.toLowerCase();
                char c1=upper.charAt(random.nextInt(upper.length()));
                char c2=lower.charAt(random.nextInt(lower.length()));
                char c3=pdob.charAt(random.nextInt(pdob.length()));
                String current=new String(String.valueOf(c1)+String.valueOf(c2)+String.valueOf(c3));
                String combined_data = pname + pdob + symbols;

                for (int i = 3; i < len; i++) {
                    password[i] = combined_data.charAt(random.nextInt(combined_data.length()));
                }
                String passWord=new String(password);
                String result=current+passWord;
                display.setText(result);
                display.setVisibility(View.VISIBLE);

            }
        });

        easy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pname = name.getText().toString().trim();
                String pdob = dob.getText().toString();
                String symbols = "!@#$<>";
                String pass_name;
                int len = Integer.parseInt(length.getText().toString());
                char[] password = new char[len];
                String combined_data = pdob + symbols;
                Random random = new Random();
                if(pname.length()>=len){
                    pass_name=pname.substring(0,1).toUpperCase()+pname.substring(1,len-3)+pdob.charAt(random.nextInt(pdob.length()));
                }
                else{
                    pass_name=pname.substring(0,1).toUpperCase()+pname.substring(1,pname.length())+pdob.charAt(random.nextInt(pdob.length()));
                }
                for (int i = pass_name.length(); i < len; i++) {
                    password[i] = combined_data.charAt(random.nextInt(combined_data.length()));
                }
                String passWord=new String(password);
                String result=pass_name+passWord;

                display.setText(result);
                display.setVisibility(View.VISIBLE);
            }
        });



    }
}