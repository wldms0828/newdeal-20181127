# eomcs-java-project-49

## 작업

### Spring Ioc Container 라이브러리 추가
- https://mvnrepository.com/에서 'spring-context' 를 검색하여 라이브러리 정보를 알아낸다.
- build.gradle 파일에 등록
- $ gradle eclipse 실행하여 이클립스 설정 파일을 갱신
- 이클립스에서 프로젝트 리프레시


### Spring Ioc 설정 파일 추가
- AppConfig.java 작성
    - SqlSessionFactory 객체를 생성하는 메서드 추가
    - Spring IoC container가 자동으로 객체를 생성할 수 없는 경우 메소드를 정의하여 직접 객체를 생성한다.
    - DAO나 Command의 경우 내가 정의한 것이라서 Spring Ioc컨테이너를 통해 객체를 자동생성되게 설정 할 수 있다.
    - 그러나 Mybatis 관련 객체인 경우 내가 만든 클래스가 아니라서 Spring Ioc 컨테이너가 객체를 자동 생성하게 설정할 수 없다.
    - 따라서 Mybatis 관련 클래스는 직접 인스턴스를 생성해야 한다.
    - DAO 클래스에 객체 자동 생성하도록 설정
        - 클래스 선언부에 @Component를 붙여라
    - Command 클래스에 객체 자동 생성하도록 설정
        - 클래스 선언부에 @Component를 붙여라


### Spring Ioc 컨테이너 준비
- 'App.java' 
    - Spring IoC 컨테이너 객체를 준비한다.
- BoardDao 클래스에 있는 SQL을 이 파일로 옮긴다.
- 물론 mybatis 파일을 참고하여 만들어라.

### SqlSessionFactory 인스턴스를 생성

- 'App.java' 클래스에서 Mybatis의 SqlSeesionFactory 객체를 준비한다.
- DAO 객체가 사용할 수 있게 생성자에 주입해 준다.

### DAO