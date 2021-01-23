package com.company;

import java.lang.*;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // testComplex();
        testMatrix();
    }

    // This method demonstrates "CompNum class"
    public static void testComplex() {
        CompNum compNum1 = new CompNum(1.0, 3.0);
        CompNum compNum2 = new CompNum(4.0, -5.0);
        System.out.println("Numbers:\n" + compNum1 + "\n" + compNum2);
        compNum1 = compNum1.plus(compNum2);
        System.out.println("Num1 + Num2:\n" + compNum1 + "\n");

        compNum1.setNumber(-2.0, 1.0);
        compNum2.setNumber(3.0, 5.0);
        System.out.println("Numbers:\n" + compNum1 + "\n" + compNum2);
        compNum1 = compNum1.minus(compNum2);
        System.out.println("Num1 - Num2:\n" + compNum1 + "\n");

        compNum1.setNumber(1.0, -1.0);
        compNum2.setNumber(3.0, 6.0);
        System.out.println("Numbers:\n" + compNum1 + "\n" + compNum2);
        compNum1 = compNum1.multiply(compNum2);
        System.out.println("Num1 * Num2:\n" + compNum1 + "\n");

        compNum1.setNumber(13.0, 1.0);
        compNum2.setNumber(7.0, -6.0);
        System.out.println("Numbers:\n" + compNum1 + "\n" + compNum2);
        compNum1 = compNum1.divide(compNum2);
        System.out.println("Num1 / Num2:\n" + compNum1 + "\n");

        compNum1.setNumber(2.0, 3.0);
        System.out.println("Number:\n" + compNum1);
        System.out.println("Module: " + compNum1.getModule() +
                ", Argument: " + compNum1.getArgument());
    }

    // This method demonstrates "Matrix class"
    public static void testMatrix() {
        double[][] arr = new double[2][2];
        arr[0][0] = 1; arr[0][1] = 2; arr[1][0] = 3; arr[1][1] = 4;
        MatrixNum matrixNum = new MatrixNum(arr);

        arr[0][0] = 4; arr[0][1] = 3; arr[1][0] = 2; arr[1][1] = 1;
        MatrixNum matrixNum1 = new MatrixNum(arr);
        double[][] arr2 = new double[4][4];
        Random r = new Random();
        for (int i = 1; i <= arr2.length; i++) {
            for (int j = 1; j <= arr2.length; j++) {
                arr2[i-1][j-1] = Math.ceil(r.nextDouble()*10);
            }
        }
        MatrixNum result = new MatrixNum(arr2);
        System.out.println(result.toText() + "\n");
        System.out.println(result.findDeterminant());
    }
}
