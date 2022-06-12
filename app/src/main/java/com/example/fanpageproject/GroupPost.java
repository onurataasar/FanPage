package com.example.fanpageproject;

import com.google.firebase.auth.FirebaseAuth;

public class GroupPost {
    public String getGroupPost() {
        return GroupPost;
    }

    public void setGroupPost(String groupPost) {
        GroupPost = groupPost;
    }

    private String GroupPost;

    public GroupPost() {
        this.GroupPost = GroupPost;
    }
    String user = FirebaseAuth.getInstance().getCurrentUser().getUid().replaceAll("gfFXHshb3YdNxDm5MWzuJ5BmHPj1", "onurataasar").replaceAll("QUSCnpZiI1NNSBDQjtiqp6cayik2", "enesbatuhanay");

    public String toString() {
        return user + ": \n \n" + GroupPost +" \n " + " \n .";

    }
}
