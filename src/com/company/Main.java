package com.company;

import java.util.*;
import java.lang.*;

import com.company.CompNum;
import com.company.Matrix;

public class Main {
    public static void main(String[] args) {
        testComplex();
    }

    // This method demonstrate "CompNum class"
    public static void testComplex() {
        CompNum compNum1 = new CompNum(1.0, 3.0);
        CompNum compNum2 = new CompNum(4.0, -5.0);
        System.out.println("Numbers:\n" + compNum1 + "\n" + compNum2);
        compNum1.add(compNum2);
        System.out.println("Num1 + Num2:\n" + compNum1 + "\n");

        compNum1.setNumber(-2.0, 1.0);
        compNum2.setNumber(3.0, 5.0);
        System.out.println("Numbers:\n" + compNum1 + "\n" + compNum2);
        compNum1.subtract(compNum2);
        System.out.println("Num1 - Num2:\n" + compNum1 + "\n");

        compNum1.setNumber(1.0, -1.0);
        compNum2.setNumber(3.0, 6.0);
        System.out.println("Numbers:\n" + compNum1 + "\n" + compNum2);
        compNum1.multiply(compNum2);
        System.out.println("Num1 * Num2:\n" + compNum1 + "\n");

        compNum1.setNumber(13.0, 1.0);
        compNum2.setNumber(7.0, -6.0);
        System.out.println("Numbers:\n" + compNum1 + "\n" + compNum2);
        compNum1.divide(compNum2);
        System.out.println("Num1 / Num2:\n" + compNum1 + "\n");

        compNum1.setNumber(2.0, 3.0);
        System.out.println("Number:\n" + compNum1);
        System.out.println("Module: " + compNum1.getModule() +
                ", Argument: " + compNum1.getArgument());
    }

    // This method demonstrate "Matrix class"
    public static void testMatrix() {

    }
}
