package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * https://marcin-chwedczuk.github.io/creating-and-using-adnotations-in-java
 *
 * Annotation can have zero or more elements e.g. priority and method
 *
 * 'default' provides default value for method element
 *
 * @Target tells Java compiler on what program elements annotation can be used.
 *
 * ElementType.Type -> annotation can be only used on classes and interfaces
 *
 * @Retention tells compiler and JVM if annotation should be accessible at runtime
 *
 * RetentionPolicy.RUNTIME that can be accessed using reflection
 *
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface RunAtStartup {
    int priority();
    String method() default "run";
}

