package com.example.karan.smartpark;

/**
 * Created by Karan on 27-08-2017.
 */
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mLogOutBtn;
    private TextView mUserTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mLogOutBtn = (Button) findViewById(R.id.LogOut);
        mUserTextView = (TextView) findViewById(R.id.nameText);

        mUserTextView.setText("Welcome");

        mLogOutBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        finish();
        startActivity(new Intent(LoginActivity.this, MainActivity.class));

    }
}
