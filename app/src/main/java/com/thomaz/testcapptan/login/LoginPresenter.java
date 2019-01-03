package com.thomaz.testcapptan.login;

/**
 * Created by thomaz on 02/01/19.
 */
public class LoginPresenter implements LoginContract.Presenter {

    private LoginContract.View emailPasswordView;
    private LoginActivity activity;

    public LoginPresenter(LoginContract.View emailPasswordView, LoginActivity activity) {
        this.emailPasswordView = emailPasswordView;
        this.activity = activity;
    }

    @Override
    public void start() {
        emailPasswordView.setPresenter(this);
    }


}
