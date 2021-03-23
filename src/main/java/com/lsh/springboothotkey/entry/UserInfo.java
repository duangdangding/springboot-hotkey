package com.lsh.springboothotkey.entry;

public class UserInfo {
    
    private String name;
    private String userId;
    private int follow; // 0 关注 1 不关注

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getFollow() {
        return follow;
    }

    public void setFollow(int follow) {
        this.follow = follow;
    }
}
