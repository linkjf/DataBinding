package com.globant.android.list_example;

import android.support.v7.widget.RecyclerView;

import com.globant.android.list_example.databinding.AdapterItemBinding;


/**
 * Created by joseortega on 8/13/15.
 */
public class UserHolder extends RecyclerView.ViewHolder {

	AdapterItemBinding adapterItemBinding;

	public UserHolder(AdapterItemBinding binding) {
		super(binding.getRoot());
		this.adapterItemBinding = binding;
	}

	public void bindConnection(User user) {
		this.adapterItemBinding.setUser(user);
	}
}
