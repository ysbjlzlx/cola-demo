package com.example.demo.base.utils;

import javax.validation.*;
import java.util.*;

/**
 * 实体校验
 *
 * @author where.liu
 */
public class ValidationUtils {
    public static <T> Map<String, List<String>> validate(T bean, Class<?>... groups) throws ValidationException {
        try (ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory()) {
            Validator validator = validatorFactory.getValidator();

            Set<ConstraintViolation<T>> constraintViolations = validator.validate(bean, groups);
            Map<String, List<String>> errors = new HashMap<>(16);
            for (ConstraintViolation<T> constraintViolation : constraintViolations) {
                String field = constraintViolation.getPropertyPath().toString();
                errors.computeIfAbsent(field, key -> new ArrayList<>()).add(constraintViolation.getMessage());
            }

            return errors;
        }
    }
}
