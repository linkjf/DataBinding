package com.globant.android.mvvm_example;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.text.Editable;
import android.text.TextWatcher;

/**
 * Created by joseortega on 8/28/15.
 */
public class UserViewModel extends BaseObservable {

	private User user;

	public UserViewModel(User user) {
		this.user = user;
	}

	@Bindable
	public String getUserFirstName() {
		return this.user.getFirstName();
	}

	@Bindable
	public String getUserLastName() {
		return this.user.getLastName();
	}

	public void setFirstName(String firstName) {
		this.user.setFirstName(firstName);
		notifyPropertyChanged(com.globant.android.mvvm_example.BR.userFirstName);
	}

	public void setLastName(String lastName) {
		this.user.setLastName(lastName);
		notifyPropertyChanged(com.globant.android.mvvm_example.BR.userLastName);
	}


	public TextWatcher getNameWatcher() {
		return new TextWatcher() {
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {

			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {

			}

			@Override
			public void afterTextChanged(Editable s) {
				setFirstName(s.toString());
			}
		};
	}
}
