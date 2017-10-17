package com.axellience.vuegwtexamples.client.examples.errorboundary;

import com.axellience.vuegwt.client.component.HasRender;
import com.axellience.vuegwt.client.component.VueComponent;
import com.axellience.vuegwt.client.component.hooks.HasErrorCaptured;
import com.axellience.vuegwt.client.jsnative.jstypes.JsObject;
import com.axellience.vuegwt.client.vnode.VNode;
import com.axellience.vuegwt.client.vnode.VNodeData;
import com.axellience.vuegwt.client.vnode.builder.VNodeBuilder;
import com.axellience.vuegwt.jsr69.component.annotations.Component;
import jsinterop.annotations.JsProperty;

@Component
public class ErrorBoundaryComponent extends VueComponent implements HasErrorCaptured, HasRender
{
    @JsProperty JsObject error;

    @Override
    public boolean errorCaptured(JsObject err, VueComponent vue, String info)
    {
        this.error = err;
        return false;
    }

    @Override
    public VNode render(VNodeBuilder builder)
    {
        if (error != null)
        {
            VNodeData style = new VNodeData().setStyle(map("color", "red"));
            return builder.el("pre", style, "An error occurred: " + error);
        }

        //return this.$slots().get("default").get(0);
        return builder.el(ErrorMakerComponent.class);
    }
}