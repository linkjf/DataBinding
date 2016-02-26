package com.globant.android.list_example;

import java.util.ArrayList;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.globant.android.list_example.databinding.AdapterItemBinding;

/**
 * Created by joseortega on 8/13/15.
 */
public class SimpleAdapter extends RecyclerView.Adapter<UserHolder> {

    private ArrayList<User> mUsers;

    public SimpleAdapter(ArrayList<User> data) {
        super();
        this.mUsers = data;
    }

    @Override
    public UserHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        AdapterItemBinding adapterItemBinding = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()),
                R.layout.adapter_item, viewGroup, false);
        return new UserHolder(adapterItemBinding);
    }

    @Override
    public void onBindViewHolder(UserHolder user, int i) {
        user.bindConnection(mUsers.get(i));
    }

    @Override
    public int getItemCount() {
        return mUsers.size();
    }

    public boolean addUser(User user) {
        boolean isUserAdded = mUsers.add(user);
        if (isUserAdded) {
            notifyDataSetChanged();
        }
        return isUserAdded;
    }
}
