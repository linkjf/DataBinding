package com.globant.android.list_example;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.globant.android.list_example.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

	private ActivityMainBinding binding;
	private SimpleAdapter simpleAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
		RecyclerView recyclerView = binding.list;
		simpleAdapter = new SimpleAdapter(getUserNames());
		recyclerView.setLayoutManager(new LinearLayoutManager(this));
		recyclerView.setAdapter(simpleAdapter);
		binding.addUser.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				addUser();
			}
		});
 	}

	private void addUser(){
		String name = binding.userNameEdit.getText().toString();
		String lastName = binding.userLastNameEdit.getText().toString();
		if(checkEditText()){
			if(simpleAdapter.addUser(new User(name, lastName))){
				binding.userNameEdit.setText("");
				binding.userLastNameEdit.setText("");
				binding.userNameEdit.requestFocus();
			}else{
				Toast.makeText(MainActivity.this, getString(R.string.add_user_error), Toast.LENGTH_SHORT).show();
			}
		}else{
			Toast.makeText(MainActivity.this, getString(R.string.add_user_complete_form), Toast.LENGTH_SHORT).show();
		}
	}

	private boolean checkEditText(){
		return !TextUtils.isEmpty(binding.userNameEdit.getText()) && !TextUtils.isEmpty(binding.userLastNameEdit.getText());
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
