package com.globant.android.databindingexample;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;

import com.globant.android.databindingexample.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private User mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mUser = new User("John", "Power");
        binding.userNameEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mUser.setFirstName(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        binding.userLastNameEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mUser.setLastName(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        binding.setUser(mUser);
    }
}
