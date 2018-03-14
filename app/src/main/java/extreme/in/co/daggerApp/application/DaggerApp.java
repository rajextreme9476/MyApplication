package extreme.in.co.daggerApp.application;

import android.app.Application;

import extreme.in.co.daggerApp.dagger.component.ApiComponent;
import extreme.in.co.daggerApp.dagger.component.DaggerApiComponent;
import extreme.in.co.daggerApp.dagger.module.ApiModule;
import extreme.in.co.daggerApp.dagger.module.AppModule;

/**
 * Created by ravdesai on 14-03-2018.
 */

public class DaggerApp extends Application {


    ApiComponent apiComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        apiComponent = DaggerApiComponent.builder().appModule(new AppModule(this))
                .apiModule(new ApiModule("https://reqres.in/"))
                .build();
    }


    public ApiComponent getApiComponent() {
        return apiComponent;
    }
}
