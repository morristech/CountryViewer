package com.example.arman.testproject.di.component;

import com.example.arman.testproject.di.module.AppModule;
import com.example.arman.testproject.presentation.main.MainPresenter;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = AppModule.class)
@Singleton
public interface AppComponent {
    void inject(MainPresenter presenter);
}
