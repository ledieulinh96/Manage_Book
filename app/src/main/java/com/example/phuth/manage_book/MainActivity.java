package com.example.phuth.manage_book;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.phuth.manage_book.DAO.AccountDAO;
import com.example.phuth.manage_book.Model.Account;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    AccountDAO accountDAO;

    EditText txtUsername, txtPassword;
    Button btnSignup, btnSignin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtUsername = findViewById(R.id.txtUsername);
        txtPassword = findViewById(R.id.txtPassword);
        btnSignup = findViewById(R.id.btnSignup);
        btnSignin = findViewById(R.id.btnSignin);
        btnSignin.setOnClickListener(this);
        btnSignup.setOnClickListener(this);

        accountDAO = new AccountDAO(this);
        accountDAO.open();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnSignin:

                Account account = new Account();
                account.setUsername(txtUsername.getText().toString());
                account.setPassword(txtPassword.getText().toString());
                boolean check = accountDAO.checkAccount(account);
                Toast.makeText(this, "check = " + check, Toast.LENGTH_SHORT );
                break;

            case R.id.btnSignup:
                Account account2 = new Account();
                account2.setUsername(txtUsername.getText().toString());
                account2.setPassword(txtPassword.getText().toString());
                boolean check2 = accountDAO.addAccount(account2);
                Toast.makeText(this, "check = " + check2, Toast.LENGTH_SHORT );
                break;
        }
    }
}
