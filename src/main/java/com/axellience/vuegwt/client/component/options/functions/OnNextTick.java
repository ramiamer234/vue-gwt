package com.axellience.vuegwt.client.component.options.functions;

import jsinterop.annotations.JsFunction;

/**
 * Callback for Vue nextTick
 * @author Adrien Baron
 */
@JsFunction
@FunctionalInterface
public interface OnNextTick
{
    Object onNextTick();
}
