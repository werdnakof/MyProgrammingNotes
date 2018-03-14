package annotations;

/**
 * Usage:
 *
 * SimpleAnnotation({ "foo", "bar" })
 * public class Main {...}
 *
 * instead of @SimpleAnnotation(value = { "foo", "bar" })
 */
public @interface ArrayAnnotation {
    String[] value() default { "ok" };
}
