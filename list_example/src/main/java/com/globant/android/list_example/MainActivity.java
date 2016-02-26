package com.globant.android.list_example;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;

import com.globant.android.list_example.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
		RecyclerView recyclerView = binding.list;

		SimpleAdapter simpleAdapter = new SimpleAdapter(getUserNames());
		recyclerView.setLayoutManager(new LinearLayoutManager(this));
		recyclerView.setAdapter(simpleAdapter);

	}

	private ArrayList<User> getUserNames(){
		String[] userNames = getResources().getStringArray(R.array.names);
		ArrayList<User> users = new ArrayList<>();
		for (String userFullName : userNames){
			String[] nameParts = TextUtils.split(userFullName, " ");
			users.add(new User(nameParts[0], nameParts[1]));
		}
		return users;
	}
}
