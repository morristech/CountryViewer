package com.example.arman.testproject.data.repositories;

import android.content.SharedPreferences;

public class SharedDataRepository {
    private final SharedPreferences sharedPreferences;
    private static final String FIRST_LAUNCH = "first_launch";

    public SharedDataRepository(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
    }

    private void saveBoolean(String key, boolean value) {
        sharedPreferences.edit().putBoolean(key, value).apply();
    }

    private boolean getBoolean(String key, boolean defValue) {
        return sharedPreferences.getBoolean(key, defValue);
    }

    boolean isFirstLaunch() {
        return getBoolean(FIRST_LAUNCH, true);
    }

    void setFirstLaunch(boolean firstLaunch) {
        saveBoolean(FIRST_LAUNCH, firstLaunch);
    }
}
