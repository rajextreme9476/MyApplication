package indigo.in.co.daggerApp.dagger.component;

import javax.inject.Singleton;

import dagger.Component;
import indigo.in.co.daggerApp.dagger.module.ApiModule;
import indigo.in.co.daggerApp.dagger.module.AppModule;
import indigo.in.co.daggerApp.ui.activity.MainActivity;

/**
 * Created by Belal on 12/2/2017.
 */

@Singleton
@Component(modules = {AppModule.class, ApiModule.class})
public interface ApiComponent {
    void inject(MainActivity activity);
}
