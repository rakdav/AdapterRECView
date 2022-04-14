package com.example.myapplication;

public class Country
{
    private String name;
    private String capital;
    private int count;
    private int flag;

    public Country(String name, String capital, int count, int flag) {
        this.name = name;
        this.capital = capital;
        this.count = count;
        this.flag = flag;
    }

    public String getName() {
        return name;
    }

    public String getCapital() {
        return capital;
    }

    public int getCount() {
        return count;
    }

    public int getFlag() {
        return flag;
    }
}
