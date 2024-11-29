package com.algebra.question_generator.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MatrixQuestion {

  private String questionText;
  private List<Matrix> matrices;
  private String expresssion;
  private Matrix rightAnswer;
}
