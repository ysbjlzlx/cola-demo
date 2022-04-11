package com.example.demo.base.utils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidationException;
import javax.validation.Validator;
import java.util.*;

/**
 * 实体校验
 *
 * @author where.liu
 */
public class ValidatorUtils {
    private static final Validator VALIDATOR = Validation.buildDefaultValidatorFactory().getValidator();

    public static <T> Map<String, List<String>> validate(T bean, Class<?>... groups) throws ValidationException {
        Set<ConstraintViolation<T>> constraintViolations = VALIDATOR.validate(bean, groups);
        Map<String, List<String>> errors = new HashMap<>(16);
        for (ConstraintViolation<T> constraintViolation : constraintViolations) {
            String field = constraintViolation.getPropertyPath().toString();
            errors.computeIfAbsent(field, key -> new ArrayList<>()).add(constraintViolation.getMessage());
        }
        return errors;
    }
}
