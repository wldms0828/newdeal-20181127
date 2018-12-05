package com.eomcs.lms.dao.impl;

import java.sql.DriverManager;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Component;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.domain.Board;

//Spring Ioc컨테이너가 이 클래스의 객체를 생성하도록 클래스에 표시해 둔다.
@Component
public class MariaDBBoardDao implements BoardDao {
  //프로그램의 유연성을 위해서 그냥 Interface로 설정해준다(List)
  
  SqlSessionFactory sqlSessionFactory;

public MariaDBBoardDao(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory=sqlSessionFactory;
  }
public List<Board> findAll() throws Exception{  
  try (SqlSession sqlSession = sqlSessionFactory.openSession()){   
    return sqlSession.selectList("BoardDao.findAll");
}
}
public Board findByNo(int no) throws Exception{

  DriverManager.registerDriver(new org.mariadb.jdbc.Driver());
  try (SqlSession sqlSession = sqlSessionFactory.openSession()){   
    return sqlSession.selectOne("BoardDao.findByNo", no);
}
}
public int insert(Board board) throws Exception{
  try (SqlSession sqlSession = sqlSessionFactory.openSession()){   
    int count =  sqlSession.insert("BoardDao.insert", board);
    sqlSession.commit();
    //jdbc는 atuo commit 이 가능 하지만 mybatis는 안된다.
    return count;
  }
}
public int update(Board board) throws Exception {
  try (SqlSession sqlSession = sqlSessionFactory.openSession()){   
    int count =  sqlSession.update("BoardDao.update", board);
    sqlSession.commit();
    //jdbc는 atuo commit 이 가능 하지만 mybatis는 안된다.
    return count;
  }
}
public int delete(int no) throws Exception{
  try (SqlSession sqlSession = sqlSessionFactory.openSession()){   
    int count =  sqlSession.delete("BoardDao.delete", no);
    sqlSession.commit();
    //jdbc는 atuo commit 이 가능 하지만 mybatis는 안된다.
    return count;
  }
}
}
