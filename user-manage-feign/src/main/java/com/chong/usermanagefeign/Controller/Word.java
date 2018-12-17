package com.chong.usermanagefeign.Controller;

public class Word {
    private String name;
    private String info;

    public Word() {
    }

    public Word(String name, String info) {
        this.name = name;
        this.info = info;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
