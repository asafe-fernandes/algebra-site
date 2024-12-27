package com.algebra.question_generator.model;

import java.util.Arrays;
import java.util.Random;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Matrix implements Operand {
  private final Rational[][] data;
  Random rand = new Random();

  public Matrix(int rows, int columns) {
    this.data = new Rational[rows][columns];
  }

  public Matrix(Rational[][] data) {
    this.data = data;
  }

  public Matrix(int rows, int columns, int min, int max) {
    this.data = new Rational[rows][columns];
    generateRandomValues(min, max);
  }

  public int getRows() {
    return this.data.length;
  }

  public int getColumns() {
    return this.data[0].length;
  }

  public Rational getValue(int row, int column) {
    return data[row][column];
  }

  public void setValue(int row, int column, Rational value) {
    data[row][column] = value;
  }

  private void generateRandomValues(int min, int max) {
    for (Rational[] datum : data) {
      for (Rational rational : datum) {
        rational.setNumerator(rand.nextInt(max - min + 1) + min);
        rational.setDenominator(rand.nextInt(max - min + 1) + min);
      }
    }
  }

  public Matrix transpose() {
    int rows = getRows();
    int cols = getColumns();
    Matrix transposed = new Matrix(cols, rows);
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        transposed.setValue(j, i, this.getValue(i, j));
      }
    }

    return transposed;
  }

  @Override
  public Operand sum(Operand other) {
    Matrix result = new Matrix(this.getRows(), this.getColumns());

    if (other instanceof Matrix) {

      Matrix m = (Matrix) other;
      if (m.getColumns() != this.getColumns() || m.getRows() != this.getRows())
        throw new ArithmeticException("cannot sum different order matrices");
      for (int i = 0; i < this.getRows(); i++) {
        for (int j = 0; j < this.getColumns(); j++) {
          result.setValue(i, j, (Rational) this.getValue(i, j).sum(m.getValue(i, j)));
        }
      }
      return result;

    } else if (other instanceof Rational) {
      Rational r = (Rational) other;
      for (int i = 0; i < this.getRows(); i++) {
        for (int j = 0; j < this.getColumns(); j++) {
          result.setValue(i, j, (Rational) this.getValue(i, j).sum(r));
        }
      }
      return result;
    }
    throw new UnsupportedOperationException("Unsupported operation for this type" + other.getClass().getName());
  }

  @Override
  public Operand subtract(Operand other) {
    Matrix result = new Matrix(this.getRows(), this.getColumns());

    if (other instanceof Matrix) {

      Matrix m = (Matrix) other;
      if (m.getColumns() != this.getColumns() || m.getRows() != this.getRows())
        throw new ArithmeticException("cannot subtract different order matrices");
      for (int i = 0; i < this.getRows(); i++) {
        for (int j = 0; j < this.getColumns(); j++) {
          System.out.println("i: " + i + " j:" + j);
          result.setValue(i, j, (Rational) this.getValue(i, j).subtract(m.getValue(i, j)));
        }
      }
      return result;
    } else if (other instanceof Rational) {
      Rational r = (Rational) other;
      for (int i = 0; i < this.getRows(); i++) {
        for (int j = 0; j < this.getColumns(); j++) {
          result.setValue(i, j, (Rational) this.getValue(i, j).subtract(r));
        }
      }
      return result;
    }
    throw new UnsupportedOperationException("Unsupported operation for this type" + other.getClass().getName());
  }

  @Override
  public Operand multiply(Operand other) {
    int rowsA = this.getRows();
    int colsA = this.getColumns();

    if (other instanceof Matrix) {
      Matrix m = (Matrix) other;
      Matrix result = new Matrix(this.getRows(), m.getColumns());

      System.out.println("colsA: " + colsA);
      System.out.println("RowsB: " + m.getRows());

      if (colsA != m.getRows())
        throw new ArithmeticException("cannot multiply matrices with different collumns and rows!" + "MatrixA: "
            + this.toString() + " MatrixB: " + m.toString());
      int colsB = m.getColumns();
      for (int i = 0; i < rowsA; i++) {
        for (int j = 0; j < colsB; j++) {
          for (int k = 0; k < colsA; k++) {
            result.setValue(i, j, (Rational) this.getValue(i, k).multiply(m.getValue(k, j)));
          }
        }
      }
      return result;
    } else if (other instanceof Rational) {
      Rational r = (Rational) other;
      Matrix result = new Matrix(this.getRows(), this.getColumns());
      for (int i = 0; i < this.getRows(); i++) {
        for (int j = 0; j < this.getColumns(); j++) {
          result.setValue(i, j, (Rational) this.getValue(i, j).multiply(r));
        }
      }
      return result;
    }
    throw new UnsupportedOperationException("Unsupported operation for type: " + other.getClass().getName());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("[");
    for (int i = 0; i < data.length; i++) {
      sb.append(Arrays.toString(data[i]));
      if (i != data.length - 1)
        sb.append(",");
    }
    sb.append("]");
    return sb.toString();
  }
}
