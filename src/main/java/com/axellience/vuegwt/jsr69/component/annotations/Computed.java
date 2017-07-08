package com.axellience.vuegwt.jsr69.component.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.CLASS;

/**
 * Mark a computed property
 * @author Adrien Baron
 */
@Target(METHOD)
@Retention(CLASS)
public @interface Computed
{
    String propertyName() default "";
}
