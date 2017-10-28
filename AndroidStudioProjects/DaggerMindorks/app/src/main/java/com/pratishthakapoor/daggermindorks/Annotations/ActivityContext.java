package com.pratishthakapoor.daggermindorks.Annotations;

/**
 * Created by Pratishtha on 9/20/2017.
 */

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface ActivityContext{

}
