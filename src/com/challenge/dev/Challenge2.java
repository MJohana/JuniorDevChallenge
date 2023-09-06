package com.challenge.dev;

import java.util.ArrayList;

//Johana Araque, hash 4d4c0f80b06819f9b76536fe35ab8018 S = 4
public class Challenge2 {

    public static void main(String[] args) {
        int S = 4;
        int maxRange = (S * 10) + S;

        printArrayList(sortWithFilter(new int[]{1, 2, 3, 5, 6, 8, 9}, maxRange));
        printArrayList(sortWithFilter(new int[]{-2, -1}, maxRange));
        printArrayList(sortWithFilter(new int[]{-6, -5, 0, 5, 6}, maxRange));
        printArrayList(sortWithFilter(new int[]{-10, 10}, maxRange));


    }

    public static void printArrayList(ArrayList<Integer> list){

        for(int i: list){
            System.out.print(i+ " ");
        }
        System.out.println();
    }

    public static ArrayList<Integer> sortWithFilter(int[] numbers, int maxRange){

        ArrayList<Integer> negativeNumbers = new ArrayList<>();
        ArrayList<Integer> positiveNumbers = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();

        for(int i = 0; i < numbers.length; i++){
            if(numbers[i] < 0){
                negativeNumbers.add(numbers[i]);
            }else {
                positiveNumbers.add(numbers[i]);
            }
        }

        for(int n : negativeNumbers){
            int index = 0;
            for(int i = 0; i < positiveNumbers.size(); i++){
                if(Math.abs(n) < positiveNumbers.get(i)){
                    index = i;
                    break;
                }else {
                    index = i + 1;
                }
            }
            positiveNumbers.add(index, Math.abs(n));
        }

        for(int p: positiveNumbers){
            if((p * p) > maxRange){
                continue;
            }
            result.add((p * p));
        }

        return result;

    }
}
