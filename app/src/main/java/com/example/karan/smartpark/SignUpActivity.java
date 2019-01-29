package com.example.karan.smartpark;

/**
 * Created by Karan on 27-08-2017.
 */
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.EditText;

import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.OnCompleteListener;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener{
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    private FirebaseAuth firebaseAuth;
    private EditText mFirstName;
    private EditText mLastName;
    private EditText mEmail;
    private EditText mPassword;
    private Button mSignUpButton;

    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_signup);
        mFirstName = (EditText) findViewById(R.id.firstName);
        mLastName = (EditText) findViewById(R.id.LastName);
        mEmail = (EditText) findViewById(R.id.emailAdd);
        mPassword = (EditText) findViewById(R.id.password);
        mSignUpButton =(Button) findViewById(R.id.signUpBtn);

        mSignUpButton.setOnClickListener(this);

        firebaseAuth = FirebaseAuth.getInstance();

    }

    @Override
    public void onClick(View v){
        if (v == mSignUpButton){
            loginUser();
        }
    }

    private void loginUser(){

        final String firstName = mFirstName.getText().toString().trim();
        final String lastName = mLastName.getText().toString().trim();
        final String email = mEmail.getText().toString().trim();
        final String password = mPassword.getText().toString().trim();

        if(TextUtils.isEmpty(firstName)){
            Toast.makeText(this,"enter first name",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(lastName)){
            Toast.makeText(this,"enter last name",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(email)){
            Toast.makeText(this,"enter email",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(password)){
            Toast.makeText(this,"enter the password",Toast.LENGTH_SHORT).show();
            return;
        }

        final ProgressDialog progressDialog = ProgressDialog.show(SignUpActivity.this,"Please wait","Processing",true);
        (firebaseAuth.createUserWithEmailAndPassword(email,password)).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressDialog.dismiss();
                if (task.isSuccessful()){
                    Toast.makeText(SignUpActivity.this,"Signup successful",Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(SignUpActivity.this,MainActivity.class);
                    startActivity(i);
                }
                else {
                    Log.e("Error",task.getException().toString());
                    Toast.makeText(SignUpActivity.this,task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
