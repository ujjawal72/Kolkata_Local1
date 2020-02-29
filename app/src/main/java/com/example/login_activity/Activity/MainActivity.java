package com.example.login_activity.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.login_activity.Fragments.Train_Search_Fragment;
import com.example.login_activity.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText userIdEditText,passwordEditText;
    Button loginButton,registerButton,skipButton;
    FirebaseAuth mAuth;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userIdEditText = (EditText)findViewById(R.id.userIdEditText);
        passwordEditText = (EditText)findViewById(R.id.passwordEditTextRegPage);

        loginButton = (Button)findViewById(R.id.loginButton);
        registerButton = (Button)findViewById(R.id.registerButtonMainPage);
      /*  skipButton = (Button)findViewById(R.id.skipButton);*/

        loginButton.setOnClickListener(this);
        registerButton.setOnClickListener(this);
      /*  skipButton.setOnClickListener(this);*/

        mAuth=FirebaseAuth.getInstance();
        progressBar=findViewById(R.id.ProgressBar);

          if (mAuth.getCurrentUser()!=null) {
              startActivity(new Intent(getApplicationContext(), DrawerActivity.class));
              finish();
          }

/*
        if (mAuth.getCurrentUser()!=null){
            startActivity(new Intent(MainActivity.this,Train_Search_Fragment.class));
            finish();
        }
*/
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.loginButton:
                loginUser();
               break;

            case R.id.registerButtonMainPage:
                Intent intent1 = new Intent(MainActivity.this, RegistrationActivity.class);
                startActivity(intent1);
                break;

            /*case R.id.skipButton:
                Intent intent2 = new Intent(MainActivity.this, DrawerActivity.class);
                startActivity(intent2);
                break;*/

            default:
                Toast.makeText(this,"Something went wrong!!",Toast.LENGTH_LONG).show();
                break;
        }
    }

    private void loginUser(){

        String email=userIdEditText.getText().toString().trim();
        String password=passwordEditText .getText().toString().trim();


        if (TextUtils.isEmpty(email)){
            userIdEditText.setError("Email is Required");
            userIdEditText.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(password)){
            passwordEditText.setError("Password is Required");
            passwordEditText.requestFocus();
            return;
        }

        if (password.length()<6){
            passwordEditText.setError("Password must be 6 characters or more");
            passwordEditText.requestFocus();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);


        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(MainActivity.this,"logIn  successful",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(),DrawerActivity.class));
                    finish();
                }else{
                    Toast.makeText(getApplicationContext(),task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);
                }
            }
        });

    }
}
