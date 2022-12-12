package com.shiva.webservices.restfulwebservices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Demo {
    public static void main(String[] args) {

        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(20);
        arr.add(10);
        arr.add(25);
        arr.add(5);

        List<Integer> arr2 = arr;

        // List<Integer> arr = Arrays.asList(10, 20, 30, 21, 1, 2, 3);

        Predicate<Integer> findGreaterThan10 = n -> n > 10;

        List<Integer> result = arr.stream().filter(findGreaterThan10).toList();

        System.out.println(result);
        System.out.println(result.getClass().getName());

    }

}


@FunctionalInterface
interface LambdaInterface {
    int square(int a);
}
