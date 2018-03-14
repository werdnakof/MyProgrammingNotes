package annotations;

/**
 * Usage:
 *
 * @SimpleAnnotation("foo")
 * public class Main { ... }
 *
 * instead of @StringAnnotation(value = "foo")
 */
public @interface StringAnnotation {
    String value() default "ok";
}