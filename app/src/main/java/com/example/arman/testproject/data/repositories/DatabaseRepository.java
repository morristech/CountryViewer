package com.example.arman.testproject.data.repositories;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.arman.testproject.data.db.dao.CountryDao;
import com.example.arman.testproject.data.db.entity.Country;

@Database(entities = {Country.class},
        version = 20181025,
        exportSchema = false)
public abstract class DatabaseRepository extends RoomDatabase {
    public abstract CountryDao getCountryDao();
}
