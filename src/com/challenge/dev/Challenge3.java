package com.challenge.dev;

import java.util.Arrays;

public class Challenge3 {

    public static void main(String[] args) {

        System.out.println("{1, 2, 4} = " + impossibleMinCash(new int[]{1, 2, 4}));
        System.out.println("{1, 2, 4, 9} = " + impossibleMinCash(new int[]{9, 1, 2, 4}));
        System.out.println("{1, 2, 4, 7} = " + impossibleMinCash(new int[]{1, 2, 7, 4}));
        System.out.println("{5, 7, 1, 1, 2, 3, 22} = " + impossibleMinCash(new int[]{5, 7, 1, 1, 2, 3, 22}));
        System.out.println("{1, 1, 1, 1, 1} = " + impossibleMinCash(new int[]{1, 1, 1, 1, 1}));
        System.out.println("{1, 5, 1, 1, 1, 10, 15, 20, 100} = " + impossibleMinCash(new int[]{1, 5, 1, 1, 1, 10, 15, 20, 100}));

    }

    public static int impossibleMinCash(int[] coins){
        int minCash = 1;

        //sort
        Arrays.sort(coins);

        if(coins[0] > minCash){
            return minCash;
        }

        int maxCash = sumCash(coins, coins.length) + 1;


        for(int k = 2; k < maxCash; k++ ){
            int index = Arrays.binarySearch(coins, k);
            if(index >= 0){
                continue;
            }else if(sumCash(coins, Math.abs(index + 1)) < k){
                return k;
            }
        }

        return maxCash;
    }

    private static int sumCash(int coins[], int index){
        int sum = 0;

        for(int i = 0; i < index; i++){
            sum += coins[i];
        }
        return sum;
    }
}
