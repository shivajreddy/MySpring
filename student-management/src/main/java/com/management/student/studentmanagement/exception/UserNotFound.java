package com.management.student.studentmanagement.exception;

import java.util.Comparator;

public class UserNotFound extends RuntimeException {

    public UserNotFound(Long id, String message) {
        super("User not found with id: " + id);
    }
}


class Demo {
    public static <T extends Comparable<T>> T maximum(T x, T y, T z) {
        T max = x;
        if (y.compareTo(max) > 0) {
            max = y;
        }
        if (z.compareTo(max) > 0) {
            max = z;
        }
        return max;
    }
}