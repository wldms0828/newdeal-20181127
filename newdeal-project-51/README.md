# eomcs-java-project-49

## 작업

### Mybatis-Spring 연동 라이브러리 추가
- https://mvnrepository.com/에서 'Mybatis-spring' 를 검색하여 라이브러리 정보를 알아낸다.
- build.gradle 파일에 등록
- $ gradle eclipse 실행하여 이클립스 설정 파일을 갱신
- 이클립스에서 프로젝트 리프레시


### SqlSessionFactory 객체 생성
-apache common-dbcp 라이브러리 추가
    - DataSource 구현체 (DB 커넥션 풀 객체)
- spring-jdbc 라이브러리 추가
- AppConfig.java 작성
    - DataSource 객체를 생성하는 메소드 추가
    - SqlSessionFactory 객체를 생성하는 메서드 변경
     - Mybatis-Spring 연동 라이브러리에서 제공하는 도우미 클래스를 사용하여 SqlSessionFactory 객체를 만든다.
    - TransationManager 객체를 생성하는 메소드 추가

### SQL 분리
- 'src/main/resources/com/eomcs/lms/mapper/BoardMapper.xml' 파일을 작성한다.
- BoardDao 클래스에 있는 SQL을 이 파일로 옮긴다.
- 물론 mybatis 파일을 참고하여 만들어라.

### SqlSessionFactory 인스턴스를 생성

- 'App.java' 클래스에서 Mybatis의 SqlSeesionFactory 객체를 준비한다.
- DAO 객체가 사용할 수 있게 생성자에 주입해 준다.

### DAO