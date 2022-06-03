package Springtest2.entity;

import javax.persistence.*;

@Entity // 해당 클래스를 엔티티로 사용
@Table(name="test")
public class TestEntity { // 클래스
    @Id // 기본 키 설정 (pk)
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동 번호 부여
    public int no;         // 필드
    @Column
    public String content; // 필드
}
//JPA : 클래스를 DB 테이블처럼 사용
    //자바 클래스를 엔티티화 해서 테이블이 자동 생성
    //