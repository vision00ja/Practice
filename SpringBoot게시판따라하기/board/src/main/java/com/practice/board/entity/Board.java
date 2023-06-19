package com.practice.board.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.boot.autoconfigure.web.WebProperties;

import javax.annotation.processing.Generated;

// entity의 클래스이름은 왠만하면 엔티티(테이블)와 일치시키는게 좋다 예) table -> table.java
@Entity // java에서 entity는 db의 테이블을 의미한다
@Data // Board 클래스를 이용해서 컨트롤러에서 바로 아래 필드들을 가져올수있다 이때 Data 어노테이션 필수
public class Board {

    @Id // ID anno는 Primary Key (PK)를 의미
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String title;
    private String content;
}
