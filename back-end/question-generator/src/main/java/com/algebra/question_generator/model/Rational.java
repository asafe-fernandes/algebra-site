package com.algebra.question_generator.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Rational implements Operand {
  int numerator;
  int denominator;

  public Rational(int numerator, int denominator) {
    if (denominator == 0)
      throw new IllegalArgumentException("Denominator cannot be zero.");
    this.numerator = numerator;
    this.denominator = denominator;
  }

  private void reduceFration() {
    int numerator = this.getNumerator();
    int denominator = this.getDenominator();
    int _gcd = gcd(numerator, denominator);
    this.setNumerator(numerator / _gcd);
    this.setDenominator(denominator / _gcd);
  }

  private int gcd(int a, int b) {
    if (b == 0)
      return a;
    return gcd(b, a % b);
  }

  @Override
  public Operand sum(Operand other) {
    if (other instanceof Rational) {
      Rational r = (Rational) other;
      int num = this.numerator * r.denominator + r.numerator * this.denominator;
      int den = this.denominator * r.denominator;

      Rational result = new Rational(num, den);
      result.reduceFration();

      return result;

    } else if (other instanceof Matrix) {
      return ((Matrix) other).sum(this);
    }
    throw new UnsupportedOperationException("unsupported operation for type :" + other.getClass().getName());

  }

  @Override
  public Operand subtract(Operand other) {
    if (other instanceof Rational) {
      Rational r = (Rational) other;
      int num = this.numerator * r.denominator - r.numerator * this.denominator;
      int den = this.denominator * r.denominator;

      Rational result = new Rational(num, den);
      result.reduceFration();

      return result;
    } else if (other instanceof Matrix) {
      return ((Matrix) other).subtract(this);
    }
    throw new UnsupportedOperationException("unsupported operation for type :" + other.getClass().getName());
  }

  @Override
  public Operand multiply(Operand other) {
    if (other instanceof Rational) {
      Rational r = (Rational) other;
      int num = this.numerator * r.numerator;
      int den = this.denominator * r.denominator;

      Rational result = new Rational(num, den);
      result.reduceFration();

      return result;
    } else if (other instanceof Matrix) {
      return ((Matrix) other).multiply(this);
    }
    throw new UnsupportedOperationException("unsupported operation for type :" + other.getClass().getName());
  }

  public Operand divide(Operand other) {
    if (other instanceof Rational) {
      Rational r = (Rational) other;
      if (r.denominator == 0)
        throw new IllegalArgumentException("Cannot divide by zero.");
      int num = this.numerator * r.denominator;
      int den = this.denominator * r.numerator;

      Rational result = new Rational(num, den);
      result.reduceFration();

      return result;
    }
    throw new UnsupportedOperationException("unsupported operation for type :" + other.getClass().getName());
  }

  @Override
  public String toString() {
    return numerator + "/" + denominator;
  }

  public int getNumerator() {
    return numerator;
  }

  public void setNumerator(int numerator) {
    this.numerator = numerator;
  }

  public int getDenominator() {
    return denominator;
  }

  public void setDenominator(int denominator) {
    this.denominator = denominator;
  }
}
