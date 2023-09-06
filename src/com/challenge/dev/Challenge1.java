package com.challenge.dev;

import java.util.ArrayList;

//Johana Araque, hash 4d4c0f80b06819f9b76536fe35ab8018 S = 4
public class Challenge1 {

    public static void main(String[] args) {
        int S = 4;
        printArray(switchFunction(new int[]{1, 2, 3, 4, 5, 6}, S));
        printArray(switchFunction(new int[]{10, 20, 30, 40}, S));
        printArray(switchFunction(new int[]{4}, S));
        printArray(switchFunction(new int[]{44}, S));
        printArray(switchFunction(new int[]{45}, S));
        printArray(switchFunction(new int[]{4, 2, 1}, S));
        printArray(switchFunction(new int[]{40, 4, 5, 6, 3, 2, 7, 7, 29, 1}, S));

    }

    public static void printArray(int[] numbers){

        for(int i = 0; i < numbers.length; i++){
            System.out.print(numbers[i]+ " ");
        }
        System.out.println();
    }


    public static int[] switchFunction(int[] numbers, int S){

        ArrayList<Integer> numberList = new ArrayList<>();

        for(int i = 0; i < numbers.length; i++){
            if(numbers[i] == S){
                continue;
            }else {
                int mod = numbers[i] % 10;
                int div = numbers[i] / 10;
                if(mod != S && div != S){
                    numberList.add(numbers[i]);
                }else if(mod != S){
                    numberList.add(mod);
                }else if(div != S){
                    numberList.add(div);
                }

            }

        }

        int[] switched = new int[numberList.size()];
        for(int i = 0, k = switched.length -1; i <= k; i++, k--){
            switched[i] = numberList.get(k);
            switched[k] = numberList.get(i);
        }

        return switched;

    }
}
