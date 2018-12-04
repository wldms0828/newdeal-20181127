package com.eomcs.lms.dao.impl;

import org.apache.ibatis.session.SqlSessionFactory;
import com.eomcs.lms.dao.LessonDao;

public class MariaDBLessonDao implements LessonDao {
  SqlSessionFactory sqlSessionFactory;
  public MariaDBLessonDao(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory=sqlSessionFactory;
  }
  
}
