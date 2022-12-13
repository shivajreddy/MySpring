package com.shiva.webservices.restfulwebservices.buisiness;

public class SomeBusinessImpl {
    private DataService dataService;

    public SomeBusinessImpl(DataService dataService) {
        this.dataService = dataService;
    }

    public int findTheGreatestFromAllData() {
        int[] data = dataService.retrieveData();
        int greatest = Integer.MIN_VALUE;

        for (int n : data) {
            if (n > greatest) {
                greatest = n;
            }
        }
        return greatest;
    }

    // public int findSmallestData(){
    // }
}

interface DataService {
    int[] retrieveData();
}
