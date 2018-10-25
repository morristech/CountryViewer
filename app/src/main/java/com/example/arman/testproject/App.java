package com.example.arman.testproject;

import android.app.Application;

import com.example.arman.testproject.di.component.AppComponent;
import com.example.arman.testproject.di.component.DaggerAppComponent;
import com.example.arman.testproject.di.module.AppModule;

public class App extends Application {
    private static AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        initializeDaggerGraph();
    }

    private void initializeDaggerGraph() {
        component = DaggerAppComponent.builder()
                .appModule(new AppModule(getApplicationContext()))
                .build();
    }

    public static AppComponent getComponent() {
        return component;
    }
}
