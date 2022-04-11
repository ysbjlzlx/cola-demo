package com.example.demo.base.validator.annotation;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Arrays;
import java.util.List;

/**
 * 校验字段值是否在给定的范围内
 * boolean: true false
 * integer: 1 2 3
 * string: a b c
 *
 * @author where
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = In.InValidator.class)
public @interface In {
    String message() default "值不合法";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String[] allows() default {};

    class InValidator implements ConstraintValidator<In, Object> {
        private List<String> allows;

        @Override
        public void initialize(In constraintAnnotation) {
            this.allows = Arrays.asList(constraintAnnotation.allows());
        }

        @Override
        public boolean isValid(Object value, ConstraintValidatorContext context) {
            return value == null || allows.contains(String.valueOf(value));
        }
    }
}
