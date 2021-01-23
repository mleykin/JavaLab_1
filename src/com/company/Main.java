package com.company;

import java.lang.*;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // Uncomment any line to test Class

        //testComplex();
        //testMatrixNum();
        //testMatrixComp();
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
    public static void testMatrixNum() {
        double[][] arr = new double[2][2];
        arr[0][0] = 1; arr[0][1] = 2; arr[1][0] = 3; arr[1][1] = 4;
        MatrixNum matrixNum = new MatrixNum(arr);
        System.out.println("First Matrix:\n" + matrixNum.toText());

        arr[0][0] = 4; arr[0][1] = 3; arr[1][0] = 2; arr[1][1] = 1;
        MatrixNum matrixNum1 = new MatrixNum(arr);
        System.out.println("Second Matrix:\n" + matrixNum1.toText());

        System.out.println("Plus:\n" + matrixNum.plus(matrixNum1).toText());
        System.out.println("Multiply:\n" + matrixNum.multiply(matrixNum1).toText() + "\n");
        double[][] arr2 = new double[4][4];
        Random r = new Random();
        for (int i = 1; i <= arr2.length; i++) {
            for (int j = 1; j <= arr2.length; j++) {
                arr2[i-1][j-1] = Math.ceil(r.nextDouble()*10);
            }
        }
        MatrixNum result = new MatrixNum(arr2);
        System.out.println("New Matrix:\n" + result.toText() + "\n");
        System.out.println("Determinant:\n" + result.findDeterminant());
    }

    public static void testMatrixComp() {
        CompNum[][] arr = new CompNum[2][2];
        arr[0][0] = new CompNum(10, 2); arr[0][1] = new CompNum(9, 5);
        arr[1][0] = new CompNum(5, 7); arr[1][1] = new CompNum(1, 1);

        MatrixComp matrixComp = new MatrixComp(arr);
        System.out.println("First Matrix:\n" + matrixComp.toText());

        arr[0][0] = new CompNum(1, 6); arr[0][1] = new CompNum(7, 4);
        arr[1][0] = new CompNum(-9, 2); arr[1][1] = new CompNum(4, -5);
        MatrixComp matrixComp1 = new MatrixComp(arr);
        System.out.println("Second Matrix:\n" + matrixComp1.toText());

        System.out.println("Plus:\n" + matrixComp.plus(matrixComp1).toText());
        System.out.println("Multiply:\n" + matrixComp.multiply(matrixComp1).toText() + "\n");

        System.out.println("Determinant of the first:\n" + matrixComp.findDeterminant());
    }
}
