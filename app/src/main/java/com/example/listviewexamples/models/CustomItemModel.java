package com.example.listviewexamples.models;

public class CustomItemModel {
//    int avatarResource;
    String textAvt;
    String title;
    String subtitle;
    String time;

    public CustomItemModel() {
    }

    public CustomItemModel(String textAvt, String title, String subtitle, String time) {
//        this.avatarResource = avatarResource;
        this.textAvt = textAvt;
        this.title = title;
        this.subtitle = subtitle;
        this.time = time;
    }

//    public int getAvatarResource() {
//        return avatarResource;
//    }

//    public void setAvatarResource(int avatarResource) {
//        this.avatarResource = avatarResource;
//    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTextAvt() {
        return textAvt;
    }

    public void setTextAvt(String textAvt) {
        this.textAvt = textAvt;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

}
