package com.globant.android.mvvm_example;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.globant.android.mvvm_example.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
		User user = new User("Test", "User");
		binding.setUservm(new UserViewModel(user));
	}
}
