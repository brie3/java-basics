package packages.calculator;

import java.text.*;

public class complex {
    private double real;
    private double imaginary;

    public complex() {
        this(0.0, 0.0);
    }

    public complex(double r, double i) {
        real = r;
        imaginary = i;
    }

    public complex(String s) {
        var split = s.split("[\\+|\\-]");
        real = Double.parseDouble(split[0]);
        imaginary = Double.parseDouble(split[1].substring(0, split[1].length() - 1));
    }

    public complex add(complex c) {
        real += c.real;
        imaginary += c.imaginary;
        return this;
    }

    public complex sub(complex c) {
        real -= c.real;
        imaginary -= c.imaginary;
        return this;
    }

    public complex mul(complex c) {
        var tmp = real * c.real;
        var imagOne = c.real * imaginary;
        var imagTwo = real * c.imaginary;
        var minus = imaginary * c.imaginary;
        real = tmp - minus;
        imaginary = imagOne + imagTwo;
        return this;
    }

    public complex div(complex c) {
        var conjugate = new complex(c.real, -c.imaginary);
        this.mul(conjugate);
        c.mul(conjugate);
        this.real /= c.real;
        this.imaginary /= c.real;
        return this;
    }

    @Override
    public String toString() {
        String sign = "";
        if (imaginary >= 0) {
            sign = "+";
        }
        DecimalFormat df = new DecimalFormat("#.##");
        return df.format(real) + sign + df.format(imaginary) + "i";
    }

    public double getReal() {
        return this.real;
    }

    public double setReal(double d) {
        return this.real = d;
    }
}
