package com.sbs.exam.jsp.board.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class Article {
  int id;
  String regDate;
  String updateDate;
  String title;
  String content;

}
