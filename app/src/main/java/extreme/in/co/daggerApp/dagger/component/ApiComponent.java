package extreme.in.co.daggerApp.dagger.component;

import javax.inject.Singleton;

import dagger.Component;
import extreme.in.co.daggerApp.dagger.module.ApiModule;
import extreme.in.co.daggerApp.dagger.module.AppModule;
import extreme.in.co.daggerApp.ui.activity.MainActivity;


/**
 * Created by ravdesai on 14-03-2018.
 */

@Singleton
@Component(modules = {AppModule.class, ApiModule.class})
public interface ApiComponent {
    void inject(MainActivity activity);
}
