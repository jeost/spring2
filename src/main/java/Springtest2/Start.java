package Springtest2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Start {
    public static void main(String[] args) {
        SpringApplication.run(Start.class);
    }
}
/* 패키지구조
    1. src
        2. main
            3. java
                4. root 패키지(임의)
                    5. controller 패키지
                        dto 패키지
                        dao(entity) 패키지
                        service 패키지
                        Start 클래스(임의)
            3. resources : 프론트엔드, 설정파일
                4. static : css, js, img 등등
                4. templates : html 등등
 */
//스프링 : java 를 이용해 미리 만들어진 다양한 API 들
    //스프링부트 : 스프링 내 자주 사용되는 API 들의 기본 세팅
        //@SpringBootApplication
        //1. MVC 컴포넌트 기본 세팅
        //2. tomcat 내장 서버 세팅 지원
        //3. restful api : HTTP ( URL ) 를 이용한 자원공유
    //SpringApplication.run(현재 클래스명.class); : 스프링 실행

//타임리프 : 템플릿엔진(정적문서에 데이터 넣는 프로그램)
    //템플릿엔진 :
        //백엔드 : 1. JSP 2. 타임리프 3. 머스테치
        //프론트엔드 : 1. REACT.js 2. Vue.js
    //백엔드(java/spring) : 1.RESTFUL API 제작
    //프론트엔드(JS) : RESTFUL API 를 이용한 데이터 교환

    //view <--템플릿엔진--> controller
        //클라이언트가 URL 을 요청했을 경우

    //데이터베이스
        //1. dao : 순수 java 형식의 sql 작성
        //2. SQL Mapper [ xml 방식 ] : mybatis(DBMS) 에서 주로 사용
        //3. JPA : JDBC(java-db 커넥터) API
            // ** 반복되는 SQL 을 JAVA 코드로 변경시키고 코드 줄이기
            // SQL 문법->JAVA 문법