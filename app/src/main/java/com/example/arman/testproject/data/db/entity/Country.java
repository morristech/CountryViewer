package com.example.arman.testproject.data.db.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class Country {
    @NonNull
    @PrimaryKey(autoGenerate = true)
    public long id;
    public String name;
    public String capital;
    public int area;
    public int population;

    public Country(String name, String capital, int area, int population) {
        this.name = name;
        this.capital = capital;
        this.area = area;
        this.population = population;
    }
}
