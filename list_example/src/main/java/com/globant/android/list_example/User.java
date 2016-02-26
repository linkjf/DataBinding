package com.globant.android.list_example;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * Created by joseortega on 8/12/15.
 */
public class User extends BaseObservable {
    private final String firstName;
    private final String lastName;

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Bindable
    public String getFirstName() {
        return this.firstName;
    }

    @Bindable
    public String getLastName() {
        return this.lastName;
    }

    public boolean hasLastName() {
        return !this.lastName.isEmpty();
    }
}
