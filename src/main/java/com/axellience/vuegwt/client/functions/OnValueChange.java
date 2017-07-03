package com.axellience.vuegwt.client.functions;

import jsinterop.annotations.JsFunction;

/**
 * Callback when a Vue.js event is fired by a child component
 */
@JsFunction
@FunctionalInterface
public interface OnValueChange
{
    void exec(Object newValue, Object oldValue);
}