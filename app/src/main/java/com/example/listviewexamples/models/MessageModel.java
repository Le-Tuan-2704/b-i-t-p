package com.example.listviewexamples.models;

public class MessageModel {
    int avatarResource;
    String username;
    String message;

    public MessageModel(int avatarResource, String username, String message) {
        this.avatarResource = avatarResource;
        this.username = username;
        this.message = message;
    }

    public int getAvatarResource() {
        return avatarResource;
    }

    public void setAvatarResource(int avatarResource) {
        this.avatarResource = avatarResource;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
