package com.qqq.yuxin.model;

public class MyFriends {
    private String id;

    private String myUserId;

    private String myFriendsUserId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getMyUserId() {
        return myUserId;
    }

    public void setMyUserId(String myUserId) {
        this.myUserId = myUserId == null ? null : myUserId.trim();
    }

    public String getMyFriendsUserId() {
        return myFriendsUserId;
    }

    public void setMyFriendsUserId(String myFriendsUserId) {
        this.myFriendsUserId = myFriendsUserId == null ? null : myFriendsUserId.trim();
    }
}