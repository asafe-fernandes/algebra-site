package com.algebra.question_generator.model;

public class Rational implements Operand {
    int numerator;
    int denominator;
    public Rational(int numerator,int denominator) {
        if (denominator == 0) throw new IllegalArgumentException("Denominator cannot be zero.");
        this.numerator = numerator;
        this.denominator = denominator;
    }
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    @Override
    public Operand sum(Operand other) {
        if (other instanceof Rational) {
            Rational r = (Rational) other;
            int num = this.numerator * r.denominator + r.numerator * this.denominator;
            int den = this.denominator * r.denominator;
            return new Rational(num, den);
        } else if (other instanceof Matrix) {
            return ((Matrix) other).sum(this);
        }
        throw new UnsupportedOperationException("unsupported operation for type :"+other.getClass().getName());

    }

    @Override
    public Operand subtract(Operand other) {
        if (other instanceof Rational) {
            Rational r = (Rational) other;
            int num = this.numerator * r.denominator - r.numerator * this.denominator;
            int den = this.denominator * r.denominator;
            return new Rational(num,den);
        } else if (other instanceof Matrix) {
            return ((Matrix) other).subtract(this);
        }
        throw new UnsupportedOperationException("unsupported operation for type :"+other.getClass().getName());
    }

    @Override
    public Operand multiply(Operand other) {
        if (other instanceof Rational) {
            Rational r = (Rational) other;
            int num = this.numerator * r.numerator;
            int den = this.denominator * r.denominator;
            return new Rational(num,den);
        } else if (other instanceof Matrix) {
            return ((Matrix) other).multiply(this);
        }
        throw new UnsupportedOperationException("unsupported operation for type :"+other.getClass().getName());
    }

    @Override
    public Operand divide(Operand other) {
        if (other instanceof Rational) {
            Rational r = (Rational) other;
            if (r.denominator == 0) throw new IllegalArgumentException("Cannot divide by zero.");
            int num = this.numerator * r.denominator;
            int den = this.denominator * r.numerator;
            return new Rational(num, den);
        }
        throw new UnsupportedOperationException("unsupported operation for type :"+other.getClass().getName());
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

}
