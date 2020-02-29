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
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class RegistrationActivity extends AppCompatActivity {
    EditText nameEditText,emailEditText,phoneEditText,passwordEditText;
    Button registerButton;
    private FirebaseAuth mAuth;
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        nameEditText = (EditText)findViewById(R.id.nameEditText);
        emailEditText = (EditText)findViewById(R.id.emailEditText);
        phoneEditText = (EditText)findViewById(R.id.phoneEditText);
        passwordEditText = (EditText)findViewById(R.id.passwordEditTextRegPage);

        registerButton = (Button)findViewById(R.id.registerButton);

        mAuth=FirebaseAuth.getInstance();
        progressBar=findViewById(R.id.ProgressBar2);

        /*if (mAuth.getCurrentUser()!=null){
            startActivity(new Intent(getApplicationContext(),DrawerActivity.class));
            finish();
        }*/



        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=emailEditText.getText().toString().trim();
                String password=passwordEditText.getText().toString().trim();
                String name=nameEditText.getText().toString();
                String mobileNo=phoneEditText.getText().toString();


                if (TextUtils.isEmpty(name)){
                    nameEditText.setError("Name is Required");
                    nameEditText.requestFocus();
                    return;
                }


                if (TextUtils.isEmpty(mobileNo)) {
                    phoneEditText.setError("Mobile Number is required");
                    passwordEditText.requestFocus();
                    return;
                }

                if (mobileNo.length()<10) {
                    phoneEditText.setError("Mobile Number must be of 10 digits");
                    passwordEditText.requestFocus();
                    return;
                }

                if (TextUtils.isEmpty(email)){
                    emailEditText.setError("Email is Required");
                    emailEditText.requestFocus();
                    return;
                }

                if (TextUtils.isEmpty(password)){
                    passwordEditText.setError("Password is Required");
                    passwordEditText.requestFocus();
                    return;
                }

                if (password.length()<6){
                    passwordEditText.setError("Password must be of 6 characters or more");
                    passwordEditText.requestFocus();
                    return;
                }
                progressBar.setVisibility(View.VISIBLE);

                mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()){
                            Toast.makeText(RegistrationActivity.this,"Registration Successful",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        }else {
                            if (task.getException()instanceof FirebaseAuthUserCollisionException){
                                Toast.makeText(getApplicationContext(),"Already registered",Toast.LENGTH_SHORT).show();
                            }
                            else {
                                Toast.makeText(getApplicationContext(),task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                            }
                        }
                    }


                });


            }
        });
    }
}
