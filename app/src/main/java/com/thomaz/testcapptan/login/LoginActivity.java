package com.thomaz.testcapptan.login;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.thomaz.testcapptan.R;
import com.thomaz.testcapptan.activity.BaseActivity;


/**
 * Created by thomaz on 02/01/19.
 */
public class LoginActivity extends AppCompatActivity {

    private LoginPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        LoginContract.View emailPasswordView = findViewById(R.id.login_view);

        presenter = new LoginPresenter(emailPasswordView, this);

        setTitle("Identificação");
    }

}