package com.project.smartdevice;

import com.project.smartdevice.patterns.observer.IObserver;
import com.project.smartdevice.utilities.Icons;

public class User implements IObserver {

    private String username;
    private String password;

    public User(Builder builder){
        this.username=builder.username;
        this.password=builder.password;
    }

    @Override
    public void update(String message) {
        System.out.println(Icons.NOTIFICATION +" Message to user \""+getUsername()+"\": -> "+message);
    }

    public static class Builder{

        private String username;
        private String password;

        public Builder(String username, String password){
            this.username=username;
            this.password=password;
        }

        public User build(){
            return new User(this);
        }
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User{ " + username + " } ";
    }
}
