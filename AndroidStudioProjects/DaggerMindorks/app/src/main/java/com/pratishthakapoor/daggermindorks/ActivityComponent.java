package com.pratishthakapoor.daggermindorks;

import com.pratishthakapoor.daggermindorks.Annotations.PerActivity;

import dagger.Component;

/**
 * Created by Pratishtha on 9/20/2017.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void  inject(MainActivity mainActivity);
}
