package com.example.warehouse.utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ValidationUtils {

    public static void checkOnNull(Long id) {

        if (id == null) {
            throw new IllegalArgumentException("ID must not be null");
        }
    }
}
