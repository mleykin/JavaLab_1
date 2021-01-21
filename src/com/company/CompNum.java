package com.company;

import org.jetbrains.annotations.NotNull;
import java.math.*;

public class CompNum {
    // private
    private double real = 0.0;
    private double unreal = 0.0;
    private double module = 0.0;
    private double argument = 0.0;

    private void setModuleAndArgument() {
        this.module = Math.sqrt(Math.abs(
                this.real * this.real + this.unreal * this.unreal));
        double tmp = this.unreal / this.real;
        this.argument = this.real > 0 ? 1 / Math.tan(tmp) :
                        this.unreal > 0 ? Math.PI + 1 / Math.tan(tmp) :
                        1 / Math.tan(tmp) - Math.PI;
    }

    // public
    public CompNum(double real, double unreal) {
        this.real = real;
        this.unreal = unreal;
        this.setModuleAndArgument();
    }

    public CompNum(CompNum new_num) {
        this.real = new_num.real;
        this.unreal = new_num.unreal;
        this.setModuleAndArgument();
    }

    public double getReal(){
        return this.real;
    }

    public double getUnreal() {
        return this.unreal;
    }

    public double getModule() {
        return this.module;
    }

    public double getArgument() {
        return this.argument;
    }

    public void setNumber(double real, double unreal) {
        this.real = real;
        this.unreal = unreal;
        this.setModuleAndArgument();
    }

    public void add(CompNum new_num) {
        this.real += new_num.real;
        this.unreal += new_num.unreal;
        this.setModuleAndArgument();
    }

    public void subtract(CompNum new_num) {
        this.real -= new_num.real;
        this.unreal -= new_num.unreal;
        this.setModuleAndArgument();
    }

    public void multiply(CompNum new_num) {
        double tmp = this.real * new_num.real - this.unreal * new_num.unreal;
        this.unreal = this.real * new_num.unreal + this.unreal * new_num.real;
        this.real = tmp;
        this.setModuleAndArgument();
    }

    public void divide(CompNum new_num) throws ArithmeticException {
        CompNum sopr = new CompNum(new_num.real, -new_num.unreal);
        CompNum tmp_new_num = new CompNum(new_num);
        tmp_new_num.multiply(sopr);
        if (new_num.real == 0 && new_num.unreal == 0)
            throw new ArithmeticException("Divide by 0");
        this.multiply(sopr);
        this.real = this.real / tmp_new_num.real;
        this.unreal = this.unreal / tmp_new_num.real;
        this.setModuleAndArgument();
    }

    public void copy(CompNum new_num) {
        this.real = new_num.real;
        this.unreal = new_num.unreal;
        this.setModuleAndArgument();
    }

    @Override
    public String toString() {
        String result = this.unreal > 0 ? " + " : " - ";
        result = this.real + result + Math.abs(this.unreal) + "*i";
        return result;
    }
}
