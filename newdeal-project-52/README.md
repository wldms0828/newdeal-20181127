# eomcs-java-project-52

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
        - 'src/main/webap' 폴더가 웹 프로젝트에 정식으로 등록된다.

##이클립스에 톰캣 서버 등록
- 환결설정 
    - 

## JSTL 환경구축
- JSTL 구현 라이브러리를 가져온다.
    - https://mvnrepository.com/에서 'jstl' 을 검색한다.

### MVC아키텍처 적용


### HttpSession을 이용한 로그인/로그아웃


### Filter를 이용하여 서블릿을 실행하기 전에 특정 작업을 수행한다.


### Mybatis의 고급 Result Map 다루기


### Mybatis의 DAO 구현체 자동 생성하기
- AppConfig.java
    - @MapperScan 애노테이션 사용하여 DAO 인터페이스 구현체를 자동 생성한다.