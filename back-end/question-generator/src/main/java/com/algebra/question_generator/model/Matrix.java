package com.algebra.question_generator.model;

import java.util.Random;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Matrix {
  private final int[][] data;
  Random rand = new Random();

  public Matrix(int rows, int columns) {
    this.data = new int[rows][columns];
  }

  public Matrix(int[][] data) {
    this.data = data;
  }

  public Matrix(int rows, int columns, int min, int max) {
    this.data = new int[rows][columns];
    generateRandomValues(min, max);
  }

  public int getRows() {
    return this.data.length;
  }

  public int getColumns() {
    return this.data[0].length;
  }

  public int getValue(int row, int column) {
    return data[row][column];
  }

  public void setValue(int row, int column, int value) {
    data[row][column] = value;
  }

  private void generateRandomValues(int min, int max) {

    for (int i = 0; i < data.length; i++) {
      for (int j = 0; j < data[i].length; j++) {
        data[i][j] = rand.nextInt(max - min + 1) + min;
      }
    }
  }

  public Matrix transpose() {
    int rows = getRows();
    int cols = getColumns();
    int[][] transposed = new int[cols][rows];

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        transposed[j][i] = data[i][j];
      }
    }
    return new Matrix(transposed);
  }

  public Matrix add(Matrix other) {
    Matrix result = new Matrix(this.getRows(), this.getColumns());

    for (int i = 0; i < this.getRows(); i++) {
      for (int j = 0; j < this.getColumns(); j++) {
        result.setValue(i, j, this.getValue(i, j) + other.getValue(i, j));
      }
    }
    return result;
  }

  public Matrix subtract(Matrix other) {
    Matrix result = new Matrix(this.getRows(), this.getColumns());

    for (int i = 0; i < this.getRows(); i++) {
      for (int j = 0; j < this.getColumns(); j++) {
        result.setValue(i, j, this.getValue(i, j) - other.getValue(i, j));
      }
    }
    return result;
  }

  public Matrix multiply(Matrix other) {
    int rowsA = this.getRows();
    int colsA = this.getColumns();
    int colsB = other.getColumns();
    Matrix result = new Matrix(this.getRows(), this.getColumns());

    for (int i = 0; i < rowsA; i++) {
      for (int j = 0; j < colsB; j++) {
        for (int k = 0; k < colsA; k++) {
          result.setValue(i, j, this.getValue(i, k) * other.getValue(k, j));
        }
      }
    }
    return result;
  }

  @JsonValue
  public int[][] getData() {
    return this.data;
  }
}
