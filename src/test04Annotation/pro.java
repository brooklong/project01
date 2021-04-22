package test04Annotation;

/*
*   描述需要执行的类名，和方法名*/

import org.junit.Test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)

public @interface pro {

    String className();
    String methodName();
}
