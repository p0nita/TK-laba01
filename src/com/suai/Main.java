package com.suai;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input N: ");
        String N = sc.nextLine();
        int n = Integer.parseInt(N);

        System.out.println("Input K: ");
        String K = sc.nextLine();
        int k = Integer.parseInt(K);

        Matrix test = Matrix.getG(n, k);
        System.out.println("Matrix G = \n" + test);

        Matrix code_book = test.getVocabulary();
        System.out.println("Code words = \n" + code_book);
        System.out.println("Number of words in the code = " + code_book.getRow());

        int d = code_book.minDistance();
        System.out.println("Min distance = " + d);

        int t = (d - 1) / 2;
        System.out.println("The correction of the erroneous bits = " + t + "\n");

        if(Math.pow(2, k) <= (Matrix.hamming(n, t))) {
            System.out.println("Hamming border: " + Math.pow(2, k) + " <= " + Matrix.hamming(n, t));
        }
        else {System.out.println("Hamming border is bad, because " + Math.pow(2, k) + " > " + Matrix.hamming(n, t));}

        if(Math.pow(2, k) >= (Matrix.hilbert(n, d))) {
            System.out.println("Hilbert border: " + Math.pow(2, k) + " >= " + Matrix.hilbert(n, d));
        }
        else {System.out.println("Hilbert border is bad, because " + Math.pow(2, k) + " < " + Matrix.hilbert(n, d));}

        if(k <= Matrix.singleton(n, d)) {
            System.out.println("Singleton border: " + k + " <= " + Matrix.singleton(n, d));
        }
        else {System.out.println("Singleton border is bad, because " + k + " > " + Matrix.singleton(n, d));}

    }
}