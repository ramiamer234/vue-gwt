# GWT Styles

!INCLUDE "../dependencies.md"

## Adding Style to Our Component

Vue GWT is compatible with GSS styles.
You can declare your `CssResource` interfaces and use them within your Vue GWT Components.

You also get type checking of your styles rules at compile type.
So if you try to use `myStyle.bob()` in your template, and this style doesn't exist, the compilation will break with an explicit error.

Let see it in action with a simple example.

We will create a simple style that set the text color to red.

***MelisandreComponentStyle.java***

First, we create a `CssResource` interface.
We also add the `@Style` annotation to it.
This annotation will automatically generate a GWT Bundle for us.

```java
@Style
public interface MelisandreComponentStyle extends CssResource {
    String red();
    String bold();
}
```

***MelisandreComponentStyle.gss***

We then create the style for this interface.
It's important to give the gss file the same name as your Interface.
This is because the binding is made automatically by Vue GWT based on the name.

```css
.red {
    color: red;
}
.bold {
	font-weight: bold;
}
```

***MelisandreComponent.java***

Let's use our style in a small Component.
For the Java part, nothing is needed, so we can just create an empty Component class.

```java
@Component
public class MelisandreComponent extends VueComponent {
}
```

***MelisandreComponent.html***

In the template, we can now import our style.
We just have to add an `vue-gwt:import` statement on top of our component.
In the `style` attribute, we put the full class name of our Style interface.
We also add a `name` attribute to give our style a name in the template.

We can then simply use Vue `v-bind` directive to bind our style.

```html
<vue-gwt:import style="com.mypackage.MelisandreComponentStyle" name="myStyle"/>
<div v-bind:class="myStyle.red()">
    For the night is dark and full of terrors.
</div>
```

## Adding More Than One CSS Class

You can add more than one CSS Class to your Components by using the [`array` builder](../js-interop/README.md#array):

```html
<div v-bind:class="array(myStyle.red(), myStyle.bold())">
    For the night is dark, full of terrors and bold.
</div>
```

## Conditional Styling

You can apply a Style conditionally.
First we add a boolean in our `MelisandreComponent`:

```java
@Component
public class MelisandreComponent extends VueComponent {
    @JsProperty boolean isRed = true;
}
```
 
Then we simply use a ternary expression (be careful with the quotes):

```html
<div v-bind:class='isRed ? myStyle.red() : ""'>
    For the night is dark, full of terrors and might or not be red.
</div>
```

## Conditional Styling With Several CSS Class

You can combine both the `array` and the ternary syntax:
 
```html
<div v-bind:class='array(isRed ? myStyle.red() : "", myStyle.bold())'>
    For the night is dark, full of terrors, might or not be red and always BOLD.
</div>
```

## Here is our finished `MelisandreComponent`

{% raw %}
<div class="example-container" data-name="melisandreComponent">
    <span id="melisandreComponent"></span>
</div>
{% endraw %}

You can try toggling the red color on the two bottom sentences by typing in your browser console:

```
melisandreComponent.isRed = false;
```