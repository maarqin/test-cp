package com.thomaz.testcapptan.login;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ScrollView;

import com.thomaz.testcapptan.R;
import com.thomaz.testcapptan.databinding.ViewEmailPasswordBinding;


/**
 * Created by thomaz on 02/01/19.
 */
public class LoginView extends ScrollView implements LoginContract.View {

    private LoginContract.Presenter presenter;

    public LoginView(Context context) {
        super(context);
        init();
    }

    public LoginView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        LayoutInflater inflater = LayoutInflater.from(getContext());

        ViewEmailPasswordBinding binding = DataBindingUtil.inflate(inflater, R.layout.view_email_password, this, true);
    }

    @Override
    public void setPresenter(LoginContract.Presenter presenter) {
        this.presenter = presenter;
    }

}