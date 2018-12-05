# eomcs-java-project-49

## 작업
## 웹 프로젝트 관련 빌드 명령을 사용할 수 있게 준비한다.
-build.gradle
    - 'eclipse' 플러그인 대신에 'eclipse-wtp' 플러그인을 추가한다.
    - 웹 애플리케이션 배치 파일(.war)을 만들 'war'플러그 인을 추가한다.
    - 단독으로 실행할 수 없기 때문에 기존의 'application'은 제거한다.
    - 'application' 플러그인과 관련된 mainClassName = 'App' 을 제거한다.

### 서블릿 애플리케이션 개발에 사용할 라이브러리 추가하기
- https://mvnrepository.com/에서 'servlet-api' 를 검색하여 라이브러리 정보를 알아낸다.
- build.gradle 파일에 등록
- $ gradle eclipse 실행하여 이클립스 설정 파일을 갱신

### 이클립스 웹 프로젝트 설정 파일 준비하기
- src/main/webapp
    - HTML, CSS, JavaScript, PNG, JPEG, JSP 등 웹 자원을 둘 디렉토리를 생성한다.
- index.html
    - 웹 어플리케이션에대해 설명하는 간단한 페이지를 만든다.
    - $ gradle eclipse 실행하여 이클립스 설정 파일을 갱신

### SqlSessionFactory 객체 생성
-apache common-dbcp 라이브러리 추가
    - DataSource 구현체 (DB 커넥션 풀 객체)
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