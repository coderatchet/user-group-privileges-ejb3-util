package com.thenaglecode.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;

/**
 * Created with IntelliJ IDEA.
 * User: jxnagl
 * Date: 6/09/13
 * Time: 4:03 PM
 * //todo implement
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({METHOD, TYPE})
public @interface UserHasPrivileges {
    String[] privileges();
}
