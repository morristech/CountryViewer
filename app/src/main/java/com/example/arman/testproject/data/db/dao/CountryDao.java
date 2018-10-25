package com.example.arman.testproject.data.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.arman.testproject.data.db.entity.Country;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public abstract class CountryDao {
    @Insert(onConflict = REPLACE)
    public abstract void insertPlanets(List<Country> countries);

    @Query("SELECT * FROM Country order by area desc")
    public abstract List<Country> getCountries();

    @Query("SELECT * FROM Country where name like :query order by area desc")
    public abstract List<Country> getCountries(String query);

    public List<Country> getCountriesByQuery(String query) {
        query = "%".concat(query).concat("%");
        return getCountries(query);
    }
}
