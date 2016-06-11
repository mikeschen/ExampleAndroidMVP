package com.mikeschen.www.todoandroidmvp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.mikeschen.www.todoandroidmvp.Presenter.MainPresenter;

public class MainActivity extends AppCompatActivity implements MainPresenter.View {
    private MainPresenter mainPresenter;

    private TextView userInfoTextView;
    private EditText fullName;
    private EditText email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainPresenter = new MainPresenter(this);

        userInfoTextView = (TextView) findViewById(R.id.userInfo);
        fullName = (EditText) findViewById(R.id.fullName);
        email = (EditText) findViewById(R.id.email);

        fullName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mainPresenter.updateFullName(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mainPresenter.updateEmail(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @Override
    public void updateUserInfoTextView(String info) {
        userInfoTextView.setText(info);
    }
}
