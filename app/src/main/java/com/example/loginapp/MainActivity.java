package com.example.loginapp;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ConstraintLayout mylayout;
    AnimationDrawable animationDrawable;
    private EditText username,password,Email;
    private Button login;
    private TextView textView;
    private int count=3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        animation_run();//runs the animation
        initialize();//initilaze the account
       //checks the user login whether it the true user in the system or not and only checks when login button pressed
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validateTheInfo()){
                    //Firebase used to store the data

                }
        }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this,SecondaryActivity.class));
            }
        });



    }
    protected void animation_run(){
        mylayout=(ConstraintLayout) findViewById(R.id.root_layout);
        animationDrawable= (AnimationDrawable)mylayout.getBackground();
        animationDrawable.setEnterFadeDuration(4500);
        animationDrawable.setExitFadeDuration(1000);
        animationDrawable.start();

    }
    protected void initialize(){
        username=(EditText)findViewById(R.id.etUserName);
        password=(EditText)findViewById(R.id.etPassword);
        login=(Button)findViewById(R.id.loginButton);
        textView=(TextView)findViewById(R.id.tvAttempts);
        Email=(EditText) findViewById(R.id.etEmail);
        //validateTheInfo(username,password);
    }
    private Boolean validateTheInfo() {

        Boolean result = false;
        if (this.username.getText().toString().isEmpty() && (this.password.getText().toString().isEmpty()) && (this.Email.getText().toString().isEmpty())) {

            Toast.makeText(this, "Each must be filled", Toast.LENGTH_SHORT).show();

        } else {
            result = true;
        }
        return result;

    }




        //individual admin access can also be given or special access
/**
        if((username.equals("admin")) && (password.equals("asdfg"))){
            Intent intent= new Intent(MainActivity.this, SecondaryActivity.class);
            startActivity(intent);
        } else{
            count--;

            if(count==0){
                textView.setEnabled(true);
                login.setEnabled(false);
                textView.setText("number of attempts remaining: "+String.valueOf(count));

            }else{
                textView.setEnabled(false);
            }
        }*/
    }


