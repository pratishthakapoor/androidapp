package com.pratishthakapoor.daggermindorks.Annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * Created by Pratishtha on 9/20/2017.
 */

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @ interface ApplicationContext {
}
