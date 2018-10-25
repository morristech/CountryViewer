package com.example.arman.testproject.di.module;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.preference.PreferenceManager;

import com.example.arman.testproject.data.repositories.DataManager;
import com.example.arman.testproject.data.repositories.DatabaseRepository;
import com.example.arman.testproject.data.repositories.SharedDataRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    private Context context;

    public AppModule(Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    Context providesContext() {
        return context;
    }

    @Provides
    @Singleton
    DatabaseRepository providesDatabaseRepository() {
        return Room.databaseBuilder(context, DatabaseRepository.class, "test.db").build();
    }

    @Provides
    @Singleton
    SharedDataRepository providesSharedDataRepository(Context context) {
        return new SharedDataRepository(PreferenceManager.getDefaultSharedPreferences(context));
    }

    @Provides
    @Singleton
    DataManager providesDataManager(DatabaseRepository database, SharedDataRepository sharedData) {
        return new DataManager(database, sharedData);
    }
}
