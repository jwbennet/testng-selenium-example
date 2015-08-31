package edu.iu.es.esi.demo;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention( RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface Page {
    String value() default "";
}
