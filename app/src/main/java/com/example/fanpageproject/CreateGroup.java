package com.example.fanpageproject;

public class CreateGroup {
    public CreateGroup() {
        this.Group = Group;
    }

    public String getGroup() {
        return Group;
    }

    public void setGroup(String group) {
        Group = group;
    }

    public String toString() {
        return this.Group+ " ";
    }


    private String Group;
}
