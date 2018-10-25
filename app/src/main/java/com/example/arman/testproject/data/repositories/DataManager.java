package com.example.arman.testproject.data.repositories;

import com.example.arman.testproject.data.db.entity.Country;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class DataManager {
    private DatabaseRepository database;
    private SharedDataRepository sharedData;

    public DataManager(DatabaseRepository database, SharedDataRepository sharedData) {
        this.database = database;
        this.sharedData = sharedData;
    }

    public Observable<Boolean> insertCountries(List<Country> countries) {
        return Observable.fromCallable(() -> {
            database.getCountryDao().insertPlanets(countries);
            return true;
        }).compose(applyObservableSchedulers());
    }

    public Observable<List<Country>> getCountries() {
        return Observable.fromCallable(() -> database.getCountryDao().getCountries())
                .compose(applyObservableSchedulers());
    }

    public Observable<List<Country>> getCountriesByQuery(String query) {
        return Observable.fromCallable(() -> database.getCountryDao().getCountriesByQuery(query))
                .compose(applyObservableSchedulers());
    }

    private <T> ObservableTransformer<T, T> applyObservableSchedulers() {
        return observable -> observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public boolean isFirstLaunch() {
        return sharedData.isFirstLaunch();
    }

    public void setFirstLaunch(boolean firstLaunch) {
        sharedData.setFirstLaunch(firstLaunch);
    }
}
