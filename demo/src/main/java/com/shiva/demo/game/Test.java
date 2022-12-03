package com.shiva.demo.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

public class Test {
}

interface SortingAlgorithm {
}


@Component
@Primary
class QuickSort implements SortingAlgorithm {
}


@Component
class BubbleSort implements SortingAlgorithm {
}

@Component
@Qualifier("qualifier_radix_sort")
class RadixSort implements SortingAlgorithm {
}

@Component
class ComplexAlgorithm1 {

    public ComplexAlgorithm1(SortingAlgorithm algorithm) {
    }
}

@Component
class ComplexAlgorithm2 {
    @Autowired
    @Qualifier("qualifier_radix_sort")
    private SortingAlgorithm iWantToUseRedixSortOnly;
}

