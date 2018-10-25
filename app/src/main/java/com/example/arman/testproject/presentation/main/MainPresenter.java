package com.example.arman.testproject.presentation.main;

import android.content.Context;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.arman.testproject.App;
import com.example.arman.testproject.R;
import com.example.arman.testproject.data.repositories.DataManager;
import com.example.arman.testproject.data.repositories.statical.CountriesData;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {
    private final CompositeDisposable disposables = new CompositeDisposable();
    private CountryAdapter adapter;

    @Inject
    DataManager dataManager;

    @Inject
    Context context;

    MainPresenter() {
        App.getComponent().inject(this);

        adapter = new CountryAdapter();
        adapter.setActions(country -> getViewState().showSelectedCountry(country.name));
    }

    @Override
    protected void onFirstViewAttach() {
        if (dataManager.isFirstLaunch()) {
            dataManager.setFirstLaunch(false);

            disposables.add(dataManager.insertCountries(CountriesData.getCountries())
                    .subscribe(isSuccess -> {
                    }, th -> showError()));
        }

        disposables.add(dataManager.getCountries()
                .subscribe(countries -> adapter.updateCountries(countries), th -> showError()));
    }

    public void onQueryTextChange(String query) {
        disposables.add(dataManager.getCountriesByQuery(query)
                .subscribe(countries -> adapter.updateCountries(countries), th -> showError()));

    }

    private void showError() {
        getViewState().showMessage(R.string.internal_error);
    }

    public CountryAdapter getAdapter() {
        return adapter;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        disposables.dispose();
    }
}
