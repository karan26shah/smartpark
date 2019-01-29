package com.example.karan.smartpark;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.EditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.OnCompleteListener;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private FirebaseAuth firebaseAuth;
    private EditText mEmailText;
    private EditText mPwdText;
    private Button mSignUpTextView;
    private Button mSignInBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseAuth = FirebaseAuth.getInstance();
        mSignInBtn = (Button) findViewById(R.id.signIn);
        mEmailText = (EditText) findViewById(R.id.email);
        mPwdText = (EditText) findViewById(R.id.pwd);
        mSignUpTextView = (Button) findViewById(R.id.signUp);

        mSignInBtn.setOnClickListener(this);

        mSignUpTextView.setOnClickListener(this);
    }

    private void loginUser(){
        String email = mEmailText.getText().toString().trim();
        String password = mPwdText.getText().toString().trim();

        if (TextUtils.isEmpty(email)){
            Toast.makeText(this,"please enter the email",Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(password)){
            Toast.makeText(this,"please enter the password",Toast.LENGTH_SHORT).show();
            return;
        }
        final ProgressDialog progressDialog = ProgressDialog.show(MainActivity.this,"Please wait","Processing",true);
        (
                firebaseAuth.signInWithEmailAndPassword(email,password)
                ).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressDialog.dismiss();
                if (task.isSuccessful())
                {
                    Toast.makeText(MainActivity.this,"Login successful",Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(MainActivity.this,MapsActivity.class);
                    i.putExtra("Email",firebaseAuth.getCurrentUser().getEmail());
                    startActivity(i);
                }
                else
                {
                    Log.e("Error",task.getException().toString());
                    Toast.makeText(MainActivity.this,task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    @Override
    public void onClick(View view){
        if (view == mSignInBtn){
            loginUser();
        }
        if (view == mSignUpTextView){
            registerUser();
        }
    }



    private void registerUser(){
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
    }
}
