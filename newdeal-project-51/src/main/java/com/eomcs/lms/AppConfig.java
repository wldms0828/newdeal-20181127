package com.eomcs.lms;

import java.util.Scanner;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
//Spring IoC 컨테이너에게 패키지 이름을 알려주면 그 패키지를 뒤져서  @Component가 붙은 클래스에 대해
//인스턴스를 자동으로 생성해 준다.
@ComponentScan("com.eomcs.lms")
//Spring IoC컨테이너에게 프로퍼티 파일을 로딩할 것을 명령한다. 
@PropertySource("classpath:/com/eomcs/lms/conf/jdbc.properties")
public class AppConfig {
  
//Spring IoC컨테이너가 오딩한 프로퍼티 정보를 가져오기
  // 스프링 IoC 컨테이너 로딩한 프로퍼티 값 중에서 jdbcDriver라는 이름을 가진 값을 꺼내 jdbcDriver 변수에 넣어줘 
  @Value("${jdbc.driver}")
  String jdbcDriver;
  @Value("${jdbc.url}")
  String jdbcUrl;
  @Value("${jdbc.username}")
  String jdbcUsername;
  @Value("${jdbc.password}")
  String jdbcPassword;
  @Bean 
  public DataSource dataSource() {
    BasicDataSource dataSource = new BasicDataSource();
    dataSource.setDriverClassName(this.jdbcDriver);
    dataSource.setUrl(this.jdbcUrl);
    dataSource.setUsername(this.jdbcUsername);
    dataSource.setPassword(this.jdbcPassword);
    return dataSource;
  }
  //Spring IoC 컨테이너에세 이 메서드를 호출하여 리턴 값을 보관하라고 표시하기
  //=> 리턴값을 저장할 떄 사용할 이름을 따로 지정하지 않으면 메소드 이름으로 저장한다.
  //=> 그래서 이런 메소드의 이름은 보통 동사로 시작하지 않고, 객체의 이름인 명사형태로 짓는다.
  public PlatformTransactionManager transactionManager(DataSource dataSource) {
    return new DataSourceTransactionManager(dataSource);
  }
  @Bean
  public SqlSessionFactory sqlSessionFactory(
      DataSource dataSource, ApplicationContext iocContainer) throws Exception{
    SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
    // DataSource(DB 커넥션풀) 객체주입
    factoryBean.setDataSource(dataSource);
    
    //도메인 클래스(VO)의 별명 자동 생성하기
    factoryBean.setTypeAliasesPackage("com.eomcs.lms.domain");
    
    //SQL 매퍼 파일 로딩
    //=>SQL 매퍼 파일의 위치 정보를 Resource 객체에 담아서 넘겨야 한다.
    //=> Resource 객체는 Spring Ioc 컨테이너를 통해 만들 수 있다.
    //=> Spring IoC 컨테이너 객체를 얻는 방법
    // 이 메소드의 파라미터에 달라고 하면된다.    
    factoryBean.setMapperLocations(iocContainer.getResources(
        "classpath:/com/eomcs/lms/mapper/*Mapper.xml"));
    return factoryBean.getObject();
  }
  // 트랜젝션 객체를 생성할 때 
  // 기본이름으로 transactionManager 라고 설정하라.
  // 다른이름으로 설정하면 트랜젝션 관련하여 다른 객체를 생성할 때 그 객체가 트랜젝션 관리자를 스스로 찾지 못한다.
  
  @Bean
  public Scanner keyboard() {
    return new Scanner(System.in);
  }
  
}
