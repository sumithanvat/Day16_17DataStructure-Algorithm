package com.bridgelabz;


import java.util.Arrays;

public class PrimeNumberRange {

    public static void main(String[] args) {
        int[][] primes = new int[10][];
        int startIndex = 0;
        int endIndex = 100;

        for (int i = 0; i < 10; i++) {
            primes[i] = getPrimesInRange(startIndex, endIndex);
            startIndex = endIndex + 1;
            endIndex += 100;
        }

        for (int i = 0; i < 10; i++) {
            System.out.print("Primes in range " + (i * 100) + " - " + ((i + 1) * 100 - 1) + ": ");
            for (int j = 0; j < primes[i].length; j++) {
                System.out.print(primes[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int[] getPrimesInRange(int start, int end) {
        int[] primes = new int[25];
        int count = 0;

        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                if (count == primes.length) {
                    primes = resizeArray(primes);
                }
                primes[count++] = i;
            }
        }

        Arrays Arrays = null;
        primes = Arrays.copyOf(primes, count);
        return primes;
    }

    private static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    private static int[] resizeArray(int[] arr) {
        int[] newArr = new int[arr.length * 2];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        return newArr;
    }

}
