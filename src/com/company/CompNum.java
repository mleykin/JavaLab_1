package com.company;

import org.jetbrains.annotations.NotNull;
import java.math.*;

public class CompNum {
    // private
    private double real = 0.0;
    private double unreal = 0.0;
    private double module = 0.0;
    private double argument = 0.0;

    private CompNum setModuleAndArgument() {
        this.module = Math.sqrt(Math.abs(
                this.real * this.real + this.unreal * this.unreal));
        double tmp = this.unreal / this.real;
        this.argument = this.real > 0 ? 1 / Math.tan(tmp) :
                        this.unreal > 0 ? Math.PI + 1 / Math.tan(tmp) :
                        1 / Math.tan(tmp) - Math.PI;
        return this;
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

    public CompNum plus(CompNum new_num) {
        CompNum compNum = new CompNum(this.real + new_num.real,
                this.unreal + new_num.unreal);
        compNum.setModuleAndArgument();
        return compNum;
    }

    public CompNum minus(CompNum new_num) {
        CompNum compNum = new CompNum(this.real - new_num.real,
                this.unreal - new_num.unreal);
        compNum.setModuleAndArgument();
        return compNum;
    }

    public CompNum multiply(CompNum new_num) {
        double tmp_real = this.real * new_num.real - this.unreal * new_num.unreal;
        double tmp_unreal = this.real * new_num.unreal + this.unreal * new_num.real;
        return (new CompNum(tmp_real, tmp_unreal)).setModuleAndArgument();
    }

    public CompNum divide(CompNum new_num) throws ArithmeticException {
        CompNum sopr = new CompNum(new_num.real, -new_num.unreal);
        CompNum tmp1 = new CompNum(this);
        CompNum tmp2 = new CompNum(new_num);
        tmp2.multiply(sopr);
        if (new_num.real == 0 && new_num.unreal == 0)
            throw new ArithmeticException("Divide by 0");
        tmp1.multiply(sopr);
        tmp1.real = tmp1.real / tmp2.real;
        tmp1.unreal = tmp1.unreal / tmp2.real;
        return tmp1.setModuleAndArgument();
    }

    public CompNum copy() {
        return new CompNum(this.real, this.unreal);
    }

    public void copy(CompNum new_num) {
        this.real = new_num.real;
        this.unreal = new_num.unreal;
        this.setModuleAndArgument();
    }

    @Override
    public String toString() {
        if (this.unreal == 0)
            return this.real + "";
        else if (this.real == 0)
            return this.unreal + "*i";
        String result = this.unreal > 0 ? " + " : " - ";
        result = this.real + result + Math.abs(this.unreal) + "*i";
        return result;
    }
}
