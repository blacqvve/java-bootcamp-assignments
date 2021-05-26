package com.hrms.hrms.core.utilities.validators.abstracts;

public interface Validator<T> {
    boolean validate(T object);
}
